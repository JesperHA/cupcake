package control;

import ModelLayer.*;
import data.OrdreMapper;
import facadeLayer.BottomFacade;
import facadeLayer.TopFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        String destination = "index.jsp";
        String source = request.getParameter("source");

        HttpSession session = request.getSession();

//        ArrayList<Kunder> kunde;
//        kunde = (ArrayList<Kunder>) session.getAttribute("kunde");
//        if (kunde == null){
//            kunde = new ArrayList<>();
//            session.setAttribute("kunde",kunde);
//        }


        ArrayList<Login> bruger;
        bruger = (ArrayList<Login>) session.getAttribute("login");
        if(bruger == null){
            bruger = new ArrayList<>();
        }


        ArrayList<Cart> cart;
        cart = (ArrayList<Cart>) session.getAttribute("cart");
        if (cart == null){
            cart = new ArrayList<>();
            session.setAttribute("cart",cart);
        }

        response.setContentType("text/html;charset=UTF-8");

        switch (source) {
            case "customers":
                String customerID = request.getParameter("customerid");

                destination = "orders.jsp";
                break;




                //////////////////////////////
            case "addtocart":
                String bottom = request.getParameter("bottom");
                String top = request.getParameter("top");
                String number = request.getParameter("number");
                if (bottom != null && top != null && number != null){
                    request.setAttribute("status","ok");
                    request.setAttribute("message",
                            String.format("Bund: %s, Top: %s, Antal: %s er nu lagt i kurven",
                                    bottom, top, number));

                    int bottomId = Integer.parseInt(bottom);
                    int topId = Integer.parseInt(top);
                    int numberId = Integer.parseInt(number);
                    int ialt = numberId * (BottomFacade.getBottomList().get(bottomId-1).getPris() + TopFacade.getTopList().get(topId-1).getPris());


                    cart.add(new Cart(bottomId, topId, numberId, ialt));
                    session.removeAttribute("cart");
                    session.setAttribute("cart", cart);



                } else {
                    request.setAttribute("status","error");
                    request.setAttribute("message",
                            String.format("Du mangler at vælge bund, top eller antal!",
                                    bottom, top, number));
                }
                destination = "/index.jsp";
                break;

            case "login":

                System.out.println("Kommer til login");

                ArrayList<Kunder> kundeList = facadeLayer.KundeFacade.getKunderList();

                String email = request.getParameter("email");
                String password = request.getParameter("password");


                for (int i = 0; i < kundeList.size(); i++) {
                    System.out.println("Kommer til første loop");
                    System.out.println(email + password);
                    if (kundeList.get(i).getEmail().equals(email) && kundeList.get(i).getPassword() == Integer.parseInt(password)) {


                        System.out.println("Tjek af login OK");
                        int kunde_id = kundeList.get(i).getKunde_id();
                        String navn = kundeList.get(i).getNavn();
                        int saldo = kundeList.get(i).getSaldo();

                        bruger.add(new Login(kunde_id, navn, email, password, saldo));
//                        session.removeAttribute("login");
                        session.setAttribute("login", bruger);


                    }

                }


//                for (int i = 0; i < kundeList.size(); i++) {
//                    if(email.equalsIgnoreCase(kundeList.get(i).getEmail())){
//
//                        if(password.equals(kundeList.get(i).getPassword())){
//
//                            kunde.add(new Kunder(kundeList.get(i).getKunde_id(), kundeList.get(i).getNavn(), kundeList.get(i).getEmail(), kundeList.get(i).getPassword()));
//                            session.removeAttribute("kunde");
//                            session.setAttribute("kunde", kunde);
//                        }
//                    }
//
//                }

//                cart.add(new Cart(bottomId, topId, numberId, ialt));
//                session.removeAttribute("cart");
//                session.setAttribute("cart", cart);




//                ArrayList<Kunder> kundeList = new ArrayList<>();
//
//                for (Kunder k : kundeList) {
//                    if(email.equalsIgnoreCase(k.getEmail())){
//                        if(password.equals(k.getPassword())){
//
//                        }
//                    }
//
//                }

//                Login loggedIn = new Login(false);
//
//                if(email != null && password != null){
//                    destination = "/index.jsp";
//
//                    loggedIn.setLoggedIn(true);
//                }else{
//                    loggedIn.setLoggedIn(false);
//                }

                break;

            case "completeorder":

                String saldo = "";

                ArrayList<Kunder> kundeListNy = facadeLayer.KundeFacade.getKunderList();

                if(bruger.get(0) != null){

                    for(int i = 0; i < kundeListNy.size(); i++) {
                        if(kundeListNy.get(i).getKunde_id() == bruger.get(0).getKunde_id()){
                            saldo = Integer.toString(kundeListNy.get(i).getSaldo());

                        }

                    }
                }
                request.setAttribute("nySaldo", saldo);

                // knappen skal:
                // oprette en ordre i sql via en ordreMapper, stemple dato, og stemple den fulde pris
                // Update de påvirkede ordrelinier med det ordre_id der lige er blevet lavet

//                Ordre nyOrdre = new Ordre(1,1,18032019,200);
//                OrdreMapper.indsætOrdre(nyOrdre);
//
//                ArrayList<Ordre> ordreList = OrdreFacade.getOrdreList();
//
//                int tempOrdre_id = ordreList.size()-1;
//
//
//                for (int i = 0; i <= OrdrelinieFacade.getOrdrelinieList().size(); i++) {
//
//                    int tempOrdrelinieId = OrdrelinieFacade.getOrdrelinieList().get(i).getOrdrelinie_id();
//
//                    OrdrelinieMapper.updateOrdrelinie(OrdreFacade.getOrdreList().get(tempOrdre_id).getOrdre_id(), tempOrdrelinieId);
//
//                }





                OrdreMapper.indsætOrdreOgOrdrelinier(cart, bruger.get(0).getKunde_id(), bruger.get(0).getSaldo());


                destination = "/cart.jsp";

                break;
            case "gotoorder":

                String ordre_id = request.getParameter("ordre");

                int ordrenummer = Integer.parseInt(ordre_id);

                request.setAttribute("ordre_id", ordrenummer);



                destination = "/ordreinfo.jsp";


                break;

            case "logout":

                        session.removeAttribute("login");

                destination = "/index.jsp";
        }

        request.getRequestDispatcher(destination).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

package facadeLayer;


import ModelLayer.OrdreView;
import data.OrdreViewMapper;

import java.util.ArrayList;

public class OrdreViewFacade {
    private static ArrayList<OrdreView> ordreViewList;

    public static ArrayList<OrdreView> getOrdreViewList(int id) {
//        if(ordreViewList == null){
        ordreViewList = OrdreViewMapper.getOrdreViewList(id);
//        }
        return ordreViewList;
    }
    public static ArrayList<OrdreView> getOrdreViewListByOrdre(int id) {
//        if(ordreViewList == null){
        ordreViewList = OrdreViewMapper.getOrdreViewListByOrdre(id);
//        }
        return ordreViewList;
    }
}
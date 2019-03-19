package facadeLayer;

import ModelLayer.Ordre;
import data.OrdreMapper;


import java.util.ArrayList;

public class OrdreFacade {
    private static ArrayList<Ordre> ordreList;

    public static ArrayList<Ordre> getOrdreList() {
//        if(ordrelinieList == null){
        ordreList = OrdreMapper.getOrdreList();
//        }
        return ordreList;
    }
}

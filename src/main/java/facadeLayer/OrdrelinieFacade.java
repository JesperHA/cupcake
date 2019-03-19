package facadeLayer;

import ModelLayer.Ordrelinie;
import data.OrdrelinieMapper;

import java.util.ArrayList;

public class OrdrelinieFacade {
    private static ArrayList<Ordrelinie> ordrelinieList;

    public static ArrayList<Ordrelinie> getOrdrelinieList(int id) {
//        if(ordrelinieList == null){
            ordrelinieList = OrdrelinieMapper.getOrdrelinieList(id);
//        }
        return ordrelinieList;
    }
}

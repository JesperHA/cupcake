package facadeLayer;

import ModelLayer.Kunder;
import data.KundeMapper;

import java.util.ArrayList;

public class KundeFacade {
    private static ArrayList<Kunder> kundeList;

    public static ArrayList<Kunder> getKunderList() {
//        if (kundeList == null) {
            kundeList = KundeMapper.getKunderList();
//        }
        return kundeList;
    }

    public static ArrayList<Kunder> getKunderListById(int id) {
//        if (kundeList == null) {
            kundeList = KundeMapper.getKunderListById(id);
//        }
        return kundeList;
    }
}
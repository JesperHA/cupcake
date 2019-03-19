package facadeLayer;

import ModelLayer.Toppings;
import data.TopMapper;

import java.util.ArrayList;

public class TopFacade {
    private static ArrayList<Toppings> topList;

    public static ArrayList<Toppings> getTopList(){
        if(topList == null){
            topList = TopMapper.getToppingList();
        }
        return topList;
    }


}

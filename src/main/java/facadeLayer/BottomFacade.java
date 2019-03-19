package facadeLayer;

import ModelLayer.Bottom;
import data.BottomMapper;

import java.util.ArrayList;

public class BottomFacade {
    private static ArrayList<Bottom> bottomList;

    public static ArrayList<Bottom> getBottomList() {
        if(bottomList == null){
            bottomList = BottomMapper.getBottomList();
        }
        return bottomList;
    }
}

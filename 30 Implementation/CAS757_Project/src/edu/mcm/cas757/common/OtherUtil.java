package edu.mcm.cas757.common;

import java.text.DecimalFormat;

public class OtherUtil {

    public static float format(float f,String point){
        DecimalFormat format = new DecimalFormat(point);
        return Float.parseFloat(format.format(f));
    }
}

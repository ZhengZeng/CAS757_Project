package edu.mcm.cas757.common;

import java.text.DecimalFormat;

/**
 * User: kuner
 * Date: 13-4-15
 * Time: 下午9:30
 */
public class OtherUtil {

    /*
    *
    * 保留几位小数
    param point #.00两位小数
    */
    public static float format(float f,String point){
        DecimalFormat format = new DecimalFormat(point);
        return Float.parseFloat(format.format(f));
    }
}

package com.forezp.open.utils;



import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by forezp on 2015/12/28.
 * 屏幕操作工具类
 */
public class ScreenUtils {

    /**
     * 获取屏幕px
     * @param context
     * @return  分辨率
     */
    static public int getScreenWidthPixels(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * dip 转px
     * @param context
     * @param dip
     * @return
     */
    static public int dipToPx(Context context, int dip) {
        return (int) (dip * getScreenDensity(context) + 0.5f);
    }

    /**
     * 获取屏幕密度
     * @param context
     * @return
     */

    static public float getScreenDensity(Context context) {
        try {
            DisplayMetrics dm = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                    .getMetrics(dm);
            return dm.density;
        } catch (Exception e) {
            return DisplayMetrics.DENSITY_DEFAULT;
        }
    }
}


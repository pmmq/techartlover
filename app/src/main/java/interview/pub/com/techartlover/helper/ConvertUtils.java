package interview.pub.com.techartlover.helper;

import android.content.res.Resources;

/**
 * Created by Pub on 9/9/2559.
 */
public class ConvertUtils {
    public static float dp2px(Resources resources, float dp) {
        final float scale = resources.getDisplayMetrics().density;
        return  dp * scale + 0.5f;
    }

    public static float sp2px(Resources resources, float sp){
        final float scale = resources.getDisplayMetrics().scaledDensity;
        return sp * scale;
    }
}

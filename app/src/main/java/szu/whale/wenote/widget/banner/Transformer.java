package szu.whale.wenote.widget.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.hyx.whale.wenote.banner.transformer.AccordionTransformer;
import com.hyx.whale.wenote.banner.transformer.BackgroundToForegroundTransformer;
import com.hyx.whale.wenote.banner.transformer.CubeInTransformer;
import com.hyx.whale.wenote.banner.transformer.CubeOutTransformer;
import com.hyx.whale.wenote.banner.transformer.DefaultTransformer;
import com.hyx.whale.wenote.banner.transformer.DepthPageTransformer;
import com.hyx.whale.wenote.banner.transformer.FlipHorizontalTransformer;
import com.hyx.whale.wenote.banner.transformer.FlipVerticalTransformer;
import com.hyx.whale.wenote.banner.transformer.ForegroundToBackgroundTransformer;
import com.hyx.whale.wenote.banner.transformer.RotateDownTransformer;
import com.hyx.whale.wenote.banner.transformer.RotateUpTransformer;
import com.hyx.whale.wenote.banner.transformer.ScaleInOutTransformer;
import com.hyx.whale.wenote.banner.transformer.StackTransformer;
import com.hyx.whale.wenote.banner.transformer.TabletTransformer;
import com.hyx.whale.wenote.banner.transformer.ZoomInTransformer;
import com.hyx.whale.wenote.banner.transformer.ZoomOutSlideTransformer;
import com.hyx.whale.wenote.banner.transformer.ZoomOutTranformer;


public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}

package szu.whale.wenote.widget.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import szu.whale.wenote.widget.banner.transformer.AccordionTransformer;
import szu.whale.wenote.widget.banner.transformer.BackgroundToForegroundTransformer;
import szu.whale.wenote.widget.banner.transformer.CubeInTransformer;
import szu.whale.wenote.widget.banner.transformer.CubeOutTransformer;
import szu.whale.wenote.widget.banner.transformer.DefaultTransformer;
import szu.whale.wenote.widget.banner.transformer.DepthPageTransformer;
import szu.whale.wenote.widget.banner.transformer.FlipHorizontalTransformer;
import szu.whale.wenote.widget.banner.transformer.FlipVerticalTransformer;
import szu.whale.wenote.widget.banner.transformer.ForegroundToBackgroundTransformer;
import szu.whale.wenote.widget.banner.transformer.RotateDownTransformer;
import szu.whale.wenote.widget.banner.transformer.RotateUpTransformer;
import szu.whale.wenote.widget.banner.transformer.ScaleInOutTransformer;
import szu.whale.wenote.widget.banner.transformer.StackTransformer;
import szu.whale.wenote.widget.banner.transformer.TabletTransformer;
import szu.whale.wenote.widget.banner.transformer.ZoomInTransformer;
import szu.whale.wenote.widget.banner.transformer.ZoomOutSlideTransformer;
import szu.whale.wenote.widget.banner.transformer.ZoomOutTranformer;


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

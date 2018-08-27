package com.example.bitmapreader;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * @author: Liujin
 * @version: V1.0
 * @date: 2018-08-22
 * @time: 10:17
 */
public class ScreenSize {

      private static int   sWidth;
      private static int   sHeight;
      private static float s1Dp;

      public static void init ( Context context ) {

            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            sWidth = displayMetrics.widthPixels;
            sHeight = displayMetrics.heightPixels;

            s1Dp = TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, 1f, displayMetrics );
      }

      public static int getWidth ( ) {

            return sWidth;
      }

      public static int getHeight ( ) {

            return sHeight;
      }

      public static int getWidth ( float percent ) {

            return (int) ( sWidth * percent );
      }

      public static int getHeight ( float percent ) {

            return (int) ( sHeight * percent );
      }

      public static float dp ( float dpSize ) {

            return dpSize * s1Dp;
      }
}
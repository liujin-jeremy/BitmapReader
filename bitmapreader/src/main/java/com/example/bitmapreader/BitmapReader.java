package com.example.bitmapreader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.BitmapFactory.Options;
import android.support.annotation.DrawableRes;
import java.io.File;
import java.io.InputStream;

/**
 * @author wuxio
 * @date 2017-05-30
 */
public class BitmapReader {

      /**
       * 解析图片，生成Bitmap对象.从资源文件中解析
       */
      public static Bitmap decodeSampledBitmap (
          Resources res, int resId, int reqWidth, int reqHeight) {
            // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(res, resId, options);
            // 调用下面定义的方法计算inSampleSize值
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            // 使用获取到的inSampleSize值再次解析图片
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeResource(res, resId, options);
      }

      /**
       * 解析图片，生成Bitmap对象.从资源文件中解析
       */
      public static Bitmap decodeMaxSampledBitmap (
          Resources res, int resId, int reqWidth, int reqHeight) {
            // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(res, resId, options);
            // 调用下面定义的方法计算inSampleSize值
            options.inSampleSize = calculateMaxInSampleSize(options, reqWidth, reqHeight);
            // 使用获取到的inSampleSize值再次解析图片
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeResource(res, resId, options);
      }

      /**
       * 解析图片，生成Bitmap对象。使用本地文件
       */
      public static Bitmap decodeSampledBitmap (File file, int reqWidth, int reqHeight) {

            String path = file.getPath();
            // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path);
            // 调用下面定义的方法计算inSampleSize值
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            // 使用获取到的inSampleSize值再次解析图片
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(path);
      }

      /**
       * 解析图片，生成Bitmap对象。使用本地文件
       */
      public static Bitmap decodeMaxSampledBitmap (File file, int reqWidth, int reqHeight) {

            String path = file.getPath();
            // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path);
            // 调用下面定义的方法计算inSampleSize值
            options.inSampleSize = calculateMaxInSampleSize(options, reqWidth, reqHeight);
            // 使用获取到的inSampleSize值再次解析图片
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(path);
      }

      /**
       * 解析图片，生成Bitmap对象。流文件
       */
      public static Bitmap decodeSampledBitmap (InputStream input, int reqWidth, int reqHeight) {

            // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(input, null, options);
            // 调用下面定义的方法计算inSampleSize值
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            // 使用获取到的inSampleSize值再次解析图片
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeStream(input, null, options);
      }

      /**
       * 解析图片，生成Bitmap对象。流文件
       */
      public static Bitmap decodeMaxSampledBitmap (InputStream input, int reqWidth, int reqHeight) {

            // 第一次解析将inJustDecodeBounds设置为true，来获取图片大小
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(input, null, options);
            // 调用下面定义的方法计算inSampleSize值
            options.inSampleSize = calculateMaxInSampleSize(options, reqWidth, reqHeight);
            // 使用获取到的inSampleSize值再次解析图片
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeStream(input, null, options);
      }

      /**
       * 解析一个图片资源到匹配设定的尺寸
       *
       * @param context 提供resource
       * @param id 资源id
       * @param widthSize 要求的宽度
       * @param heightSize 要求的高度
       *
       * @return bitmap
       */
      public static Bitmap decodeBitmapToMatchSize (
          Context context,
          @DrawableRes int id,
          int widthSize,
          int heightSize) {

            BitmapFactory.Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), id, options);

            int outWidth = options.outWidth;
            int outHeight = options.outHeight;

            float fateWidth = outWidth * 1f / widthSize;
            float fateHeight = outHeight * 1f / heightSize;

            if(fateHeight > fateWidth) {

                  options.inDensity = outHeight;
                  options.inTargetDensity = heightSize;
            } else {

                  options.inDensity = outWidth;
                  options.inTargetDensity = widthSize;
            }

            options.inScaled = true;
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeResource(context.getResources(), id, options);
      }

      /**
       * 解析一个图片资源到匹配设定的尺寸
       *
       * @param widthSize 要求的宽度
       * @param heightSize 要求的高度
       *
       * @return bitmap
       */
      public static Bitmap decodeBitmapToMatchSize (
          File file,
          int widthSize,
          int heightSize) {

            BitmapFactory.Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);

            int outWidth = options.outWidth;
            int outHeight = options.outHeight;

            float fateWidth = outWidth * 1f / widthSize;
            float fateHeight = outHeight * 1f / heightSize;

            if(fateHeight > fateWidth) {

                  options.inDensity = outHeight;
                  options.inTargetDensity = heightSize;
            } else {

                  options.inDensity = outWidth;
                  options.inTargetDensity = widthSize;
            }

            options.inScaled = true;
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
      }

      /**
       * 解析一个图片资源到匹配设定的尺寸
       *
       * @param widthSize 要求的宽度
       * @param heightSize 要求的高度
       *
       * @return bitmap
       */
      public static Bitmap decodeBitmapToMatchSize (
          InputStream inputStream,
          int widthSize,
          int heightSize) {

            BitmapFactory.Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);

            int outWidth = options.outWidth;
            int outHeight = options.outHeight;

            float fateWidth = outWidth * 1f / widthSize;
            float fateHeight = outHeight * 1f / heightSize;

            if(fateHeight > fateWidth) {

                  options.inDensity = outHeight;
                  options.inTargetDensity = heightSize;
            } else {

                  options.inDensity = outWidth;
                  options.inTargetDensity = widthSize;
            }

            options.inScaled = true;
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeStream(inputStream, null, options);
      }

      /**
       * 解析一个图片资源到匹配设定的尺寸
       *
       * @param context 提供resource
       * @param id 资源id
       * @param widthSize 要求的宽度
       *
       * @return bitmap
       */
      public static Bitmap decodeBitmapToMatchWidth (
          Context context,
          @DrawableRes int id,
          int widthSize) {

            BitmapFactory.Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), id, options);

            options.inDensity = options.outWidth;
            options.inTargetDensity = widthSize;

            options.inScaled = true;
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeResource(context.getResources(), id, options);
      }

      /**
       * 解析一个图片资源到匹配设定的尺寸
       *
       * @param widthSize 要求的宽度
       *
       * @return bitmap
       */
      public static Bitmap decodeBitmapToMatchWidth (
          File file,
          int widthSize) {

            BitmapFactory.Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);

            options.inDensity = options.outWidth;
            options.inTargetDensity = widthSize;

            options.inScaled = true;
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
      }

      /**
       * 解析一个图片资源到匹配设定的尺寸
       *
       * @param widthSize 要求的宽度
       *
       * @return bitmap
       */
      public static Bitmap decodeBitmapToMatchWidth (
          InputStream inputStream,
          int widthSize) {

            BitmapFactory.Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);

            options.inDensity = options.outWidth;
            options.inTargetDensity = widthSize;

            options.inScaled = true;
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeStream(inputStream, null, options);
      }

      /**
       * 解析一个图片资源到匹配设定的尺寸
       *
       * @param context 提供resource
       * @param id 资源id
       * @param heightSize 要求的宽度
       *
       * @return bitmap
       */
      public static Bitmap decodeBitmapToMatchHeight (
          Context context,
          @DrawableRes int id,
          int heightSize) {

            BitmapFactory.Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), id, options);

            options.inDensity = options.outHeight;
            options.inTargetDensity = heightSize;

            options.inScaled = true;
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeResource(context.getResources(), id, options);
      }

      /**
       * 解析一个图片资源到匹配设定的尺寸
       *
       * @param heightSize 要求的高度
       *
       * @return bitmap
       */
      public static Bitmap decodeBitmapToMatchHeight (
          File file,
          int heightSize) {

            BitmapFactory.Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);

            options.inDensity = options.outHeight;
            options.inTargetDensity = heightSize;

            options.inScaled = true;
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
      }

      /**
       * 解析一个图片资源到匹配设定的尺寸
       *
       * @param heightSize 要求的高度
       *
       * @return bitmap
       */
      public static Bitmap decodeBitmapToMatchHeight (
          InputStream inputStream,
          int heightSize) {

            BitmapFactory.Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);

            options.inDensity = options.outHeight;
            options.inTargetDensity = heightSize;

            options.inScaled = true;
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeStream(inputStream, null, options);
      }

      /**
       * 计算图片缩放比例
       */
      private static int calculateInSampleSize (
          BitmapFactory.Options options, int reqWidth, int reqHeight) {

            if(reqWidth == 0 || reqHeight == 0) {
                  return 1;
            }
            final int height = options.outHeight;
            final int width = options.outWidth;
            int inSampleSize = 1;

            //如果图片宽或者高 大于 view的宽高
            if(height > reqHeight || width > reqWidth) {

                  //计算图片的宽高的一半
                  final int halfHeight = height / 2;
                  final int halfWidth = width / 2;

                  //如果原始图片宽高是 view宽高的 2,4,8,16 ... 倍以上,会压缩图片至宽高任意一条边略大于 view 的 宽高为止,图片质量不会太差
                  while((halfHeight / inSampleSize) >= reqHeight
                      && (halfWidth / inSampleSize) >= reqWidth) {
                        inSampleSize *= 2;
                  }
            }
            return inSampleSize;
      }

      /**
       * 计算图片极限缩放比例,使用宽高采样率中最大的
       */
      private static int calculateMaxInSampleSize (
          BitmapFactory.Options options, int reqWidth, int reqHeight) {

            if(reqWidth == 0 || reqHeight == 0) {
                  return 1;
            }

            final int height = options.outHeight;
            final int width = options.outWidth;
            int inSampleSize = 1;

            //如果图片宽或者高 大于 view的宽高
            if(height > reqHeight || width > reqWidth) {

                  //分别计算宽高采样率,使用其中最大的值
                  while((height / inSampleSize) >= reqHeight) {
                        inSampleSize *= 2;
                  }

                  int heightSampleSize = inSampleSize;

                  while((width / inSampleSize) >= reqWidth) {
                        inSampleSize *= 2;
                  }

                  inSampleSize = heightSampleSize > inSampleSize ? heightSampleSize : inSampleSize;
            }
            return inSampleSize;
      }
}
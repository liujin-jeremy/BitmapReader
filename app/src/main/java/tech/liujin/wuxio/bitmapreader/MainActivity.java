package tech.liujin.wuxio.bitmapreader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.threekilogram.wuxio.bitmapreader.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import tech.liujin.bitmap.BitmapReader;

/**
 * @author liujin
 */
public class MainActivity extends AppCompatActivity {

      private static final String TAG = "MainActivity";

      protected TextView       mTextView;
      protected ImageView      mImageView;
      protected NavigationView mNavigationView;
      protected DrawerLayout   mDrawerLayout;

      @Override
      protected void onCreate ( Bundle savedInstanceState ) {

            super.onCreate( savedInstanceState );
            super.setContentView( R.layout.activity_main );
            initView();
      }

      private void initView ( ) {

            mTextView = findViewById( R.id.textView );
            mImageView = findViewById( R.id.ImageView );
            mNavigationView = findViewById( R.id.navigationView );
            mDrawerLayout = findViewById( R.id.drawerLayout );

            mNavigationView.setCheckedItem( R.id.menu00 );
            mNavigationView.setNavigationItemSelectedListener( new MainMenuItemClick() );
            setSrc();
      }

      private void setSrc ( ) {

            mImageView.setImageResource( R.drawable.src );
            Bitmap bitmap = ( (BitmapDrawable) mImageView.getDrawable() ).getBitmap();
            int count = bitmap.getAllocationByteCount();
            setTextView( bitmap );
      }

      private void setTextView (
          Bitmap bitmap ) {

            String format = String.format(
                Locale.CHINA,
                "图片大小: %d; 宽: %d, 高: %d",
                bitmap.getAllocationByteCount(),
                bitmap.getWidth(),
                bitmap.getHeight()
            );
            mTextView.setText( format );
      }

      //============================ item click ============================

      private void closeDrawer ( ) {

            mDrawerLayout.closeDrawer( Gravity.START );
      }

      //============================ event ============================

      private void scaleSrc ( int width, int height ) {

            Bitmap bitmap = BitmapReader.sampled(
                this,
                R.drawable.src,
                width,
                height,
                Config.ARGB_8888
            );
            mImageView.setImageBitmap( bitmap );
            setTextView( bitmap );
      }

      private void scaleSrcRgb ( int width, int height ) {

            Bitmap bitmap = BitmapReader
                .sampled( this, R.drawable.src, width, height );
            mImageView.setImageBitmap( bitmap );
            setTextView( bitmap );
      }

      private void maxScaleSrc ( int width, int height ) {

            Bitmap bitmap = BitmapReader
                .sampledMost( this, R.drawable.src, width, height, Config.ARGB_8888 );
            mImageView.setImageBitmap( bitmap );
            setTextView( bitmap );
      }

      private void maxScaleSrcRgb ( int width, int height ) {

            Bitmap bitmap = BitmapReader
                .sampledMost( this, R.drawable.src, width, height );
            mImageView.setImageBitmap( bitmap );
            setTextView( bitmap );
      }

      private void matchSize ( int width, int height ) {

            Bitmap bitmap = BitmapReader.matchSizeMost(
                this,
                R.drawable.src,
                500,
                500,
                Config.ARGB_8888
            );

            mImageView.setImageBitmap( bitmap );

            setTextView( bitmap );
      }

      private void matchSizeRgb ( int width, int height ) {

            Bitmap bitmap = BitmapReader.matchSizeMost(
                this,
                R.drawable.src,
                500,
                500
            );

            mImageView.setImageBitmap( bitmap );

            setTextView( bitmap );
      }

      private void matchWidth ( int width ) {

            Bitmap bitmap = BitmapReader.matchWidth(
                this,
                R.drawable.src,
                width,
                Config.ARGB_8888
            );

            mImageView.setImageBitmap( bitmap );

            setTextView( bitmap );
      }

      private void matchWidthRgb ( int width ) {

            Bitmap bitmap = BitmapReader.matchWidth( this, R.drawable.src, width );

            mImageView.setImageBitmap( bitmap );

            Log.e( TAG, "matchWidth : byteCount:"
                + bitmap.getAllocationByteCount()
                + " width: " + bitmap.getWidth() + " "
                + bitmap.getHeight()
            );

            setTextView( bitmap );
      }

      private void matchHeight ( int height ) {

            Bitmap bitmap = BitmapReader.matchHeight(
                this,
                R.drawable.src,
                height,
                Config.ARGB_8888
            );

            mImageView.setImageBitmap( bitmap );

            setTextView( bitmap );
      }

      private void matchHeightRgb ( int height ) {

            Bitmap bitmap = BitmapReader.matchHeight( this, R.drawable.src, height );

            mImageView.setImageBitmap( bitmap );

            Log.e( TAG, "matchWidth : byteCount:"
                + bitmap.getAllocationByteCount()
                + " width: " + bitmap.getWidth() + " "
                + bitmap.getHeight()
            );

            setTextView( bitmap );
      }

      private class MainMenuItemClick implements NavigationView.OnNavigationItemSelectedListener {

            @Override
            public boolean onNavigationItemSelected ( @NonNull MenuItem item ) {

                  switch( item.getItemId() ) {

                        case R.id.menu00:
                              setSrc();
                              break;

                        case R.id.menu01:
                              scaleSrc( 500, 500 );
                              break;

                        case R.id.menu02:
                              maxScaleSrc( 500, 500 );
                              break;

                        case R.id.menu03:
                              matchSize( 500, 500 );
                              break;

                        case R.id.menu04:
                              matchWidth( 500 );
                              break;

                        case R.id.menu05:
                              matchHeight( 500 );
                              break;

                        case R.id.menu06:
                              scaleSrcRgb( 500, 500 );
                              break;

                        case R.id.menu07:
                              maxScaleSrcRgb( 500, 500 );
                              break;

                        case R.id.menu08:
                              matchSizeRgb( 500, 500 );
                              break;

                        case R.id.menu09:
                              matchWidthRgb( 500 );
                              break;

                        case R.id.menu10:
                              matchHeightRgb( 500 );
                              break;

                        case R.id.menu11:
                              clipStart();
                              break;

                        case R.id.menu12:
                              clipEnd();
                              break;

                        case R.id.menu13:
                              clipLeft();
                              break;

                        case R.id.menu14:
                              clipRight();
                              break;

                        case R.id.menu15:
                              clipCenter();
                              break;
                        case R.id.menu16:
                              matchMost();
                              break;
                        case R.id.menu17:
                              matchMostArgb();
                              break;

                        case R.id.menu18:
                              decodeStream();
                              break;

                        default:
                              break;
                  }

                  closeDrawer();
                  return true;
            }
      }

      private void matchMostArgb ( ) {

            Bitmap bitmap = BitmapReader
                .matchSize( this, R.drawable.src, 500, 500, Config.ARGB_8888 );
            mImageView.setImageBitmap( bitmap );
            setTextView( bitmap );
      }

      private void matchMost ( ) {

            Bitmap bitmap = BitmapReader.matchSize( this, R.drawable.src, 500, 500 );
            mImageView.setImageBitmap( bitmap );
            setTextView( bitmap );
      }

      private void clipCenter ( ) {

            Bitmap bitmap = BitmapReader.read( this, R.drawable.src );
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();

            bitmap = BitmapReader.clipCenter( bitmap, 500, 500 );
            mImageView.setImageBitmap( bitmap );

            setTextView( bitmap );
      }

      private void clipRight ( ) {

            Bitmap bitmap = BitmapReader.read( this, R.drawable.src );
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();

            bitmap = BitmapReader.clipRight( bitmap, 500 );
            mImageView.setImageBitmap( bitmap );

            setTextView( bitmap );
      }

      private void clipLeft ( ) {

            Bitmap bitmap = BitmapReader.read( this, R.drawable.src );
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();

            bitmap = BitmapReader.clipLeft( bitmap, 500 );
            mImageView.setImageBitmap( bitmap );

            setTextView( bitmap );
      }

      private void clipEnd ( ) {

            Bitmap bitmap = BitmapReader.read( this, R.drawable.src );
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();

            bitmap = BitmapReader.clipBottom( bitmap, 500 );
            mImageView.setImageBitmap( bitmap );

            setTextView( bitmap );
      }

      private void clipStart ( ) {

            Bitmap bitmap = BitmapReader.read( this, R.drawable.src );
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();

            bitmap = BitmapReader.clipTop( bitmap, 500 );
            mImageView.setImageBitmap( bitmap );

            setTextView( bitmap );
      }

      private void decodeStream ( ) {

            try {
                  InputStream stream = getAssets().open( "src.jpg" );
                  Bitmap bitmap = BitmapReader.matchWidth( stream, 500 );
                  mImageView.setImageBitmap( bitmap );

                  setTextView( bitmap );
                  Log.i( TAG, "decodeStream: " + bitmap );
            } catch(IOException e) {
                  e.printStackTrace();
            }
      }

      public static int getStatusBarHeight ( Context context ) {

            int statusBarHeight = 0;
            Resources res = context.getResources();
            int resourceId = res.getIdentifier(
                "status_bar_height",
                "dimen",
                "android"
            );
            if( resourceId > 0 ) {
                  statusBarHeight = res.getDimensionPixelSize( resourceId );
            }
            return statusBarHeight;
      }
}

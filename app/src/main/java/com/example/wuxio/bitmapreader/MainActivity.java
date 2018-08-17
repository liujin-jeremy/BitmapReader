package com.example.wuxio.bitmapreader;

import android.graphics.Bitmap;
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
import com.example.bitmapreader.BitmapReader;
import java.util.Locale;

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
            setTextView( mTextView, count, bitmap.getWidth(), bitmap.getHeight() );
      }

      private void setTextView (
          TextView textView, int byteCount, int bitmapWidth, int bitmapHeight ) {

            String format = String.format(
                Locale.CHINA,
                "原始大小: %d;   bitmap宽: %d, 高: %d",
                byteCount,
                bitmapWidth,
                bitmapHeight
            );
            textView.setText( format );
      }

      //============================ item click ============================

      private void closeDrawer ( ) {

            mDrawerLayout.closeDrawer( Gravity.START );
      }

      //============================ event ============================

      private void scaleSrc ( int width, int height ) {

            Bitmap bitmap = BitmapReader
                .sampledBitmap( this, R.drawable.src, width, height );
            mImageView.setImageBitmap( bitmap );
            setTextView(
                mTextView, bitmap.getAllocationByteCount(), bitmap.getWidth(), bitmap.getHeight() );
      }

      private void maxScaleSrc ( int width, int height ) {

            Bitmap bitmap = BitmapReader
                .maxSampledBitmap( this, R.drawable.src, width, height );
            mImageView.setImageBitmap( bitmap );
            setTextView(
                mTextView, bitmap.getAllocationByteCount(), bitmap.getWidth(), bitmap.getHeight() );
      }

      private void matchSize ( int width, int height ) {

            Bitmap bitmap = BitmapReader.matchSize( this, R.drawable.src, 500, 500 );

            mImageView.setImageBitmap( bitmap );

            Log.e( TAG, "matchSize : size:"
                + bitmap.getAllocationByteCount()
                + " width: " + bitmap.getWidth() + " "
                + bitmap.getHeight()
            );

            setTextView(
                mTextView,
                bitmap.getAllocationByteCount(),
                bitmap.getWidth(),
                bitmap.getHeight()
            );
      }

      private void matchWidth ( int width ) {

            Bitmap bitmap = BitmapReader.matchWidth( this, R.drawable.src, width );

            mImageView.setImageBitmap( bitmap );

            Log.e( TAG, "matchWidth : byteCount:"
                + bitmap.getAllocationByteCount()
                + " width: " + bitmap.getWidth() + " "
                + bitmap.getHeight()
            );

            setTextView(
                mTextView,
                bitmap.getAllocationByteCount(),
                bitmap.getWidth(),
                bitmap.getHeight()
            );
      }

      private void matchHeight ( int height ) {

            Bitmap bitmap = BitmapReader.matchHeight( this, R.drawable.src, height );

            mImageView.setImageBitmap( bitmap );

            Log.e( TAG, "matchWidth : byteCount:"
                + bitmap.getAllocationByteCount()
                + " width: " + bitmap.getWidth() + " "
                + bitmap.getHeight()
            );

            setTextView(
                mTextView,
                bitmap.getAllocationByteCount(),
                bitmap.getWidth(),
                bitmap.getHeight()
            );
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
                        default:
                              break;
                  }

                  closeDrawer();
                  return true;
            }
      }
}

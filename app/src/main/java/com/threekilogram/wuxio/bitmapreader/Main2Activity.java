package com.threekilogram.wuxio.bitmapreader;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.threekilogram.bitmapreader.BitmapReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity implements OnClickListener {

      private static final String    TAG = Main2Activity.class.getSimpleName();
      private              ImageView mImageView;
      private              Button    mRead;
      private              Button    mSample;
      private              Button    mSampleMost;
      private              Button    mMatchSize;
      private              Button    mMatchSizeMost;
      private              Button    mMatchWidth;
      private              Button    mMatchHeight;
      private              Button    mClipLeft;
      private              Button    mClipTop;
      private              Button    mClipRight;
      private              Button    mClipBottom;
      private              Button    mClipCenter;
      private              TextView  mTextView;
      private              Button    mMatchSizeFile;
      private              Button    mMatchSizeFD;
      private              Button    mMatchSizeFilePath;
      private              Button    mMatchSizeStream;

      @Override
      protected void onCreate ( Bundle savedInstanceState ) {

            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_main2 );
            initView();

            File filesDir = getFilesDir();
            File local = new File( filesDir, "src.jpg" );
            copyFile( local );
      }

      private void initView ( ) {

            mImageView = (ImageView) findViewById( R.id.imageView );
            mRead = (Button) findViewById( R.id.read );
            mRead.setOnClickListener( this );
            mSample = (Button) findViewById( R.id.sample );
            mSample.setOnClickListener( this );
            mSampleMost = (Button) findViewById( R.id.sampleMost );
            mSampleMost.setOnClickListener( this );
            mMatchSize = (Button) findViewById( R.id.matchSize );
            mMatchSize.setOnClickListener( this );
            mMatchSizeMost = (Button) findViewById( R.id.matchSizeMost );
            mMatchSizeMost.setOnClickListener( this );
            mMatchWidth = (Button) findViewById( R.id.matchWidth );
            mMatchWidth.setOnClickListener( this );
            mMatchHeight = (Button) findViewById( R.id.matchHeight );
            mMatchHeight.setOnClickListener( this );
            mClipLeft = (Button) findViewById( R.id.clipLeft );
            mClipLeft.setOnClickListener( this );
            mClipTop = (Button) findViewById( R.id.clipTop );
            mClipTop.setOnClickListener( this );
            mClipRight = (Button) findViewById( R.id.clipRight );
            mClipRight.setOnClickListener( this );
            mClipBottom = (Button) findViewById( R.id.clipBottom );
            mClipBottom.setOnClickListener( this );
            mClipCenter = (Button) findViewById( R.id.clipCenter );
            mClipCenter.setOnClickListener( this );
            mTextView = (TextView) findViewById( R.id.textView );
            mMatchSizeFile = (Button) findViewById( R.id.matchSizeFile );
            mMatchSizeFile.setOnClickListener( this );
            mMatchSizeFD = (Button) findViewById( R.id.matchSizeFD );
            mMatchSizeFD.setOnClickListener( this );
            mMatchSizeFilePath = (Button) findViewById( R.id.matchSizeFilePath );
            mMatchSizeFilePath.setOnClickListener( this );
            mMatchSizeStream = (Button) findViewById( R.id.matchSizeStream );
            mMatchSizeStream.setOnClickListener( this );
      }

      private void copyFile ( File local ) {

            if( !local.exists() ) {
                  FileOutputStream outputStream = null;
                  InputStream open = null;
                  try {
                        outputStream = new FileOutputStream( local );
                        open = getAssets().open( "src.jpg" );

                        byte[] temp = new byte[ 128 ];
                        int len = 0;
                        while( len != -1 ) {
                              outputStream.write( temp, 0, len );
                              len = open.read( temp );
                        }
                        Log.i( TAG, "onCreate: " + local + " " + local.exists() );
                  } catch(FileNotFoundException e) {
                        e.printStackTrace();
                  } catch(IOException e) {
                        e.printStackTrace();
                  } finally {
                        try {
                              outputStream.close();
                        } catch(IOException e) {
                              e.printStackTrace();
                        }
                        try {
                              open.close();
                        } catch(IOException e) {
                              e.printStackTrace();
                        }
                  }
            }
      }

      private void setBitmapMessage ( Bitmap bitmap ) {

            String format = String.format(
                Locale.CHINA,
                "宽: %d, 高: %d, 图片大小: %d",
                bitmap.getWidth(),
                bitmap.getHeight(),
                bitmap.getAllocationByteCount()
            );
            mTextView.setText( format );
      }

      @Override
      public void onClick ( View v ) {

            File filesDir = getFilesDir();
            File local = new File( filesDir, "src.jpg" );
            Bitmap bitmap = null;

            switch( v.getId() ) {
                  case R.id.read:
                        bitmap = BitmapReader.read( this, R.drawable.src );
                        mImageView.setImageBitmap( bitmap );
                        setBitmapMessage( bitmap );
                        break;
                  case R.id.sample:
                        bitmap = BitmapReader.sampled( this, R.drawable.src, 400, 400 );
                        mImageView.setImageBitmap( bitmap );
                        setBitmapMessage( bitmap );
                        break;
                  case R.id.sampleMost:
                        bitmap = BitmapReader.sampledMost( this, R.drawable.src, 400, 400 );
                        mImageView.setImageBitmap( bitmap );
                        setBitmapMessage( bitmap );
                        break;
                  case R.id.matchSize:
                        bitmap = BitmapReader.matchSize( this, R.drawable.src, 400, 400 );
                        mImageView.setImageBitmap( bitmap );
                        setBitmapMessage( bitmap );
                        break;
                  case R.id.matchSizeMost:
                        bitmap = BitmapReader.matchSizeMost( this, R.drawable.src, 400, 400 );
                        mImageView.setImageBitmap( bitmap );
                        setBitmapMessage( bitmap );
                        break;
                  case R.id.matchWidth:
                        bitmap = BitmapReader.matchWidth( this, R.drawable.src, 400 );
                        mImageView.setImageBitmap( bitmap );
                        setBitmapMessage( bitmap );
                        break;
                  case R.id.matchHeight:
                        bitmap = BitmapReader.matchHeight( this, R.drawable.src, 400 );
                        mImageView.setImageBitmap( bitmap );
                        setBitmapMessage( bitmap );
                        break;
                  case R.id.matchSizeFile:
                        bitmap = BitmapReader.matchSize( local, 400, 400 );
                        mImageView.setImageBitmap( bitmap );
                        setBitmapMessage( bitmap );
                        break;
                  case R.id.matchSizeFD:
                        try {
                              RandomAccessFile accessFile = new RandomAccessFile( local, "rwd" );
                              FileDescriptor fd = accessFile.getFD();
                              bitmap = BitmapReader.matchSize( fd, 400, 400 );
                              mImageView.setImageBitmap( bitmap );
                              setBitmapMessage( bitmap );
                        } catch(FileNotFoundException e) {
                              e.printStackTrace();
                        } catch(IOException e) {
                              e.printStackTrace();
                        }
                        break;
                  case R.id.matchSizeFilePath:
                        bitmap = BitmapReader.matchSize( local.getAbsolutePath(), 400, 400 );
                        mImageView.setImageBitmap( bitmap );
                        setBitmapMessage( bitmap );
                        break;
                  case R.id.matchSizeStream:
                        try {
                              bitmap = BitmapReader.matchSize( getAssets().open( "src.jpg" ), 400, 400 );
                              mImageView.setImageBitmap( bitmap );
                              setBitmapMessage( bitmap );
                        } catch(IOException e) {
                              e.printStackTrace();
                        }
                        break;
                  case R.id.clipLeft:
                        bitmap = BitmapReader.read( this, R.drawable.src );
                        Bitmap left = BitmapReader.clipLeft( bitmap, 200 );
                        mImageView.setImageBitmap( left );
                        setBitmapMessage( left );
                        break;
                  case R.id.clipTop:
                        bitmap = BitmapReader.read( this, R.drawable.src );
                        Bitmap top = BitmapReader.clipTop( bitmap, 200 );
                        mImageView.setImageBitmap( top );
                        setBitmapMessage( top );
                        break;
                  case R.id.clipRight:
                        bitmap = BitmapReader.read( this, R.drawable.src );
                        Bitmap right = BitmapReader.clipRight( bitmap, 200 );
                        mImageView.setImageBitmap( right );
                        setBitmapMessage( right );
                        break;
                  case R.id.clipBottom:
                        bitmap = BitmapReader.read( this, R.drawable.src );
                        Bitmap bottom = BitmapReader.clipBottom( bitmap, 200 );
                        mImageView.setImageBitmap( bottom );
                        setBitmapMessage( bottom );
                        break;
                  case R.id.clipCenter:
                        bitmap = BitmapReader.read( this, R.drawable.src );
                        Bitmap center = BitmapReader.clipCenter( bitmap, 200, 200 );
                        mImageView.setImageBitmap( center );
                        setBitmapMessage( center );
                        break;
                  default:
                        break;
            }
      }
}

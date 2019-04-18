
## BitmapReader

bitmap 解析工具

```
implementation 'tech.liujin:bitmapReader:1.0.0'
```

### 使用

```
// 使用采样率压缩,即压缩后宽度高度均比设置的值大一点
Bitmap bitmap = BitmapReader.sampledBitmap( this, R.drawable.src, width, height ); //资源
Bitmap bitmap = BitmapReader.sampledBitmap( file, width, height );//文件
Bitmap bitmap = BitmapReader.sampledBitmap( fileDescriptor, width, height );//文件描述符
Bitmap bitmap = BitmapReader.sampledBitmap( filePath, width, height );//文件路径
Bitmap bitmap = BitmapReader.sampledBitmap( inputStream, width, height );//图片文件流
```

```
// 使用采样率压缩,即压缩后宽度高度均比设置的值小一点
Bitmap bitmap = BitmapReader.maxSampledBitmap( this, R.drawable.src, width, height );
Bitmap bitmap = BitmapReader.maxSampledBitmap( file, width, height );//文件
Bitmap bitmap = BitmapReader.maxSampledBitmap( fileDescriptor, width, height );//文件描述符
Bitmap bitmap = BitmapReader.maxSampledBitmap( filePath, width, height );//文件路径
Bitmap bitmap = BitmapReader.maxSampledBitmap( inputStream, width, height );//图片文件流
```

```
// 将图片压缩至宽度或者高度一个符合设置的要求,另一个大于设置的要求
Bitmap bitmap = BitmapReader.matchSizeMost( this, R.drawable.src, width, height );
Bitmap bitmap = BitmapReader.matchSizeMost( file, width, height );//文件
Bitmap bitmap = BitmapReader.matchSizeMost( fileDescriptor, width, height );//文件描述符
Bitmap bitmap = BitmapReader.matchSizeMost( filePath, width, height );//文件路径
Bitmap bitmap = BitmapReader.matchSizeMost( inputStream, width, height );//图片文件流
```

```
// 将图片压缩至宽度或者高度一个符合设置的要求,另一个小于设置的要求
Bitmap bitmap = BitmapReader.matchSize( this, R.drawable.src, width, height );
Bitmap bitmap = BitmapReader.matchSize( file, width, height );//文件
Bitmap bitmap = BitmapReader.matchSize( fileDescriptor, width, height );//文件描述符
Bitmap bitmap = BitmapReader.matchSize( filePath, width, height );//文件路径
Bitmap bitmap = BitmapReader.matchSize( inputStream, width, height );//图片文件流
```

```
// 将图片压缩至宽度符合设置的要求
Bitmap bitmap = BitmapReader.matchWidth( this, R.drawable.src, width );
Bitmap bitmap = BitmapReader.matchWidth( file, width, height );//文件
Bitmap bitmap = BitmapReader.matchWidth( fileDescriptor, width, height );//文件描述符
Bitmap bitmap = BitmapReader.matchWidth( filePath, width, height );//文件路径
Bitmap bitmap = BitmapReader.matchWidth( inputStream, width, height );//图片文件流
```

```
// 将图片压缩至高度符合设置的要求
Bitmap bitmap = BitmapReader.matchHeight( this, R.drawable.src, height );
Bitmap bitmap = BitmapReader.matchHeight( file, width, height );//文件
Bitmap bitmap = BitmapReader.matchHeight( fileDescriptor, width, height );//文件描述符
Bitmap bitmap = BitmapReader.matchHeight( filePath, width, height );//文件路径
Bitmap bitmap = BitmapReader.matchHeight( inputStream, width, height );//图片文件流
```



## 裁剪

```
// 以图片中心为中心,裁剪指定的尺寸
bitmap = BitmapReader.clipCenter( bitmap, 500, 500 );
// 裁剪图片右边指定宽度
bitmap = BitmapReader.clipRight( bitmap, 500 );
// 裁剪左边指定宽度
bitmap = BitmapReader.clipLeft( bitmap, 500 );
// 裁剪底部指定高度
bitmap = BitmapReader.clipBottom( bitmap, 500 );
// 裁剪上部指定高度
bitmap = BitmapReader.clipTop( bitmap, 500 );
```




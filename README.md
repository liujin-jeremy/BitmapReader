
## BitmapReader

bitmap 解析工具

```
implementation 'tech.threekilogram:bitmapReader:2.0.3'
```

### 使用

```
// 使用采样率压缩,即压缩后宽度高度均比设置的值大一点
Bitmap bitmap = BitmapReader.sampledBitmap( this, R.drawable.src, width, height );
```

```
// 使用采样率压缩,即压缩后宽度高度均比设置的值小一点
Bitmap bitmap = BitmapReader.maxSampledBitmap( this, R.drawable.src, width, height );
```

```
// 将图片压缩至宽度或者高度一个符合设置的要求,另一个大于设置的要求
Bitmap bitmap = BitmapReader.matchSizeMost( this, R.drawable.src, width, height );
```

```
// 将图片压缩至宽度或者高度一个符合设置的要求,另一个小于设置的要求
Bitmap bitmap = BitmapReader.matchSize( this, R.drawable.src, width, height );
```

```
// 将图片压缩至宽度符合设置的要求
Bitmap bitmap = BitmapReader.matchWidth( this, R.drawable.src, width );
```

```
// 将图片压缩至高度符合设置的要求
Bitmap bitmap = BitmapReader.matchHeight( this, R.drawable.src, height );
```


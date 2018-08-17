
## BitmapReader

bitmap 解析工具

### 引入

**Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```
	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency

```
	dependencies {
	        implementation 'com.github.threekilogram:BitmapReader:1.1.6'
	}
```

### 使用

```
// 将图片压缩至宽度或者高度任一小于设置的要求
Bitmap bitmap = BitmapReader.decodeSampledBitmap( this, R.drawable.src, width, height );
```

```
// 将图片压缩至宽度或者高度全部小于设置的要求
Bitmap bitmap = BitmapReader.decodeMaxSampledBitmap( this, R.drawable.src, width, height );
```

```
// 将图片压缩至宽度或者高度任一符合设置的要求
Bitmap bitmap = BitmapReader.decodeBitmapToMatchSize( this, R.drawable.src, 500, 500 );
```

```
// 将图片压缩至宽度符合设置的要求
Bitmap bitmap = BitmapReader.decodeBitmapToMatchWidth( this, R.drawable.src, width );
```

```
// 将图片压缩至高度符合设置的要求
Bitmap bitmap = BitmapReader.decodeBitmapToMatchHeight( this, R.drawable.src, height );
```
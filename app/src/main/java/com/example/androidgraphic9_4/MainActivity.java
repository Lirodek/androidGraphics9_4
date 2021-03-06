package com.example.androidgraphic9_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }
    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);

            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.elaina2);

            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            Paint paint = new Paint();
            BlurMaskFilter bMask;
//            bMask = new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL);

//            bMask = new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER);

//            bMask = new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER);

            bMask = new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID);

            paint.setMaskFilter(bMask);
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();

        }
    }
}
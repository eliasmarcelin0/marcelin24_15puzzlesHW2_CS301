package com.example.marcelin24_15puzzleshw2_cs301;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class boardView extends SurfaceView implements SurfaceHolder.Callback
{
    private Paint paint;
    private Paint paint2;
    private RectF[] rects;

    public boardView(Context context) {
        super(context);
        init();
    }

    public boardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint2 = new Paint();
        paint2.setColor(Color.BLACK);
        paint2.setStyle(Paint.Style.FILL);

        rects = new RectF[16];
        for (int i = 0; i < rects.length; i++) {
            rects[i] = new RectF();
        }

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawRectangles();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        drawRectangles();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    private void drawRectangles() {
        Canvas canvas = getHolder().lockCanvas();
        if (canvas != null) {
            canvas.drawColor(Color.BLACK);

            int columns = 4;
            int rows = 4;
            int padding = 10;

            int cellWidth = (canvas.getWidth() - padding * (columns + 1)) / columns;
            int cellHeight = (canvas.getHeight() - padding * (rows + 1)) / rows;

            for (int i = 0; i < rects.length; i++) {
                int row = i / columns;
                int col = i % columns;

                float left = padding + col * (cellWidth + padding);
                float top = padding + row * (cellHeight + padding);
                float right = left + cellWidth;
                float bottom = top + cellHeight;

                rects[i].set(left, top, right, bottom);

                canvas.drawRect(rects[i], paint);
                paint2.setTextSize(220);
                canvas.drawText(Integer.toString(i), (right - left), (bottom - top), paint2);

            }

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

} // end of class

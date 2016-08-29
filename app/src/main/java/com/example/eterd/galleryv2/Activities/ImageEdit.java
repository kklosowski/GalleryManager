package com.example.eterd.galleryv2.Activities;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
/**
 * Created by Eter on 11/16/2015.
 */
public class ImageEdit {

    public Bitmap rotateThumbnail(Bitmap bitmap, int rotation, boolean full) {

        Bitmap bitmapRotated;

        if (!full){
            Matrix matrix = new Matrix();
            matrix.postRotate(rotation);
            bitmapRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        else {
            Matrix matrix = new Matrix();
            matrix.postRotate(rotation);
            bitmapRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth()/4, bitmap.getHeight()/4, matrix, true);
        }

        return bitmapRotated;
    }
}

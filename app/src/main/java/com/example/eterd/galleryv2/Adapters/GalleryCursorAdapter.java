package com.example.eterd.galleryv2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;

import com.example.eterd.galleryv2.Activities.GalleryItemFullscreenActivity;
import com.example.eterd.galleryv2.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by eterd on 10/22/2015.
 */
public class GalleryCursorAdapter extends CursorAdapter {
    private ArrayList<String> mPathArrayList;
    public GalleryCursorAdapter(Context context, Cursor cursor, int flags, ArrayList<String> pathArrayList) {
        super(context, cursor, 0);
        mPathArrayList = pathArrayList;
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.gallery_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        //BitmapFactory.Options options = new BitmapFactory.Options();
        //options.inJustDecodeBounds = true;
        //Bitmap bitmap = BitmapFactory.decodeFile(path, options);
        //options.inSampleSize = calculateInSampleSize(options, 520,520);
        //options.inJustDecodeBounds = false;
        //loadBitmap(path, imgView, options);
        //bitmap = BitmapFactory.decodeFile(path, options);
        //imgView.setImageBitmap(bitmap);
        //imgView.setImageURI(path);

        ImageView imgView = (ImageView) view.findViewById(R.id.itemImageView);
        final String path = cursor.getString(1);

        File file = new File(path);
        Picasso.with(context).load(file).resize(200, 200).placeholder(R.drawable.placeholder).centerCrop().into(imgView);

        imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), GalleryItemFullscreenActivity.class);
                intent.putExtra("path", path);
                intent.putStringArrayListExtra("pathArrayList",mPathArrayList);
                v.getContext().startActivity(intent);
            }
        });
    }


}
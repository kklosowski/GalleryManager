package com.example.eterd.galleryv2.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.eterd.galleryv2.R;
import com.example.eterd.galleryv2.Views.TouchImageView;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by eterd on 10/24/2015.
 */
public class GalleryItemFullscreenActivity extends Activity {
    private ArrayList<String> mPathArrayList;
    private String mPath;
    private int mCurrentId;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_item_full_screen);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        Intent intent = getIntent();

        mPath = intent.getExtras().getString("path");
        mPathArrayList = intent.getStringArrayListExtra("pathArrayList");
        mCurrentId = getCurrentId(mPath);


        File file = new File(mPath);
        TouchImageView imageView = (TouchImageView) findViewById(R.id.imageViewFullscreen);

        Picasso.with(getApplicationContext()).load(file).into(imageView);
    }
    
    private int getCurrentId(String path) {
        int index = 0;
        for (String s: mPathArrayList
             ) {
            if(s.equals(path)) return index;

            index++;
        }
        return 0;
    }
}

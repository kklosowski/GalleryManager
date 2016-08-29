package com.example.eterd.galleryv2.Activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.eterd.galleryv2.R;

public class ImageEditActivity extends AppCompatActivity {
    public ImageEdit imageEdit = new ImageEdit();
    public ImageView editImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_edit);

        editImageView = (ImageView) findViewById(R.id.editImageView);

        final Button rotateButton = (Button) findViewById(R.id.rotateButton);
        final SeekBar rotateSeekBar = (SeekBar) findViewById(R.id.rotateSeekBar);
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateSeekBar.setVisibility(View.VISIBLE);
                rotateSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                     //   editImageView.setImageBitmap(imageEdit.rotate(((BitmapDrawable) editImageView.getDrawable()).getBitmap(), i));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                       // seekBar.getProgress()
                    }
                });
            }
        });
    }
}

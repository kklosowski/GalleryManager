package com.example.eterd.galleryv2.Activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.eterd.galleryv2.Adapters.TextSpinnerAdapter;
import com.example.eterd.galleryv2.Fragments.FontDialogFragment;
import com.example.eterd.galleryv2.R;

import java.io.IOException;
import java.util.Arrays;

public class TextComposeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_compose);

        Button fontButton = (Button) findViewById(R.id.fontButton);

        fontButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showFontDialog();

            }
        });

        try {
            String[] fontsArray = getAssets().list("Fonts");
            TextSpinnerAdapter textSpinnerAdapter = new TextSpinnerAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, Arrays.asList(fontsArray));
            final Spinner spinner = (Spinner) findViewById(R.id.spinnerAct);
            spinner.setAdapter(textSpinnerAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    EditText editText = (EditText) findViewById(R.id.editText);
                    Typeface font = Typeface.createFromAsset(getAssets(), "Fonts/" + spinner.getSelectedItem().toString());
                    editText.setTypeface(font);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void showFontDialog() {

        FontDialogFragment fontDialogFragment = new FontDialogFragment();
        fontDialogFragment.show( getFragmentManager(), "tag");
        Log.v("xx", "showFontDialog");

    }
}

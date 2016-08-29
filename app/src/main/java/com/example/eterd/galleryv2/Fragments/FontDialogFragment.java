package com.example.eterd.galleryv2.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;

import com.example.eterd.galleryv2.R;
import com.example.eterd.galleryv2.Adapters.TextSpinnerAdapter;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Eter on 11/2/2015.
 */
public class FontDialogFragment extends DialogFragment {

    String[] fontsArray;

    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.text_compose_dialog, null, false))
                .setPositiveButton("Select", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //On font selected
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //On canceled
                    }
                });


        Log.v("xx", "onCreateDialog");
        return builder.create();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
     super.onViewCreated(view, savedInstanceState);
        Log.v("xx", "onCreatedView");
        try {
            fontsArray = getActivity().getAssets().list("Fonts");
            TextSpinnerAdapter textSpinnerAdapter = new TextSpinnerAdapter(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, Arrays.asList(fontsArray));
            Spinner spinner = (Spinner) getActivity().findViewById(R.id.fontSpinner);
            spinner.setAdapter(textSpinnerAdapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.eterd.galleryv2.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Eter on 11/4/2015.
 */
public class TextSpinnerAdapter extends ArrayAdapter<String> {

    public TextSpinnerAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setText("item");
        Log.v("xx", getItem(position));
        //view.setTypeface(getItem());
        return view;
    }

    @Override
    public View getDropDownView(final int position, View convertView, ViewGroup parent){

        final TextView view = (TextView) super.getDropDownView(position, convertView, parent);

        new Thread(new Runnable() {
            public void run() {
                view.post(new Runnable() {
                    public void run() {
                        view.setText(getItem(position));
                        Typeface font = Typeface.createFromAsset(getContext().getAssets(),"Fonts/"+getItem(position));
                        view.setTypeface(font);
                    }
                });
            }
        }).start();

        return  view;
    }


}

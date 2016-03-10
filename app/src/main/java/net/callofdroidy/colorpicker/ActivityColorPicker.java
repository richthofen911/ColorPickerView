package net.callofdroidy.colorpicker;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityColorPicker extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);


        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        float density = metrics.density;
        Log.e("width & height", config.screenWidthDp * density + "--" + config.screenHeightDp * density);

        View viewColorPicker = new ColorPickerView(this, new ColorPickerView.OnColorChangedListener(){
            @Override
            public void onColorChanged(String str,int color) {
                ActivityColorPicker.this.findViewById(android.R.id.content).setBackgroundColor(color);
            }
        }, Color.WHITE, Color.WHITE, config.screenWidthDp * density, config.screenHeightDp * density, density);

        LinearLayout rootView = (LinearLayout) findViewById(R.id.root_layout);
        rootView.addView(viewColorPicker);

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.activity_color_picker, null);

    }

}

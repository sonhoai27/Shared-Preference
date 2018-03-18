package com.sonhoai.sonho.sharepreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bai2SharedPreference extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_shared_preference);
        Button btn=(Button) findViewById(R.id.btnsetting);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent=new Intent(Bai2SharedPreference.this,
                        MySettingActivity.class);
                startActivityForResult(intent, 113);
            }
        });
        Context ctx=getApplicationContext();
        SharedPreferences pre= PreferenceManager.
                getDefaultSharedPreferences(ctx);
        pre.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        boolean data=sharedPreferences.getBoolean(s, false);
        TextView txt=(TextView) findViewById(R.id.textView1);
        if(data==true)
        {
            txt.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
        }
        else
        {
            txt.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        }
    }
}

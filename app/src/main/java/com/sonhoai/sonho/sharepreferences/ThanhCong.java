package com.sonhoai.sonho.sharepreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThanhCong extends AppCompatActivity {
    TextView txtMsg;
    Button btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_cong);
        txtMsg=(TextView) findViewById(R.id.txtmsg);
        btnThoat=(Button) findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
        Intent i=getIntent();
        txtMsg.setText("Hello : "+i.getStringExtra("user"));
    }
}

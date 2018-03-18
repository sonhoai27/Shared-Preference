package com.sonhoai.sonho.sharepreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText edituser,editpassword;
    CheckBox chksaveaccount;
    String prefname="my_data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin=(Button) findViewById(R.id.btnlogin);
        edituser =(EditText)
                findViewById(R.id.editUser);
        editpassword=(EditText)
                findViewById(R.id.editPassword);
        chksaveaccount=(CheckBox)
                findViewById(R.id.chksaveacount);
        btnlogin.setOnClickListener(
            new View.OnClickListener() {
                public void onClick(View arg0) {
                    doLogin();
                }
            });
    }

    public void doLogin()
    {
        finish();
        Intent i=new Intent(this, ThanhCong.class);
        i.putExtra("user", edituser.getText().toString());
        startActivity(i);
    }
    @Override
    protected void onPause() {
        super.onPause();
        savingPreferences();
    }
    @Override
    protected void onResume() {
        super.onResume();
        restoringPreferences();
    }

    public void savingPreferences()
    {
        SharedPreferences pre=getSharedPreferences
                (prefname, MODE_PRIVATE);
        SharedPreferences.Editor editor=pre.edit();
        String user=edituser.getText().toString();
        String pwd=editpassword.getText().toString();
        boolean bchk=chksaveaccount.isChecked();
        if(!bchk)
        {
            editor.clear();
        }
        else
        {
            editor.putString("user", user);
            editor.putString("pwd", pwd);
            editor.putBoolean("checked", bchk);
        }
        editor.commit();
    }
    public void restoringPreferences()
    {
        SharedPreferences pre=getSharedPreferences
                (prefname,MODE_PRIVATE);
        boolean bchk=pre.getBoolean("checked", false);
        if(bchk)
        {
            String user=pre.getString("user", "");
            String pwd=pre.getString("pwd", "");
            edituser.setText(user);
            editpassword.setText(pwd);
        }
        chksaveaccount.setChecked(bchk);
    }
}

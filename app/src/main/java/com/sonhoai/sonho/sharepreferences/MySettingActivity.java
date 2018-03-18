package com.sonhoai.sonho.sharepreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by sonho on 3/18/2018.
 */

public class MySettingActivity extends PreferenceActivity {
    protected void onCreate
        (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.mypreferencelayout);
        }
}



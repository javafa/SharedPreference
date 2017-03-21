package com.veryworks.android.sharedpreference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    // 내부저장소 절대경로 가져오기 ( /data/data/패키지명/files )
    String internalStoragePath;
    final String propertyFile = "test.properties";


    EditText editName;
    Switch switchShuffle;

    RelativeLayout layout;

    PropertyUtil propertyUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        propertyUtil = PropertyUtil.getInstance(this);

        internalStoragePath = getFilesDir().getAbsolutePath();

        editName = (EditText) findViewById(R.id.editName);
        switchShuffle = (Switch) findViewById(R.id.switchShuffle);
        layout = (RelativeLayout) findViewById(R.id.layout2);

        // firstOpen 체크가 되어 있으면 도움말 레이아웃을 닫아준다
        if("false".equals(propertyUtil.getProperty("firstOpen"))){
            layout.setVisibility(View.GONE);
        }
    }

    public void closeHelp(View view){
        layout.setVisibility(View.GONE);
        propertyUtil.saveProperty("firstOpen", "false");
    }

    public void saveSetting(View view){

    }


}












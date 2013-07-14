package com.sample.orientation;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button btn;
    static final String ORIENTATION_PORTRAIT = "Portrait mode";
    static final String ORIENTATION_LANDSCAPE = "Landscape mode";

    // определяем изменение ориентации экрана
    boolean mState = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // not right way, use option in manifest

        btn = (Button) findViewById(R.id.button1);
        // set default text display
        btn.setText(ORIENTATION_LANDSCAPE);


        EditText edit = (EditText)findViewById(R.id.editTest);
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this,
                        "onTextChanged: " + s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private String getScreenOrientation(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return "Портретная ориентация";
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return "Альбомная ориентация";
        else
            return "";
    }

    private String mOrientation = "";
    private boolean isLandscapeMode(Activity acitivity)
    {
        int width =
                acitivity.getWindowManager().getDefaultDisplay().getWidth();
        int height =
                acitivity.getWindowManager().getDefaultDisplay().getHeight();

        boolean isLandscape = width > height;

        if(isLandscape)
            mOrientation = "Альбомная";
        else
            mOrientation = "Портретная";

        return isLandscape;
    }


    private String getRotateOrientation() {
        int rotate = getWindowManager().getDefaultDisplay().getRotation();
        switch (rotate) {
            case Surface.ROTATION_0:
                return "Не поворачивали";
            case Surface.ROTATION_90:
                return "Повернули на 90 градусов по часовой стрелке";
            case Surface.ROTATION_180:
                return "Повернули на 180 градусов";
            case Surface.ROTATION_270:
                return "Повернули на 90 градусов по часовой стрелке";
            default:
                return "Не понятно";
        }
    }

    public void onClick(View v) {
        // state FALSE: переключаемся на LANDSCAPE
        if (!mState) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            btn.setText(ORIENTATION_PORTRAIT);
        }
        // state TRUE: переключаемся PORTRAIT
        else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            btn.setText(ORIENTATION_LANDSCAPE);
        }
        // обновляем state на противоположное значение
        mState = !mState;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Проверяем ориентацию экрана
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
    
}

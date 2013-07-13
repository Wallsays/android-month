package com.derevyankodv.crossscreen;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtInfo = (TextView)findViewById(R.id.textView1);

        String user = getIntent().getExtras().getString(MainActivity.USER);
        String gift = getIntent().getExtras().getString(MainActivity.GIFT);

        txtInfo.setText(user + " , you sent " + gift);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }


    
}

package com.sample.menus;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView tvInfo = (TextView) findViewById(R.id.tvinfo);

        // Операции для выбранного пункта меню
        switch (item.getItemId()) {
            case R.id.action_dog:
                tvInfo.setText("Picked dog");
                return true;
            case R.id.action_cat:
                tvInfo.setText("Picked cat");
                return true;
            case R.id.action_kitten:
                tvInfo.setText("Picked kitten");
                return true;
            case R.id.action_show_hide_ab:
                tvInfo.setText("Clicked Show/Hide Action bar");
                ActionBar actionBar = getActionBar();
                if (actionBar.isShowing()) {
                    actionBar.hide();
                } else {
                    actionBar.show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

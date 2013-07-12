package com.derevyankodv.sampleapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button butCrowsCounter;
    int count = 0;

    public TextView tvInfo;
    public RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butCrowsCounter = (Button)findViewById(R.id.butCrowsCounter);
        butCrowsCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvHello = (TextView)findViewById(R.id.textView1);
                tvHello.setText("I counted " + ++count + " crows");
            }
        });

        relativeLayout = (RelativeLayout)findViewById(R.id.relativelayout);
        tvInfo = (TextView)findViewById(R.id.textView2);
    }

    public void onColorButtonClick(View view) {
        switch(view.getId())  {
            case  R.id.buttonRed:
                tvInfo.setText(R.string.Red);
                relativeLayout.setBackgroundResource(R.color.redColor);
                break;
            case  R.id.buttonYellow:
                tvInfo.setText(R.string.Yellow);
                relativeLayout.setBackgroundResource(R.color.yellowColor);
                break;
            case  R.id.buttonGreen:
                tvInfo.setText(R.string.Green);
                relativeLayout.setBackgroundResource(R.color.greeenColor);
                break;
            default:
                // log error
                break;
        }
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void butHello_Click(View v){
        TextView tvHello = (TextView)findViewById(R.id.textView1);
        tvHello.setText("Hey yo maan!");
    }
}

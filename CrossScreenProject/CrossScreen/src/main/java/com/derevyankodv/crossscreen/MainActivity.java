package com.derevyankodv.crossscreen;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    public final static String USER = "com.derevyankodv.crossscreen.USER";
    public final static String GIFT = "com.derevyankodv.crossscreen.GIFT";
    static final private int CHOOSE_NUMBER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;

        }
    }

    public void buttonSendOnClick(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        TextView toStr = (TextView)findViewById(R.id.toField);
        TextView descrStr = (TextView)findViewById(R.id.descrField);

        intent.putExtra(USER, toStr.getText().toString()); // в ключ username пихаем текст из текстового поля
        intent.putExtra(GIFT, descrStr.getText().toString());  // в ключ gift пихаем текст из текстового поля
        startActivity(intent);
    }

    public void buttonPickNumberOnClick(View v) {
        Intent questionIntent = new Intent(MainActivity.this,ChooserActivity.class);
        startActivityForResult(questionIntent, CHOOSE_NUMBER);
    }


    // Код запроса. Код, который использовался для
    //              запуска активности, возвращающей результат
    // Результирующий код. Код результата, устанавливаемый дочерней активностью
    //                     и указывающий, как завершилась её работа. Это может
    //                     быть любое целочисленное значение, но, как правило,
    //                     либо Activity.RESULT_OK, либо Activity.RESULT_CANCELED
    // Данные. Намерение, используемое для упаковки возвращаемых данных. В зависимости
    //         от назначения дочерней Активности оно может включать путь URI,
    //         представляющий выбранную часть содержимого. В качестве альтернативы
    //         (или дополнения) дочерняя активность может возвращать информацию
    //         в виде простых значений, упакованных в параметр намерения extras
    //
    // Если работа дочерней активности завершилась непредвиденно или если перед её
    // закрытием не был указан код результата, этот параметр станет равен Activity.RESULT_CANCELED.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_NUMBER) {
            TextView dataString = (TextView)findViewById(R.id.textView2);
            if (resultCode == RESULT_OK) {
                String info = data.getStringExtra(ChooserActivity.MAGIC_WORD);
                dataString.setText(info);
            } else {
                dataString.setText("you're not picked it");
            }
        }
    }

}

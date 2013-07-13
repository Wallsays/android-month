package com.derevyankodv.crossscreen;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class ChooserActivity extends Activity {
    public final static String MAGIC_WORD = "com.derevyankodv.crossscreen.MAGIC_WORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooser_activity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chooser, menu);
        return true;
    }

    public void onRadioClick(View v) {
        Intent answerInent = new Intent();

        switch (v.getId()) {
            case R.id.radio1:
                answerInent.putExtra(MAGIC_WORD, "supposed... 21");
                break;
            case R.id.radio2:
                answerInent.putExtra(MAGIC_WORD, "supposed... 133");
                break;
            case R.id.radio3:
                answerInent.putExtra(MAGIC_WORD, "supposed... 696");
                break;

            default:
                break;
        }

        // Для удобства, после выбора мы сразу закрываем второе окно и перед закрытием
        // передаём значение RESULT_OK, чтобы было понятно, что выбор сделан. Если пользователь
        // закроет экран через кнопку Back, то будет передано значение RESULT_CANCELED.
        //
        // Метод setResult() принимает два параметра: результирующий код и сам
        // результат, представленный в виде намерения. Результирующий код говорит о том,
        // с каким результатом завершилась работа активности, как правило, это либо Activity.RESULT_OK,
        // либо Activity.RESULT_CANCELED. В некоторых случаях нужно использовать собственный
        // код возврата для обработки специфических для вашего приложения вариантов. Метод
        // setResult() поддерживает любое целочисленное значение.
        //
        // Если вы будете передавать данные явно через кнопку, то неплохо бы добавить
        // метод finish(), чтобы закрыть вторую активность за ненадобностью. Если
        // переход происходит через кнопку Назад, то это делать не обязательно.
        //
        // Если активность была закрыта пользователем при нажатии аппаратной
        // кнопки возврата или если метод finish() был вызван раньше, чем метод
        // setResult(), результирующий код установится в RESULT_CANCELED, а
        // возвращенное намерение покажет значение null.
        setResult(RESULT_OK, answerInent);
        finish();
    }

}

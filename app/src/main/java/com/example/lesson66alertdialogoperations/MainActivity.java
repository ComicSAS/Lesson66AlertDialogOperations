package com.example.lesson66alertdialogoperations;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import static android.content.DialogInterface.OnCancelListener;
import static android.content.DialogInterface.OnDismissListener;
import static android.content.DialogInterface.OnShowListener;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    final int DIALOG = 1;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG) {
            Log.d(LOG_TAG, "Create");
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Title");
            adb.setMessage("Message");
            adb.setPositiveButton("OK", null);
            dialog = adb.create();
            // обработчик отображения
            dialog.setOnShowListener(new OnShowListener() {
                public void onShow(DialogInterface dialog) {
                    Log.d(LOG_TAG, "Show");
                }
            });

            // обработчик отмены
            dialog.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    Log.d(LOG_TAG, "Cancel");
                }
            });

            // обработчик закрытия
            dialog.setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    Log.d(LOG_TAG, "Dismiss");
                }
            });
            return dialog;
        }
        return super.onCreateDialog(id);
    }

    void dismsiss() {
        dialog.dismiss();
//        dismissDialog(DIALOG);
    }

    void cancel() {
        dialog.cancel();
    }

    void hide() {
        dialog.hide();
    }

    void remove() {
        removeDialog(DIALOG);
    }

    public void onclick(View v) {
        showDialog(DIALOG);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                remove();
//                showDialog(DIALOG);
                // hide();
            }
        }, 2000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialog(DIALOG);
                // cancel();
                dismsiss();
            }
        }, 4000);
    }
}

package com.example.broadcastreceiverpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcastbestpractice");
        ForceOfflineReceiver receiver = new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

     class ForceOfflineReceiver extends BroadcastReceiver{
         @Override
         public void onReceive(final Context context, Intent intent) {
             AlertDialog.Builder builder =new  AlertDialog.Builder(context);
             builder.setTitle("Warning")
                     .setMessage("You are forced to be offline.Please try to login again")
                     .setCancelable(false)
                     .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             ActivityCollector.finishAll();
                             Intent in = new Intent(context,LoginActivity.class);
                             context.startActivity(in);
                         }
                     });
             builder.show();
         }
     }
}

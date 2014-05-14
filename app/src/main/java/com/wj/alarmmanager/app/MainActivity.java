package com.wj.alarmmanager.app;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends Activity {
Button btn;

    Button close;
    PendingIntent pi;

    TextView textView;
    Calendar mcalendar;
    ReminderManager RemindM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(Active_Alarm);
        textView=(TextView)findViewById(R.id.textView);
        close=(Button)findViewById(R.id.close);
        close.setOnClickListener(closeAlarm);
         RemindM=new ReminderManager(MainActivity.this);

    }

    Button.OnClickListener Active_Alarm=new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            mcalendar=Calendar.getInstance();
            mcalendar.set(Calendar.SECOND,5);
            RemindM.setAlarm();
        }
    };

    Button.OnClickListener closeAlarm=new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
          RemindM.cancelAlarm();
        }
    };
    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}

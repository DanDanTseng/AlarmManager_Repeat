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

public class MainActivity extends Activity {
Button btn;
    AlarmManager alarmMgr;
    PendingIntent pi;
    int second=1000;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(Active_Alarm);
        textView=(TextView)findViewById(R.id.textView);
    }
    Button.OnClickListener Active_Alarm=new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
         setAlarm(MainActivity.this);
        }
    };
    public void setAlarm(Context context){
        alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(context,AlarmReceiver.class);
        intent.putExtra("msg","partyOn");

        pi=PendingIntent.getBroadcast(context,0,intent,0);
        alarmMgr.setRepeating(AlarmManager.RTC,1*second,10*second,pi);
        //alarmMgr.setInexactRepeating();
    }

    @Override
    protected void onDestroy() {
        alarmMgr.cancel(pi);

        super.onDestroy();
    }
}

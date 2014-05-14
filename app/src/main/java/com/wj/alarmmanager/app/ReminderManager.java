package com.wj.alarmmanager.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by wj on 2014/5/14.
 */
public class ReminderManager {
    AlarmManager alarmMgr;
    Context mcontext;
    PendingIntent pi;
    int second=1000;
    public ReminderManager(Context context){
        alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        mcontext=context;
    }
    public void setAlarm(){
        Intent i=new Intent(mcontext,AlarmReceiver .class);
        i.putExtra("msg","partyOn");
        pi= PendingIntent.getBroadcast(mcontext, 0, i, 0);
        alarmMgr.setRepeating(AlarmManager.RTC,5*second ,10*second ,pi);
    }
    public void cancelAlarm(){
        Log.v("WJ", "cancel");
        alarmMgr.cancel(pi);
    }
}

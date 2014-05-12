package com.wj.alarmmanager.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by WJ on 5/12/2014.
 */
public class NotifyM {
    public void SetNotify(Context context){
        NotificationManager NotMgr = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        int icon = R.drawable.ic_launcher;
        long when=System.currentTimeMillis();
        Intent call = new Intent(context, MainActivity.class);
        //call.putExtra("notiId", 1);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, call, 0);
        String alert="提醒";
        Notification notifi=new Notification(icon,alert,when);
        String title="這是標題";
        String content="這是提醒內容";
        notifi.setLatestEventInfo(context,title,content,pIntent);
        notifi.number=1;
        NotMgr.notify(1,notifi);
    }
}

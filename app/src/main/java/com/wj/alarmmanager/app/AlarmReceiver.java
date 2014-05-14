package com.wj.alarmmanager.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by WJ on 5/12/2014.
 */
public class AlarmReceiver extends BroadcastReceiver {
    //Toast toast;

    @Override
    public void onReceive(Context context,Intent intent){

        Bundle bundle =intent.getExtras();
        //NotifyM nm=new NotifyM();
        if(bundle.get("msg").equals("partyOn")){

        Log.d("WJ","doReceiver");
         Toast toast=Toast.makeText(context, "Hello World", Toast.LENGTH_SHORT);
                 toast.show();
        // nm.SetNotify(context);
        }

    }


}

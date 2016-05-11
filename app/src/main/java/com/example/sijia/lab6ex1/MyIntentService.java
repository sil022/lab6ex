package com.example.sijia.lab6ex1;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(MyIntentService.this, "Service Started", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent,flags, startId);
    }

    @Override
    public void onDestroy(){
        Toast.makeText(MyIntentService.this, "Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent){
        if (intent!=null){
            synchronized (this){
                try{
                    wait(10000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            stopService(intent);
        }
    }
}

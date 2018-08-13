package com.nativesplash;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;



import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.app.NotificationChannel;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    /*
     NotificationManager notificationmgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pintent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

     //   PendingIntent pintent = PendingIntent.getActivities(this,(int)System.currentTimeMillis(),intent, 0);


    Notification mBuilder = new NotificationCompat.Builder(this, "")
                .setContentTitle("Hello Android Hari")
                .setContentText("Welcome to Notification Service")
                .setContentIntent(pintent)
                .build();


        notificationmgr.notify(0,mBuilder);*/



      NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    String channelId = "ircid";

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

      CharSequence channelName = "Imagine radio";
      int importance = NotificationManager.IMPORTANCE_MAX;
      NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, importance);
      notificationChannel.enableLights(true);
      notificationChannel.enableVibration(true);
      notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
      notificationManager.createNotificationChannel(notificationChannel);
    }
      // This intent is fired when notification is clicked
      Intent intent = new Intent(this, MainActivity.class);
      PendingIntent pintent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

      // Use NotificationCompat.Builder to set up our notification.
      NotificationCompat.Builder builder = new NotificationCompat.Builder(this,channelId);

      //icon appears in device notification bar and right hand corner of notification
      builder.setSmallIcon(R.drawable.ic_launcher);


      // Set the intent that will fire when the user taps the notification.
      builder.setContentIntent(pintent);

      // Large icon appears on the left of the notification
      builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

      // Content title, which appears in large type at the top of the notification
      builder.setContentTitle("Imagine Radio");

      // Content text, which appears in smaller text below the title
      builder.setContentText("Imagine Radio notification .");

      // The subtext, which appears under the text on newer devices.
      // This will show-up in the devices with Android 4.2 and above only
      builder.setSubText("Tap to view documentation about notifications.");


      // Will display the notification in the notification bar
      notificationManager.notify(0, builder.build());





    SoLoader.init(this, /* native exopackage */ false);
  }
/*
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }*/

}

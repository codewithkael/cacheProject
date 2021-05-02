package com.codewithkael.masoudcachesystem;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.snatik.storage.Storage;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFileFromURL extends AsyncTask<String, Integer, String> {


    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder build;
    private Storage storage;
    private File fileurl;
    int id = 123;
    OutputStream output;
    private Context context;
    private String pathName;
    private String selectedDate;
    private String idString;
    private String ts = "";
    private IDownloadHelper iDownloadHelper;

    public DownloadFileFromURL(Context context, String selectedDate,String id,IDownloadHelper iDownloadHelper) {
        this.context = context;
        this.selectedDate = selectedDate;
        this.iDownloadHelper = iDownloadHelper;
        this.idString = id;

        storage = new Storage(context);
        pathName = storage.getExternalStorageDirectory()+ File.separator + "Pictures/Cache/";
        storage.createDirectory(pathName);

    }

    protected void onPreExecute() {
        super.onPreExecute();

        mNotifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        build = new NotificationCompat.Builder(context);
        build.setAutoCancel(true).setContentTitle(context.getResources().getString(R.string.app_name))
                .setContentText("downloading")
                .setChannelId(id + "")
                .setSmallIcon(R.drawable.ic_baseline_cloud_download_24)
                .setDefaults(0);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(id + "",
                    "Social Media Downloader",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("no sound");
            channel.setSound(null, null);
            channel.enableLights(false);
            channel.setLightColor(Color.BLUE);
            channel.enableVibration(false);
            mNotifyManager.createNotificationChannel(channel);

        }
        build.setProgress(100, 0, false);
        mNotifyManager.notify(id, build.build());
        String msg = "Download started";
        //CustomToast.showToast(context,msg);
    }

    @Override
    protected String doInBackground(String... f_url) {
        int count;
        ts = selectedDate.split("T")[0];
        try {
            URL url = new URL(f_url[0]);
            URLConnection conection = url.openConnection();
            conection.connect();
            int lenghtOfFile = conection.getContentLength();

            InputStream input = new BufferedInputStream(url.openStream(),
                    8192);
            // Output stream
            output = new FileOutputStream(pathName + ts + ".jpg");
            File Sample = new File(pathName);
            if (!Sample.exists()){
                Sample.mkdir();
            }
            fileurl = new File(pathName+ ts + ".jpg");
            byte[] data = new byte[1024];

            long total = 0;

            while ((count = input.read(data)) != -1) {
                total += count;
                int cur = (int) ((total * 100) / lenghtOfFile);

                publishProgress(Math.min(cur, 100));
                if (Math.min(cur, 100) > 98) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Log.d("Failure", "sleeping failure");
                    }
                }


                output.write(data, 0, count);
            }

            output.flush();

            output.close();
            input.close();

        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }

        return null;
    }

    protected void onProgressUpdate(Integer... progress) {
        build.setProgress(100, progress[0], false);
        mNotifyManager.notify(id, build.build());
        super.onProgressUpdate(progress);
    }

    @Override
    protected void onPostExecute(String file_url) {
        build.setContentText("saved in gallery");
        build.setProgress(0, 0, false);
        iDownloadHelper.OnDownloadFinished(idString,fileurl.getAbsolutePath());

        addVideo(fileurl);
//        Uri path = Uri.parse(String.valueOf(pathName));

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setType("image/*");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        build.setContentIntent(pendingIntent);
        mNotifyManager.notify(id, build.build());
    }
    public Uri addVideo(File videoFile) {
        ContentValues values = new ContentValues(3);
        values.put(MediaStore.Images.Media.TITLE,ts );
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpg");
        values.put(MediaStore.Images.Media.DATA, videoFile.getAbsolutePath());
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

}
}
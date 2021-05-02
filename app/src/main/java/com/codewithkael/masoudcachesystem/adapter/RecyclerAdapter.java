package com.codewithkael.masoudcachesystem.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithkael.masoudcachesystem.DownloadFileFromURL;
import com.codewithkael.masoudcachesystem.IDownloadHelper;
import com.codewithkael.masoudcachesystem.ImageModel;
import com.codewithkael.masoudcachesystem.R;
import com.codewithkael.masoudcachesystem.persistence.LocationDao;
import com.codewithkael.masoudcachesystem.persistence.LocationDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<Adapter> implements IDownloadHelper{
    private static final String TAG = "RecyclerAdapter";
    IDownloadHelper iDownloadHelper;
    LocationDao locationDao;
    private Context context;
    private List<ImageModel> imageModels;

    public RecyclerAdapter(Context context, List<ImageModel> imageModels,IDownloadHelper iDownloadHelper) {
        this.context = context;
        this.imageModels = imageModels;
        locationDao = LocationDatabase.getInstance(context).getLocationDao();
        this.iDownloadHelper = iDownloadHelper;

    }

    @NonNull
    @Override
    public Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_single, parent,false);
        return new Adapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter holder, int position) {

        if (imageModels.get(position).getDownloaded()){
            Picasso.get().load(imageModels.get(position).getImage_url()).into(holder.imageView);
        } else {
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DownloadFileFromURL(context,imageModels.get(position).getImage_id(),
                            imageModels.get(position).getImage_id(),iDownloadHelper)
                            .execute(imageModels.get(position).getImage_url());
                }
            });
        }

        holder.textView.setText(imageModels.get(position).getImage_id());
    }

    @Override
    public int getItemCount() {
        return imageModels.size();
    }


    @Override
    public void OnDownloadFinished(String id, String path) {
        Log.d(TAG, "OnDownloadFinished: "+id+"  "+path);

    }
}

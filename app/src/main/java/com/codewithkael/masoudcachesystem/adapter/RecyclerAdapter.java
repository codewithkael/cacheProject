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

import java.io.File;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<Adapter> {
    private static final String TAG = "RecyclerAdapter";

    LocationDao locationDao;
    private Context context;
    private List<ImageModel> imageModels;

    public RecyclerAdapter(Context context, List<ImageModel> imageModels) {
        this.context = context;
        this.imageModels = imageModels;
        locationDao = LocationDatabase.getInstance(context).getLocationDao();


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
            File file = new File(imageModels.get(position).getImage_url());
            Picasso.get().load(file).into(holder.imageView);
        } else {
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DownloadFileFromURL(context, imageModels.get(position).getImage_id(),
                            imageModels.get(position).getImage_id(), new IDownloadHelper() {
                        @Override
                        public void OnDownloadFinished(String id, String path) {
                            AsyncTask.execute(new Runnable() {
                                @Override
                                public void run() {
                                    ImageModel imageModel = new ImageModel(id,path,true);
                                    locationDao.update(imageModel);
                                }
                            });
                        }

                        @Override
                        public void OnProgressChange(String id, int progress) {
                            holder.textView.setText(String.valueOf(progress)+"%");
                        }
                    })
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



}

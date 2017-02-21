package com.example.iket.pehlakadam.imageViewer.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.helper.image_loader.GlideImageLoader;
import com.example.iket.pehlakadam.helper.image_loader.ImageLoader;
import com.example.iket.pehlakadam.imageViewer.model.ImagesData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by Iket on 8/21/2016.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.MyViewHolder> {
private List<ImagesData> imagesDataList = new ArrayList<>();
private Context context;
private LayoutInflater layoutInflater;private Random mRandom = new Random();
private ImageLoader imageLoader;
public ImagesAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

        imageLoader = new GlideImageLoader(context);
        }

public void setData(List<ImagesData> imagesData) {
        this.imagesDataList = imagesData;
        }

@Override
public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = layoutInflater.inflate(R.layout.image_item, parent, false);
        return new MyViewHolder(itemView);
        }

@Override
public void onBindViewHolder(final MyViewHolder holder, int position) {

        ImagesData imagesData = imagesDataList.get(position);
//        holder.image1.getLayoutParams().height = getRandomIntInRange(250,75);
        imageLoader.loadImage(imagesData.getImage1(), holder.image1,holder.progressBar);
        }

@Override
public int getItemCount() {
        return this.imagesDataList.size();
        }

protected class MyViewHolder extends RecyclerView.ViewHolder {

    private ImageView image1;
    private ProgressBar progressBar;
    private MyViewHolder(View itemView) {
        super(itemView);
        progressBar=(ProgressBar)itemView.findViewById(R.id.progress_bar);
        image1= (ImageView) itemView.findViewById(R.id.image1);

    }

}
//    protected int getRandomIntInRange(int max, int min){
//        return mRandom.nextInt((max-min)+min)+min;
//    }
}

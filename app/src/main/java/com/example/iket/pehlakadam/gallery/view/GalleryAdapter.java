package com.example.iket.pehlakadam.gallery.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.gallery.model.data.ContentDetails;
import com.example.iket.pehlakadam.helper.image_loader.GlideImageLoader;
import com.example.iket.pehlakadam.helper.image_loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meghal on 13/10/16.
 */

public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private LayoutInflater layoutInflater;
    private List<ContentDetails> contentDetailses=new ArrayList<>();
    private ImageLoader imageLoader;

    public GalleryAdapter(Context context) {
        this.context = context;
        layoutInflater= LayoutInflater.from(context);
        imageLoader=new GlideImageLoader(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view=layoutInflater.inflate(R.layout.gallery_item,parent,false);

        return new ImageViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ImageViewHolder imageViewHolder=(ImageViewHolder)holder;

        imageLoader.loadImage(contentDetailses.get(position).getImage_url(),imageViewHolder.imageView,imageViewHolder.progressBar);
        imageViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(context instanceof HomeActivity){
//                    ((HomeActivity) context).openImageViewer(imageUrlList,position);
//
//                }
            }
        });

    }
    @Override
    public int getItemCount() {
        return contentDetailses.size();
    }


    public void setImageUrlList(List<ContentDetails> imageUrlList){
        this.contentDetailses=imageUrlList;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

//        @BindView(R.id.imageView)
        ImageView imageView;
        ProgressBar progressBar;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            progressBar=(ProgressBar)itemView.findViewById(R.id.imageProgressBar);
        }
    }

}

package com.example.marowl.ui.favorite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.marowl.R;
import com.example.marowl.model.ComicsModel;
import com.example.marowl.ui.comic.ComicActivity;

import java.util.ArrayList;
import java.util.List;

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.myviewholder> {
    List<ComicsModel> data;
    Context mContext;

    public ComicsAdapter(Context mContext){
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.card_layout,parent,false);
        return  new myviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        final ComicsModel temp=data.get(position);
        Glide.with(holder.itemView).load(temp.getImg_url()).into(holder.comicImageView);
        holder.comicTitle.setText(data.get(position).getTitle());
        holder.comicDetails.setText(data.get(position).getDescription());
        holder.comicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(mContext, ComicActivity.class);
                intent.putExtra("ComicImage",temp.getImg_url());
                intent.putExtra("ComicTitle", temp.getTitle());
                intent.putExtra("ComicDetails",temp.getDescription());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        if (data==null){
            return 0;
        }
        else {

            return data.size();
        }
    }

    public void filterList(ArrayList<ComicsModel> filteredList) {
    data=filteredList;
    notifyDataSetChanged();
    }

    public void setData(List<ComicsModel> data) {
        this.data = data;
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        ImageView comicImageView;
        TextView comicTitle;
        TextView comicDetails;
        ConstraintLayout comicView;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            comicView=itemView.findViewById(R.id.comic_item_view);
            comicImageView=itemView.findViewById(R.id.comics_image);
            comicTitle=itemView.findViewById(R.id.comic_title);
            comicDetails=itemView.findViewById(R.id.comic_detail);
        }
    }
}

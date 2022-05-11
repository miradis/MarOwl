package com.example.marowl.ui.favorite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marowl.R;
import com.example.marowl.data.Comics.Comic;

import java.util.ArrayList;

public class RecycleAdapter extends ArrayAdapter<Comic>{
    private Context mContext;
    private int layoutResourceId;
    private ArrayList data = new ArrayList<>();

    public RecycleAdapter(@NonNull Context context,  int layoutResourceId, ArrayList data) {
        super(context,layoutResourceId, data);
        this.mContext = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    static class ViewHolder{
        TextView ComicTitle;
        TextView ComicDetails;
        ImageView ComicImage;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder=null;
        Comic currentComic=getItem(position);

        if (convertView==null){
        LayoutInflater inflater=((Activity) mContext).getLayoutInflater();
        convertView=inflater.inflate(layoutResourceId,parent,false);
        holder=new ViewHolder();
        holder.ComicImage=(ImageView) convertView.findViewById(R.id.comics_image);
        holder.ComicTitle=(TextView) convertView.findViewById(R.id.comic_title);
        holder.ComicDetails=(TextView) convertView.findViewById(R.id.comic_detail);
        convertView.setTag(holder);
        }
        else{
        holder=(ViewHolder)convertView.getTag();
        }
        holder.ComicTitle.setText(currentComic.getComicTitle());
        holder.ComicDetails.setText(currentComic.getComicDetails());
        holder.ComicImage.setImageResource(currentComic.getComicImage());

        return convertView;
    }


}

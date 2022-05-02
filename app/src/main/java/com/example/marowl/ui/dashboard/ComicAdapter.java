package com.example.marowl.ui.dashboard;

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

import com.example.marowl.R;
import com.example.marowl.model.Comic;

import java.util.ArrayList;

public class ComicAdapter extends ArrayAdapter<Comic> {

    private Context mContext;
    private int layoutResourceId;
    private ArrayList data=new ArrayList();

    public ComicAdapter(@NonNull Context context, int resource, ArrayList data) {
        super(context, resource);
        this.mContext = mContext;
        this.layoutResourceId = resource;
        this.data = data;
    }


    static class ViewHolder{
    TextView textTitle;
    TextView textDescription;
    ImageView imageView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        ViewHolder holder =null;
        Comic currentComic=getItem(position);

        if (convertView==null){
            LayoutInflater inflater=((Activity) mContext).getLayoutInflater();
            convertView=inflater.inflate(layoutResourceId,parent, false);
            holder=new ViewHolder();
            holder.textTitle=(TextView) convertView.findViewById(R.id.comics_title);
            holder.textDescription=(TextView) convertView.findViewById(R.id.comics_description);
            holder.imageView=(ImageView) convertView.findViewById(R.id.comics_preview);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.textTitle.setText(currentComic.getComicName());
        holder.textDescription.setText(currentComic.getDescription());
        holder.imageView.setImageResource(currentComic.getImage_URL());
        return convertView;
    }
}

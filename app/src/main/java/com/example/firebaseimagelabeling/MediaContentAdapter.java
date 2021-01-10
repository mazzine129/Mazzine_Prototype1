package com.example.firebaseimagelabeling;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaseimagelabeling.MediaContent;
import com.example.firebaseimagelabeling.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MediaContentAdapter extends RecyclerView.Adapter<MediaContentAdapter.ViewHolder> {
    ArrayList<MediaContent> mediaContents;
    Context context;

    public MediaContentAdapter(Context context, ArrayList<MediaContent> mediaContents) {
        this.context = context;
        this.mediaContents = mediaContents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.media_content_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set image to ImageView
        holder.imageView.setImageResource(mediaContents.get(position).getContentLogo());
        // Set text to TextView
        holder.textView.setText(mediaContents.get(position).getContentName());
    }

    @Override
    public int getItemCount() {
        return mediaContents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.content_image);
            textView = (TextView) itemView.findViewById(R.id.content_name);
        }
    }
}

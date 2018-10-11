package com.example.daiverandresdoria.seccion_03_recycled_view.MyAdapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.daiverandresdoria.seccion_03_recycled_view.Models.Movie;
import com.example.daiverandresdoria.seccion_03_recycled_view.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewholder>{
    private List<Movie> movie;
    private int layout;
    private onItemClickLisener itemClickLisener;
    private Context context;

    public MyAdapter(List<Movie> movies, int layout, onItemClickLisener itemClickLisener) {
        movie = movies;
        this.layout = layout;
        this.itemClickLisener = itemClickLisener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        Viewholder vh = new Viewholder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.bind(movie.get(position), itemClickLisener);
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        public TextView TextViewName;
        public ImageView ImageViewPoster;

        public Viewholder(View itemView) {
            super(itemView);
            this.TextViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.ImageViewPoster = (ImageView) itemView.findViewById(R.id.imageViewPoster);
        }
        public void bind(final Movie movie, final onItemClickLisener lisener){
            //setiamos los datos que tiene el objeto (procesamos los datos renderizados)
            TextViewName.setText(movie.getName());
            Picasso.get().load(movie.getPoster()).fit().into(ImageViewPoster);
            //ImageViewPoster.setImageResource(movie.getPoster());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lisener.onItemClick(movie,getAdapterPosition());
                }
            });
        }
    }
    public interface onItemClickLisener{
        void onItemClick(Movie movie, int position);
    }
}

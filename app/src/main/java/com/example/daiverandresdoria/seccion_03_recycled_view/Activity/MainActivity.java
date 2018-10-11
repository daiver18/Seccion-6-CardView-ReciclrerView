package com.example.daiverandresdoria.seccion_03_recycled_view.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.daiverandresdoria.seccion_03_recycled_view.Models.Movie;
import com.example.daiverandresdoria.seccion_03_recycled_view.MyAdapter.MyAdapter;
import com.example.daiverandresdoria.seccion_03_recycled_view.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private List<Movie> movies;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        this.movies = AllMovies();
        //configuraciones del layout (List,Grid,StaggeredGrid)
        mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager = new GridLayoutManager(this,2);
        //mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //Adaptador
        mAdapter = new MyAdapter(movies, R.layout.recycler_view_item,   new MyAdapter.onItemClickLisener() {
            @Override
            public void onItemClick(Movie movie, int position) {
                //Toast.makeText(MainActivity.this,Name + " - Position:" + position,Toast.LENGTH_SHORT).show();
                deletName(position);
            }
        });

        //agregar adaptador a el recycled
        //recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_name:
                this.addName(0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Movie> AllMovies(){
        return new ArrayList<Movie>(){{
            add(new Movie("DeadPool",R.drawable.new_fruit));
            add(new Movie("Fast and Furious",R.drawable.new_fruit));
            add(new Movie("League of Justice",R.drawable.new_fruit));
            add(new Movie("Infinity War",R.drawable.new_fruit));
        }};
    }

    private void addName(int posicion) {
        movies.add(posicion,new Movie("new Movie n°"+(++count),R.drawable.proximamente));
        mAdapter.notifyItemInserted(posicion);
        mLayoutManager.scrollToPosition(posicion);
    }

    private void deletName(int posicion){
        movies.remove(posicion);
        mAdapter.notifyItemRemoved(posicion);
    }

}

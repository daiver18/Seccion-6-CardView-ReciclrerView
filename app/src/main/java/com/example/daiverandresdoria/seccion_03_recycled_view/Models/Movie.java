package com.example.daiverandresdoria.seccion_03_recycled_view.Models;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Movie {
    private String name;
    private int poster;

    public Movie(String name, int poster) {
        this.name = name;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }
    public void setPoster(int poster) {
        this.poster = poster;
    }
}

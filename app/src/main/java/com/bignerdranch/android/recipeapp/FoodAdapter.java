package com.bignerdranch.android.recipeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {

    private LayoutInflater inflater;
    private int layout;
    private List<Food> foods;

    public FoodAdapter(Context context, int resource, List<Food> states) {
        super(context, resource, states);
        this.foods = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = view.findViewById(R.id.img);
        TextView nameView = view.findViewById(R.id.name);
        TextView capitalView = view.findViewById(R.id.link);

        Food food = foods.get(position);
        flagView.setImageResource(food.getImgResource());
        nameView.setText(food.getName());
        capitalView.setText(food.getLink());

        return view;
    }
}

package com.bignerdranch.android.recipeapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentList extends Fragment {

    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;

    ArrayList<Food> foods = new ArrayList<Food>();
    //ListView recipesList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        // получаем элемент ListView
        //ListView recipeList = view.findViewById(R.id.recipesList);
        setInitialData();
        //recipesList = getView().findViewById(R.id.recipesList);
        ListView recipesList = view.findViewById(R.id.recipesList);
        // создаем адаптер
        FoodAdapter adapter = new FoodAdapter(getContext(),R.layout.list_item, foods);
        // устанавливаем для списка адаптер
        recipesList.setAdapter(adapter);
        // добавляем для списка слушатель
        recipesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
//                Food selectedState = (Food)parent.getItemAtPosition(position);
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedState.getLink()));
//                startActivity(browserIntent);

                // получаем выбранный элемент
                Food selectedItem = (Food)parent.getItemAtPosition(position);
                // Посылаем данные Activity
                fragmentSendDataListener.onSendData(selectedItem.getLink());
            }
        });
        return view;
    }

    private void setInitialData(){
        foods.add(new Food ("Шашлык", "https://www.russianfood.com/recipes/recipe.php?rid=116634", R.drawable.shash));
        foods.add(new Food ("Пельмени", "https://www.russianfood.com/recipes/recipe.php?rid=124988", R.drawable.pelm));
        foods.add(new Food ("Бургер", "https://www.russianfood.com/recipes/recipe.php?rid=143767", R.drawable.burger));
        foods.add(new Food ("Пицца", "https://www.russianfood.com/recipes/recipe.php?rid=143040", R.drawable.pizza));
        foods.add(new Food ("Шаурма", "https://www.russianfood.com/recipes/recipe.php?rid=149263", R.drawable.shawa));
    }

}

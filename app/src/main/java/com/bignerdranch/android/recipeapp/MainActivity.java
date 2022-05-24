package com.bignerdranch.android.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.watch_set:
                Intent intent = new Intent(this, WatchActivity.class);
                startActivity(intent);
                return true;
            case R.id.version:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Единственная и уникальная", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.developer:
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "Это я!", Toast.LENGTH_SHORT);
                toast1.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goRecipe(View view){
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }
}
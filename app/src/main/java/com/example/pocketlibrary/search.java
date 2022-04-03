package com.example.pocketlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class search extends AppCompatActivity {

    ListView bookList;
    String [] bookNames= {"Муравьи", "Записки Горького", "Несущий огонь", "Босс качалки", "Хоббит",
                          "Академия", "Эти ведьмы не горят", "Сталкер", "Бэтмен. Год первый",
                          "Над пропостью во ржи", "Карамора", "Академия и Имеприя", "Идиот"};

    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bookList.findViewById(R.id.books_list);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bookNames);
        bookList.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_2);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Введите название книги");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                arrayAdapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
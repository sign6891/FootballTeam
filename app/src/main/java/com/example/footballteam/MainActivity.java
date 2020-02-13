package com.example.footballteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] names = {"Никита", "Миша", "Яша", "Миша из Атлантиса", "Кирилл Z", "Никита Низнаемов", "Дима(Я)", "Дима(С Никитой)",
            "Антон", "Паша", "Игорь Краснов", "Женя", "ВестХем","Серега", "Юра", "Ань", "Данила",
            "Dmitrii", "Ильдар", "Илья в очках", "Олег"};

    int[] mas = new int[names.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list_gamer = findViewById(R.id.list_gamer);

        for (int i = 0; i < mas.length; i++) {
            mas[i] = -1;
        }

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, names);

        // присваиваем адаптер списку
        list_gamer.setAdapter(adapter);

        //Обрабатываем клик на элемент списка и реакцию CheckBox
        list_gamer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mas[position] == -1) {
                    mas[position] = position;
                } else {
                    mas[position] = -1;
                }
                Log.i("key", Arrays.toString(mas));

            }
        });

    }

    public void sborKomand(View view) {
        Intent intent = new Intent(MainActivity.this, FormatGamerList.class);
        intent.putExtra("com.example.footballteam.mas", mas);
        intent.putExtra("com.example.footballteam.names", names);
        startActivity(intent);
    }
}

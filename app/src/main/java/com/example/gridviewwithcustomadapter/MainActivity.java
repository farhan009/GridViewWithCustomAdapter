package com.example.gridviewwithcustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    String[] countryNames;
    int[] flags = {R.drawable.bangladesh, R.drawable.canada, R.drawable.germany, R.drawable.india, R.drawable.london, R.drawable.usa,
            R.drawable.linkedin, R.drawable.messenger, R.drawable.skype, R.drawable.spotify, R.drawable.telegram, R.drawable.twitter,
            R.drawable.whatsapp, R.drawable.youtube};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView_id);
        countryNames = getResources().getStringArray(R.array.countryNames);

        CustomAdapter adapter = new CustomAdapter(this, countryNames, flags);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryNames[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

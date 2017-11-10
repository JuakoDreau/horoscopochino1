package com.example.sebax.horoscopo_chino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainLiebreActivity extends AppCompatActivity {
    ArrayList<usuarios> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_liebre);
        if(getIntent().getSerializableExtra("lista")!=null)
        {
            lista=(ArrayList<usuarios>) getIntent().getSerializableExtra("lista");

        }
        else
        {
            lista=new ArrayList<usuarios>();

        }
    }
}

package com.example.sebax.horoscopo_chino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainRegistroActivity extends AppCompatActivity {
    EditText User;
    EditText Password;
    Button Registrar, Volver;
    ArrayList <usuarios> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registro);
        Registrar = (Button)findViewById(R.id.Registrar);
        Volver = (Button)findViewById(R.id.Volver);
        User = (EditText)findViewById(R.id.User2);
        Password = (EditText)findViewById(R.id.Password2);
        if(getIntent().getSerializableExtra("lista")!=null)
        {
            lista=(ArrayList<usuarios>) getIntent().getSerializableExtra("lista");

        }
        else
        {
            lista=new ArrayList<usuarios>();

        }
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = User.getText().toString();
                String pass = Password.getText().toString();
                if (User.getText().toString().isEmpty() || Password.getText().toString().isEmpty()) {
                    Toast.makeText(MainRegistroActivity.this, "hay campos SIN rellenar", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (lista.isEmpty())
                    {
                        usuarios u = new usuarios(user, pass);
                        lista.add(u);
                        Toast.makeText(MainRegistroActivity.this, "Usuario "+u.getUser()+" Agregado", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        int comprobar=0;
                        for (int i=0;i<lista.size();i++) {
                          if (lista.get(i).getUser().equals(user)){
                              comprobar=1;
                          }

                        }
                        if (comprobar==1){
                            Toast.makeText(MainRegistroActivity.this, "esta cuenta ya existe", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            usuarios usuarios= new usuarios(user, pass);
                            lista.add(usuarios);
                            Toast.makeText(MainRegistroActivity.this, "Usuario "+usuarios.getUser()+" Agregado", Toast.LENGTH_SHORT).show();
                        }

                    }
                }

            }
        });
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainRegistroActivity.this,MainActivity.class);
                i.putExtra("lista",lista);
                startActivity(i);
            }
        });

    }
}

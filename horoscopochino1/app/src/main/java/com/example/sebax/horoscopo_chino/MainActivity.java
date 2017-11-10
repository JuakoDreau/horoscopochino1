package com.example.sebax.horoscopo_chino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button login, registro;
    EditText User, Password;
    ArrayList<usuarios> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        login = (Button)findViewById(R.id.login);
        registro = (Button)findViewById(R.id.registro);
        User = (EditText)findViewById(R.id.user);
        Password = (EditText)findViewById(R.id.password);
        if(getIntent().getSerializableExtra("lista")!=null)
        {
            lista=(ArrayList<usuarios>) getIntent().getSerializableExtra("lista");

        }
        else
        {
            lista=new ArrayList<usuarios>();

        }

    }

    public void login(View view) {
        String user = User.getText().toString();
        String pass = Password.getText().toString();
        usuarios u = new usuarios(user, pass);
        if (User.getText().toString().isEmpty() || Password.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "hay campos SIN rellenar", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (lista.isEmpty())
            {
                Toast.makeText(MainActivity.this, "NO hay Usuarios Registrados", Toast.LENGTH_SHORT).show();
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
                    Intent i=new Intent(MainActivity.this,MainBusquedaActivity.class);
                    i.putExtra("lista",lista);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "esta cuenta NO existe", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

    public void registrar(View view) {
        Intent i=new Intent(MainActivity.this,MainRegistroActivity.class);
        i.putExtra("lista",lista);
        startActivity(i);
    }
}

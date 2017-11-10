package com.example.sebax.horoscopo_chino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainBusquedaActivity extends AppCompatActivity {
Button Buscar;
EditText barra;
ArrayList<usuarios> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Buscar=(Button)findViewById(R.id.Buscar);
        if(getIntent().getSerializableExtra("lista")!=null)
        {
            lista=(ArrayList<usuarios>) getIntent().getSerializableExtra("lista");

        }
        else
        {
            lista=new ArrayList<usuarios>();

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_busqueda);
    }

    public void Buscar(View view) {
        barra=(EditText)findViewById(R.id.barra);
        String fecha=barra.getText().toString();
        try {
            int f = Integer.parseInt(fecha);
            if (f<0)
            {
                Toast.makeText(MainBusquedaActivity.this, "Ingrese un año mayor que 0", Toast.LENGTH_SHORT).show();
            }
            else
            {
                switch (f%12)
                {
                    case 0:
                        Intent m=new Intent(MainBusquedaActivity.this,MainMonoActivity.class);
                        m.putExtra("lista",lista);
                        startActivity(m);

                        break;
                    case 1:
                        Intent g=new Intent(MainBusquedaActivity.this,MainGalloActivity.class);
                        g.putExtra("lista",lista);
                        startActivity(g);
                        break;
                    case 2:
                        Intent p=new Intent(MainBusquedaActivity.this,MainPerroActivity.class);
                        p.putExtra("lista",lista);
                        startActivity(p);
                        break;
                    case 3:
                        Intent j=new Intent(MainBusquedaActivity.this,MainJabaliActivity.class);
                        j.putExtra("lista",lista);
                        startActivity(j);
                        break;
                    case 4:
                        Intent R=new Intent(MainBusquedaActivity.this,MainRataActivity.class);
                        R.putExtra("lista",lista);
                        startActivity(R);
                        break;
                    case 5:
                        Intent b=new Intent(MainBusquedaActivity.this,MainBueyActivity.class);
                        b.putExtra("lista",lista);
                        startActivity(b);
                        break;
                    case 6:
                        Intent t=new Intent(MainBusquedaActivity.this,MainTigreActivity.class);
                        t.putExtra("lista",lista);
                        startActivity(t);
                        break;//falta tigre
                    case 7:
                        Intent l=new Intent(MainBusquedaActivity.this,MainLiebreActivity.class);
                        l.putExtra("lista",lista);
                        startActivity(l);
                        break;
                    case 8:
                        Intent d=new Intent(MainBusquedaActivity.this,MainDragonActivity.class);
                        d.putExtra("lista",lista);
                        startActivity(d);
                        break;
                    case 9:
                        Intent s=new Intent(MainBusquedaActivity.this,MainSerpienteActivity.class);
                        s.putExtra("lista",lista);
                        startActivity(s);
                        break;
                    case 10:
                        Intent c=new Intent(MainBusquedaActivity.this,MainCaballoActivity.class);
                        c.putExtra("lista",lista);
                        startActivity(c);
                        break;
                    case 11:
                        Intent ca=new Intent(MainBusquedaActivity.this,MainCabraActivity.class);
                        ca.putExtra("lista",lista);
                        startActivity(ca);
                        break;
                }
            }
        }
        catch (NumberFormatException e)
        {
            Toast.makeText(MainBusquedaActivity.this, "Solo se puede ingresar Números", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.michelle.problema2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    private EditText et1;
    private TextView tv2,tv3;
    private int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.et1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);

        SharedPreferences prefe=getSharedPreferences("datos",Context.MODE_PRIVATE);
        String v=String.valueOf(prefe.getInt("puntos",0));
        tv2.setText(v);
        numero=1+(int)(Math.random()*50);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void verificar(View v) {
        int valor=Integer.parseInt(et1.getText().toString());
        if (numero==valor) {
            int puntosactual=Integer.parseInt(tv2.getText().toString());
            puntosactual++;
            tv2.setText(String.valueOf(puntosactual));
            tv3.setText("Muy bien ganó. Ahora pienso otro numero");
            et1.setText("");
            SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
            Editor editor=preferencias.edit();
            editor.putInt("puntos", puntosactual);
            editor.commit();

        } else {
            if (valor>numero) {
                tv3.setText("Ingreso un numero mayor al que penso la maquina.");
            } else {
                tv3.setText("Ingreso un numero menor al que penso la maquina.");
            }
        }
    }

}
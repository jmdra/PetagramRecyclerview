package com.whiwol.petagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarando el Action Bar de Material Design
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setIcon(R.drawable.iconopaw);

        agregarFAB();

        //13.- Asigna el Recycler View
        listaMascotas = (RecyclerView) findViewById(R.id.rvContactos);

        //14.- Dandole Forma al Recycler View
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_like:
                Toast.makeText(this, R.string.favs, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Favoritos.class);
                startActivity(intent);
                break;
            case R.id.action_settings:
                Toast.makeText(this, R.string.opciones, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void agregarFAB(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fabMiFAB);
    }

    //11.- Seteando el Adaptador
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    //12.- Inicializar Lista de Mascotas
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Charmander", "12", R.drawable.charmander));
        mascotas.add(new Mascota("Chilaquill", "4", R.drawable.chilaquil));
        mascotas.add(new Mascota("Elefantito", "6", R.drawable.donphant));
        mascotas.add(new Mascota("Ho-Oh", "7", R.drawable.hooh));
        mascotas.add(new Mascota("Vamo a Calmarno", "15", R.drawable.squar));
        mascotas.add(new Mascota("Hunter", "10", R.drawable.hunter));
        mascotas.add(new Mascota("Gatito", "5", R.drawable.meowth));
        mascotas.add(new Mascota("Mew", "10", R.drawable.mew));
    }

}

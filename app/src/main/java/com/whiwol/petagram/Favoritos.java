package com.whiwol.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.iconopaw);
        getSupportActionBar().setTitle(R.string.favs);

        listaMascotas = (RecyclerView) findViewById(R.id.rvContactos2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarFavs();
        inicializarAdaptador();
    }

    //11.- Seteando el Adaptador
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    //12.- Inicializar Lista de Mascotas Hardcoded
    public void inicializarFavs(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Vamo a Calmarno", "15", R.drawable.squar));
        mascotas.add(new Mascota("Charmander", "12", R.drawable.charmander));
        mascotas.add(new Mascota("Hunter", "10", R.drawable.hunter));
        mascotas.add(new Mascota("Mew", "10", R.drawable.mew));
        mascotas.add(new Mascota("Ho-Oh", "7", R.drawable.hooh));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fav_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(this, R.string.opciones, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

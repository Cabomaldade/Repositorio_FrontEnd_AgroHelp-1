package com.projeto.integrador;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class DrawerCreator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        LinearLayout layout = (LinearLayout) findViewById(R.id.inclusao);
        int layoutid = savedInstanceState.getInt("layout");
        View view = getLayoutInflater().inflate(layoutid, layout, false);
        layout.addView(view);

        /**Linha 27 à linha 37 -> Implementação de Drawer_menu**/
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_feed);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abrir, R.string.fechar);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigationDrawer);
        navigationView.setNavigationItemSelectedListener(this);

    }

    /**
     * Este método controla o abrir e fechar do Drawer_menu
     **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    /**
     * Este método controla o que cada item do Drawer_menu irá fazer
     **/
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        Intent intent;
        switch (id) {

            case R.id.propostas:
                intent = new Intent(this, PropostasActivity.class);
                startActivity(intent);
                break;
            case R.id.user:
                intent = new Intent(this, CadastroActivity.class);
                startActivity(intent);
                break;
        }

        return false;
    }
}

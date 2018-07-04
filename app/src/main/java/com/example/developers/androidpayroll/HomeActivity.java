package com.example.developers.androidpayroll;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout rDwawerLayout;
    private ActionBarDrawerToggle rToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rDwawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        rToggle=new ActionBarDrawerToggle(this,rDwawerLayout,R.string.open,R.string.close);
        rDwawerLayout.addDrawerListener(rToggle);
        rToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(rToggle.onOptionsItemSelected(item))
        {
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.Home)
        {
            Toast.makeText(this,"this is home",Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.login1)
        {
            Intent log=new Intent(this,LoginActivity.class);
            startActivity(log);
        }
        if (id==R.id.signup1)
        {
            Intent sign=new Intent(this,SignupActivity.class);
            startActivity(sign);
        }
        return false;
    }
}

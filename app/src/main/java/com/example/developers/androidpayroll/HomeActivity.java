package com.example.developers.androidpayroll;

import android.app.Fragment;
import android.content.Intent;
import android.net.Network;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
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
        rDwawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        rToggle = new ActionBarDrawerToggle(this, rDwawerLayout, R.string.open, R.string.close);
        rDwawerLayout.addDrawerListener(rToggle);
       /* NavigationView nvDrawer = (NavigationView) findViewById(R.id.navigation_view);*/
        rToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (rToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Home) {
            Intent payroll = new Intent(this, Employee_Payroll.class);
            startActivity(payroll);
        }
        if (id == R.id.login1) {
            Intent log = new Intent(this, LoginActivity.class);
            startActivity(log);
        }
        if (id == R.id.signup1) {
            Intent sign = new Intent(this, SignupActivity.class);
            startActivity(sign);
        }
        return false;
    }
}


/* setupDrawerContent(nvDrawer);


    }
    /* here we handle navigation view item click*/
  /*  public void selectItemDrawer(MenuItem menuItem) {
        /*every time we check which item was clicked in navigation drawer */
       /* Fragment myFragment=null;
        Class fragmentClass;
        switch (menuItem.getItemId())
        {
            case R.id.Home:
                fragmentClass= Home.class;
                break;
            case R.id.login1:
                fragmentClass=Login.class;
                break;
            case R.id.signup1:
                fragmentClass=Signout.class;
                break;
                default:
                    fragmentClass=Home.class;
        }
        try {
            myFragment=(Fragment)fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        /* This will insert the fragment by replacing existing fragment*/
        /*fragmentManager.beginTransaction().replace(R.id.f1,myFragment).commit();
        /*Hignlight the selected item has been done by Navigation view*/
       /* menuItem.setChecked(true);
        /*set aAction bar Title*/
       /* setTitle(menuItem.getTitle());
        rDwawerLayout.closeDrawers();
    }
    private  void  setupDrawerContent(NavigationView navigationView){*/
        /*we will call the previous method(selectedDrawer)whenever a navigation menu item is selected,so inside on navigationSelected(Menuitem item)
        We need to add the following line*/
        /* navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 selectItemDrawer(item);
                 return true;
             }
         });

    }
}*/



       /* NavigationView navigationView=(NavigationView)findViewById(R.id.navigation_view);
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
            Intent payroll=new Intent(this,Employee_Payroll.class);
            startActivity(payroll);
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
*/
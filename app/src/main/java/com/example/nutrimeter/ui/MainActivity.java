package com.example.nutrimeter.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.nutrimeter.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    DrawerLayout mDrawer;
    NavigationView mNavigationView;
    Toolbar mToolbar;
    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        mFab = findViewById(R.id.fab);
        mFab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        mDrawer = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.drawer_navigationView);

        initNavigationDrawer();
    }


    private void initNavigationDrawer(){

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_diary, R.id.nav_my_food, R.id.nav_me, R.id.nav_shopping_list)
                .setDrawerLayout(mDrawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(mNavigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.nav_auth) {
                    mToolbar.setVisibility(View.GONE);
                    mFab.hide();
                    //bottomNavigationView.setVisibility(View.GONE);
                } else {
                    mFab.show();
                    mToolbar.setVisibility(View.VISIBLE);
                    //bottomNavigationView.setVisibility(View.VISIBLE);
                }
            }
        });

        //mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings: {
                Toast.makeText(this, "SETTINGS", Toast.LENGTH_SHORT).show();
                break;
            }
            default: {
                break;

            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_diary:{

                Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.nav_diary);

                Toast.makeText(this, "DIARY", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_my_food:{
                NavOptions navOptions = new NavOptions.Builder()
                        .setPopUpTo(R.id.nav_diary, true)
                        .build();

                Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.nav_my_food, null, navOptions);

                Toast.makeText(this, "MY FOOD", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_me: {

                Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.nav_me);

                Toast.makeText(this, "ME", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_shopping_list : {

                Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.nav_shopping_list);

                Toast.makeText(this, "SHOPPING LIST", Toast.LENGTH_SHORT).show();
                break;
            }

        }
        item.setChecked(true);
        mDrawer.closeDrawer(GravityCompat.START);

        return true;
    }

}
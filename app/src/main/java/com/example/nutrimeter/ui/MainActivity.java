package com.example.nutrimeter.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.ViewModelProviderFactory;
import com.example.nutrimeter.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Inject ViewModelProviderFactory providerFactory;

    MainActivityViewModel viewModel;
    ActivityMainBinding binding;

    private AppBarConfiguration mAppBarConfiguration;
    NavController mNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this, providerFactory).get(MainActivityViewModel.class);

        setupNavigation();

        viewModel.getCurrentUserLiveData().observe(this, firebaseUser -> {
            if (firebaseUser == null){
                mNavController.navigate(R.id.auth_graph);
            }
        });

        initNavigationDrawer();

    }

    private void setupNavigation(){
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);
        mNavController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getParent().getId()) {
                    case R.id.auth_graph:
                        binding.toolbar.setVisibility(View.GONE);
                        binding.fab.hide();
                        break;
                    default:
                        binding.fab.show();
                        binding.toolbar.setVisibility(View.VISIBLE);
                        initNavigationDrawer();
                        break;
                }
            }
        });
    }

    private void initNavigationDrawer(){
        if (mAppBarConfiguration == null){
            setSupportActionBar(binding.toolbar);
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_diary, R.id.nav_my_food, R.id.nav_me, R.id.nav_shopping_list)
                    .setDrawerLayout(binding.drawerLayout)
                    .build();

            NavigationUI.setupActionBarWithNavController(this, mNavController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(binding.drawerNavigationView, mNavController);


            binding.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show());

            //mNavigationView.setNavigationItemSelectedListener(this);
        }
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
            case R.id.action_logout: {
                viewModel.logout();
                break;
            }
            case R.id.action_disconnect:{
                viewModel.disconnectGoogleAccount(this);
                mNavController.navigate(R.id.auth_graph);
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
        binding.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}
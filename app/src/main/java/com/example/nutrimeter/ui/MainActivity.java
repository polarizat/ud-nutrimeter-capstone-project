package com.example.nutrimeter.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.ViewModelProviderFactory;
import com.example.nutrimeter.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    @Inject ViewModelProviderFactory providerFactory;

    MainActivityViewModel viewModel;
    ActivityMainBinding binding;

    private AppBarConfiguration mAppBarConfiguration;
    NavController mNavController;

    Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this, providerFactory).get(MainActivityViewModel.class);
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);

        if (savedInstanceState == null){
            initNavigationDrawer();
            setupNavigation();
            viewModel.getAuthenticationStateLiveData().observe(this, authenticationState -> {
                switch (authenticationState){
                    case UNAUTHENTICATED: case INVALID_AUTHENTICATION:
                        mNavController.navigate(R.id.action_global_auth_graph);
                        break;
                    case AUTHENTICATED: case AUTHENTICATED_GOOGLE:
                        mNavController.navigate(R.id.main_navigation);
                        break;
                }
            });
        }
    }



    private void setupNavigation(){

        mNavController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            switch (destination.getParent().getId()){
                case R.id.auth_graph:
                    getSupportActionBar().hide();
                    binding.toolbar.setVisibility(View.GONE);
                    binding.fab.hide();
                    break;
                case R.id.main_navigation:
                    binding.logoAppBar.setVisibility(View.VISIBLE);
                    binding.toolbar.setVisibility(View.VISIBLE);
                    getSupportActionBar().show();
                    binding.fab.show();
                    break;
            }

            switch (destination.getId()){
                case R.id.nav_search_usda:
                    binding.searchSv.setVisibility(View.VISIBLE);
                    binding.logoAppBar.setVisibility(View.INVISIBLE);
                    mMenu.findItem(R.id.action_search).setVisible(false); //TODO For debug only
                    break;
                case R.id.foodDetail: case R.id.nav_my_food: case R.id.nav_diary: case R.id.nav_me:
                case R.id.nav_shopping_list:
                    binding.searchSv.setVisibility(View.GONE);
                    binding.logoAppBar.setVisibility(View.VISIBLE);
                    if (mMenu != null) {
                        mMenu.findItem(R.id.action_search).setVisible(true);
                    }
                default: {
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

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        mMenu = menu;
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
            }
            case R.id.action_search: {
                mNavController.navigate(R.id.nav_search_usda);
            }
            case R.id.action_test: {

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

//    private void setupObservers() {
//        viewModel.getAuthResultLiveData().observe(getViewLifecycleOwner(), firebaseUserResourceAuth -> {
//            switch (firebaseUserResourceAuth.status){
//                case SUCCESS:
//                    Navigation.findNavController(getView()).navigate(R.id.action_pop_out_of_auth);
//                    break;
//                case ERROR:
//                    Snackbar.make(getView(), "Google sign in failed! Try again!", Snackbar.LENGTH_LONG ).show();
//                    Navigation.findNavController(getView()).navigate(R.id.nav_auth);
//                    break;
//                case LOADING:
//                case DEFAULT:
//                    break;
//            }
//        });
//    }



}
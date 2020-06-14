package com.example.nutrimeter.ui.search_food;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.data.model.search.SearchResultFood;
import com.example.nutrimeter.databinding.SearchUsdaFragmentBinding;

import java.util.LinkedList;

import timber.log.Timber;

public class SearchUsda extends BaseFragment implements SearchedFoodAdapter.ListItemClickListener {

    private SearchUsdaViewModel viewModel;
    private SearchUsdaFragmentBinding binding;

    private SearchedFoodAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SearchUsdaFragmentBinding.inflate(getLayoutInflater());
        viewModel = getViewModel(SearchUsdaViewModel.class, this);

        setupObservers();
        setupRecyclerView();

        Toolbar toolbar = binding.searchAppBarLayout.searchToolbarMain;

        NavController navController = NavHostFragment.findNavController(this);
        NavigationUI.setupWithNavController(toolbar, navController);

        binding.testBtn.setOnClickListener(v -> {
            viewModel.performSearch("cheddar cheese");
        });

        return binding.getRoot();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this.getActivity());
        binding.searchRv.setHasFixedSize(false);
        binding.searchRv.setLayoutManager(layoutManager);

        mAdapter = new SearchedFoodAdapter(new LinkedList<>(), this);
        binding.searchRv.setAdapter(mAdapter);

    }

    private void setupObservers() {
        viewModel.getSearchedFoodListLiveData().observe(getViewLifecycleOwner(), listResource -> {
            switch (listResource.status){
                case SUCCESS:
                    binding.searchLoadingPb.setVisibility(View.INVISIBLE);
                    mAdapter.setNewList(listResource.data);
                    Timber.d("(polarizat) ---> SearchUsda ----> setupObservers: SIZE NUTRIENTS %s", listResource.data.get(0).getFoodNutrients().size());
                    Timber.d("(polarizat) ---> SearchUsda ----> setupObservers: SIZE NUTRIENTS %s", listResource.data.get(0).getFoodNutrients().get(0).toString());

                    break;
                case ERROR:
                    binding.searchLoadingPb.setVisibility(View.INVISIBLE);
                    // TODO
                    break;
                case LOADING:
                    binding.searchLoadingPb.setVisibility(View.VISIBLE);
                    break;
            }
        });
    }

    @Override
    public void onSearchedFoodClick(SearchResultFood food, int foodIndex, View view) {
        //TODO GO TO DETAILS
    }
}
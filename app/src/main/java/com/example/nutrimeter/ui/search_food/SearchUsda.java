package com.example.nutrimeter.ui.search_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.data.model.Food;
import com.example.nutrimeter.data.model.usda.search.SearchResultFood;
import com.example.nutrimeter.databinding.SearchUsdaFragmentBinding;

import java.util.LinkedList;

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


        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.findItem(R.id.action_search).setVisible(false);
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
                    binding.searchLoadingPb.getRoot().setVisibility(View.INVISIBLE);
                    if (listResource.data != null && listResource.data.size() > 0){
                        binding.searchRv.setVisibility(View.VISIBLE);
                        mAdapter.setNewList(listResource.data);
                    } else {
                        Toast.makeText(getContext(), "No matching foodEntities were found! Try something else!", Toast.LENGTH_SHORT).show();
                    }

                    break;
                case ERROR:
                    binding.searchLoadingPb.getRoot().setVisibility(View.INVISIBLE);
                    Toast.makeText(getContext(), "An error has occurred! Check your internet connection and try again!", Toast.LENGTH_SHORT).show();

                    // TODO
                    break;
                case LOADING:
                    binding.searchRv.setVisibility(View.INVISIBLE);
                    binding.searchLoadingPb.getRoot().setVisibility(View.VISIBLE);
                    break;
            }
        });

        androidx.appcompat.widget.Toolbar toolbar =  getActivity().findViewById(R.id.toolbar);
        SearchView searchView = toolbar.findViewById(R.id.search_sv);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.performSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onSearchedFoodClick(SearchResultFood searchResultFood) {
        viewModel.setSelectedFood(new Food(searchResultFood));
        Navigation.findNavController(getView()).navigate(R.id.action_nav_search_usda_to_foodDetail);
    }
}
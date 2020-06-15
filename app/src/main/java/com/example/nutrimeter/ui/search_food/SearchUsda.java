package com.example.nutrimeter.ui.search_food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.data.model.search.SearchResultFood;
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
                    binding.searchLoadingPb.progressBar.setVisibility(View.INVISIBLE);
                    mAdapter.setNewList(listResource.data);

                    break;
                case ERROR:
                    binding.searchLoadingPb.progressBar.setVisibility(View.INVISIBLE);
                    // TODO
                    break;
                case LOADING:
                    binding.searchLoadingPb.progressBar.setVisibility(View.VISIBLE);
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
    public void onSearchedFoodClick(SearchResultFood food) {
        Navigation.findNavController(getView()).navigate(R.id.action_nav_search_usda_to_foodDetail);
    }
}
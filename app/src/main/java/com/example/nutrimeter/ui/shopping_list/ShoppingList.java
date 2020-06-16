package com.example.nutrimeter.ui.shopping_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;

public class ShoppingList extends BaseFragment {

    private ShoppingListViewModel viewModel;

    public static ShoppingList newInstance() {
        return new ShoppingList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        viewModel = getViewModel(ShoppingListViewModel.class);
        return inflater.inflate(R.layout.fragment_shopping_list, container, false);
    }



}
package com.example.nutrimeter.ui.food_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.nutrimeter.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddToBottomSheetFragment extends BottomSheetDialogFragment {

    public static AddToBottomSheetFragment newInstance() {
        return new AddToBottomSheetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_add_to_bs_fragment, container,
                false);

        // get the views and attach the listener

        return view;

    }

}

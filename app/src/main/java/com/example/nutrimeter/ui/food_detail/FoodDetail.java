package com.example.nutrimeter.ui.food_detail;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.databinding.FragmentFoodDetailBinding;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FoodDetail extends BaseFragment {

    FoodDetailViewModel viewModel;
    FragmentFoodDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFoodDetailBinding.inflate(getLayoutInflater());
        viewModel = getViewModel(FoodDetailViewModel.class);

        binding.detailsProteins.setText(generateMacroText(11.35f, "Proteins"));
        binding.detailsCarbs.setText(generateMacroText(33.5f, "Carbs"));
        binding.detailsFats.setText(generateMacroText(9.89f, "Fats"));

        binding.pieChart.configurePieChart(266, 11, 33, 10);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fabAddTo.setOnClickListener(
                v -> Navigation.findNavController(v).navigate(R.id.action_foodDetail_to_addToBottomSheetFragment)
        );

    }

    private SpannableString generateMacroText(float macro, String macroType) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        SpannableString s = new SpannableString(df.format(macro) + "g\n" + macroType);
        s.setSpan(new RelativeSizeSpan(2.0f), 0, df.format(macro).length()+1, 0);
        //s.setSpan(new ForegroundColorSpan(Color.GRAY), 3, s.length(), 0);
        return s;
    }

}

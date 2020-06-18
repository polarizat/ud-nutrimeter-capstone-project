package com.example.nutrimeter.ui.food_detail;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nutrimeter.common.BaseFragment;
import com.example.nutrimeter.data.model.Food;
import com.example.nutrimeter.databinding.FragmentFoodDetailBinding;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FoodDetail extends BaseFragment {

    FoodDetailViewModel viewModel;
    FragmentFoodDetailBinding binding;

    Food mFood;
    private NutrientAdapter mMineralsAdapter;
    private NutrientAdapter mVitaminsAdapter;
    private NutrientAdapter phytonutrientsAdapter;
    private NutrientAdapter miscellaneousAdapter;

    private float currentQuantity = Food.DEFAULT_QUANTITY_IN_GRAMS;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFoodDetailBinding.inflate(getLayoutInflater());
        viewModel = getViewModel(FoodDetailViewModel.class);

        setupObservers();
        setupQuantityEditText();

        return binding.getRoot();
    }

    private void setupQuantityEditText() {
        binding.editTextQuantity.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                String newQuantity = binding.editTextQuantity.getText().toString();
                if (!newQuantity.equals("")) viewModel.updateQuantity(Float.parseFloat(newQuantity));
                else viewModel.updateQuantity(currentQuantity);
            }
            binding.editTextQuantity.clearFocus();
            return false;
        });
    }

    private void setupObservers() {
        viewModel.getSelectedFood().observe(getViewLifecycleOwner(), food -> {
            if (food != null){
                mFood = food;
                showFoodDetails();
            }
        });

        viewModel.mQuantityLiveData.observe(getViewLifecycleOwner(), quantity -> {
            if (quantity > 0) {
                updateDetailsWithQuantity(quantity);
            }
        });
    }

    private void showFoodDetails() {
        binding.setFood(mFood);

        setupPieChart(Food.DEFAULT_QUANTITY_IN_GRAMS);
        setupNutrientsRecyclerViews();
    }

    private void setupPieChart(Float quantity) {

        float quantityMultiplier = quantity / 100;

        float kcalValue = mFood.getCalories().getValue() * quantityMultiplier;
        float proteinsValue = mFood.getProteins().getValue() * quantityMultiplier;
        float carbsValue = mFood.getCarbs().getValue() * quantityMultiplier;
        float fatsValue = mFood.getFats().getValue() * quantityMultiplier;

        binding.detailsPieChartMacrosLayout.pieChart.configurePieChart(kcalValue, proteinsValue, carbsValue, fatsValue);

        binding.detailsPieChartMacrosLayout.detailsCarbs.setText(generateMacroText(kcalValue, "Kcal"));
        binding.detailsPieChartMacrosLayout.detailsProteins.setText(generateMacroText(proteinsValue, "Proteins"));
        binding.detailsPieChartMacrosLayout.detailsCarbs.setText(generateMacroText(carbsValue, "Carbs"));
        binding.detailsPieChartMacrosLayout.detailsFats.setText(generateMacroText(fatsValue, "Fats"));

        DecimalFormat df = new DecimalFormat("#.");
        binding.setDf(df);
    }

    private void setupNutrientsRecyclerViews() {
        LinearLayoutManager layoutManager;

        /* Minerals */
        layoutManager = new LinearLayoutManager(getContext());
        binding.detailsMineralsListLayout.nutrientListRecyclerView.setHasFixedSize(false);
        binding.detailsMineralsListLayout.nutrientListRecyclerView.setLayoutManager(layoutManager);
        mMineralsAdapter = new NutrientAdapter(mFood.getmMinerals());
        binding.detailsMineralsListLayout.nutrientListRecyclerView.setAdapter(mMineralsAdapter);

        /* Vitamins */
        layoutManager = new LinearLayoutManager(getContext());
        binding.detailsVitaminsListLayout.nutrientListRecyclerView.setHasFixedSize(false);
        binding.detailsVitaminsListLayout.nutrientListRecyclerView.setLayoutManager(layoutManager);
        mVitaminsAdapter = new NutrientAdapter(mFood.getmVitamins());
        binding.detailsVitaminsListLayout.nutrientListRecyclerView.setAdapter(mVitaminsAdapter);

        /* Phytonutrients */
        if (mFood.getmPhytonutrients().size() > 0) {
            layoutManager = new LinearLayoutManager(getContext());
            binding.detailsPhytonutrientsListLayout.nutrientListRecyclerView.setHasFixedSize(false);
            binding.detailsPhytonutrientsListLayout.nutrientListRecyclerView.setLayoutManager(layoutManager);
            phytonutrientsAdapter = new NutrientAdapter(mFood.getmPhytonutrients());
            binding.detailsPhytonutrientsListLayout.nutrientListRecyclerView.setAdapter(phytonutrientsAdapter);
        } else {
            binding.detailsPhytonutrientsListLayout.getRoot().setVisibility(View.GONE);
            binding.detailsPhytonutrientsLabel.setVisibility(View.GONE);
        }

        /* Miscellaneous */
        if (mFood.getmMiscellaneous().size() > 0) {
            layoutManager = new LinearLayoutManager(getContext());
            binding.detailsMiscellaneousListLayout.nutrientListRecyclerView.setHasFixedSize(false);
            binding.detailsMiscellaneousListLayout.nutrientListRecyclerView.setLayoutManager(layoutManager);
            miscellaneousAdapter = new NutrientAdapter(mFood.getmMiscellaneous());
            binding.detailsMiscellaneousListLayout.nutrientListRecyclerView.setAdapter(miscellaneousAdapter);
        } else {
            binding.detailsMiscellaneousListLayout.getRoot().setVisibility(View.GONE);
            binding.detailsMiscellaneousLabel.setVisibility(View.GONE);
        }

}


    private void updateDetailsWithQuantity(float quantity){
        setupPieChart(quantity);

        if (mMineralsAdapter != null) mMineralsAdapter.updateQuantity(quantity);
        if (mVitaminsAdapter != null) mVitaminsAdapter.updateQuantity(quantity);
        if (miscellaneousAdapter != null) miscellaneousAdapter.updateQuantity(quantity);
        if (phytonutrientsAdapter != null) phytonutrientsAdapter.updateQuantity(quantity);

    }


    private SpannableString generateMacroText(float macro, String macroType) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        SpannableString s = new SpannableString(df.format(macro) + "g\n" + macroType);
        s.setSpan(new RelativeSizeSpan(1.7f), 0, df.format(macro).length()+1, 0);
        return s;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.fabAddTo.setOnClickListener(
//                v -> Navigation.findNavController(v).navigate(R.id.action_foodDetail_to_addToBottomSheetFragment)
//        );

    }

}

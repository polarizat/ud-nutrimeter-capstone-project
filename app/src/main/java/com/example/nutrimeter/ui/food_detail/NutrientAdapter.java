package com.example.nutrimeter.ui.food_detail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutrimeter.data.model.Nutrient;
import com.example.nutrimeter.databinding.ListItemNutrientDetailsBinding;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class NutrientAdapter extends RecyclerView.Adapter<NutrientAdapter.NutrientViewHolder> {

    private static final float DEFAULT_QUANTITY = 100f;

    private List<Nutrient> mNutrients;
    private float mCurrentQuantity;

    public NutrientAdapter(List<Nutrient> nutrients) {
        mNutrients = nutrients;
        mCurrentQuantity = DEFAULT_QUANTITY;
    }

    @NonNull
    @Override
    public NutrientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ListItemNutrientDetailsBinding itemNutrientBinding = ListItemNutrientDetailsBinding.inflate(inflater, viewGroup, false);

        return new NutrientViewHolder(itemNutrientBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NutrientViewHolder holder, int position) {
        Nutrient nutrient = mNutrients.get(position);
        holder.bind(nutrient);
    }

    @Override
    public int getItemCount() {
        return mNutrients.size();
    }

    public void setNewList(List<Nutrient> list) {
        if (list != null) {
            mNutrients.clear();
            mNutrients.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void updateQuantity(float quantity) {
        mCurrentQuantity = quantity;
        notifyDataSetChanged();
    }

    /**
     * VIEW HOLDER
     */
    class NutrientViewHolder extends RecyclerView.ViewHolder {
        private final ListItemNutrientDetailsBinding binding;

        NutrientViewHolder(ListItemNutrientDetailsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Nutrient nutrient) {
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            binding.setDecimalFormat(df);

            binding.setQuantityMultiplier(mCurrentQuantity / 100f);
            binding.setNutrient(nutrient);

            binding.nutrientRDA.setText(String.format("%s RDA", 0.03f)); //TODO CALCULATE RDA

            binding.executePendingBindings();
        }

    }
}

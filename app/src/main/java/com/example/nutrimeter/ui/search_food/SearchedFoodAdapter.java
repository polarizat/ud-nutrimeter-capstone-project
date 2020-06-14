package com.example.nutrimeter.ui.search_food;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutrimeter.data.model.search.SearchResultFood;
import com.example.nutrimeter.databinding.ListItemSearchedFoodBinding;

import java.util.ArrayList;
import java.util.List;


public class SearchedFoodAdapter extends RecyclerView.Adapter<SearchedFoodAdapter.SeachedFoodViewHolder> {

        private List<SearchResultFood> mFoods;
        final private ListItemClickListener mOnClickLister;

        public SearchedFoodAdapter(List<SearchResultFood> foods, ListItemClickListener listener){
            List<SearchResultFood> list = new ArrayList<>();
            list.add(new SearchResultFood(-1));
            list.addAll(1, foods);
            mFoods = list;
            mOnClickLister = listener;
        }

        public interface ListItemClickListener{
            void onSearchedFoodClick(SearchResultFood food, int foodIndex, View view);
        }


        @NonNull
        @Override
        public SeachedFoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            ListItemSearchedFoodBinding itemFoodBinding = ListItemSearchedFoodBinding.inflate(inflater, viewGroup, false);

            return new SeachedFoodViewHolder(itemFoodBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull SeachedFoodViewHolder holder, int position) {
            SearchResultFood food = mFoods.get(position);
            holder.bind(food);
        }

        @Override
        public int getItemCount() {
            return mFoods.size();
        }

        public void setNewList(List<SearchResultFood> list){
            if (list != null){
                mFoods.clear();
                mFoods.addAll(list);
                notifyDataSetChanged();
            }
        }



        /** VIEW HOLDER*/
        class SeachedFoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private final ListItemSearchedFoodBinding binding;

            SeachedFoodViewHolder(ListItemSearchedFoodBinding binding){
                super(binding.getRoot());
                this.binding = binding;
                binding.searchItemContainer.setOnClickListener(this);
            }

            void bind (SearchResultFood food) {
                binding.setFood(food);
                binding.executePendingBindings();
            }

            @Override
            public void onClick(View v) {
                SearchResultFood food = mFoods.get(getAdapterPosition());
                mOnClickLister.onSearchedFoodClick(food, getLayoutPosition(), v);
            }
        }
}

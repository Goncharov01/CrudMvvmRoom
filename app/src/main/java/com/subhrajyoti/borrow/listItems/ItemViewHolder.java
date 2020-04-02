package com.subhrajyoti.borrow.listItems;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.subhrajyoti.borrow.databinding.RecyclerItemBinding;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    RecyclerItemBinding binding;

    public ItemViewHolder(View v) {
        super(v);
        binding = DataBindingUtil.bind(v);
    }


    public void bind(Object obj){
        binding.setVariable(BR.model,obj);
        binding.executePendingBindings();
    }

}

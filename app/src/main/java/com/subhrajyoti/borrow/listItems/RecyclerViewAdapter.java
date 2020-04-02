package com.subhrajyoti.borrow.listItems;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.subhrajyoti.borrow.R;
import com.subhrajyoti.borrow.databinding.RecyclerItemBinding;
import com.subhrajyoti.borrow.db.BorrowModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<BorrowModel> borrowModelList;
    private View.OnLongClickListener longClickListener;


    public RecyclerViewAdapter(List<BorrowModel> borrowModelList, View.OnLongClickListener longClickListener) {
        this.borrowModelList = borrowModelList;
        this.longClickListener = longClickListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerItemBinding binding = RecyclerItemBinding.inflate(inflater, parent, false);
        return new ItemViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        BorrowModel borrowModel = borrowModelList.get(position);
        holder.bind(borrowModel);
    }


//    @Override
//    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
//        BorrowModel borrowModel = borrowModelList.get(position);
//        holder.bind(borrowModel)
////        holder.itemTextView.setText(borrowModel.getItemName());
////        holder.nameTextView.setText(borrowModel.getPersonName());
////        holder.dateTextView.setText(borrowModel.getBorrowDate().toLocaleString().substring(0, 11));
//        holder.itemView.setTag(borrowModel);
//        holder.itemView.setOnLongClickListener(longClickListener);
//    }

    @Override
    public int getItemCount() {
        return borrowModelList.size();
    }

    public void addItems(List<BorrowModel> borrowModelList) {
        this.borrowModelList.clear();
        this.borrowModelList.addAll(borrowModelList);
        notifyDataSetChanged();

    }

}


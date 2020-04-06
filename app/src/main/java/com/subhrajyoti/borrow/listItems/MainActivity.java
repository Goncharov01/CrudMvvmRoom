package com.subhrajyoti.borrow.listItems;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.subhrajyoti.borrow.R;
import com.subhrajyoti.borrow.addItem.AddActivity;
import com.subhrajyoti.borrow.databinding.ActivityMainBinding;
import com.subhrajyoti.borrow.db.BorrowModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    private BorrowedListViewModel viewModel;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        MyHandlers myHandlers = new MyHandlers();
//        binding.setHandler(myHandlers);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, AddActivity.class));
//            }
//        });

//        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<BorrowModel>(), this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        recyclerView.setAdapter(recyclerViewAdapter);
        binding.setAdapter(recyclerViewAdapter);
        viewModel = ViewModelProviders.of(this).get(BorrowedListViewModel.class);

        viewModel.getItemAndPersonList().observe(MainActivity.this, new Observer<List<BorrowModel>>() {
            @Override
            public void onChanged(@Nullable List<BorrowModel> itemAndPeople) {

//                List<BorrowModel> borrowModels = new ArrayList<>();
//                borrowModels.add(new BorrowModel("qwerty","qwerty",new Date()));

                recyclerViewAdapter.addItems(itemAndPeople);
            }
        });

    }

    @Override
    public boolean onLongClick(View v) {
        BorrowModel borrowModel = (BorrowModel) v.getTag();
        System.out.println(borrowModel);
        return true;

    }

}

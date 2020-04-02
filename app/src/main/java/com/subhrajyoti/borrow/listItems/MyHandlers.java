package com.subhrajyoti.borrow.listItems;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.subhrajyoti.borrow.addItem.AddActivity;

public class MyHandlers implements View.OnLongClickListener {

    @Override
    public boolean onLongClick(View view) {
        Toast.makeText(view.getContext(), "On Long Click Listener", Toast.LENGTH_SHORT).show();
        view.getContext().startActivity(new Intent(view.getContext(), AddActivity.class));
        return true;
    }
}



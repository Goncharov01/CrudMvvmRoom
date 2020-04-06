package com.subhrajyoti.borrow.listItems;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.subhrajyoti.borrow.addItem.AddActivity;
import com.subhrajyoti.borrow.db.AppDatabase;
import com.subhrajyoti.borrow.db.BorrowModel;

public class MyHandlers implements View.OnLongClickListener {

    AppDatabase appDatabase;
    BorrowModel borrowModel;

    public MyHandlers(BorrowModel borrowModel) {
        this.borrowModel = borrowModel;


    }

    @Override
    public boolean onLongClick(View view) {
        Toast.makeText(view.getContext(), borrowModel.getItemName(), Toast.LENGTH_SHORT).show();
        appDatabase = AppDatabase.getDatabase(view.getContext());
        new DeleteAsyncTask(appDatabase).execute(borrowModel);
        return false;
    }

    private static class DeleteAsyncTask extends AsyncTask<BorrowModel, Void, Void> {

        private AppDatabase db;

        DeleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final BorrowModel... params) {
            db.itemAndPersonModel().deleteBorrow(params[0]);
            return null;
        }

    }

}



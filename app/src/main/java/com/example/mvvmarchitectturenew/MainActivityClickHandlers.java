package com.example.mvvmarchitectturenew;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainActivityClickHandlers {
    Context  context;

    public MainActivityClickHandlers(Context context) {
        this.context = context;
    }

    public void onFabClick(View v){
        Intent i=new Intent(v.getContext(),AddNewContact.class);
        context.startActivity(i);
    }
}

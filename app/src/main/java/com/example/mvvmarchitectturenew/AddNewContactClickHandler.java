package com.example.mvvmarchitectturenew;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {

    Contacts contacts;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contacts, Context context,MyViewModel myViewModel) {
        this.contacts = contacts;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void onSubmitbtnClick(View v) {
        if(contacts.getName()==null){
            Toast.makeText(context,"Please Enter Valid Data",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i=new Intent(context,MainActivity.class);
            Contacts c=new Contacts(contacts.getName(),contacts.getEmail());
            myViewModel.addNewContacts(c);
            context.startActivity(i);

        }
    }
}

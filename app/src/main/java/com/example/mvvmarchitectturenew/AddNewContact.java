package com.example.mvvmarchitectturenew;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmarchitectturenew.databinding.ActivityAddNewContactBinding;

public class AddNewContact extends AppCompatActivity {

    private ActivityAddNewContactBinding binding;
    private Contacts contacts;
    private AddNewContactClickHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_new_contact);

        contacts=new Contacts();
        binding.setContact(contacts);

        MyViewModel myViewModel=new ViewModelProvider(this).get(MyViewModel.class);
        handler=new AddNewContactClickHandler(contacts,this,myViewModel);
        binding.setClickHandler(handler);

    }
}
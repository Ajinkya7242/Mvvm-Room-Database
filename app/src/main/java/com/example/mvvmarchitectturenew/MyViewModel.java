package com.example.mvvmarchitectturenew;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Objects;

public class MyViewModel extends AndroidViewModel {

    private Repository repository;
    public LiveData<List<Contacts>> allContacts;
    public MyViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        allContacts=repository.getAllContacts();
        return allContacts;
    }

    public void addNewContacts(Contacts contacts) {
        repository.addContact(contacts);
    }

    public void removeContacts(Contacts contacts) {
        repository.deleteContact(contacts);
    }
}

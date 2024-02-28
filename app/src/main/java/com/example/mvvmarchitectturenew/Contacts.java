package com.example.mvvmarchitectturenew;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts")
public class Contacts {
    @PrimaryKey(autoGenerate = true)
    private int contact_id;
    private String name;
    private String email;

    public Contacts(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public Contacts(){

    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

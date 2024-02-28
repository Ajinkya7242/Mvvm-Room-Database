package com.example.mvvmarchitectturenew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvmarchitectturenew.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contactsArrayList=new ArrayList<>();
    private MyAdapter myAdapter;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers mainActivityClickHandlers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainActivityClickHandlers=new MainActivityClickHandlers(this);
        activityMainBinding.setClickHandeler(mainActivityClickHandlers);
        MyAdapter myAdapter=new MyAdapter(contactsArrayList);

        RecyclerView recyclerView=activityMainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        contactDatabase=ContactDatabase.getInstance(this);

        MyViewModel viewModel=new ViewModelProvider(this).get(MyViewModel.class);


     


        viewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contactsArrayList.clear();
                for(Contacts c : contacts) {

                    Log.v("TAGY",c.getName());
                    Log.v("TAGY",c.getEmail());
                    contactsArrayList.add(c);
                }
                myAdapter.notifyDataSetChanged();
            }
        });


        recyclerView.setAdapter(myAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Contacts c=contactsArrayList.get(viewHolder.getAdapterPosition());
                viewModel.removeContacts(c);
            }



        }).attachToRecyclerView(recyclerView);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Contacts c = contactsArrayList.get(viewHolder.getAdapterPosition());
                viewModel.removeContacts(c);
            }
        }).attachToRecyclerView(recyclerView);

    }

}
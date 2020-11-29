package com.example.stufftracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.stufftracker.model.Inventory;
import com.example.stufftracker.model.Item;
import com.example.stufftracker.model.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class InventoryActivity extends AppCompatActivity {
    User user;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter itemAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        // get the user data
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("user");
            user = new Gson().fromJson(value, User.class);
        }


        // populate the list
       recyclerView = (RecyclerView) findViewById(R.id.itemsList);
//        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<Item> input = new ArrayList<>();

        // loading some test data
        Inventory inv = new Inventory();
        inv.addItem("Diamonds", 55);
        inv.addItem("Rubles", 55);
        for (Item i : inv.getInventory()) {
            input.add(i);
        }
        // define an adapter
        itemAdapter = new ItemAdapter(input);
        recyclerView.setAdapter(itemAdapter);

    }

    // newItem(View view) {}
    // delete item() {}
    // incrementItem() {}
    // decrementItem() {}
    // setItemCount() {}
}



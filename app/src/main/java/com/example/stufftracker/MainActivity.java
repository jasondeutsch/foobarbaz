package com.example.stufftracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.stufftracker.model.Item;
import com.example.stufftracker.model.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Map<String, User> users = new HashMap<String, User>();
    private ArrayList<Item> Inventory;

    private String username = "";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBTN = findViewById(R.id.login);
        Button signupBTN = findViewById(R.id.newUser);

        EditText usernameEditText = findViewById(R.id.editTextTextPersonName);
        EditText passwordEditText = findViewById(R.id.editTextTextPassword);
        // attach event listener for text change to nameText
        //usernameEditText.addTextChangedListener(new TextWatcher(){
        //    @Override
        //    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        //    @Override
        //    public void onTextChanged(CharSequence s, int start, int before, int count) { }

        //    @Override
        //    public void afterTextChanged(Editable s) {
        //        // TODO include password quality check
        //        username = usernameEditText.toString();
        //        loginBTN.setEnabled(!s.toString().equals(""));
        //        signupBTN.setEnabled(!s.toString().equals(""));
        //    }
        //});

        //passwordEditText.addTextChangedListener(new TextWatcher(){
        //    @Override
        //    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        //    @Override
        //    public void onTextChanged(CharSequence s, int start, int before, int count) { }

        //    @Override
        //    public void afterTextChanged(Editable s) {
        //        // TODO include password quality check
        //        password = passwordEditText.toString();
        //        loginBTN.setEnabled(!s.toString().equals(""));
        //        signupBTN.setEnabled(!s.toString().equals(""));
        //    }
        //});
    }



    public void signup(View view) {
        if (users.containsKey(username)) {
            // TODO alert that the  name is taken
        } else {
            // todo username and password validation
            User newUser = new User(username, password);
            users.put(username, newUser);

            // launch inventory activity with user data
            Intent intent = new Intent(getBaseContext(), InventoryActivity.class);
            intent.putExtra("user", new Gson().toJson(users.get(username)));
            startActivity(intent);
            //setContentView(R.layout.activity_inventory);
        }
    }

    public void login(View view) {
        if (users.containsKey(username) && users.get(username).comparePassword(password)) {
            // launch inventory activity with user data
            Intent intent = new Intent(getBaseContext(), InventoryActivity.class);
            intent.putExtra("user", new Gson().toJson(users.get(username)));
            startActivity(intent);

            //setContentView(R.layout.activity_inventory);
        } else {
            // TODO give notification that credentials are invalid
        }
    }
}
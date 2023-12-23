package com.example.gopillbox;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import ApiInterfaces.RetrofitClient;
import ApiInterfaces.UsersApiInterface;
import Models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_registro extends AppCompatActivity {

    private UsersApiInterface usersApi;
    private EditText editTextEmail, editTextPassword;
    private Button btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Initialize the UsersApi interface
        usersApi = RetrofitClient.getClient().create(UsersApiInterface.class);

        // Initialize views
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnRegistrarse = findViewById(R.id.btn_registrarse);

        // Set OnClickListener for the "Registrarse" button
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Retrieve email and password from EditText fields
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Create a User object
        User user = new User();
        user.setUserName(email);  // Assuming email is the username
        user.setPassword(password);

        // Make a POST request using Retrofit
        Call<User> call = usersApi.createUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User registeredUser = response.body();
                    // Save the registered user object in local storage
                    saveUserLocally(registeredUser);
                    // Handle the registered user object
                } else {
                    // Handle API error
                    showErrorMessage("API Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle failure
                showErrorMessage("Network Failure: " + t.getMessage());
            }
        });
    }

    private void showErrorMessage(String message) {
        // Display an AlertDialog with the error message
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setTitle("Error")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Do nothing, or handle the click event
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void saveUserLocally(User user) {
        // Save the user details in SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("userId", String.valueOf(user.getUserId()));
        editor.putString("userName", user.getUserName());
        // Add more user details as needed
        editor.apply();
    }
}

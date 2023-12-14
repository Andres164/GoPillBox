package com.example.gopillbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gopillbox.R;

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
                    // Handle the registered user object
                } else {
                    // Handle API error
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle failure
            }
        });
    }
}

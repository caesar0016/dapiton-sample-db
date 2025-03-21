package com.example.dapiton_banse_week2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dapiton_banse_week2.roomModel.Person.AppDataPerson;
import com.example.dapiton_banse_week2.roomModel.Person.DaoUserAccounts;
import com.example.dapiton_banse_week2.roomModel.Person.UserAccounts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private DaoUserAccounts daoUserAccounts;
    private static final ExecutorService executor = Executors.newSingleThreadExecutor(); // Background thread

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize database
        AppDataPerson db = AppDataPerson.getInstance(this);
        daoUserAccounts = db.daoAccounts();

        // Run database operation in the background
        executor.execute(() -> {
            daoUserAccounts.insertAccount(new UserAccounts("username03", "password2", "Admin"));


        });


    }
}
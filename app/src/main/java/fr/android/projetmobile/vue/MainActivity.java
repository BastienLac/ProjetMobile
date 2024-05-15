package fr.android.projetmobile.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.android.projetmobile.R;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_VOYAGE = R.id.voyage;
    private static final int MENU_MAPS = R.id.maps;
    private static final int MENU_TAKE_PHOTO = R.id.take_photo;
    private static final int MENU_GALLERY = R.id.gallery;
    private static final int MENU_FORM = R.id.form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        if(bottomNavigationView != null){
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    NavigationUtils.navigate(item, MainActivity.this);
                    return true;
                }
            });
        }

    }

    protected void connectUser(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    EditText login = findViewById(R.id.journeyTitle);
                    EditText password = findViewById(R.id.journeyBudget);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/projetmobile", "root", "");

                    String sql = "SELECT id FROM user WHERE login = " + login + " AND password= " + password;
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        //On connecte
                    }
                    else {
                        // On rejete
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }}).start();
    }
}
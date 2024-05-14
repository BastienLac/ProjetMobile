package fr.android.projetmobile.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;

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
                    // Gérer les clics sur les éléments du menu ici
                    int id = item.getItemId();
                    Intent intent = null;
                    if (id == R.id.voyage) {
                        intent = new Intent(MainActivity.this, DisplayJourneyActivity.class);
                        startActivity(intent);
                    }
                    else if (id == R.id.maps) {
                        intent = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(intent);
                    }
                    else if (id == R.id.take_photo) {
                        intent = new Intent(MainActivity.this, PhotosActivity.class);
                        startActivity(intent);
                    }
                    else if (id == R.id.gallery) {
                        //intent = new Intent(MainActivity.this, .class);
                        //startActivity(intent);
                    }
                    else if (id == R.id.form) {
                        intent = new Intent(MainActivity.this, CreateJourneyActivity.class);
                        startActivity(intent);
                    }
                    return false;
                }
            });
        }

    }
}
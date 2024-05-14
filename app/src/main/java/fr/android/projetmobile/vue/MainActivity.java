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
                    intent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.gallery) {
                    intent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.form) {
                    intent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.voyage) {

            Intent display_journey_intent = new Intent(this, DisplayJourneyActivity.class);
            startActivity(display_journey_intent);

            return true;
        } else if (id == R.id.maps) {

            Intent maps_intent = new Intent(this, MapsActivity.class);
            startActivity(maps_intent);

            return true;
        } else if (id == R.id.take_photo) {

            Intent photos_intent = new Intent(this, PhotosActivity.class);
            startActivity(photos_intent);

            return true;
        } else if (id == R.id.gallery) {

            //Intent gallery_intent = new Intent(this, EnterURLActivity.class);
            //startActivity(gallery_intent);

            return true;
        } else if (id == R.id.form) {

            Intent form_intent = new Intent(this, CreateJourneyActivity.class);
            startActivity(form_intent);

            return true;


        }

        return super.onOptionsItemSelected(item);
    }
}
package fr.android.projetmobile.vue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;

import fr.android.projetmobile.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.bottomNavigationView);
        setSupportActionBar(toolbar);
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

            Intent last_operation_intent = new Intent(this, DisplayJourneyActivity.class);
            startActivity(last_operation_intent);

            return true;
        } else if (id == R.id.maps) {

            Intent maps_intent = new Intent(this, MapsActivity.class);
            startActivity(maps_intent);

            return true;
        } else if (id == R.id.take_photo) {

            Intent enter_url_intent = new Intent(this, PhotoActivity.class);
            startActivity(enter_url_intent);

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
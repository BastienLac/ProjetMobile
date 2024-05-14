package fr.android.projetmobile.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;
import fr.android.projetmobile.R;
import fr.android.projetmobile.model.Journey;
import fr.android.projetmobile.outils.JourneyOpenHelper;

public class DisplayJourneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_journey);

        RecyclerView journeyList = findViewById(R.id.journeyList);
        JourneyOpenHelper journeyOpenHelper = new JourneyOpenHelper(this);

        List<Journey> journeys = journeyOpenHelper.getAllJourneys();
        JourneyAdapter adapter = new JourneyAdapter(journeys, journeyOpenHelper);
        journeyList.setLayoutManager(new LinearLayoutManager(this));
        journeyList.setAdapter(adapter);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Gérer les clics sur les éléments du menu ici
                int id = item.getItemId();
                Intent intent = null;
                if (id == R.id.voyage) {
                    intent = new Intent(DisplayJourneyActivity.this, DisplayJourneyActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.maps) {
                    intent = new Intent(DisplayJourneyActivity.this, MapsActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.take_photo) {
                    intent = new Intent(DisplayJourneyActivity.this, PhotosActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.gallery) {
                    //intent = new Intent(MainActivity.this, .class);
                    //startActivity(intent);
                }
                else if (id == R.id.form) {
                    intent = new Intent(DisplayJourneyActivity.this, CreateJourneyActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }
}
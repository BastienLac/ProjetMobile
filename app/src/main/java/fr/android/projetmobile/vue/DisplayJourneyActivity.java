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
                NavigationUtils.navigate(item, DisplayJourneyActivity.this);
                return true;
            }
        });
    }
}
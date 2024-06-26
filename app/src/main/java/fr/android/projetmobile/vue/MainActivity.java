package fr.android.projetmobile.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

import fr.android.projetmobile.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMap(View view) throws IOException {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    public void CreateJourney(View view) {
        Intent intent = new Intent(MainActivity.this, CreateJourneyActivity.class);
        startActivity(intent);
    }

    public void DisplayJourney(View view) {
        Intent intent = new Intent(MainActivity.this, DisplayJourneyActivity.class);
        startActivity(intent);
    }
}
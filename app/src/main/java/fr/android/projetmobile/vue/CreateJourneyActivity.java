package fr.android.projetmobile.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.android.projetmobile.R;
import fr.android.projetmobile.model.Journey;
import fr.android.projetmobile.outils.JourneyOpenHelper;

public class CreateJourneyActivity extends AppCompatActivity {

    private EditText journeyTitle;
    private EditText journeyBudget;
    private EditText journeyDescription;
    private JourneyOpenHelper journeyOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_journey);

        //on recupere les champs du formulaire
        journeyTitle = findViewById(R.id.journeyTitle);
        journeyBudget = findViewById(R.id.journeyBudget);
        journeyDescription = findViewById(R.id.journeyDescription);

        journeyOpenHelper = new JourneyOpenHelper(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Gérer les clics sur les éléments du menu ici
                int id = item.getItemId();
                Intent intent = null;
                if (id == R.id.voyage) {
                    intent = new Intent(CreateJourneyActivity.this, DisplayJourneyActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.maps) {
                    intent = new Intent(CreateJourneyActivity.this, MapsActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.take_photo) {
                    intent = new Intent(CreateJourneyActivity.this, PhotosActivity.class);
                    startActivity(intent);
                }
                else if (id == R.id.gallery) {
                    //intent = new Intent(MainActivity.this, .class);
                    //startActivity(intent);
                }
                else if (id == R.id.form) {
                    intent = new Intent(CreateJourneyActivity.this, CreateJourneyActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    public void validateJourney(View view) {
        // on recupère les valeurs des champs
        String title = journeyTitle.getText().toString();
        String budget = journeyBudget.getText().toString();
        String description = journeyDescription.getText().toString();

        if (title.isEmpty() || budget.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        Journey journey = new Journey(title, Double.parseDouble(budget), description);
        journeyOpenHelper.addJourney(journey);

        Toast.makeText(this, "Voyage ajouté avec succès", Toast.LENGTH_SHORT).show();

        // redirige vers la page d'accueil
        finish();
    }


}
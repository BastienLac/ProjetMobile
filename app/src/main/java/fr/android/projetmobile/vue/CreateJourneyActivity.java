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
                NavigationUtils.navigate(item, CreateJourneyActivity.this);
                return true;
            }
        });
    }

    public void validateJourney(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // on recupère les valeurs des champs
                final String title = journeyTitle.getText().toString();
                final String budget = journeyBudget.getText().toString();
                final String description = journeyDescription.getText().toString();

                if (title.isEmpty() || budget.isEmpty()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }

                final Journey journey = new Journey(title, Double.parseDouble(budget), description);
                journeyOpenHelper.addJourney(journey);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Voyage ajouté avec succès", Toast.LENGTH_SHORT).show();
                        // redirige vers la page d'accueil
                        Intent intent = new Intent(CreateJourneyActivity.this, DisplayJourneyActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }).start();
    }



}
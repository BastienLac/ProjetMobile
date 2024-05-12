package fr.android.projetmobile.vue;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
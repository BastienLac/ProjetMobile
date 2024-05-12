package fr.android.projetmobile.vue;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
    }
}
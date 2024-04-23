package fr.android.projetmobile;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map); // Assure-toi d'avoir un fichier XML correspondant

        // Ici, tu peux ajouter le code pour initialiser la carte et implémenter la géolocalisation en temps réel
        // Par exemple, tu peux utiliser Google Maps Android API ou une autre bibliothèque de cartographie
    }
}

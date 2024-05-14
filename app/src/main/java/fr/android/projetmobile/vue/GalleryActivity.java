package fr.android.projetmobile.vue;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.android.projetmobile.R;

public class GalleryActivity extends AppCompatActivity {


    ImageView imageview;
    Button buttongallery;
    ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        buttongallery = findViewById(R.id.photo_gallery);
        imageview = findViewById(R.id.imageViewFromGallery);


        registerResult();
        buttongallery.setOnClickListener(view -> pickImage());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                NavigationUtils.navigate(item, GalleryActivity.this);
                return true;
            }
        });

    }

    private void pickImage() {
        Intent intent = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
        }
        if (intent != null) {
            resultLauncher.launch(intent);
        } else {
            Toast.makeText(this, "La sélection d'image n'est pas supportée sur cet appareil.", Toast.LENGTH_SHORT).show();
        }
    }

    private void registerResult() {
        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        try {
                            Uri imageUri = result.getData().getData();
                            imageview.setImageURI(imageUri);
                        } catch (Exception e) {
                            Toast.makeText(GalleryActivity.this, "Pas d'image sélectionnée", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }



}


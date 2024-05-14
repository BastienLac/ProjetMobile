package fr.android.projetmobile.vue;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import java.io.OutputStream;
import fr.android.projetmobile.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PhotoActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 100;
    private static final int REQUEST_PERMISSIONS = 2;
    ImageView imageview;
    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        imageview = findViewById(R.id.imageViewFromPhoto);
        button = findViewById(R.id.take_photo);

        if (ContextCompat.checkSelfPermission(PhotoActivity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PhotoActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imageview.setImageBitmap(imageBitmap);
                saveImageToGallery(imageBitmap);
            }
        }
    }

    private void saveImageToGallery(Bitmap imageBitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentResolver resolver = getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, "image_" + System.currentTimeMillis() + ".jpg");
            contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            contentValues.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures");
            Uri imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            try {
                OutputStream outputStream = resolver.openOutputStream(imageUri);
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        }
    }


}
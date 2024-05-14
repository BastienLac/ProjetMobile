package fr.android.projetmobile.vue;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import fr.android.projetmobile.R;

public class NavigationUtils {
    public static void navigate(MenuItem item, Activity currentActivity) {
        Intent intent = null;
        int itemId = item.getItemId();

        if (itemId == R.id.voyage) {
            intent = new Intent(currentActivity, DisplayJourneyActivity.class);
        } else if (itemId == R.id.maps) {
            intent = new Intent(currentActivity, MapsActivity.class);
        } else if (itemId == R.id.take_photo) {
            intent = new Intent(currentActivity, PhotosActivity.class);
        } else if (itemId == R.id.gallery) {
            intent = new Intent(currentActivity, GalleryActivity.class);
        } else if (itemId == R.id.form) {
            intent = new Intent(currentActivity, CreateJourneyActivity.class);
        }

        if (intent != null) {
            currentActivity.startActivity(intent);
        }
    }
}


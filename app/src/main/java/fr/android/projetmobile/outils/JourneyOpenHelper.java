package fr.android.projetmobile.outils;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import fr.android.projetmobile.model.Journey;

public class JourneyOpenHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Journey.JourneyEntry.TABLE_NAME + " (" +
            Journey.JourneyEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            Journey.JourneyEntry.COLUMN_NAME_TITLE + " TEXT," +
            Journey.JourneyEntry.COLUMN_NAME_BUDGET + " REAL," +
            Journey.JourneyEntry.COLUMN_NAME_DESCRIPTION + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Journey.JourneyEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Journey.db";

    public JourneyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void addJourney(Journey journey) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Journey.JourneyEntry.COLUMN_NAME_TITLE, journey.getTitle());
        values.put(Journey.JourneyEntry.COLUMN_NAME_BUDGET, journey.getBudget());
        values.put(Journey.JourneyEntry.COLUMN_NAME_DESCRIPTION, journey.getDescription());

        long newRowId = db.insert(Journey.JourneyEntry.TABLE_NAME, null, values);
        journey.setId(newRowId);
    }

    public void deleteJourney(Journey journey) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Journey.JourneyEntry.TABLE_NAME, Journey.JourneyEntry.COLUMN_NAME_ID + " = ?",
                new String[]{String.valueOf(journey.getId())});
        db.close();
    }

    @SuppressLint("Range")
    public List<Journey> getAllJourneys() {
        List<Journey> journeyList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + Journey.JourneyEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Journey journey = new Journey();
                journey.setId(cursor.getLong(cursor.getColumnIndex(Journey.JourneyEntry.COLUMN_NAME_ID)));
                journey.setTitle(cursor.getString(cursor.getColumnIndex(Journey.JourneyEntry.COLUMN_NAME_TITLE)));
                journey.setBudget(cursor.getDouble(cursor.getColumnIndex(Journey.JourneyEntry.COLUMN_NAME_BUDGET)));
                journey.setDescription(cursor.getString(cursor.getColumnIndex(Journey.JourneyEntry.COLUMN_NAME_DESCRIPTION)));
                journeyList.add(journey);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return journeyList;
    }
}

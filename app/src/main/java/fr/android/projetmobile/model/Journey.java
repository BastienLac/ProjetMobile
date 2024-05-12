package fr.android.projetmobile.model;

import android.provider.BaseColumns;

public class Journey {

    private long id;
    private String title;
    private double budget;
    private String description;

    public Journey(String title, double budget, String description) {
        this.title = title;
        this.budget = budget;
        this.description = description;
    }

    public Journey() {

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public double getBudget() {
        return budget;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class JourneyEntry implements BaseColumns {
        public static final String TABLE_NAME = "journey";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_BUDGET = "budget";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }
}

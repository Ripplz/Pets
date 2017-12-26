package com.example.android.pets;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract;
import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by DELL on 12/5/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Pet.db";

    private final String TEXT_TYPE = " TEXT";
    private final String INTEGER_TYPE = " INTEGER";
    private final String NOT_NULL = " NOT NULL";
    private final String DEFAULT = " DEFAULT";
    private final String COMMA_SEP = ", ";

    private final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PetEntry.TABLE_NAME + " (" +
            PetEntry._ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PetEntry.COLUMN_PET_NAME + TEXT_TYPE + COMMA_SEP +
            PetEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA_SEP +
            PetEntry.COLUMN_PET_GENDER + INTEGER_TYPE + NOT_NULL + COMMA_SEP +
            PetEntry.COLUMN_PET_WEIGHT + INTEGER_TYPE + NOT_NULL + DEFAULT + " " + 0 +
            ")";

    private final String SQL_DELETE_ENTRIES = "DROP TABLE " + PetEntry.TABLE_NAME;

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}

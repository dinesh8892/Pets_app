package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Pets.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA = ",   ";
    private static final String INT_TYPE = " INTEGER";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+ PetEntry.TABLE_NAME
            + "(" + PetEntry._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT, " + PetEntry.COLUMN_PET_NAME
            + TEXT_TYPE + " NOT NULL " + COMMA + PetEntry.COLUMN_PET_BREED + TEXT_TYPE + COMMA +
            PetEntry.COLUMN_PET_GENDER + INT_TYPE + " NOT NULL" + COMMA + PetEntry.COLUMN_PET_WEIGHT
            + INT_TYPE + " NOT NULL DEFAULT 0" +")";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;

    public PetDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int Older_Version, int New_Version){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int Older_Version, int New_Version){
        onUpgrade(db, Older_Version, New_Version);
    }
}

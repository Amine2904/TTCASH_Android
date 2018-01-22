package fr.utt.if26.ttcash;

/**
 * Created by Amine on 02/01/2018.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_CREATE =
            "CREATE TABLE ScoreBoard(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "name VARCHAR(255) NOT NULL,"
                    + "score INTEGER NOT NULL"
                    + ");";

    private static final String DATABASE_NAME = "GameDatabase";
    private static final String TABLE_NAME = "ScoreBoard";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_DROP = "DROP TABLE IF EXISTS "
            + TABLE_NAME + ";";
    private static final String firstColumn = "ID";
    private static final String secondColumn = "name";
    private static final String thirdColumn = "score";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TABLE_DROP);
        onCreate(sqLiteDatabase);

    }

    public boolean addData(String playerName, int score) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(secondColumn, playerName);
        contentValues.put(thirdColumn, score);
        Cursor data = getData();
        int dataCount = data.getCount();
        int position = dataCount;
        data.moveToLast();

        if (data.getCount() == 0) {
            position = 0;
        } else {
            do {
                int currentScore = data.getInt(2);
                if (currentScore < score) {
                    position = data.getPosition();
                }
            } while (data.moveToPrevious());
        }

        if (dataCount == 5) {
            dataCount = dataCount - 2;
        } else if (dataCount < 5) {
            long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
            dataCount--;
        }

        while (dataCount >= position) {
            data.moveToPosition(dataCount);
            String nameToMove = data.getString(1);
            int scoreToMove = data.getInt(2);
            updateRow(scoreToMove, nameToMove, dataCount + 2);
            dataCount--;
        }

        updateRow(score, playerName, position + 1);
        return true;

    }

    public Cursor getData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = sqLiteDatabase.rawQuery(query, null);
        return data;
    }

    private void updateRow(int newScore, String newName, int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + secondColumn +
                " = '" + newName + "' WHERE " + firstColumn + " = '" + id + "'";
        sqLiteDatabase.execSQL(query);

        query = "UPDATE " + TABLE_NAME + " SET " + thirdColumn +
                " = '" + newScore + "' WHERE " + firstColumn + " = '" + id + "'";
        sqLiteDatabase.execSQL(query);
    }

}
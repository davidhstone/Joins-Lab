package com.example.davidstone.myjoinsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by davidstone on 7/17/16.
 */
public class JoinsAppSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "EMPLOYEE_JOB.db";

    public static final String EMPLOYEES_TABLE_NAME = "EMPLOYEES";

   // public static final String EMPLOYEES_COL_ID = "_id";
    public static final String EMPLOYEES_COL_SSN = "SSN";
    public static final String EMPLOYEES_COL_FIRST_NAME = "First_Name";
    public static final String EMPLOYEES_COL_LAST_NAME = "Last_Name";
    public static final String EMPLOYEES_COL_YEAR_OF_BIRTH = "Year_of_Birth";
    public static final String EMPLOYEES_COL_CITY = "City";

    public static final String[] EMPLOYEE_COLUMNS = {EMPLOYEES_COL_SSN,
            EMPLOYEES_COL_FIRST_NAME,EMPLOYEES_COL_LAST_NAME,EMPLOYEES_COL_YEAR_OF_BIRTH,
            EMPLOYEES_COL_CITY};

    private static final String CREATE_EMPLOYEES_TABLE =
            "CREATE TABLE " + EMPLOYEES_TABLE_NAME +
                    "(" +
                 //   EMPLOYEES_COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    EMPLOYEES_COL_SSN + " TEXT PRIMARY KEY NOT NULL, " +
                    EMPLOYEES_COL_FIRST_NAME + " TEXT NOT NULL, " +
                    EMPLOYEES_COL_LAST_NAME + " TEXT NOT NULL, " +
                    EMPLOYEES_COL_YEAR_OF_BIRTH + " TEXT NOT NULL," +
                    EMPLOYEES_COL_CITY + " TEXT )";



    public static final String JOBS_TABLE_NAME = "JOBS";

 //   public static final String JOBS_COL_ID = "_id";
    public static final String JOBS_COL_SSN = " TEXT PRIMARY KEY NOT NULL, ";
    public static final String JOBS_COL_COMPANY = " TEXT NOT NULL ";
    public static final String JOBS_COL_SALARY = " TEXT NOT NULL ";
    public static final String JOBS_COL_EXPERIENCE = " TEXT)";

    public static final String[] JOBS_COLUMNS = {JOBS_COL_SSN,
            JOBS_COL_COMPANY,JOBS_COL_SALARY,JOBS_COL_EXPERIENCE};

    private static final String CREATE_JOBS_TABLE =
            "CREATE TABLE " + JOBS_TABLE_NAME +
                    "(" +
            //        JOBS_COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    JOBS_COL_SSN + " TEXT, " +
                    JOBS_COL_COMPANY + " TEXT, " +
                    JOBS_COL_SALARY + " TEXT, " +
                    JOBS_COL_EXPERIENCE + " TEXT, )";

    private static JoinsAppSQLiteOpenHelper instance;

    public static JoinsAppSQLiteOpenHelper getInstance(Context context){
        if(instance == null){
            instance = new JoinsAppSQLiteOpenHelper(context.getApplicationContext());
        }
        return instance;
    }


    private JoinsAppSQLiteOpenHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EMPLOYEES_TABLE);
        db.execSQL(CREATE_JOBS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EMPLOYEES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + JOBS_TABLE_NAME);
        this.onCreate(db);
    }

    public void insertRowEmployee (String emplSSN, String firstName, String lastName,
                                String yob, String city) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EMPLOYEES_COL_SSN, emplSSN);
        values.put(EMPLOYEES_COL_FIRST_NAME, firstName);
        values.put(EMPLOYEES_COL_LAST_NAME, lastName);
        values.put(EMPLOYEES_COL_YEAR_OF_BIRTH, yob);
        values.put(EMPLOYEES_COL_CITY, city);

        db.insert(EMPLOYEES_TABLE_NAME, null, values);

        db.close();
    }

    public void insertRowJob (String jobsSSN, String company, String salary,
                                String experience) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(JOBS_COL_SSN, jobsSSN);
        values.put(JOBS_COL_COMPANY, company);
        values.put(JOBS_COL_SALARY, salary);
        values.put(JOBS_COL_EXPERIENCE, experience);

        db.insert(JOBS_TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<String> getCompanyJoins () {
        String result = "";
   //     String result2 = "";
        ArrayList<String> employeeList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        // Building query using INNER JOIN keyword.
        String query = "SELECT " + EMPLOYEES_COL_FIRST_NAME + EMPLOYEES_COL_LAST_NAME + " FROM " +
                EMPLOYEES_TABLE_NAME + " JOIN " + JOBS_TABLE_NAME + " ON " + EMPLOYEES_TABLE_NAME +
                "." + EMPLOYEES_COL_SSN + " = " + JOBS_TABLE_NAME + "." + JOBS_COL_SSN + " AND " +
                JOBS_COL_COMPANY + " = 'Macys'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()) {
             //   result1 += cursor.getString(cursor.getColumnIndex(EMPLOYEES_COL_FIRST_NAME
             //   )) + " " + cursor.getString(cursor.getColumnIndex(EMPLOYEES_COL_LAST_NAME
             //   ));
        //       result2 += cursor.getString(cursor.getColumnIndex(EMPLOYEES_COL_FIRST_NAME
        //       )) + " " + cursor.getString(cursor.getColumnIndex(EMPLOYEES_COL_LAST_NAME
        //       ));
             // result.//add// (cursor.getString(cursor.getColumnIndex(EMPLOYEES_COL_FIRST_NAME)) +
              employeeList.add(cursor.getString(cursor.getColumnIndex(EMPLOYEES_COL_FIRST_NAME)) +
              " " + cursor.getString(cursor.getColumnIndex(EMPLOYEES_COL_LAST_NAME)));
              cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return employeeList;
    }
}

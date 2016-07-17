package com.example.davidstone.myjoinsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mAddDataButton;
    EditText mEmplSsnEditText;
    EditText mFirstNameEditText;
    EditText mLastNameEditText;
    EditText mYobEditText;
    EditText mCityEditText;

    EditText mJobsSsn;
    EditText mCompany;
    EditText mSalary;
    EditText mExperience;

    Button mGetCompanyJoins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mAddDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emplssn = mEmplSsnEditText.getText().toString();
                String firstName = mFirstNameEditText.getText().toString();
                String lastName = mLastNameEditText.getText().toString();
                String yob = mYobEditText.getText().toString();
                String city = mCityEditText.getText().toString();

                String jobsssn = mJobsSsn.getText().toString();
                String company = mCompany.getText().toString();
                String salary = mSalary.getText().toString();
                String experience = mExperience.getText().toString();

                JoinsAppSQLiteOpenHelper.getInstance(MainActivity.this).insertRowEmployee
                        (emplssn, firstName, lastName,
                        yob, city);

                JoinsAppSQLiteOpenHelper.getInstance(MainActivity.this).insertRowJob
                        (jobsssn, company, salary, experience);

                Toast.makeText(MainActivity.this, "Employee Added, I think", Toast.LENGTH_SHORT).show();
            }
        });

        mGetCompanyJoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JoinsAppSQLiteOpenHelper.getInstance(MainActivity.this).
                        getCompanyJoins();

                Toast.makeText(MainActivity.this, "Company Joins Were Gotten, I think", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

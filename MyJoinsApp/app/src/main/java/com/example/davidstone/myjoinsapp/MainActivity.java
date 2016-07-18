package com.example.davidstone.myjoinsapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   // private List<EditText> employeeData;


    EditText mEmplSSNEditText;
    EditText mFirstNameEditText;
    EditText mLastNameEditText;
    EditText mYobEditText;
    EditText mCityEditText;

    EditText mJobsSSN;
    EditText mCompany;
    EditText mSalary;
    EditText mExperience;

    private Button AddDataButton;
    private Button GetCompanyJoinsButton;
    private Button BostonCompany;
    private Button HighestSalary;

    private ListView two_or_more_listsview;
    private TextView salaryTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        two_or_more_listsview = (ListView) findViewById(R.id.two_or_more_listview);
        salaryTextView = (TextView) findViewById(R.id.salaryTextview);
        AddDataButton = (Button) findViewById(R.id.addDataButton);
        GetCompanyJoinsButton = (Button) findViewById(R.id.sameCompanyButton);
        BostonCompany = (Button) findViewById(R.id.companyCityButton);
        HighestSalary = (Button) findViewById(R.id.salaryButton);




      //  employeeData = new ArrayList<>();
      //  employeeData.add((EditText) findViewById(R.id.));
      //  employeeData.add((EditText) findViewById(R.id.noun2));
      //  employeeData.add((EditText) findViewById(R.id.adjective1));
      //  employeeData.add((EditText) findViewById(R.id.adjective2));
      //  employeeData.add((EditText) findViewById(R.id.animals));
      //  employeeData.add((EditText) findViewById(R.id.name));

        JoinsAppSQLiteOpenHelper helper = JoinsAppSQLiteOpenHelper.
                getInstance(MainActivity.this);

        Employees employee = new Employees("123-04-5678","John", "Smith", "1973", "NY");
        Employees employee1 = new Employees("123-04-5679","David", "McWill", "1982", "Seattle");
        Employees employee2 = new Employees("123-04-5680","Katerina", "Wise", "1973", "Boston");
        Employees employee3 = new Employees("123-04-5681","Donald", "Lee", "1992", "London");
        Employees employee4 = new Employees("123-04-5682","Gary", "Henwood", "1987", "Las Vegas");
        Employees employee5 = new Employees("123-04-5683","Anthony", "Bright", "1963", "Seattle");
        Employees employee6 = new Employees("123-04-5684","William", "Newey", "1995", "Boston");
        Employees employee7 = new Employees("123-04-5685","Melony", "Smith", "1970", "Chicago");

        Jobs job = new Jobs("123-04-5678", "Fuzz", "60", "1");
        Jobs job1 = new Jobs("123-04-5679", "GA", "70", "2");
        Jobs job2 = new Jobs("123-04-5680", "Little Place", "120", "5");
        Jobs job3 = new Jobs("123-04-5681", "Macy's", "78", "3");
        Jobs job4 = new Jobs("123-04-5682", "New Life", "65", "1");
        Jobs job5 = new Jobs("123-04-5683", "Believe", "158", "6");
        Jobs job6 = new Jobs("123-04-5684", "Macy's", "200", "8");
        Jobs job7 = new Jobs("123-04-5685", "Stop", "299", "12");

    //    mEmplSSNEditText = findViewById(R.id.)

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                EditText emplSSN = mEmplSSNEditText;
                emplSSN.setHint("SSN");
                EditText firstName = mFirstNameEditText;
                firstName.setHint("First NAme");
                EditText lastName = mLastNameEditText;
                lastName.setHint("Last NAme");
                EditText yob = mYobEditText;
                yob.setHint("Birth Year");
                EditText city = mCityEditText;
                city.setHint("Your City");

                LinearLayout layout = new LinearLayout(MainActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.addView(emplSSN);
                layout.addView(firstName);
                layout.addView(lastName);
                layout.addView(yob);
                layout.addView(city);

                builder.setTitle("Joins Lab");
                builder.setView(layout);
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setPositiveButton("Add Your Data", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

            }
        });
//

        AddDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emplSSN = mEmplSSNEditText.getText().toString();
                String firstName = mFirstNameEditText.getText().toString();
                String lastName = mLastNameEditText.getText().toString();
                String yob = mYobEditText.getText().toString();
                String city = mCityEditText.getText().toString();

                String jobsSSN = mJobsSSN.getText().toString();
                String company = mCompany.getText().toString();
                String salary = mSalary.getText().toString();
                String experience = mExperience.getText().toString();

                JoinsAppSQLiteOpenHelper.getInstance(MainActivity.this).insertRowEmployee
                        (emplSSN, firstName, lastName,
                        yob, city);

                JoinsAppSQLiteOpenHelper.getInstance(MainActivity.this).insertRowJob
                        (jobsSSN, company, salary, experience);

                Toast.makeText(MainActivity.this, "Employees Added, I think",
                        Toast.LENGTH_SHORT).show();
            }
        });


        GetCompanyJoinsButton.setOnClickListener(new View.OnClickListener() {
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

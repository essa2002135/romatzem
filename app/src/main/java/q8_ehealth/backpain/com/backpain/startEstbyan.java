package q8_ehealth.backpain.com.backpain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class startEstbyan extends AppCompatActivity {


    Spinner sp1;
    Spinner sp2;
    Spinner sp3;
    Spinner sp4;
    Intent gotNext;

    ArrayList<String> itemsAddedage = new ArrayList<String>();
    ArrayList<String> itemsAddedNationality = new ArrayList<String>();

    ArrayList<String> itemsAddedgendar = new ArrayList<String>();

    ArrayList<String> itemsAddededucation = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_estbyan);
        itemsAddedage.add("السن");



        itemsAddedNationality.add("الجنسية");
        itemsAddedNationality.add("كويتي");
        itemsAddedNationality.add("غير كويتي");



        itemsAddedgendar.add("الجنس");

        itemsAddedgendar.add("ذكر");
        itemsAddedgendar.add("أنثى");


        itemsAddededucation.add("التعليم");

        itemsAddededucation.add("ابتدائي");
        itemsAddededucation.add("متوسط");
        itemsAddededucation.add("ثانوي");
        itemsAddededucation.add("جامعي");


        for(int i=6;i<=100;i++)
        {


            String covertToString = Integer.toString(i);
            itemsAddedage.add(covertToString);

        }







        sp1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.custom_spinner, itemsAddedage);
        adapter.setDropDownViewResource(R.layout.custom_spinner);

        sp1.setAdapter(adapter);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.i("getPostion","yes"+position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        sp2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                R.layout.custom_spinner, itemsAddedNationality);
        adapter2.setDropDownViewResource(R.layout.custom_spinner);

        sp2.setAdapter(adapter2);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.i("getPostion","yes"+position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        sp3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                R.layout.custom_spinner, itemsAddedgendar);
        adapter2.setDropDownViewResource(R.layout.custom_spinner);

        sp3.setAdapter(adapter3);

        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.i("getPostion","yes"+position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        sp4 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
                R.layout.custom_spinner, itemsAddededucation);
        adapter4.setDropDownViewResource(R.layout.custom_spinner);

        sp4.setAdapter(adapter4);

        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.i("getPostion","yes"+position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void submitbt(View v)
    {
        gotNext = new Intent(getBaseContext(),qustion_estbyan.class);
        //  theId = "1";
        // gotNext.putExtra("TheType", theId);
        startActivity(gotNext);
    }

    }


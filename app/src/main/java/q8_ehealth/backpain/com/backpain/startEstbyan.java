package q8_ehealth.backpain.com.backpain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class startEstbyan extends AppCompatActivity {


    Spinner sp1;
    Spinner sp2;
    Spinner sp3;
    Spinner sp4;

    ArrayList<String> itemsAdded = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_estbyan);
        itemsAdded.add("mahmoud");
        itemsAdded.add("admed");

        sp1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, itemsAdded);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);


    }

    }


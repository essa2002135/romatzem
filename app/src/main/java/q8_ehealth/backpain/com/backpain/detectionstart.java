package q8_ehealth.backpain.com.backpain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class detectionstart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detectionstart);
    }


    public void gotoQustion(View v)
    {

        finish();
        Intent gotNext;
        String theId;

        gotNext = new Intent(getBaseContext(),detection.class);
        theId = "5";
        gotNext.putExtra("TheType", theId);
        startActivity(gotNext);
    }
}

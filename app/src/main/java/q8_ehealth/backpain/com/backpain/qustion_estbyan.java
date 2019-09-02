package q8_ehealth.backpain.com.backpain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class qustion_estbyan extends AppCompatActivity {
    Intent gotNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qustion_estbyan);
    }

    public void submitbt(View v)
    {
        gotNext = new Intent(getBaseContext(),result_esbyan.class);
      //  theId = "1";
       // gotNext.putExtra("TheType", theId);
        startActivity(gotNext);
    }
}

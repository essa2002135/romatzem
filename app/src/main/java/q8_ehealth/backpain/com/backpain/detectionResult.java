package q8_ehealth.backpain.com.backpain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class detectionResult extends AppCompatActivity {



    TextView comment1Text;
    TextView comment2Text;
    Integer state1;
    Integer state2;
    Integer state3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection_result);

        comment1Text = (TextView) findViewById(R.id.comment1);
        comment2Text = (TextView) findViewById(R.id.comment2);
        state1 = 0;
        state2 = 0;
        state3 = 0;

        Log.i("this Array length",detection.intArray.length+"");



        if (detection.intArray[0] == 1)
        {
            state1 +=1;
        }
        if (detection.intArray[0] == 2)
        {
            state2 +=1;
        }


        if (detection.intArray[1] == 1)
        {
            state1 +=1;
        }
        if (detection.intArray[1] == 2)
        {
            state2 +=1;
        }


        if (detection.intArray[2] == 1)
        {
            state1 +=1;
        }
        if (detection.intArray[2] == 2)
        {
            state2 +=1;
        }

        if (detection.intArray[3] == 1)
        {
            state1 +=1;
        }
        if (detection.intArray[3] == 2)
        {
            state2 +=1;
        }


        if (detection.intArray[4] == 1)
        {
            state1 +=1;
        }
        if (detection.intArray[4] == 2)
        {
            state2 +=1;
        }





        if (detection.intArray[5] == 1)
        {
            state1 +=1;
        }
        if (detection.intArray[5] == 2)
        {
            state2 +=1;
        }







    Log.i("red",String.valueOf(state1));
        Log.i("green",String.valueOf(state2));
        Log.i("blue",String.valueOf(state3));



        if (state2 ==0)
        {
            comment1Text.setText("تشير اجابتك إلى احتمالية اصابتك بالتهاب المفاصل الروماتزمي");
            comment2Text.setText("هذا التشخيص الاولي، وربما تكون هناك احتمالات أخرى، وهي لا تغني عن استشارة طبيبك، زيارة الطبيب المختص هو الطريق لتشخيص حالتك بدقة");

        }


        else if (state2 >=6)
        {
            comment1Text.setText("لا تشير اجابتك إلى احتمال إصابتك بالتهاب المفاصل الروماتزمي");
            comment2Text.setText("هذا تشخيص اولي وهو لايغني استشارة طبيبك في حالة وجود أي اعراض، زيارة الطبيب المختص هو الطريق لتشخيص حالتك بدقة");

        }

        else if (state2 >=4)
        {
            comment1Text.setText("تشير اجابتك إلى احتمالية اصابتك بالتهاب المفاصل الروماتزمي");
            comment2Text.setText("هذا التشخيص الاولي، وربما تكون هناك احتمالات أخرى، وهي لا تغني عن استشارة طبيبك، زيارة الطبيب المختص هو الطريق لتشخيص حالتك بدقة");
        }
        else
        {

            comment1Text.setText("لا تشير اجابتك إلى احتمال إصابتك بالتهاب المفاصل الروماتزمي");
            comment2Text.setText("هذا تشخيص اولي وهو لايغني استشارة طبيبك في حالة وجود أي اعراض، زيارة الطبيب المختص هو الطريق لتشخيص حالتك بدقة");

            //comment1Text.setText("إجاباتك لا تشير بوضوح إلى نوع آلام ظهرك، احرص على زيارة الطبيب المختص للكشف عن حالتك");
            //comment2Text.setText("");
        }

    }
}

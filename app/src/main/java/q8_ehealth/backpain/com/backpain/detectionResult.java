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
            state3 +=1;
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
            state2 +=1;
        }
        if (detection.intArray[5] == 2)
        {
            state1 +=1;
        }


        if (detection.intArray[6] == 1)
        {
            state2 +=1;
        }
        if (detection.intArray[6] == 2)
        {
            state1 +=1;
        }


        if (detection.intArray[7] == 1)
        {
            state1 +=1;
        }
        if (detection.intArray[7] == 2)
        {
            state3 +=1;
        }




    Log.i("red",String.valueOf(state1));
        Log.i("green",String.valueOf(state2));
        Log.i("blue",String.valueOf(state3));


        if (state1 >=5)
        {
            comment1Text.setText("تشير إجاباتك إلى احتمالية إصابتك بآلام الظهر الحركية.");
            comment2Text.setText("هذا التشخيص الأولي يساعدك على التعرف على حالتك من بين التشخيصات الأكثر شيوعا لآلام الظهر، وربما تكون هناك احتمالات أخرى، وهي لا تغني استشارة طبيبك، زيارة الطبيب المختص هو الطريق لتشخيص دقيق لحالتك.");

        }

        else if (state2 >=5)
        {
            comment1Text.setText("تشير إجاباتك إلى احتمالية إصابتك بآلام الظهر الالتهابية، قم بزيارة الطبيب المختص للكشف عن حالتك");
            comment2Text.setText("هذا التشخيص الأولي يساعدك على التعرف على حالتك من بين التشخيصات الأكثر شيوعا لآلام الظهر، وربما تكون هناك احتمالات أخرى، وهي لا تغني استشارة طبيبك، زيارة الطبيب المختص هو الطريق لتشخيص دقيق لحالتك.");
        }
        else
        {
            comment1Text.setText("إجاباتك لا تشير بوضوح إلى نوع آلام ظهرك، احرص على زيارة الطبيب المختص للكشف عن حالتك");
            comment2Text.setText("");
        }

    }
}

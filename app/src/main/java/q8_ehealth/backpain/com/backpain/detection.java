package q8_ehealth.backpain.com.backpain;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class detection extends AppCompatActivity {

ArrayList<String> quHeader;
ArrayList<String> answer1;
ArrayList<String> answer2;

    TextView numberText;
    TextView qheaderText;
    CheckBox anserText1;
    CheckBox anserText2;
    ImageView backButton;
    ImageView nextButton;
    ImageView sumbitImage;

    public static int[] intArray = new int[] {0,0,0,0,0,0,0,0};

    Integer counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection);

        quHeader = new ArrayList<String>();
        answer1 = new ArrayList<String>();
        answer2 = new ArrayList<String>();
        counter = 0;


        quHeader.add("هل عمرك أقل من 40 عاما؟");
        quHeader.add("هل تعرضت لأي إصابة أو حادث عرضي ؟");
        quHeader.add("هل تتحسن أعراض آلام ظهرك مع ممارسة التمارين الرياضية؟");
        quHeader.add("كيف هي سرعة تطور ألم ظهرك؟");

        quHeader.add("كيف تصبح الآلام مع الراحة؟");
        quHeader.add("هل تشعر بصعوبة التحرك صباحا عند الاستيقاظ من النوم لأكثر من 30 دقيقة (تيبس صباحي)؟");
        quHeader.add("هل تستيقظ غالبا في النصف الثاني من الليل بسبب شعورك بآلام ظهرك؟");
        quHeader.add("هل يمكنك أن تصف آلام ظهرك بأنها خافقة أو موجعة؟");
        answer1.add("نعم");
        answer2.add("لا");


        answer1.add("نعم");
        answer2.add("لا");


        answer1.add("نعم");
        answer2.add("لا");


        answer1.add("تتأزم حالة المرض بسرعة");
        answer2.add("تظهر آلام الظهر تدريجيا");

        answer1.add("تقل أعراض آلام الظهر مع الراحة");
        answer2.add("لا تقل أعراض آلام الظهر مع الراحة");

        answer1.add("نعم");
        answer2.add("لا");


        answer1.add("نعم");
        answer2.add("لا");


        answer1.add("نعم");
        answer2.add("لا");

        numberText = (TextView) findViewById(R.id.textView11);
        qheaderText = (TextView) findViewById(R.id.textView12);
        anserText1 = (CheckBox) findViewById(R.id.checkBox);
        anserText2 = (CheckBox) findViewById(R.id.checkBox2);
        backButton = (ImageView) findViewById(R.id.imageView15);

        nextButton = (ImageView) findViewById(R.id.imageView16);

        intArray = new int[] {0,0,0,0,0,0,0,0};

        backButton.setVisibility(View.INVISIBLE);

        anserText1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    intArray[counter] = 1;
                    Log.i("print","printCheck");
                    anserText2.setChecked(false);

                    // perform logic
                }

            }
        });

        anserText2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    intArray[counter] = 2;

                    Log.i("print","printCheck");
                    anserText1.setChecked(false);

                    // perform logic
                }

            }
        });

        qheaderText.setText(quHeader.get(0));
        anserText1.setText(answer1.get(0));
        anserText2.setText(answer2.get(0));

        numberText.setText("1/8");
    }



    public void nextQu(View v)
    {
        backButton.setVisibility(View.VISIBLE);

        counter += 1;
        Integer nextqu = counter + 1;
        numberText.setText(nextqu.toString()+"/8");

        if (counter == 7)
        {
            nextButton.setVisibility(View.INVISIBLE);


        }
        anserText1.setChecked(false);
        anserText2.setChecked(false);

        if (intArray[counter]  == 1)
        {
            anserText1.setChecked(true);

        }
        else if (intArray[counter]  == 2)
        {
            anserText2.setChecked(true);
        }


        qheaderText.setText(quHeader.get(counter));
        anserText1.setText(answer1.get(counter));
        anserText2.setText(answer2.get(counter));

    }

    public void backQu(View v)
    {
        nextButton.setVisibility(View.VISIBLE);

        counter -= 1;

        if (counter == 0)
        {
            backButton.setVisibility(View.INVISIBLE);

        }

        Integer nextqu = counter + 1;
        numberText.setText(nextqu.toString()+"/8");
        anserText1.setChecked(false);
        anserText2.setChecked(false);

        if (intArray[counter]  == 1)
        {
            anserText1.setChecked(true);
        }
        else if (intArray[counter]  == 2)
        {
            anserText2.setChecked(true);
        }


        qheaderText.setText(quHeader.get(counter));
        anserText1.setText(answer1.get(counter));
        anserText2.setText(answer2.get(counter));
    }

    public void submitbt(View v)
    {

        for(int i=0;i < intArray.length;i++)
        {

            if (intArray[i] == 0)
            {


                AlertDialog alertDialog = new AlertDialog.Builder(detection.this).create();
                alertDialog.setTitle("خطأ");
                alertDialog.setMessage("يجب الاجابة على كافة الأسئلة");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                return;
            }



        }

        Intent gotoNext = new Intent(this,detectionResult.class);
        finish();
        startActivity(gotoNext);
    }

}

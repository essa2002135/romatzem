package q8_ehealth.backpain.com.backpain;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class addApointment extends AppCompatActivity {
    //private Calendar mcalendar;

  //  private int ours,day,month,year;



    ArrayList<String> thedelay = new ArrayList<String>();



    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    EditText ed6;

    Button getTheDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apointment);


        getTheDate = (Button) findViewById(R.id.button10);

         ed1 = (EditText) findViewById(R.id.editText);
         ed2 = (EditText) findViewById(R.id.editText2);
         ed3 = (EditText) findViewById(R.id.editText3);
         ed4 = (EditText) findViewById(R.id.editText4);
         ed5 = (EditText) findViewById(R.id.editText5);
         ed6 = (EditText) findViewById(R.id.editText6);

        thedelay.add("بدون تذكير");

        thedelay.add("ساعتين");
        thedelay.add("24 ساعة");
        thedelay.add("اسبوع");



        Spinner sp1 = (Spinner) findViewById(R.id.spinner6);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.custom_spinner, thedelay);
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
        /*
          mcalendar = Calendar.getInstance();

        day= mcalendar.get(Calendar.DAY_OF_MONTH);
        year= mcalendar.get(Calendar.YEAR);
        month= mcalendar.get(Calendar.MONTH);
        ours= mcalendar.get(Calendar.HOUR);

        */




    }

    public void settime(View v)
    {
        final View dialogView = View.inflate(addApointment.this, R.layout.date_time_picker, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(addApointment.this).create();
        dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.date_picker);
                TimePicker timePicker = (TimePicker) dialogView.findViewById(R.id.time_picker);

                Calendar calendar = new GregorianCalendar(datePicker.getYear(),
                        datePicker.getMonth(),
                        datePicker.getDayOfMonth(),
                        timePicker.getCurrentHour(),
                        timePicker.getCurrentMinute());


                int getmonth = datePicker.getMonth()+1;
                //time = calendar.getTimeInMillis();
                getTheDate.setText(datePicker.getDayOfMonth()+"/"+getmonth+"/"+datePicker.getYear()+" & "+ timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute());
                alertDialog.dismiss();
            }});
        alertDialog.setView(dialogView);
        alertDialog.show();

      //  DateDialog();
    }



     public void saved(View v)
     {


         if (getTheDate.getText().toString().equals("الموعد") || ed1.getText().toString().equals("") || ed1.getText().toString().equals("") || ed1.getText().toString().equals("") || ed1.getText().toString().equals("") || ed1.getText().toString().equals("") || ed1.getText().toString().equals("") || ed1.getText().toString().equals(""))
             {
                 android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(addApointment.this).create();
                 alertDialog.setTitle("خطأ");
                 alertDialog.setMessage("الرجاء كتابة البيانات");
                 alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEUTRAL, "",
                         new DialogInterface.OnClickListener() {
                             public void onClick(DialogInterface dialog, int which) {
                                 dialog.dismiss();
                             }
                         });
                 alertDialog.show();

             }
         else {

             String ed1St = ed1.getText().toString();
             String ed2St = ed2.getText().toString();
             String ed3St = ed3.getText().toString();
             String ed4St = ed4.getText().toString();
             String ed5St = ed5.getText().toString();
             String ed6St = ed5.getText().toString();
             String ed7St = getTheDate.getText().toString();


             // listdoctorAppointment.mydatabase.execSQL("INSERT INTO appointment VALUES(ed1St,ed2St,ed3St,ed4St,ed5St,ed6St,'drappoint','dradaly');");
             listdoctorAppointment.mydatabase.execSQL("INSERT INTO appointment"
                     + " Values ('" + ed1St + "', '" + ed2St + "', '" + ed3St + "', '" + ed4St +"', '" + ed5St + "', '" + ed6St + "', '" + ed7St + "', '" + ed2St + "');");

             Toast.makeText(addApointment.this,"تم اضافة الموعد",Toast.LENGTH_LONG).show();
             finish();

         }

     }
    /*

    public void DateDialog(){
        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                //mdob_et.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                Log.i("this is Data",dayOfMonth + "/" + monthOfYear + "/" + year);
            }};
        DatePickerDialog dpDialog= new DatePickerDialog(addApointment.this, listener, year, month, day );
        dpDialog.show();

    }
    */


}

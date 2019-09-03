package q8_ehealth.backpain.com.backpain;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class listdoctorAppointment extends AppCompatActivity {

    public static SQLiteDatabase mydatabase;

    ArrayList<String> doctorName = new ArrayList<String>();
    ArrayList<String> place = new ArrayList<String>();
    ArrayList<String> time = new ArrayList<String>();
    ArrayList<String> resultList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdoctor_appointment);





        /// databse
        mydatabase = openOrCreateDatabase("Doctors",MODE_PRIVATE,null);

        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS appointment(drpalce VARCHAR,drname VARCHAR ,drtele VARCHAR ,drtele2 VARCHAR ,drtele3 VARCHAR ,dremail VARCHAR ,drappoint VARCHAR ,dradaly VARCHAR);");
       // mydatabase.execSQL("INSERT INTO appointment VALUES('drpalce','drname','drtele','drtele2','drtele3','dremail','drappoint','dradaly');");

        Cursor resultSet = mydatabase.rawQuery("Select * from appointment",null);
        // resultSet.moveToFirst();



        while (resultSet.moveToNext())
        {
            String date = resultSet.getString(resultSet.getColumnIndex("drname"));
            String date2 = resultSet.getString(resultSet.getColumnIndex("drpalce"));
            String date3 = resultSet.getString(resultSet.getColumnIndex("drappoint"));





            try
            {

                doctorName.add(date);
                place.add(date2);
                time.add(date3);

            }
            catch (Exception e) {
            }

        }


        for(int i = 0;i < resultList.size();i++)
        {
            Log.i("theis TheArray1",resultList.get(i));

        }




        ListView myListView = (ListView) findViewById(R.id.mydoctorlist) ;
        listdoctorAppointment.customAdabterPaper theCustomAdabter = new listdoctorAppointment.customAdabterPaper();
        myListView.setAdapter(theCustomAdabter);

    }

    public void gotoadd(View v)
    {
        Intent gotNext;
        String theId;

        gotNext = new Intent(getBaseContext(),addApointment.class);
        theId = "5";
        gotNext.putExtra("TheType", theId);
        startActivity(gotNext);

        finish();

    }

    class customAdabterPaper extends BaseAdapter
    {

        @Override
        public int getCount() {
            return doctorName.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public customAdabterPaper() {
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.custom_doctor_list,null);
            TextView myText = (TextView) view.findViewById(R.id.textView22);
            TextView myText2 = (TextView) view.findViewById(R.id.textView23);
            TextView myText3 = (TextView) view.findViewById(R.id.textView27);

            myText.setText(doctorName.get(position));
            myText2.setText(place.get(position));
            myText3.setText(time.get(position));

            // theDes.setMovementMethod(new ScrollingMovementMethod());



            //    String fileUrlImge = "http://rheumatism.q8-ehealth.com/uploads/files/"+theImage.get(position);
//            Picasso.get().load(fileUrlImge).into(theImageView);

            //theImage.setImageResource(theImges[position]);

//Picasso.with(Main3Activity.class).load("http://ahmedhalim.net/img/portfolio-1.jpg").into(theImage);
//            Picasso.with(context.)


            //  Picasso.get().load(theCoverNameListNew.get(position)).into(theImage);
            return view;
        }
    }


}

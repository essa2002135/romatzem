package q8_ehealth.backpain.com.backpain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class medicalsimportant extends AppCompatActivity {


    ArrayList<String> doctorName = new ArrayList<String>();
    ArrayList<String> place = new ArrayList<String>();
    ArrayList<String> time = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicalsimportant);

        doctorName.add("Mahmoud");
        doctorName.add("ahmed");
        doctorName.add("omar");
        doctorName.add("yehia");


        doctorName.add("Mahmoud");
        doctorName.add("ahmed");
        doctorName.add("omar");
        doctorName.add("yehia");

        ListView myListView = (ListView) findViewById(R.id.midacl) ;
        medicalsimportant.customAdabterPaper theCustomAdabter = new medicalsimportant.customAdabterPaper();
        myListView.setAdapter(theCustomAdabter);






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
            View view = getLayoutInflater().inflate(R.layout.custom_medical,null);
            TextView myText = (TextView) view.findViewById(R.id.textView22);
            myText.setText("محمود يحيى عيسى");

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

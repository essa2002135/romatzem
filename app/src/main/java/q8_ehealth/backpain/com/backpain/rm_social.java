package q8_ehealth.backpain.com.backpain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class rm_social extends AppCompatActivity {

    ArrayList<String> thetitle = new ArrayList<String>();
    ArrayList<String> image = new ArrayList<String>();
    ArrayList<String> thelink = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rm_social);
        thetitle.add("Mahmoud");
        thetitle.add("ahmed");
        thetitle.add("yehia");


        thetitle.add("Mahmoud");
        thetitle.add("ahmed");
        thetitle.add("omar");
        thetitle.add("yehia");




        ListView myListView = (ListView) findViewById(R.id.gehat) ;
        rm_social.customAdabterPaper theCustomAdabter = new rm_social.customAdabterPaper();
        myListView.setAdapter(theCustomAdabter);


    }

    class customAdabterPaper extends BaseAdapter
    {

        @Override
        public int getCount() {
            return thetitle.size();
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
            View view = getLayoutInflater().inflate(R.layout.custom_gehat,null);
            TextView myText = (TextView) view.findViewById(R.id.textView19);
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

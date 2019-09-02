package q8_ehealth.backpain.com.backpain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class result_esbyan extends AppCompatActivity {

    ArrayList<String> thetitle = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_esbyan);

        thetitle.add("السؤال الأول");
        thetitle.add("السؤال الأول");
        thetitle.add("السؤال الأول");
        thetitle.add("السؤال الأول");
        thetitle.add("السؤال الأول");
        thetitle.add("السؤال الأول");

        ListView myListView = (ListView) findViewById(R.id.resultlist) ;
        result_esbyan.customAdabterPaper theCustomAdabter = new result_esbyan.customAdabterPaper();
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
            View view = getLayoutInflater().inflate(R.layout.custom_esbyan_results,null);
            TextView myText = (TextView) view.findViewById(R.id.textView20);
            myText.setText(thetitle.get(position));

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

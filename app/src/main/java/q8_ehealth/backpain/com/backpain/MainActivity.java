package q8_ehealth.backpain.com.backpain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    Intent gotNext;

    Integer[] theImage = {R.drawable.rm1,R.drawable.rm2,R.drawable.rm3,R.drawable.rm4,R.drawable.rm5,R.drawable.medicalicon,R.drawable.rm7,R.drawable.rm8,R.drawable.rm9};

String theId;



    public void goFace(View v)
    {

        gotNext = new Intent(getBaseContext(),Sochial.class);
        theId = "1";
        gotNext.putExtra("TheType", theId);
        startActivity(gotNext);
    }

    public void goTwitter(View v)
    {
        gotNext = new Intent(getBaseContext(),Sochial.class);
        theId = "2";
        gotNext.putExtra("TheType", theId);
        startActivity(gotNext);
    }

    public void goYoutube(View v)
    {
        gotNext = new Intent(getBaseContext(),Sochial.class);
        theId = "3";
        gotNext.putExtra("TheType", theId);
        startActivity(gotNext);
    }
    public void goInsteagram(View v)
    {
        gotNext = new Intent(getBaseContext(),Sochial.class);
        theId = "4";
        gotNext.putExtra("TheType", theId);
        startActivity(gotNext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        CustomAdabterList customAdabterList = new CustomAdabterList();
        GridView mainItem = (GridView) findViewById(R.id.theGridView);

        mainItem.setAdapter(customAdabterList);

        mainItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                if (position == 0)
                {


                  //  gotNext = new Intent(getBaseContext(),theActivitySlider.class);
                  //  theId = "2";
                  //  gotNext.putExtra("TheType", theId);
                   // startActivity(gotNext);

                    gotNext = new Intent(getBaseContext(),rm_what_i_knew.class);
                    theId = "4";
                    gotNext.putExtra("TheType", theId);
                    startActivity(gotNext);

                }

                else if (position == 1)
                {
                    //gotNext = new Intent(getBaseContext(),video.class);
                    //theId = "1";
                    //gotNext.putExtra("TheType", theId);
                    //startActivity(gotNext);

                    gotNext = new Intent(getBaseContext(),detectionstart.class);
                    theId = "5";
                    gotNext.putExtra("TheType", theId);
                    startActivity(gotNext);

                }
                else if (position == 2)
                {


                   gotNext = new Intent(getBaseContext(),startEstbyan.class);
                      //theId = "5";
                      //gotNext.putExtra("TheType", theId);
                  startActivity(gotNext);

                   // gotNext = new Intent(getBaseContext(),video.class);
                 //   theId = "5";
                  //  gotNext.putExtra("TheType", theId);
                  //  startActivity(gotNext);



                }
                else if (position == 3)
                {
                    //gotNext = new Intent(getBaseContext(),papaer.class);
                   // theId = "4";
                   // gotNext.putExtra("TheType", theId);
                  //  startActivity(gotNext);


                    gotNext = new Intent(getBaseContext(),listdoctorAppointment.class);
                   // theId = "4";
                   // gotNext.putExtra("TheType", theId);
                    startActivity(gotNext);


                }
                else if (position == 4)
                {

                    // Moviee
                  //  gotNext = new Intent(getBaseContext(),medicalsimportant.class);
                  //  theId = "3";
                 //   gotNext.putExtra("TheType", theId);
                   // startActivity(gotNext);



                }
                else if (position == 5)
                {
                   // gotNext = new Intent(getBaseContext(),detection.class);
                  //  theId = "5";
                   // gotNext.putExtra("TheType", theId);
                   // startActivity(gotNext);

                    gotNext = new Intent(getBaseContext(),medicalsimportant.class);
                    theId = "3";
                    gotNext.putExtra("TheType", theId);
                    startActivity(gotNext);

                }

                else if (position == 6)
                {
                    // gotNext = new Intent(getBaseContext(),detection.class);
                    //  theId = "5";
                    // gotNext.putExtra("TheType", theId);
                    // startActivity(gotNext);

                      gotNext = new Intent(getBaseContext(),theActivitySlider.class);
                    theId = "2";
                      gotNext.putExtra("TheType", theId);
                   startActivity(gotNext);

                }


                else if (position == 7)
                {
                    // gotNext = new Intent(getBaseContext(),detection.class);
                    //  theId = "5";
                    // gotNext.putExtra("TheType", theId);
                    // startActivity(gotNext);

                    gotNext = new Intent(getBaseContext(),theHospital.class);
                    //theId = "2";
                    //gotNext.putExtra("TheType", theId);
                    startActivity(gotNext);

                }
                else if (position == 8)
                {
                    // gotNext = new Intent(getBaseContext(),detection.class);
                    //  theId = "5";
                    // gotNext.putExtra("TheType", theId);
                    // startActivity(gotNext);

                    gotNext = new Intent(getBaseContext(),rm_social.class);
                    //theId = "2";
                    //gotNext.putExtra("TheType", theId);
                    startActivity(gotNext);

                }

            }
        });




    }



    class CustomAdabterList extends BaseAdapter
    {

        @Override
        public int getCount() {
            return theImage.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.custom_main_layout,null);
            ImageView theMnuew = (ImageView) view.findViewById(R.id.imageView3);

            theMnuew.setImageResource(theImage[position]);


//            theWebView.getSettings().setJavaScriptEnabled(true);
          //  theWebView.setWebViewClient(new WebViewClient());
          //  theWebView.loadUrl("https://www.facebook.com/");



//Picasso.with(Main3Activity.class).load("http://ahmedhalim.net/img/portfolio-1.jpg").into(theImage);
//            Picasso.with(context.)
            //  theMnuew.setImageResource(theImage[position]);


            return view;
        }
    }



}



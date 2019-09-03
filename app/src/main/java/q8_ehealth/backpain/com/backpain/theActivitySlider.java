package q8_ehealth.backpain.com.backpain;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class theActivitySlider extends AppCompatActivity {


    ViewDialog viewDialog;

    private RequestQueue req;

    ListView myListView;
    ArrayList<String> theattachVideo = new ArrayList<String>();
    ArrayList<String> thetitle = new ArrayList<String>();
    ArrayList<String> thetDes = new ArrayList<String>();
    ArrayList<String> theImage = new ArrayList<String>();
    ArrayList<String> theDate = new ArrayList<String>();
    ArrayList<String> theFile = new ArrayList<String>();
    ArrayList<String> theDate2 = new ArrayList<String>();
    ArrayList<String> mainId = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_slider);
        viewDialog = new ViewDialog(this);

        req = Volley.newRequestQueue(this);
           // ImageView titleacA = (ImageView) findViewById(R.id.titleac);
       // titleacA.setImageResource(R.drawable.acttivtyand);


                TextView myText = (TextView) findViewById(R.id.textView16);

        String TheTypee = getIntent().getStringExtra("TheType");


        viewDialog.showDialog();


        jasonParse(TheTypee);
    }







    private void jasonParse(String TheTypeID)
    {

        String url = "http://backpain.q8-ehealth.com/ServicesHandler.ashx?fun=GetItems&TypeID="+TheTypeID;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                Log.i("ALlItem",response+"");


                for(int i = 0;i<response.length();i++)
                {
                    try {
                        JSONObject allContent = response.getJSONObject(i);
                        String Title = allContent.getString("Title");
                        Log.i("this is FrstName",Title);


                        thetitle.add(allContent.getString("Title"));
                        thetDes.add(allContent.getString("Des"));
                        theattachVideo.add(allContent.getString("Youtube"));
                        theImage.add(allContent.getString("Thumbs"));
                        theDate.add(allContent.getString("Date"));
                        mainId.add(allContent.getString("ID"));
                        theDate2.add(allContent.getString("Date2"));
                        theFile.add(allContent.getString("File"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                myListView = (ListView) findViewById(R.id.theListViewActivity) ;
                customAdabterActivity theCustomAdabter = new customAdabterActivity();
                myListView.setAdapter(theCustomAdabter);
                viewDialog.hideDialog();
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        String allDate = "من"+theDate.get(position)+"الى"+theDate2.get(position);
                        String titleMove =  thetitle.get(position);
                        String theDesMove = thetDes.get(position);
                        String theYoutubeMove = theattachVideo.get(position);

                        Intent gotNext = new Intent(getBaseContext(),showSlider.class);
                        String theId = mainId.get(position);
                        gotNext.putExtra("TheType", theId);
                        gotNext.putExtra("allDate", allDate);
                        gotNext.putExtra("titleMove", titleMove);
                        gotNext.putExtra("theDesMove", theDesMove);
                        gotNext.putExtra("theYoutubeMove", theYoutubeMove);

                        startActivity(gotNext);



                    }
                });

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        }

        );


        req.add(jsonArrayRequest);
    }





    class customAdabterActivity extends BaseAdapter {

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

        public customAdabterActivity() {
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.cutom_activty_play, null);
            TextView myText = (TextView) view.findViewById(R.id.textView7);
            TextView theDateText = (TextView) view.findViewById(R.id.textView8);
            TextView theDes = (TextView) view.findViewById(R.id.textView9);

            ImageView theImageView = (ImageView) view.findViewById(R.id.imageView13);

            myText.setText(thetitle.get(position));
            String allDate = "من"+theDate.get(position)+"الى"+theDate2.get(position);
            theDateText.setText(allDate);

            theDes.setText(thetDes.get(position));
            // theDes.setMovementMethod(new ScrollingMovementMethod());


            String fileUrlImge = "http://backpain.q8-ehealth.com/uploads/files/" + theImage.get(position);
            Picasso.get().load(fileUrlImge).into(theImageView);

            //theImage.setImageResource(theImges[position]);

//Picasso.with(Main3Activity.class).load("http://ahmedhalim.net/img/portfolio-1.jpg").into(theImage);
//            Picasso.with(context.)


            //  Picasso.get().load(theCoverNameListNew.get(position)).into(theImage);
            return view;
        }
    }
}

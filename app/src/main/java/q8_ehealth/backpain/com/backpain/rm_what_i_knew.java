package q8_ehealth.backpain.com.backpain;

import android.content.ActivityNotFoundException;
import android.content.Context;
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

public class rm_what_i_knew extends AppCompatActivity {


    ViewDialog viewDialog;


    private RequestQueue req;

    ListView myListView;
    public Context context;

    ArrayList<String> theattachVideo = new ArrayList<String>();
    ArrayList<String> thetitle = new ArrayList<String>();
    ArrayList<String> thetDes = new ArrayList<String>();
    ArrayList<String> theImage = new ArrayList<String>();
    ArrayList<String> theDate = new ArrayList<String>();
    ArrayList<String> theFile = new ArrayList<String>();

    Intent myIntent;
    String theId;
    String TheTypee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rm_what_i_knew);
        req = Volley.newRequestQueue(this);
        viewDialog = new ViewDialog(this);




        TheTypee = getIntent().getStringExtra("TheType");

        showCustomLoadingDialog();

        jasonParse(TheTypee);

    }


    private void jasonParse(String TheTypeID)
    {

        String url = "http://rheumatism.q8-ehealth.com/ServicesHandler.ashx?fun=GetItems&TypeID="+TheTypeID;

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
                        theFile.add(allContent.getString("File"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                myListView = (ListView) findViewById(R.id.theListViewPaper) ;
                rm_what_i_knew.customAdabterPaper theCustomAdabter = new rm_what_i_knew.customAdabterPaper();
                myListView.setAdapter(theCustomAdabter);
                viewDialog.hideDialog();
                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Log.i("new","the id is"+theId);


                        String thePdfName = theFile.get(position);


                        String urlFile = "http://rheumatism.q8-ehealth.com/uploads/files/"+thePdfName;

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.parse(urlFile), "application/pdf");
                        try{
                            view.getContext().startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            //user does not have a pdf viewer installed
                        }


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
            View view = getLayoutInflater().inflate(R.layout.custom_waht_i_knew,null);
            TextView myText = (TextView) view.findViewById(R.id.textView14);
            ImageView theImageView = (ImageView) view.findViewById(R.id.imageView11);
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

    public void showCustomLoadingDialog() {
        //..show gif and hide after 5 seconds

        viewDialog.showDialog();

        /*
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewDialog.hideDialog();
            }
        }, 7000);
        */
    }


}

package q8_ehealth.backpain.com.backpain;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class video extends AppCompatActivity {

    private RequestQueue req;

    ListView myListView;
    public Context context;

        public WebView theWebViewn;

    ViewDialog viewDialog;

    ArrayList<String> theattachVideo = new ArrayList<String>();
    ArrayList<String> thetitle = new ArrayList<String>();
    ArrayList<String> thetDes = new ArrayList<String>();

    Intent myIntent;
    String theId;
    String TheTypee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        viewDialog = new ViewDialog(this);


        req = Volley.newRequestQueue(this);



        TheTypee = getIntent().getStringExtra("TheType");


        ImageView theImageTitle = (ImageView) findViewById(R.id.imageView9);
        if (TheTypee.equals("1"))
        {
            theImageTitle.setImageResource(R.drawable.namefilm);
        }
        else
        {
            theImageTitle.setImageResource(R.drawable.advice);

        }
        jasonParse(TheTypee);

        // task.execute("http://backpain.q8-ehealth.com/ServicesHandler.ashx?fun=GetItems&TypeID=1");

//        customAdabter listcustomAdabter = new customAdabter();
//        ListView mainItem = (ListView) findViewById(R.id.theListView);
//        mainItem.setAdapter(listcustomAdabter);

        viewDialog.showDialog();


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
                        theattachVideo.add(allContent.getString("File"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                myListView = (ListView) findViewById(R.id.theListView) ;
                customAdabter theCustomAdabter = new customAdabter();

                viewDialog.hideDialog();
                myListView.setAdapter(theCustomAdabter);

                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Log.i("new","the id is"+theId);


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




class customAdabter extends BaseAdapter
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

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.custom_video,null);
            TextView myText = (TextView) view.findViewById(R.id.textView2);
            TextView theDes = (TextView) view.findViewById(R.id.textView3);

            myText.setText(thetitle.get(position));
            theDes.setText(thetDes.get(position));

            //theImage.setImageResource(theImges[position]);

//Picasso.with(Main3Activity.class).load("http://ahmedhalim.net/img/portfolio-1.jpg").into(theImage);
//            Picasso.with(context.)


            theWebViewn = (WebView) view.findViewById(R.id.mynewwebview);
            //theWebViewn.setVisibility(View.INVISIBLE);
            theWebViewn.getSettings().setJavaScriptEnabled(true);
            theWebViewn.setWebViewClient(new WebViewClient());

            // for youtube
           // theWebViewn.loadUrl("https://www.youtube.com/embed/"+theattachVideo.get(position));

            theWebViewn.loadUrl("http://backpain.q8-ehealth.com/uploads/files/"+theattachVideo.get(position));

            //  Picasso.get().load(theCoverNameListNew.get(position)).into(theImage);
            return view;
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        theWebViewn.onPause();//if it's not webview in your case then add the method name you want pause when user device is pause
    }



}

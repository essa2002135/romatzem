package q8_ehealth.backpain.com.backpain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class showSlider extends AppCompatActivity {
    private RequestQueue req;
    SliderLayout sliderLayout;

    TextView titleAc;
    TextView theDateT;
    TextView theDesT;

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
        setContentView(R.layout.activity_show_slider);
        req = Volley.newRequestQueue(this);

        String TheTypee = getIntent().getStringExtra("TheType");
        String allDate = getIntent().getStringExtra("allDate");
        String titleMove = getIntent().getStringExtra("titleMove");
        String theDesMove = getIntent().getStringExtra("theDesMove");
        String theYoutubeMove = getIntent().getStringExtra("theYoutubeMove");

        titleAc = (TextView) findViewById(R.id.textView10);
        theDateT = (TextView) findViewById(R.id.textView13);
        theDesT = (TextView) findViewById(R.id.textView15);



        titleAc.setText(titleMove);
        theDateT.setText(allDate);
        theDesT.setText(theDesMove);


        WebView theWebViewn = (WebView) findViewById(R.id.theVideRun);
        //theWebViewn.setVisibility(View.INVISIBLE);
        theWebViewn.getSettings().setJavaScriptEnabled(true);
        theWebViewn.setWebViewClient(new WebViewClient());
        theWebViewn.loadUrl("https://www.youtube.com/embed/"+theYoutubeMove);



        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :


        jasonParse(TheTypee);
    }




    private void jasonParse(String TheTypeID)
    {

        String url = "http://backpain.q8-ehealth.com/ServicesHandler.ashx?fun=GetGal&TypeID="+TheTypeID;

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
                        SliderView sliderView = new SliderView(getApplicationContext());


                        thetitle.add(allContent.getString("Title"));
                        thetDes.add(allContent.getString("Des"));
                        theImage.add(allContent.getString("Thumbs"));
                        mainId.add(allContent.getString("ID"));
                        String fileUrlImge = "http://backpain.q8-ehealth.com/Uploads/productGallery/" + allContent.getString("Thumbs");
                        Log.i("theLink is",fileUrlImge);
                        sliderView.setImageUrl(fileUrlImge);
                        sliderLayout.addSliderView(sliderView);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }





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
}

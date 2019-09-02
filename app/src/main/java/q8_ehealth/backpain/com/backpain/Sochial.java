package q8_ehealth.backpain.com.backpain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Sochial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sochial);

        WebView theWebViewn = (WebView) findViewById(R.id.soWebview);
        //theWebViewn.setVisibility(View.INVISIBLE);
        theWebViewn.getSettings().setJavaScriptEnabled(true);
        theWebViewn.setWebViewClient(new WebViewClient());
        String TheTypee = getIntent().getStringExtra("TheType");

        if (TheTypee.equals("1"))
        {
            theWebViewn.loadUrl("https://www.facebook.com/%D8%A7%D9%84%D9%85%D9%83%D8%AA%D8%A8-%D8%A7%D9%84%D8%A5%D8%B9%D9%84%D8%A7%D9%85%D9%8A-%D8%A8%D9%88%D8%B2%D8%A7%D8%B1%D8%A9-%D8%A7%D9%84%D8%B5%D8%AD%D8%A9-429542117224115/");

        }
       else if (TheTypee.equals("2"))
        {

            theWebViewn.loadUrl("https://twitter.com/moh_media?lang=en");
        }
        else if (TheTypee.equals("3"))
        {
            theWebViewn.loadUrl("https://www.youtube.com/channel/UCYkrIY0nlH7thRiIvBvcaBQ");

        }
        else if (TheTypee.equals("4"))
        {
            theWebViewn.loadUrl("https://www.instagram.com/moh_media_office/");
        }
    }
}

package q8_ehealth.backpain.com.backpain;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class showPdf extends AppCompatActivity {


    public showPdf() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pdf);

        String filePdfName = getIntent().getStringExtra("fileNamePdf");
        String urlFile = "http://backpain.q8-ehealth.com/uploads/files/"+filePdfName;



        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        File pdffile = new File(Environment.getExternalStorageDirectory(),urlFile);


        Uri myUri = Uri.parse(urlFile);


        Log.i("open Pdf",urlFile);
        pdfView.fromUri(myUri);

    }




}

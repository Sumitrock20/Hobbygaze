package com.hobbygaze.maverick.hobbygaze.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hobbygaze.maverick.hobbygaze.R;


/**
 * Created by abhishek on 11/25/15.
 */
public class BlogPostsActivity extends AppCompatActivity {
    private static final String TAG_CONTENT = "content";
    WebView ourBrow;
    public class ourViewClient extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView v, String url) {
            v.loadUrl(url);
            return true;

        }

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      //  getSupportActionBar().setHomeAsUpIndicator(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        getSupportActionBar().setTitle(" ");


        ourBrow = (WebView) findViewById(R.id.web);
        //ourBrow.getSettings().setJavaScriptEnabled(true);
        // ourBrow.getSettings().setLoadWithOverviewMode(true);
        //ourBrow.getSettings().setUseWideViewPort(true);
        // getting intent data
        Intent in = getIntent();

        // Get JSON values from previous intent
        String content = in.getStringExtra(TAG_CONTENT);
       // System.out.println(content);

        // Displaying all values on the screen
        // TextView lblurl = (TextView) findViewById(R.id.url_label);
        // TextView lblbook_title = (TextView) findViewById(R.id.book_title_label);
        // TextView lblbook_author = (TextView) findViewById(R.id.book_author_label);

        // lblurl.setText(url);
        //lblbook_title.setText(book_title);
        //lblbook_author.setText(book_author);
        // ourBrow.setWebViewClient(new ourViewClient());
        try {
            // ourBrow.loadUrl(content);


            content=content.replaceAll("&#8217;","'");
            content=content.replaceAll("&#8217;","'");
            content=content.replaceAll("'","/'");


           // byte[] data = content.getBytes("UTF-8");
            //String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            this.ourBrow.getSettings().setLoadWithOverviewMode(true);
            this.ourBrow.getSettings().setUseWideViewPort(true);

            this.ourBrow.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
            this.ourBrow.setScrollbarFadingEnabled(false);
            this.ourBrow.setVerticalScrollBarEnabled(true);
            this.ourBrow.setHorizontalScrollBarEnabled(true);

            this.ourBrow.getSettings().setSupportZoom(true);
            this.ourBrow.getSettings().setLightTouchEnabled(true);

            this.ourBrow.getSettings().setBuiltInZoomControls(true);
            this.ourBrow.getSettings().setDisplayZoomControls(false);

            ourBrow.loadData("<html><bodyonload=\"initialize()\" style=\"margin:0px; padding:0px; width:100%; height:100%\">"+ content +"</body></html>",
                    "text/html; charset=UTF-8", null);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }




}

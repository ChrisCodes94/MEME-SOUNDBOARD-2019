package com.mysterySoundBoard.chris.soundboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mysound1;
    MediaPlayer mysound2;
    MediaPlayer mysound3;
    MediaPlayer mysound4;
    MediaPlayer mysound5;
    MediaPlayer mysound6;
    MediaPlayer mysound7;
    MediaPlayer mysound8;
    MediaPlayer mysound9;
    MediaPlayer mysound10;

    

    private ImageView nextPageButton;
    private ImageView shareButton;
    private ImageView muteVolumeBtn;
    public  static boolean isMute;
    private AudioManager amanager;

    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        isMute = false;
        //interstitial Ad
        prepareAd();

        ScheduledExecutorService schedule =
                Executors.newSingleThreadScheduledExecutor();
        schedule.scheduleAtFixedRate(new Runnable() {
            public void run(){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //prepareAd();
                        if(interstitialAd.isLoaded()){
                            interstitialAd.show();
                        }else
                        {
                            Log.d("TAG","Interstitial Not Showing");
                        }
                        prepareAd();
                    }
                });
            }
        },30,120,TimeUnit.SECONDS);

        //initialize sound variables
        mysound1= MediaPlayer.create(this, R.raw.animals);
        mysound2= MediaPlayer.create(this, R.raw.crawl);
        mysound3= MediaPlayer.create(this, R.raw.dooe);
        mysound4= MediaPlayer.create(this, R.raw.ignore);
        mysound5= MediaPlayer.create(this, R.raw.mete);
        mysound6= MediaPlayer.create(this, R.raw.pussy);
        mysound7= MediaPlayer.create(this, R.raw.runvine);
        mysound8= MediaPlayer.create(this, R.raw.smmar);
        mysound9= MediaPlayer.create(this, R.raw.sure);
        mysound10= MediaPlayer.create(this, R.raw.what);



       amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        CoordinatorLayout coordinatorLayout = findViewById(R.id.mainLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable)coordinatorLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        shareButton = findViewById(R.id.shareButton);
        nextPageButton = findViewById(R.id.nextButton_1);
        muteVolumeBtn = findViewById(R.id.muteButton);


        muteVolumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isMute == false){
                    muteAudio(amanager);
                    isMute = true;
                }else {
                    unmuteAudio(amanager);
                    isMute = false;
                }
            }
        });
        //initialize button variables
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "100% Completely Free Meme SoundBoard \n https://play.google.com/store/apps/details?id=com.SoundBoardFree.chris.soundboard";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "You have to check out this awesome app!");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });
        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage2();
                finish();
            }
        });
        // Load an ad into the AdMob banner view.
        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

    }


    public void openPage2()
    {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void muteAudio(AudioManager amanager){
        //mute audio
        amanager =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
        amanager.setStreamMute(AudioManager.STREAM_ALARM, true);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
        amanager.setStreamMute(AudioManager.STREAM_RING, true);
        amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
        Toast.makeText(MainActivity.this,"Muted",Toast.LENGTH_SHORT).show();

    }

    private void unmuteAudio(AudioManager amanager){
        amanager =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
        amanager.setStreamMute(AudioManager.STREAM_ALARM, false);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        amanager.setStreamMute(AudioManager.STREAM_RING, false);
        amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
        Toast.makeText(MainActivity.this,"Unmuted",Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void prepareAd(){
        //Interstital Ad
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-6804271842029893/1951384578");
        interstitialAd.loadAd(new AdRequest.Builder().build());

    }

    //Methods called by Buttons on Click
    public void sound1(View view)
    {
        mysound1.start();
    }
    public void sound2(View view)
    {
        mysound2.start();
    }
    public void sound3(View view)
    {
        mysound3.start();
    }
    public void sound4(View view)
    {
        mysound4.start();
    }
    public void sound5(View view)
    {
        mysound5.start();
    }
    public void sound6(View view)
    {
        mysound6.start();
    }
    public void sound7(View view)
    {
        mysound7.start();
    }
    public void sound8(View view)
    {
        mysound8.start();
    }
    public void sound9(View view)
    {
        mysound9.start();
    }
    public void sound10(View view)
    {
        mysound10.start();
    }

}


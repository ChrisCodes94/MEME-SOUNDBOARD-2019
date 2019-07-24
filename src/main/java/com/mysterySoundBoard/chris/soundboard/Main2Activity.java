package com.mysterySoundBoard.chris.soundboard;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.mysterySoundBoard.chris.soundboard.MainActivity.isMute;

public class Main2Activity extends AppCompatActivity {


    MediaPlayer mysound11;
    MediaPlayer mysound12;
    MediaPlayer mysound13;
    MediaPlayer mysound14;
    MediaPlayer mysound15;
    MediaPlayer mysound16;
    MediaPlayer mysound17;
    MediaPlayer mysound18;
    MediaPlayer mysound19;
    MediaPlayer mysound20;

    private ImageView shareButton;
    private ImageView muteVolumeBtn;
    private ImageView nextPageButton;
    private ImageView prevPageButton;
    private AudioManager amanager;
    MainActivity mainActivity = new MainActivity();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        //initialize sound variables
        mysound11 = MediaPlayer.create(this, R.raw.seventeen);
        mysound12 = MediaPlayer.create(this, R.raw.eighteen);
        mysound13 = MediaPlayer.create(this, R.raw.nineteen);
        mysound14 = MediaPlayer.create(this, R.raw.twenty);
        mysound15 = MediaPlayer.create(this, R.raw.twentyone);
        mysound16 = MediaPlayer.create(this, R.raw.twentytwo);
        mysound17 = MediaPlayer.create(this,R.raw.twentythree);
        mysound18 = MediaPlayer.create(this, R.raw.twentyfour);
        mysound19 = MediaPlayer.create(this, R.raw.thirty);//modifed
        mysound20 = MediaPlayer.create(this, R.raw.twentynine);//modified

        //initialize button variables
        muteVolumeBtn = findViewById(R.id.muteButton);
        shareButton = findViewById(R.id.shareButton);

        prevPageButton = (ImageView) findViewById(R.id.backButton_2);
        nextPageButton = (ImageView) findViewById(R.id.nextButton_2);

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
        prevPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage1();
            }
        });
        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage2();
            }
        });

        // Load an ad into the AdMob banner view.
        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

    }


    private void muteAudio(AudioManager amanager){
        //mute audio
        amanager =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
        amanager.setStreamMute(AudioManager.STREAM_ALARM, true);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
        amanager.setStreamMute(AudioManager.STREAM_RING, true);
        amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
        Toast.makeText(Main2Activity.this,"Muted",Toast.LENGTH_SHORT).show();

    }

    private void unmuteAudio(AudioManager amanager){
        amanager =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
        amanager.setStreamMute(AudioManager.STREAM_ALARM, false);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        amanager.setStreamMute(AudioManager.STREAM_RING, false);
        amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
        Toast.makeText(Main2Activity.this,"Unmuted",Toast.LENGTH_SHORT).show();
    }

    public void openPage1()
    {//loads previous page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openPage2()
    {//loads next page
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

  public void saveSound(){
//TODO: add save sound button in Toolbar Menu
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    //Methods called by Buttons on Click
    public void sound11(View view)
    {
        mysound11.start();
    }
    public void sound12(View view)
    {
        mysound12.start();
    }
    public void sound13(View view)
    {
        mysound13.start();
    }
    public void sound14(View view)
    {
        mysound14.start();
    }
    public void sound15(View view)
    {
        mysound15.start();
    }
    public void sound16(View view)
    {
        mysound16.start();
    }
    public void sound17(View view)
    {
        mysound17.start();
    }
    public void sound18(View view)
    {
        mysound18.start();
    }
    public void sound19(View view)
    {
        mysound19.start();
    }
    public void sound20(View view)
    {
        mysound20.start();
    }

}

package com.mysterySoundBoard.chris.soundboard;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.mysterySoundBoard.chris.soundboard.MainActivity.isMute;

public class Main3Activity extends AppCompatActivity {

    MediaPlayer mysound21;
    MediaPlayer mysound22;
    MediaPlayer mysound23;
    MediaPlayer mysound24;
    MediaPlayer mysound25;
    MediaPlayer mysound26;
    MediaPlayer mysound27;
    MediaPlayer mysound28;
    MediaPlayer mysound29;
    MediaPlayer mysound30;

    private ImageView shareButton;
    private ImageView muteVolumeBtn;
    private ImageView prevPageButton;
    private AudioManager amanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        //initialize sound variables
        mysound21 = MediaPlayer.create(this, R.raw.seven);
        mysound22 = MediaPlayer.create(this, R.raw.eight);
        mysound23 = MediaPlayer.create(this, R.raw.nine);
        mysound24 = MediaPlayer.create(this, R.raw.ten);
        mysound25 = MediaPlayer.create(this, R.raw.eleven);
        mysound26 = MediaPlayer.create(this, R.raw.twelve);
        mysound27 = MediaPlayer.create(this,R.raw.thirteen);
        mysound28 = MediaPlayer.create(this, R.raw.fourteen);
        mysound29 = MediaPlayer.create(this, R.raw.fifteen);
        mysound30 = MediaPlayer.create(this, R.raw.sixteen);

        //initialize button variables
        muteVolumeBtn = findViewById(R.id.muteButton);
        shareButton = findViewById(R.id.shareButton);
        prevPageButton = (ImageView) findViewById(R.id.backButton_3);

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
        Toast.makeText(Main3Activity.this,"Muted",Toast.LENGTH_SHORT).show();

    }

    private void unmuteAudio(AudioManager amanager){
        amanager =(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
        amanager.setStreamMute(AudioManager.STREAM_ALARM, false);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        amanager.setStreamMute(AudioManager.STREAM_RING, false);
        amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
        Toast.makeText(Main3Activity.this,"Unmuted",Toast.LENGTH_SHORT).show();
    }

    public void openPage2()
    {//loads previous page
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }

    public void saveSound(){

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
    public void sound21(View view)
    {
        mysound21.start();
    }
    public void sound22(View view)
    {
        mysound22.start();
    }
    public void sound23(View view)
    {
        mysound23.start();
    }
    public void sound24(View view)
    {
        mysound24.start();
    }
    public void sound25(View view)
    {
        mysound25.start();
    }
    public void sound26(View view)
    {
        mysound26.start();
    }
    public void sound27(View view)
    {
        mysound27.start();
    }
    public void sound28(View view)
    {
        mysound28.start();
    }
    public void sound29(View view)
    {
        mysound29.start();
    }
    public void sound30(View view)
    {
        mysound30.start();
    }

}

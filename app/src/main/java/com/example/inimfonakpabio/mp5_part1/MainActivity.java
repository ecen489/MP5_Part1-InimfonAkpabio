package com.example.inimfonakpabio.mp5_part1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    ImageView CoverPic;
    int currentID;
    boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoverPic = (ImageView) findViewById(R.id.CoverPic);
    }

    public void RadioClick(View v) {
        if(currentID != v.getId()) {

            if(mp!=null) {
                if(mp.isPlaying()) {
                    mp.stop();
                    try {
                        mp.reset();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            switch (v.getId()) {
                case R.id.RB1:

                    CoverPic.setImageResource(R.drawable.shakira);
                    try {

                        mp = MediaPlayer.create(this, R.raw.shakira_la_la_la_brazil_2014);
                        mp.prepare();

                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    mp.start();
                    isPaused = false;
                    currentID = R.id.RB1;
                    break;

                case R.id.RB2:

                    CoverPic.setImageResource(R.drawable.bigforyourboots);
                    try {

                        mp = MediaPlayer.create(this, R.raw.stormzy_big_for_your_boots);
                        mp.prepare();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mp.start();
                    isPaused = false;
                    currentID = R.id.RB2;
                    break;

                case R.id.RB3:

                    CoverPic.setImageResource(R.drawable.seeyouagain);
                    try {

                        mp = MediaPlayer.create(this, R.raw.wiz_khalifa_see_you_again);
                        mp.prepare();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mp.start();
                    isPaused = false;
                    currentID = R.id.RB3;
                    break;

                default:
                    break;
            }
        }
    }

    public void StartPlay(View view) {
        if(mp != null) {
            if(!mp.isPlaying() && !isPaused) {
                try {
                    mp.reset();
                    if(currentID == R.id.RB1) {
                        mp = MediaPlayer.create(this, R.raw.shakira_la_la_la_brazil_2014);
                    } else if(currentID == R.id.RB2) {
                        mp = MediaPlayer.create(this, R.raw.stormzy_big_for_your_boots);
                    } else if(currentID == R.id.RB3) {
                        mp = MediaPlayer.create(this, R.raw.wiz_khalifa_see_you_again);
                    } else {
                        //do nothing
                    }
                    mp.prepare();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            mp.start();
            isPaused = false;
        }
    }

    public void StopPlay(View view) {
        if(mp != null) {
            mp.stop();
            isPaused = false;
        }
    }

    public void PausePlay(View view) {
        if(mp != null) {
            mp.pause();
            isPaused = true;
        }
    }
}

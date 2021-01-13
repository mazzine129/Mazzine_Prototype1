package com.example.firebaseimagelabeling;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.firebaseimagelabeling.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MediaActivity extends YouTubeBaseActivity {
    Button btn;
    String key;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                key= null;
            } else {
                key= extras.getString("YOUTUBE_KEY");
            }
        } else {
            key= (String) savedInstanceState.getSerializable("YOUTUBE_KEY");
        }
        Log.d("KEY!!!!!! : ", key);

        btn = findViewById(R.id.play);
        youTubePlayerView = findViewById(R.id.YoutubePlayerView);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("LwjaqyfifTA");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayerView.initialize("AIzaSyAcmfPb0Wa3SHJDIIvnyWgu68-8_tFxAN4", onInitializedListener);
            }
        });
    }
}

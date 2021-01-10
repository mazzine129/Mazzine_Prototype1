package com.example.firebaseimagelabeling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    // Media Container: Recycler View
    RecyclerView mediaContainer;

    // List of media content objects
    ArrayList<MediaContent> mediaContents;

    // Media content adapter
    MediaContentAdapter mediaContentAdapter;

    /////////////////////////////////////////
    /////////////////////////////////////////

    // Playground : Grid View
    GridView playground;
    ArrayList<Integer> playgroundImages = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaContainer = findViewById(R.id.media_contents);

        // Images
        Integer[] mediaContainerLogos = {R.drawable.starbucks
                , R.drawable.nike
                , R.drawable.wendys
                , R.drawable.burgerking
                , R.drawable.mcdonalds};

        // Titles
        String[] mediaContainerLogoNames = {"Starbucks"
                , "NIKE"
                , "Wendy's"
                , "Burger King"
                , "McDonald's"};

        int numberOfItems = mediaContainerLogoNames.length;
        // Instantiation of media content objects
        mediaContents = new ArrayList<>();

        for (int i = 0; i < numberOfItems; i++) {
            MediaContent content = new MediaContent(mediaContainerLogos[i], mediaContainerLogoNames[i]);
            mediaContents.add(content);
        }

        // Design Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(Home.this
                , LinearLayoutManager.HORIZONTAL
                , false);
        mediaContainer.setLayoutManager(layoutManager);
        mediaContainer.setItemAnimator(new DefaultItemAnimator());

        // Instatiate MediaContentAdapter
        mediaContentAdapter = new MediaContentAdapter(Home.this, mediaContents);

        // Set Media Container RecyclerView
        mediaContainer.setAdapter(mediaContentAdapter);

        //////////////////////////////////////////
        //////////////////////////////////////////

        playground = findViewById(R.id.playground);

        playgroundImages.add(R.drawable.playground_logo1);
        playgroundImages.add(R.drawable.playground_logo2);
        playgroundImages.add(R.drawable.playground_logo3);
        playgroundImages.add(R.drawable.playground_logo4);

        PlaygroundAdapter playgroundAdapter = new PlaygroundAdapter();
        playground.setAdapter(playgroundAdapter);

    }
    class PlaygroundAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return playgroundImages.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View playgroundView = getLayoutInflater().inflate(R.layout.playground_item, viewGroup, false);
            ImageView playgroundImage = (ImageView) playgroundView.findViewById(R.id.playground_image);

            playgroundImage.setImageResource(playgroundImages.get(i));

            return playgroundView;
        }
    }
}

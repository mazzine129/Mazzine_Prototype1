package com.example.firebaseimagelabeling;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class homeFragment extends Fragment {

    // Media Container: Recycler View
    RecyclerView mediaContainer;

    // List of media content objects
    ArrayList<MediaContent> mediaContents;

    // Media content adapter
    com.example.firebaseimagelabeling.MediaContentAdapter mediaContentAdapter;

    /////////////////////////////////////////
    /////////////////////////////////////////

    // Playground : Grid View
    GridView playground;
    ArrayList<Integer> playgroundImages = new ArrayList<Integer>();

    public homeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()
                , LinearLayoutManager.HORIZONTAL
                , false);
        mediaContainer.setLayoutManager(layoutManager);
        mediaContainer.setItemAnimator(new DefaultItemAnimator());

        // Instatiate MediaContentAdapter
        mediaContentAdapter = new com.example.firebaseimagelabeling.MediaContentAdapter(getActivity(), mediaContents);

        // Set Media Container RecyclerView
        mediaContainer.setAdapter(mediaContentAdapter);

        //////////////////////////////////////////
        //////////////////////////////////////////

        playgroundImages.add(R.drawable.playground_logo1);
        playgroundImages.add(R.drawable.playground_logo2);
        playgroundImages.add(R.drawable.playground_logo3);
        playgroundImages.add(R.drawable.playground_logo4);

        PlaygroundAdapter playgroundAdapter = new PlaygroundAdapter();
        playground.setAdapter(playgroundAdapter);

        return view;
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
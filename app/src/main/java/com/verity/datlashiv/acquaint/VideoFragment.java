package com.verity.datlashiv.acquaint;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.verity.datlashiv.acquaint.ModelClasses.MainCourse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class VideoFragment extends Fragment {

    private ArrayList<MainCourse> mc;


    public VideoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        VideoView videoView;

        videoView = view.findViewById(R.id.videoView);
        String url = "http://techslides.com/demos/sample-videos/small.mp4";
        videoView.setVideoURI(Uri.parse(url));
        videoView.setMediaController(new MediaController(getContext()));
        videoView.requestFocus();
        videoView.start();


    }
}

package com.example.tabvideo.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tabvideo.R;
import com.example.tabvideo.ijk.IjkPlayer;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_SECTION_URL = "section_url";

    private PageViewModel   pageViewModel;
    private IjkPlayer       mPlayer;
    private int             style;


    public static PlaceholderFragment newInstance(int index, String url) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        bundle.putString(ARG_SECTION_URL, url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        String url = null;
        if (getArguments() != null) {
            url = getArguments().getString(ARG_SECTION_URL);
        }
        pageViewModel.setUrl(url);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ijk, container, false);
        mPlayer = root.findViewById(R.id.ijkplayer);
        pageViewModel.getUrl().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mPlayer.setPath(s);
                initPlayer();
            }
        });
        return root;
    }

    private void initPlayer() {
        return;
    }

    @Override
    public void onPause() {
        super.onPause();
        mPlayer.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPlayer.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPlayer.release();
        mPlayer = null;
    }

}
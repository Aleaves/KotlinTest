package com.app.uicore.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ParallaxFragment extends Fragment {

    private List<View> parallaxViews = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater original, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        int layoutId = args.getInt("layoutId");
        ParallaxLayoutInflater inflater = new ParallaxLayoutInflater(original,getActivity(),this);
        return  inflater.inflate(layoutId,null);
    }

    public List<View> getParallaxViews(){
        return parallaxViews;
    }

}

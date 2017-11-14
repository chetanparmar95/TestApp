package com.coordinatorlayoutdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coordinatorlayoutdemo.databinding.FragmentCelebProfilieBinding;

/**
 * Created by Vishal on 21/9/17.
 */

public class CelebrityOwnProfileFragment extends Fragment {


    private FragmentCelebProfilieBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCelebProfilieBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}

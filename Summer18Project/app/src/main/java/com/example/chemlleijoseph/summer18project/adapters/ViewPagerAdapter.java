package com.example.chemlleijoseph.summer18project.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.Pair;

import com.example.chemlleijoseph.summer18project.fragments.comingSoonFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<Pair<String, Fragment>> list;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Pair<String, Fragment>> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i).second;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

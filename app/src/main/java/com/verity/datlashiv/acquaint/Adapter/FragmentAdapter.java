package com.verity.datlashiv.acquaint.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.verity.datlashiv.acquaint.PdfFragment;
import com.verity.datlashiv.acquaint.R;
import com.verity.datlashiv.acquaint.VideoFragment;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private Context context;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PdfFragment();
            case 1:
                return new VideoFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getStringArray(R.array.tabs_name)[position];
    }

    @Override
    public int getCount() {
        return context.getResources().getStringArray(R.array.tabs_name).length;
    }
}

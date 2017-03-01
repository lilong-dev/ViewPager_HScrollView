package com.ll.viewpager_hscrollview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/1.
 */

public class ContentFragment extends Fragment {
    private MyViewPager mViewPager;
    private List<View> mViews;
    private ViewPagerAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPager = (MyViewPager) view.findViewById(R.id.viewPager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.initViews();
    }

    private void initViews() {
        mViews = new ArrayList<>();
        LayoutInflater mInflater = getActivity().getLayoutInflater().from(getActivity());
        View view1 = mInflater.inflate(R.layout.view_item_1,null);
        View view2 = mInflater.inflate(R.layout.view_item_2,null);
        View view3 = mInflater.inflate(R.layout.view_item_3,null);
        mViews.add(view1);
        mViews.add(view2);
        mViews.add(view3);
        mAdapter = new ViewPagerAdapter(mViews);
        mViewPager.setAdapter(mAdapter);
    }
}

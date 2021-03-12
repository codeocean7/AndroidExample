package com.zealsoft.androidexample;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zealsoft.androidexample.TabFragments.CallFrag;
import com.zealsoft.androidexample.TabFragments.ChatFrag;
import com.zealsoft.androidexample.TabFragments.StatusFrag;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity
{
    //step 2
    ViewPager mViewPager;
    TabLayout mTabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity_lay);

        //step 3
        mTabLayout=findViewById(R.id.tablelayout);
        mViewPager=findViewById(R.id.viewpager_id);

        //step 4
        MyViewPagerAdapter myViewPagerAdapter=new MyViewPagerAdapter(getSupportFragmentManager());
        myViewPagerAdapter.addFragment(new ChatFrag(),"CHAT");
        myViewPagerAdapter.addFragment(new StatusFrag(),"STATUS");
        myViewPagerAdapter.addFragment(new CallFrag(),"CALL");

        //step 5
        mViewPager.setAdapter(myViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    //step 1
    class MyViewPagerAdapter extends FragmentPagerAdapter
    {

        final List<Fragment> listFragment = new ArrayList<>();
        final List<String> listTitles = new ArrayList<>();

        public MyViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return listFragment.get(position);
        }

        @Override
        public int getCount() {

            return listFragment.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            return listTitles.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            listFragment.add(fragment);
            listTitles.add(title);
        }
    }
    }

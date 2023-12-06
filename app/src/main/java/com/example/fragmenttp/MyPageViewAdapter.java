package com.example.fragmenttp;


import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fragmenttp.ui.map.MapFragment;


public class MyPageViewAdapter extends FragmentPagerAdapter {

        private static final int NUM_PAGES = 2;

        public MyPageViewAdapter(MainActivity mainActivity) {
            super(mainActivity.getSupportFragmentManager());
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public androidx.fragment.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return MapFragment.newInstance();
                case 1:
                    return ChallengeFragment.newInstance();
                default:
                    return null;
            }
        }
        // set tablayout title
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Map";
                case 1:
                    return "Challenge";
                default:
                    return null;
            }
        }
}
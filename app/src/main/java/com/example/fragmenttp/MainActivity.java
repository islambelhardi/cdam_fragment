package com.example.fragmenttp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import com.example.fragmenttp.ui.map.MapFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MapFragment.newInstance())
                .commitNow();
        }
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        /*tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, MapFragment.newInstance())
                            .commitNow();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, ChallengeFragment.newInstance())
                            .commitNow();
                        break;
                }
            }
            public void onTabUnselected(TabLayout.Tab tab) {}
            public void onTabReselected(TabLayout.Tab tab) {}
        });*/

        MyPageViewAdapter myPageViewAdapter = new MyPageViewAdapter(this);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(myPageViewAdapter);
        tabLayout.setupWithViewPager(viewPager);
        // set tablayout title
        tabLayout.getTabAt(0).setText("Map");
        tabLayout.getTabAt(1).setText("Challenge");
    }
}
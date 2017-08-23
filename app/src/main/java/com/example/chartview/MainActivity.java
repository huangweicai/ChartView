package com.example.chartview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.chartview.fragment.BloodChartFragment;
import com.example.chartview.fragment.BloodChartFragment_;
import com.example.chartview.fragment.RateChartFragment;
import com.example.chartview.fragment.SportChartFragment;
import com.example.chartview.fragment.WeightChartFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout toolbar_tl_tab;
    private ViewPager vp_container;
    private String[] titles = {"折线图", "曲线图", "柱状图", "镂空柱状图", "定制血压图"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar_tl_tab = (TabLayout) findViewById(R.id.toolbar_tl_tab);
        vp_container = (ViewPager) findViewById(R.id.vp_container);
        toolbar_tl_tab.setupWithViewPager(vp_container);
        toolbar_tl_tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        vp_container.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    //折线图
                    WeightChartFragment chartFragment = new WeightChartFragment();
                    chartFragment.showChart();
                    return chartFragment;
                } else if (position == 1) {
                    //曲线图
                    RateChartFragment chartFragment = new RateChartFragment();
                    chartFragment.showChart();
                    return chartFragment;
                } else if (position == 2) {
                    //柱状图
                    SportChartFragment chartFragment = new SportChartFragment();
                    chartFragment.showChart();
                    return chartFragment;
                } else if (position == 3) {
                    //镂空柱状图
                    BloodChartFragment chartFragment = new BloodChartFragment();
                    chartFragment.showChart();
                    return chartFragment;
                } else if (position == 4) {
                    //定制血压图
                    BloodChartFragment_ chartFragment = new BloodChartFragment_();
                    chartFragment.showChart();
                    return chartFragment;
                }
                return null;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }

            @Override
            public int getCount() {
                return titles.length;
            }
        });
    }

}

package com.example.chartview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.chartview.fragment.BarChartFragment;
import com.example.chartview.fragment.CurveChartFragment;
import com.example.chartview.fragment.CustomizedBloodChartFragment;
import com.example.chartview.fragment.HistogramBarChartFragment;
import com.example.chartview.fragment.LineChartFragment;
import com.example.chartview.fragment.SportBarChartFragment;

/**
 * 时间：2017/8/23
 * 作者：黄伟才
 * 简书：http://www.jianshu.com/p/87e7392a16ff
 * github：https://github.com/huangweicai/OkLibDemo
 * 描述：合并分支
 */
public class MainActivity extends AppCompatActivity {
    private TabLayout toolbar_tl_tab;
    private ViewPager vp_container;
    private String[] titles = {"折线图", "曲线图", "柱状图", "镂空柱状图", "定制血压图", "运动柱状图"};

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
                    LineChartFragment chartFragment = new LineChartFragment();
                    chartFragment.showChart();
                    return chartFragment;
                } else if (position == 1) {
                    //曲线图
                    CurveChartFragment chartFragment = new CurveChartFragment();
                    chartFragment.showChart();
                    return chartFragment;
                } else if (position == 2) {
                    //柱状图
                    BarChartFragment chartFragment = new BarChartFragment();
                    chartFragment.showChart();
                    return chartFragment;
                } else if (position == 3) {
                    //镂空柱状图
                    HistogramBarChartFragment chartFragment = new HistogramBarChartFragment();
                    chartFragment.showChart();
                    return chartFragment;
                } else if (position == 4) {
                    //定制血压图
                    CustomizedBloodChartFragment chartFragment = new CustomizedBloodChartFragment();
                    chartFragment.showChart();
                    return chartFragment;
                } else if (position == 5) {
                    //运动柱状图
                    SportBarChartFragment chartFragment = new SportBarChartFragment();
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

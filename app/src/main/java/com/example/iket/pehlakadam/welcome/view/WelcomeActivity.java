package com.example.iket.pehlakadam.welcome.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.helper.SharedPrefs;
import com.example.iket.pehlakadam.home.Navigation;
import com.example.iket.pehlakadam.welcome.model.MockWelcomeProvider;
import com.example.iket.pehlakadam.welcome.model.data.PageDetails;
import com.example.iket.pehlakadam.welcome.presenter.WelcomePresenter;
import com.example.iket.pehlakadam.welcome.presenter.WelcomePresenterImpl;

import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity implements WelcomeView {

    private ViewPager viewPager;
    Button forward_button;
    private LinearLayout dotsLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private ProgressBar progressBar;
    private WelcomePresenter welcomePresenter;
    TextView[] dots;
    Timer swipeTimer;
    private SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedPrefs=new SharedPrefs(this);
        if(sharedPrefs.isFirstTimeLaunch())
        {
            Intent home=new Intent(WelcomeActivity.this, Navigation.class);
            startActivity(home);
            finish();
        }

        forward_button=(Button)findViewById(R.id.welcome_button);
        progressBar = (ProgressBar)findViewById(R.id.first_progressBar);

        dotsLayout=(LinearLayout)findViewById(R.id.layoutDots);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager=(ViewPager)findViewById(R.id.first_viewPager);
        welcomePresenter= new WelcomePresenterImpl(this, new MockWelcomeProvider());

        welcomePresenter.requestWelcomeData();
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
                if(position==4)
                    forward_button.setVisibility(View.VISIBLE);
                else
                    forward_button.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        };
        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home=new Intent(WelcomeActivity.this, Navigation.class);
                startActivity(home);
                finish();
            }
        });
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                // do transformation here
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setScaleX(normalizedposition / 2 + 0.5f);
                page.setScaleY(normalizedposition / 2 + 0.5f);
            }
        });
        swipeTimer = new Timer();
//        swipeTimer.schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (viewPager.getCurrentItem() + 1 == 4) {
//                            viewPager.setCurrentItem(-1);
//                            //  currentPage = 0;
//                        } else {
//                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
//                        }
//                    }
//                });
//            }
//        }, 3200, 3200);


    }

    @Override
    public void showMessage(String error) {


    }

    @Override
    public void showProgressBar(boolean show) {
        if(show)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setData(List<PageDetails> pageDetails) {
        viewPagerAdapter.setData(pageDetails);
        viewPagerAdapter.notifyDataSetChanged();
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[4];
        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            //    dots[i].setTextColor(Color.WHITE);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0)
            //          dots[currentPage].setTextColor(ContextCompat.getColor(this,R.color.white));
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }


}

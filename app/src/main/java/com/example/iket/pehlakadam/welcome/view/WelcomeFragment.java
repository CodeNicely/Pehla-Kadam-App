package com.example.iket.pehlakadam.welcome.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.welcome.model.MockWelcomeProvider;
import com.example.iket.pehlakadam.welcome.model.data.PageDetails;
import com.example.iket.pehlakadam.welcome.presenter.WelcomePresenter;
import com.example.iket.pehlakadam.welcome.presenter.WelcomePresenterImpl;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.iket.pehlakadam.helper.MyApplication.getContext;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WelcomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment implements WelcomeView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewPager viewPager;


    private LinearLayout dotsLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private ProgressBar progressBar;
    private WelcomePresenter welcomePresenter;
    TextView[] dots;
    Timer swipeTimer;

    private OnFragmentInteractionListener mListener;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WelcomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WelcomeFragment newInstance(String param1, String param2) {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.welcome, container, false);
        progressBar = (ProgressBar)view.findViewById(R.id.first_progressBar);

        dotsLayout=(LinearLayout)view.findViewById(R.id.layoutDots);
        viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager=(ViewPager)view.findViewById(R.id.first_viewPager);
        welcomePresenter= new WelcomePresenterImpl(this, new MockWelcomeProvider());

        welcomePresenter.requestWelcomeData();
        viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);

        ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        };
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

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        swipeTimer.cancel();
        super.onDetach();
        mListener = null;
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
            dots[i] = new TextView(getContext());
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

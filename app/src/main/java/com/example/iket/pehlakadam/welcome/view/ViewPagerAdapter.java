package com.example.iket.pehlakadam.welcome.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.welcome.model.data.PageDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 4/2/17.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private TextView question;
    private Button forward_button;
    private List<PageDetails> pageDetailsList = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<PageDetails> pageDetailsList){
        this.pageDetailsList=pageDetailsList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.viewpager_item, container, false);
        container.addView(view);

        PageDetails welcomeDetails= pageDetailsList.get(position);
        forward_button=(Button)view.findViewById(R.id.welcome_button);
        question=(TextView)view.findViewById(R.id.first_question);
        YoYo.with(Techniques.ZoomInLeft)
                .duration(1500)
                .playOn(question);
        if(position==3)
            forward_button.setVisibility(View.VISIBLE);
        else
            forward_button.setVisibility(View.INVISIBLE);
        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Welcome) context).setHome();
            }
        });
        question.setText(welcomeDetails.getQuestion_data());
        return view;
    }

    @Override
    public int getCount() {
        return pageDetailsList.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}

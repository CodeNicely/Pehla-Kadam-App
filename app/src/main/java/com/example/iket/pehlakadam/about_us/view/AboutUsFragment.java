package com.example.iket.pehlakadam.about_us.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.about_us.model.MockDataAboutUS;
import com.example.iket.pehlakadam.about_us.model.RetrofitAboutUsProvider;
import com.example.iket.pehlakadam.about_us.model.data.AboutUsData;
import com.example.iket.pehlakadam.about_us.presenter.AboutUsPresenter;
import com.example.iket.pehlakadam.about_us.presenter.AboutUsPresenterImpl;
import com.example.iket.pehlakadam.helper.image_loader.GlideImageLoader;
import com.example.iket.pehlakadam.helper.image_loader.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AboutUsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AboutUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutUsFragment extends Fragment implements AboutUsView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageLoader imageLoader;
    private AboutUsPresenter aboutUsPresenter;
    private View snackView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.imageProgressBar)
    ProgressBar imageProgressBar;

    private OnFragmentInteractionListener mListener;

    public AboutUsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutUsFragment newInstance(String param1, String param2) {
        AboutUsFragment fragment = new AboutUsFragment();
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


        View view= inflater.inflate(R.layout.fragment_about_us, container, false);
        ButterKnife.bind(this,view);

//        snackView=getActivity().findViewById(R.id.cordinatorLayout);
        
        imageLoader=new GlideImageLoader(getContext());
        aboutUsPresenter=new AboutUsPresenterImpl(this,new MockDataAboutUS());

        description.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        aboutUsPresenter.requestAboutUs();

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
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getContext(), ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoader(boolean show) {

        if(show)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setData(AboutUsData aboutUsData) {


        imageLoader.loadImage(aboutUsData.getImage_url(),imageView,imageProgressBar);
        description.setText(aboutUsData.getDescription());

        imageView.setVisibility(View.VISIBLE);
        description.setVisibility(View.VISIBLE);

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

    @Override
    public void onStop() {
        super.onStop();
        aboutUsPresenter.onDestroy();
    }


}

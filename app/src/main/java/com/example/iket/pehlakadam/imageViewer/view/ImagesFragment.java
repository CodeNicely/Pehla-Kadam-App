package com.example.iket.pehlakadam.imageViewer.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.imageViewer.model.ImagesData;
import com.example.iket.pehlakadam.imageViewer.model.RetrofitImageProvider;
import com.example.iket.pehlakadam.imageViewer.presenter.ImagePresenter;
import com.example.iket.pehlakadam.imageViewer.presenter.ImagePresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ImagesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ImagesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImagesFragment extends Fragment implements ImagesInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @BindView(R.id.recycler_view_images)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar_images)
    ProgressBar progressBar;
    private ImagePresenter imagesPresenter;
    private ImagesAdapter adapter;
    private GridLayoutManager lLayout;

    private OnFragmentInteractionListener mListener;

    public ImagesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImagesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImagesFragment newInstance(String param1, String param2) {
        ImagesFragment fragment = new ImagesFragment();
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
        View view= inflater.inflate(R.layout.fragment_images, container, false);

        ButterKnife.bind(this,view);
        imagesPresenter=new ImagePresenterImpl(this,new RetrofitImageProvider());

        adapter = new ImagesAdapter(getContext());

        lLayout = new GridLayoutManager(getContext(),2);

        recyclerView.setLayoutManager(lLayout);
        recyclerView.setAdapter(adapter);
        imagesPresenter.requestImages();


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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    @Override
    public void showLoading(boolean show) {
        if(show)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        else
            progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<ImagesData> imagesDataList) {
        adapter.setData(imagesDataList);
        adapter.notifyDataSetChanged();
    }
}

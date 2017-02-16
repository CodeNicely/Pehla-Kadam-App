package com.example.iket.pehlakadam.video_player;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.iket.pehlakadam.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VidPlayer.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VidPlayer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VidPlayer extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @BindView(R.id.myVideo)
    VideoView videoView;

    private OnFragmentInteractionListener mListener;

    public VidPlayer() {
        // Required empty public constructor
    }

    public static VidPlayer newInstance(String param1, String param2) {
        VidPlayer fragment = new VidPlayer();
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
        View view=inflater.inflate(R.layout.fragment_vid_player, container, false);
        ButterKnife.bind(this,view);
        String vidAddress = "https://r2---sn-i3beln7k.googlevideo.com/videoplayback?requiressl=yes&ei=5BmUWNnjNtnyoAO36rHgAQ&clen=15232213&ratebypass=yes&gir=yes&itag=18&pl=20&mime=video%2Fmp4&signature=16F61FCE9DFC5AAF7B0ABC734937A8AF96E07C4C.4A63ED9A1D012703AB0B612B6C128AEA3791E657&upn=uV4yuv-HzJE&ipbits=0&sparams=clen,dur,ei,expire,gir,id,initcwndbps,ip,ipbits,ipbypass,itag,lmt,mime,mm,mn,ms,mv,nh,pl,ratebypass,requiressl,source,upn&id=o-ACd4OHwHGCLFH-W1HwcttQBAa6VRiVUj6HKMJvuPMyKl&source=youtube&expire=1486122564&dur=200.179&lmt=1486020025327296&ip=122.170.195.161&key=cms1&title=Badrinath+Ki+Dulhania++Official+Trailer+%231+(2017)+Varun+Dhawan+%26+Alia+Bhatt+Movie&req_id=4c5d20f58400a3ee&redirect_counter=2&cms_redirect=yes&ipbypass=yes&mm=30&mn=sn-i3beln7k&ms=nxu&mt=1486104738&mv=m&nh=IgpwcjAzLmhrZzAxKg4yMDMuMTMxLjI1MC44MQ";
        Uri vidUri = Uri.parse(vidAddress);
        videoView.setVideoURI(vidUri);

        final ProgressDialog pDialog = new ProgressDialog(getContext());
        // Set progressbar title
//        pDialog.setTitle("Android Video Streaming Tutorial");
//
//        pDialog.setMessage("Buffering...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(false);
//        pDialog.show();
//        // Show progressbar
//        pDialog.show();
        MediaController vidControl = new MediaController(getContext());
        vidControl.setAnchorView(videoView);
        videoView.setMediaController(vidControl);

        videoView.requestFocus();
        videoView.start();
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            // Close the progress bar and play the video
//            public void onPrepared(MediaPlayer mp) {
////                pDialog.dismiss();
//                videoView.start();
//
//            }
//        });
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

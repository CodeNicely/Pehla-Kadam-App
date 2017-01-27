package com.example.iket.pehlakadam.contact_us.view;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.iket.pehlakadam.R;

import com.example.iket.pehlakadam.contact_us.model.RetrofitContactUsProvider;
import com.example.iket.pehlakadam.contact_us.model.data.ContactUsData;
import com.example.iket.pehlakadam.contact_us.presenter.ContactUsPresenter;
import com.example.iket.pehlakadam.contact_us.presenter.ContactUsPresenterImpl;
import com.example.iket.pehlakadam.helper.image_loader.GlideImageLoader;
import com.example.iket.pehlakadam.helper.image_loader.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContactUsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContactUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactUsFragment extends Fragment implements ContactUsView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageLoader imageLoader;
    private View snackView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.email)
    TextView email;

    @BindView(R.id.mobile)
    TextView mobile;

    @BindView(R.id.address)
    TextView address;

    @BindView(R.id.website)
    TextView website;

    @BindView(R.id.facebook)
    TextView facebook;

    @BindView(R.id.twitter)
    TextView twitter;

    @BindView(R.id.instagram)
    TextView instagram;

    @BindView(R.id.imageProgressBar)
    ProgressBar imageProgressBar;

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.contactUsLayout)
    LinearLayout contactUsLayout;


    @BindView(R.id.facebookLayout)
    LinearLayout facebookLayout;

    @BindView(R.id.twitterLayout)
    LinearLayout twitterLayout;

    @BindView(R.id.instagramLayout)
    LinearLayout instagramLayout;

    @BindView(R.id.emailCard)
    CardView emailCard;

    @BindView(R.id.phoneCard)
    CardView phoneCard;

    @BindView(R.id.locationCard)
    CardView locationCard;

    @BindView(R.id.facebookCard)
    CardView facebookCard;

    @BindView(R.id.websiteCard)
    CardView websiteCard;

    @BindView(R.id.twitterCard)
    CardView twitterCard;

    @BindView(R.id.instagramCard)
    CardView instagramCard;

    private ContactUsPresenter contactUsPresenter;
    private OnFragmentInteractionListener mListener;

    public ContactUsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactUsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactUsFragment newInstance(String param1, String param2) {
        ContactUsFragment fragment = new ContactUsFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        ButterKnife.bind(this, view);

//        snackView = getActivity().findViewById(R.id.cordinatorLayout);
        contactUsPresenter = new ContactUsPresenterImpl(this, new RetrofitContactUsProvider());
        contactUsPresenter.requestContactUs();

        imageLoader = new GlideImageLoader(getContext());
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
    public void showLoader(boolean show) {

        if (show) {

            contactUsLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            contactUsLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Snackbar snackbar = Snackbar
                .make(snackView, message, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    @Override
    public void setData(final ContactUsData contactUsData) {

        final String facebookUrl="https://www.facebook.com/"+contactUsData.getFacebook();
        final String twitterUrl="https://www.twitter.com/"+contactUsData.getTwitter();
        final String instagramUrl="https://www.instagram.com/"+contactUsData.getInstagram();


        email.setText(contactUsData.getEmail());
        mobile.setText(contactUsData.getMobile());
        address.setText(contactUsData.getAddress());
        website.setText(contactUsData.getWebsite());

        emailCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, "bunchofools@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Suggestion regarding Spot");

                startActivity(Intent.createChooser(intent, "Choose an Email client :"));

            }
        });
        websiteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bunchofools.com"));
                startActivity(browserIntent);
            }
        });

        phoneCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9713265000"));
                startActivity(callIntent);
            }
        });

        facebook.setText(facebookUrl);
        twitter.setText(twitterUrl);
        instagram.setText(instagramUrl);
        imageLoader.loadImage(contactUsData.getImage(), imageView, imageProgressBar);


        facebookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                    facebookIntent.setData(Uri.parse(getFacebookPageURL(getContext(), contactUsData.getFacebook(), contactUsData.getFacebook())));
                    startActivity(facebookIntent);
                }catch (Exception e){

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(facebookUrl));
                    startActivity(i);
                }

            }
        });

        twitterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=null;
                try{
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, "this is a tweet");
                    intent.setType("text/plain");
                    final PackageManager pm = getContext().getPackageManager();
                    final List<?> activityList = pm.queryIntentActivities(intent, 0);
                    int len =  activityList.size();
                    for (int i = 0; i < len; i++) {
                        final ResolveInfo app = (ResolveInfo) activityList.get(i);
                        if ("com.twitter.android.PostActivity".equals(app.activityInfo.name)) {
                            final ActivityInfo activity=app.activityInfo;
                            final ComponentName name=new ComponentName(activity.applicationInfo.packageName, activity.name);
                            intent.addCategory(Intent.CATEGORY_LAUNCHER);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                            intent.setComponent(name);
                            startActivity(intent);
                            break;
                        }
                    }
                }
                catch(final ActivityNotFoundException e) {
                    Log.i("twitter", "no twitter native",e );
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl));
                    startActivity(intent);

                }

                /*try {
                    // get the Twitter app if possible
                    getContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id="+twitter));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl));
                }
                *//*getContext().startActivity(intent);*/
            }
        }

        );

        instagramCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    startActivity(newInstagramProfileIntent(getContext().getPackageManager(),instagramUrl));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse(instagramUrl)));
                }
            }
        });

    }

    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context, String facebookUrl, String facebookPageId) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + facebookUrl;
            } else { //older versions of fb app
                return "fb://page/" + facebookPageId;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return facebookUrl; //normal web url
        }
    }

    public static Intent newInstagramProfileIntent(PackageManager pm, String url) {
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        try {
            if (pm.getPackageInfo("com.instagram.android", 0) != null) {
                if (url.endsWith("/")) {
                    url = url.substring(0, url.length() - 1);
                }
                final String username = url.substring(url.lastIndexOf("/") + 1);
                // http://stackoverflow.com/questions/21505941/intent-to-open-instagram-user-profile-on-android
                intent.setData(Uri.parse("http://instagram.com/_u/" + username));
                intent.setPackage("com.instagram.android");
                return intent;
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        intent.setData(Uri.parse(url));
        return intent;
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
        contactUsPresenter.onDestroy();
    }
}

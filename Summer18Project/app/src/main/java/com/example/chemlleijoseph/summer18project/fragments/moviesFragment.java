package com.example.chemlleijoseph.summer18project.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chemlleijoseph.summer18project.R;
import com.example.chemlleijoseph.summer18project.adapters.ViewPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link moviesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link moviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class moviesFragment extends Fragment implements comingSoonFragment.OnFragmentInteractionListener{

    private ArrayList<Pair<String, Fragment>> list = new ArrayList<Pair<String, Fragment>>();

    @BindView(R.id.nav_tab)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;



    public moviesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment moviesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static moviesFragment newInstance() {
        moviesFragment fragment = new moviesFragment();
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
        View rootView= inflater.inflate(R.layout.fragment_movies, container, false);

        ButterKnife.bind(this, rootView);
        ViewPager mViewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        list.add(new Pair<String, Fragment>("Theaters", new inTheatersFragment()));
        list.add(new Pair<String, Fragment>("ComingSoon", new comingSoonFragment()));
        list.add(new Pair<String, Fragment>("Movies", new myMoviesFragment()));
        mViewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), list));
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setText("Out Now");
        tabLayout.getTabAt(1).setText("Coming Soon");
        tabLayout.getTabAt(2).setText("My Movies");

        return rootView;

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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

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

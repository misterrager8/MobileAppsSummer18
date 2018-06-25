package com.example.chemlleijoseph.myapplication.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.chemlleijoseph.myapplication.AdvanceListViewActivity;
import com.example.chemlleijoseph.myapplication.AdvanceViewPagerActivity;
import com.example.chemlleijoseph.myapplication.DialogActivity;
import com.example.chemlleijoseph.myapplication.IntentAndBundleActivity;
import com.example.chemlleijoseph.myapplication.MainListAdapter;
import com.example.chemlleijoseph.myapplication.NinePatchActivity;
import com.example.chemlleijoseph.myapplication.NotificationActivity;
import com.example.chemlleijoseph.myapplication.R;
import com.example.chemlleijoseph.myapplication.RadioGroupActivity;
import com.example.chemlleijoseph.myapplication.ScaleTypeActivity;
import com.example.chemlleijoseph.myapplication.ViewPagerActivity;
import com.example.chemlleijoseph.myapplication.CheckBoxActivity;
import com.example.chemlleijoseph.myapplication.bean.Base;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DemoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DemoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private MainListAdapter adapter;
    public List<String> list = new ArrayList<String>();
    private ListView listView;
    private final Context context;


    public DemoFragment() {
        // Required empty public constructor
        context = getContext();
        list.add("ViewPager");
        list.add("ImageScaleType");
        list.add("9Patch");
        list.add("Notification");
        list.add("AdvancedListView");
        list.add("AdvancedViewPager");
        list.add("Dialogs");
        list.add("RadioGroup");
        list.add("CheckBox");
        list.add("Intent & Bundle");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DemoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DemoFragment newInstance(String param1, String param2) {
        DemoFragment fragment = new DemoFragment();
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
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        listView = view.findViewById(R.id.main_demo_lv);
        adapter = new MainListAdapter(getContext(), list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(), ViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), ScaleTypeActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), NinePatchActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), NotificationActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), AdvanceListViewActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getActivity(), AdvanceViewPagerActivity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(), DialogActivity.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(getActivity(), RadioGroupActivity.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(getActivity(), CheckBoxActivity.class);
                        startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9 = new Intent(getActivity(), IntentAndBundleActivity.class);
                        intent9.putExtra("Msg", "Say Hello");
                        intent9.putExtra("No", 10);
                        Base newBase = new Base();
                        newBase.setName("Chemllei");
                        Bundle bundle = new Bundle();
                        bundle.putInt("B_Msg", 100);
                        bundle.putString("B_Msg", "FromBundle");
                        bundle.putSerializable("Base", newBase);
                        intent9.putExtra("B", bundle);
                        startActivity(intent9);
                        default:
                }
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

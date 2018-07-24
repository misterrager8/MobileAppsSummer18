package com.example.chemlleijoseph.summer18project.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.chemlleijoseph.summer18project.R;
import com.example.chemlleijoseph.summer18project.pageActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link inTheatersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link inTheatersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class inTheatersFragment extends Fragment implements View.OnClickListener {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public inTheatersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment inTheatersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static inTheatersFragment newInstance(String param1, String param2) {
        inTheatersFragment fragment = new inTheatersFragment();
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
        View v = inflater.inflate(R.layout.fragment_in_theaters, container, false);

        Button filter = v.findViewById(R.id.filterGenre);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterGenreDialog();
            }
        });
        Button filter2 = v.findViewById(R.id.filterRating);
        filter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterRatingDialog();
            }
        });

        final ImageButton page1 = v.findViewById(R.id.imageButton);
        page1.setOnClickListener(this);

        final ImageButton page2 = v.findViewById(R.id.imageButton2);
        page2.setOnClickListener(this);

        final ImageButton page3 = v.findViewById(R.id.imageButton3);
        page3.setOnClickListener(this);

        final ImageButton page4 = v.findViewById(R.id.imageButton4);
        page4.setOnClickListener(this);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(getActivity(), pageActivity.class));
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

    ArrayList<Integer> choices = new ArrayList<>();
    private void filterGenreDialog(){
        final String[] items = {"Action", "Comedy","Horror","Family"};
        final boolean initChoiceSets[] = {false, false, false, false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Filter By Genre");
        builder.setMultiChoiceItems(items, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    choices.add(which);
                }else {
                    choices.remove(which);
                }
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                int size = choices.size();
//                String str = "";
//                for (int j = 0; j < size; j++){
//                    str += items[choices.get(j)] + " ";
//                }
                View v = View.inflate(getContext(), R.layout.fragment_in_theaters, null);

                ImageButton page1 = (ImageButton) v.findViewById(R.id.imageButton);
                page1.setVisibility(View.GONE);
                ImageButton page4 = v.findViewById(R.id.imageButton4);
                page4.setVisibility(View.GONE);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(getContext(), "Cancel was clicked", Toast.LENGTH_SHORT);
            }
        });
        builder.show();
    }
    private void filterRatingDialog(){
        final String[] items = {"G", "PG","PG-13","R"};
        final boolean initChoiceSets[] = {false, false, false, false};
        choices.clear();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Filter By Rating");
        builder.setMultiChoiceItems(items, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    choices.add(which);
                }else {
                    choices.remove(which);
                }
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int size = choices.size();
                String str = "";
                for (int j = 0; j < size; j++){
                    str += items[choices.get(j)] + " ";
                }
                Toast.makeText(getContext(), "You chose " + str, Toast.LENGTH_SHORT);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(getContext(), "Cancel was clicked", Toast.LENGTH_SHORT);
            }
        });
        builder.show();
    }

}

package com.example.lenovo.smarttravel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class BookedFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private CartDetailFragment.OnFragmentInteractionListener mListener;

    ArrayList<PopularActivityModel> popularActivityModelsArrayList = new ArrayList<>();

    public BookedFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static BookedFragment newInstance(String param1, String param2) {
        BookedFragment fragment = new BookedFragment();
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
        View myView = inflater.inflate(R.layout.fragment_booked, container, false);
        Log.d("test", "onCreateView: Co vo day ko 4!");

        PopularActivityModel popularActivityModel1 = new PopularActivityModel();
        popularActivityModel1.setId(System.currentTimeMillis());
        popularActivityModel1.setDestination("Singapore");
        popularActivityModel1.setImagePath(R.drawable.hiking);
        popularActivityModel1.setPrice("699,000");
        popularActivityModel1.setReview("2202 reviews");
        popularActivityModel1.setTitle("Universal Studios Singapore Ticket");
        popularActivityModelsArrayList.add(popularActivityModel1);

        PopularActivityModel popularActivityModel2 = new PopularActivityModel();
        popularActivityModel2.setId(System.currentTimeMillis());
        popularActivityModel2.setDestination("Paris");
        popularActivityModel2.setImagePath(R.drawable.roadtrip66);
        popularActivityModel2.setPrice("1,500,000");
        popularActivityModel2.setReview("202 reviews");
        popularActivityModel2.setTitle("Montparnasse Tower Observation Deck");
        popularActivityModelsArrayList.add(popularActivityModel2);

        PopularActivityModel popularActivityModel4 = new PopularActivityModel();
        popularActivityModel4.setId(System.currentTimeMillis());
        popularActivityModel4.setDestination("Tokyo");
        popularActivityModel4.setImagePath(R.drawable.adventure);
        popularActivityModel4.setPrice("1,000,000");
        popularActivityModel4.setReview("502 reviews");
        popularActivityModel4.setTitle("Tokyo");
        popularActivityModelsArrayList.add(popularActivityModel4);

        PopularActivityModel popularActivityModel5 = new PopularActivityModel();
        popularActivityModel5.setId(System.currentTimeMillis());
        popularActivityModel5.setDestination("Irceland");
        popularActivityModel5.setImagePath(R.drawable.snow);
        popularActivityModel5.setPrice("1,500,000");
        popularActivityModel5.setReview("502 reviews");
        popularActivityModel5.setTitle("Golden Circle Tour and Kerid Crater Day Tour");
        popularActivityModelsArrayList.add(popularActivityModel5);

        PopularActivityModel popularActivityModel6 = new PopularActivityModel();
        popularActivityModel6.setId(System.currentTimeMillis());
        popularActivityModel6.setDestination("Paris");
        popularActivityModel6.setImagePath(R.drawable.roadtrip66);
        popularActivityModel6.setPrice("1,500,000");
        popularActivityModel6.setReview("202 reviews");
        popularActivityModel6.setTitle("Montparnasse Tower Observation Deck");
        popularActivityModelsArrayList.add(popularActivityModel6);

        //popular activity recyclerview horizontal
        RecyclerView recyclerView2 = (RecyclerView) myView.findViewById(R.id.recyclerviewBooked);
        RecyclerViewBookedAdapter adapter2 = new RecyclerViewBookedAdapter(popularActivityModelsArrayList,getContext());
        recyclerView2.setAdapter(adapter2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(layoutManager2);

        return myView;
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
        Log.d("test", "onCreateView: Co vo day ko 3.0!");

//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
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

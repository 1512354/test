package com.example.lenovo.smarttravel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import java.util.ArrayList;


public class PopularDestinationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PopularDestinationFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PopularDestinationFragment newInstance(String param1, String param2) {
        PopularDestinationFragment fragment = new PopularDestinationFragment();
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
        Log.d("test", "onCreateView:awdawdaw ");
        View myView = inflater.inflate(R.layout.fragment_popular_destination, container, false);

        ArrayList<ImageModel> imageModelArrayList = new ArrayList<>();
        imageModelArrayList.add(new ImageModel(1,"VIET NAME",R.drawable.singapore));
        imageModelArrayList.add(new ImageModel(2,"SINGAPORE",R.drawable.singapore));
        imageModelArrayList.add(new ImageModel(3,"THAILAND",R.drawable.singapore));
        imageModelArrayList.add(new ImageModel(4,"JAPAN",R.drawable.singapore));
        imageModelArrayList.add(new ImageModel(5,"KOREA",R.drawable.singapore));


        RecyclerView recyclerView2 = (RecyclerView) myView.findViewById(R.id.recyclerviewPopularDestination);
        RecyclerViewPopularDestinationAdapter adapter2 = new RecyclerViewPopularDestinationAdapter(imageModelArrayList,getContext());
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

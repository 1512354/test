package com.example.lenovo.smarttravel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class DiscoverFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DiscoverFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DiscoverFragment newInstance(String param1, String param2) {
        DiscoverFragment fragment = new DiscoverFragment();
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
        View view  = inflater.inflate(R.layout.fragment_discover, container, false);
        ArrayList<DiscoverModel> discoverModelArrayList = new ArrayList<>();
        discoverModelArrayList.add(new DiscoverModel(1,"ADVENTURE", R.drawable.adventure));
        discoverModelArrayList.add(new DiscoverModel(2,"CITIES", R.drawable.city));
        discoverModelArrayList.add(new DiscoverModel(3,"WILDLIFE AND NATURE", R.drawable.wildlife));
        discoverModelArrayList.add(new DiscoverModel(4,"TEMPLES", R.drawable.temples2));
        discoverModelArrayList.add(new DiscoverModel(5,"ROAD TRIPS", R.drawable.roadtrip66));
        discoverModelArrayList.add(new DiscoverModel(6,"HIKING", R.drawable.hiking));
        discoverModelArrayList.add(new DiscoverModel(7,"FOOD AND DRINK", R.drawable.food));
        discoverModelArrayList.add(new DiscoverModel(8,"COASTS ISLANDS", R.drawable.coast2));
        discoverModelArrayList.add(new DiscoverModel(9,"SKIING SNOW", R.drawable.snow));
        discoverModelArrayList.add(new DiscoverModel(10,"FAMILY", R.drawable.family2));
        discoverModelArrayList.add(new DiscoverModel(11,"ART CULTURE", R.drawable.art));
        discoverModelArrayList.add(new DiscoverModel(12,"VINTAGE SHOPPING", R.drawable.shopping2));

        RecyclerView myrv = (RecyclerView)  view.findViewById(R.id.recyclerviewDiscover);
        RecyclerViewDiscoverAdapter myAdapter =
                new RecyclerViewDiscoverAdapter(discoverModelArrayList,getContext());
        myrv.setHasFixedSize(true);
        myrv.setAdapter(myAdapter);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2));

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

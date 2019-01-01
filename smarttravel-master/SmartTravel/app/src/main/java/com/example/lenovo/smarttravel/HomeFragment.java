package com.example.lenovo.smarttravel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.robertlevonyan.views.chip.Chip;
import com.robertlevonyan.views.chip.OnChipClickListener;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.*;


public class HomeFragment extends Fragment implements OnChipClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<String> ImageUrls = new ArrayList<>();
    private ArrayList<String> ImageNames = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
//        ImageUrls.add("R.drawable.seoul");
//        ImageUrls.add("R.drawable.tokyo");
//        ImageUrls.add("R.drawable.seoul");
//        ImageUrls.add("R.drawable.tokyo");
//        ImageUrls.add("R.drawable.seoul");
//        ImageUrls.add("https://phamquocdai126.000webhostapp.com/QQ-Tr%C3%A0-xanh-chanh-d%C3%A2y-1.png");
//        ImageUrls.add("https://phamquocdai126.000webhostapp.com/QQ-Tr%C3%A0-xanh-chanh-d%C3%A2y-1.png");
//        ImageUrls.add("https://phamquocdai126.000webhostapp.com/QQ-Tr%C3%A0-xanh-chanh-d%C3%A2y-1.png");
//        ImageUrls.add("https://phamquocdai126.000webhostapp.com/QQ-Tr%C3%A0-xanh-chanh-d%C3%A2y-1.png");
//        ImageUrls.add("https://phamquocdai126.000webhostapp.com/QQ-Tr%C3%A0-xanh-chanh-d%C3%A2y-1.png");
//        ImageNames.add("HongKong");
//        ImageNames.add("Restaurants");
//        ImageNames.add("Hot Dogs");
//        ImageNames.add("Pani Puri");
//        ImageNames.add("KFC Chicken");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // ImageUrls.add("https://phamquocdai126.000webhostapp.com/QQ-Tr%C3%A0-xanh-chanh-d%C3%A2y-1.png");
        ArrayList<ImageModel> imageModelArrayList = new ArrayList<>();

        ImageModel imageModel2 = new ImageModel();
        imageModel2.setId(3);
        imageModel2.setImageName("Paris");
        imageModel2.setImagePath(R.drawable.paris4);
        imageModelArrayList.add(imageModel2);

        ImageModel imageModel1 = new ImageModel();
        imageModel1.setId(2);
        imageModel1.setImageName("Seoul");
        imageModel1.setImagePath(R.drawable.korea);
        imageModelArrayList.add(imageModel1);


        ImageModel imageModel0 = new ImageModel();
        imageModel0.setId(1);
        imageModel0.setImageName("HongKong");
        imageModel0.setImagePath(R.drawable.hongkong);
        imageModelArrayList.add(imageModel0);

        ImageModel imageModel3 = new ImageModel();
        imageModel3.setId(4);
        imageModel3.setImageName("Venice");
        imageModel3.setImagePath(R.drawable.venice2);
        imageModelArrayList.add(imageModel3);

        ImageModel imageModel4 = new ImageModel();
        imageModel4.setId(5);
        imageModel4.setImageName("Tokyo");
        imageModel4.setImagePath(R.drawable.tokyo2);
        imageModelArrayList.add(imageModel4);

        ImageModel imageModel7 = new ImageModel();
        imageModel7.setId(7);
        imageModel7.setImageName("Bangkok");
        imageModel7.setImagePath(R.drawable.bangkok2);
        imageModelArrayList.add(imageModel7);

        ImageModel imageModel5 = new ImageModel();
        imageModel5.setId(6);
        imageModel5.setImageName("London");
        imageModel5.setImagePath(R.drawable.london2);
        imageModelArrayList.add(imageModel5);





        ArrayList<PopularActivityModel> popularActivityModelsArrayList = new ArrayList<>();
        PopularActivityModel popularActivityModel1 = new PopularActivityModel();
        popularActivityModel1.setId(System.currentTimeMillis());
        popularActivityModel1.setDestination("Singapore");
        popularActivityModel1.setImagePath(R.drawable.universalsingapore);
        popularActivityModel1.setPrice("1,699,000");
        popularActivityModel1.setReview("2202 reviews");
        popularActivityModel1.setTitle("Universal Studios Singapore Ticket");
        popularActivityModelsArrayList.add(popularActivityModel1);


        PopularActivityModel popularActivityModel7 = new PopularActivityModel();
        popularActivityModel7.setId(System.currentTimeMillis());
        popularActivityModel7.setDestination("Paris");
        popularActivityModel7.setImagePath(R.drawable.swiss2);
        popularActivityModel7.setPrice("2,200,000");
        popularActivityModel7.setReview("202 reviews");
        popularActivityModel7.setTitle("Day Trip to Grindelwald and Interlaken from Lucerne");
        popularActivityModelsArrayList.add(popularActivityModel7);

        PopularActivityModel popularActivityModel2 = new PopularActivityModel();
        popularActivityModel2.setId(System.currentTimeMillis());
        popularActivityModel2.setDestination("Paris");
        popularActivityModel2.setImagePath(R.drawable.test8);
        popularActivityModel2.setPrice("1,500,000");
        popularActivityModel2.setReview("202 reviews");
        popularActivityModel2.setTitle("The Rhine in the Swiss");
        popularActivityModelsArrayList.add(popularActivityModel2);


        PopularActivityModel popularActivityModel3 = new PopularActivityModel();
        popularActivityModel3.setId(System.currentTimeMillis());
        popularActivityModel3.setDestination("London");
        popularActivityModel3.setImagePath(R.drawable.seoulactivity);
        popularActivityModel3.setPrice("2,200,000");
        popularActivityModel3.setReview("102 reviews");
        popularActivityModel3.setTitle("Nami Island Round Trip");
        popularActivityModelsArrayList.add(popularActivityModel3);


        PopularActivityModel popularActivityModel4 = new PopularActivityModel();
        popularActivityModel4.setId(System.currentTimeMillis());
        popularActivityModel4.setDestination("Tokyo");
        popularActivityModel4.setImagePath(R.drawable.hongkong4);
        popularActivityModel4.setPrice("1,000,000");
        popularActivityModel4.setReview("1,502 reviews");
        popularActivityModel4.setTitle("Hong Kong Disneyland Meal Coupon");
        popularActivityModelsArrayList.add(popularActivityModel4);

        PopularActivityModel popularActivityModel5 = new PopularActivityModel();
        popularActivityModel5.setId(System.currentTimeMillis());
        popularActivityModel5.setDestination("Irceland");
        popularActivityModel5.setImagePath(R.drawable.test7);
        popularActivityModel5.setPrice("1,500,000");
        popularActivityModel5.setReview("502 reviews");
        popularActivityModel5.setTitle("Abel Tasman National Park");
        popularActivityModelsArrayList.add(popularActivityModel5);


        PopularActivityModel popularActivityModel6 = new PopularActivityModel();
        popularActivityModel6.setId(System.currentTimeMillis());
        popularActivityModel6.setDestination("Irceland");
        popularActivityModel6.setImagePath(R.drawable.jerusalem);
        popularActivityModel6.setPrice("2,500,000");
        popularActivityModel6.setReview("102 reviews");
        popularActivityModel6.setTitle("Jerusalem & Dead Sea Tour");
        popularActivityModelsArrayList.add(popularActivityModel6);







        View myView = inflater.inflate(R.layout.fragment_home, container, false);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) myView.findViewById(R.id.recyclerviewDestination);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageModelArrayList, getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);


        //popular activity recyclerview horizontal
        RecyclerView recyclerView2 = (RecyclerView) myView.findViewById(R.id.recyclerviewActivities);
        RecyclerViewPopularAdapter adapter2 = new RecyclerViewPopularAdapter(popularActivityModelsArrayList,getContext());
        recyclerView2.setAdapter(adapter2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager2);

        Chip chip1 = (Chip) myView.findViewById(R.id.chip1);
        Chip chip2 = (Chip) myView.findViewById(R.id.chip2);
        Chip chip3 = (Chip) myView.findViewById(R.id.chip3);
        Chip chip4 = (Chip) myView.findViewById(R.id.chip4);
        Chip chip5 = (Chip) myView.findViewById(R.id.chip5);

        chip1.setOnChipClickListener(this);
        chip2.setOnChipClickListener(this);
        chip3.setOnChipClickListener(this);
        chip4.setOnChipClickListener(this);
        chip5.setOnChipClickListener(this);

        TextView txtAllPopularDestination = myView.findViewById(R.id.txtAllPopularDestination);
        txtAllPopularDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent new Intent(getActivity(),)
                ((MainActivity)getContext()).navigation.setSelectedItemId(R.id.navigation_destination);
                ((MainActivity)getContext()).loadFragment(new DestinationFragment());


            }
        });


        return myView;
    }

    @Override
    public void onChipClick(View v) {
        int id =v.getId();
        Intent intent = new Intent(getActivity(),DiscoverListActivity.class);
        switch (id){
            case R.id.chip1:
                getActivity().startActivity(intent);
                break;
            case R.id.chip2:
                getActivity().startActivity(intent);
                break;
            case R.id.chip3:
                getActivity().startActivity(intent);
                break;
            case R.id.chip4:
                getActivity().startActivity(intent);
                break;
            case R.id.chip5:
                getActivity().startActivity(intent);
                break;
        }

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

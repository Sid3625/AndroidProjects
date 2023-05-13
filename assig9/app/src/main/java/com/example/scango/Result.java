package com.example.scango;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.scango.adapter.RVRetrofitAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Result#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Result extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Result() {
        // Required empty public constructor
    }
    RecyclerView recview;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Result.
     */
    // TODO: Rename and change types and number of parameters
    public static Result newInstance(String param1, String param2) {
        Result fragment = new Result();
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
        View view= inflater.inflate(R.layout.fragment_result, container, false);
        recview=view.findViewById(R.id.recview1);
        getProducts();
        return view;
    }
    private void getProducts(){
        Call<ProductResult> apiCall = RetrofitClient.getInstance().getApis().getProducts();
        apiCall.enqueue(new Callback<ProductResult>() {


            @Override
            public void onResponse(Call<ProductResult> call, Response<ProductResult>response) {
                 ProductResult productResults= response.body();

                Toast.makeText(getContext(), "Added", Toast.LENGTH_SHORT).show();
                setAdapter(productResults);
            }

            @Override
            public void onFailure(Call<ProductResult> call, Throwable t) {
                Toast.makeText(getContext(), "error"+ t, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void setAdapter(List<ProductResult.Result> productResults) {
        recview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        RVRetrofitAdapter rvRetrofitAdapter=new RVRetrofitAdapter(getContext() ,productResults);
        recview.setHasFixedSize(true);
        recview.setAdapter(rvRetrofitAdapter);
    }
}
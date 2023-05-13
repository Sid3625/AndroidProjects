package com.example.scango.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.scango.R;
import com.example.scango.adapter.PopularProductAdapter;
import com.example.scango.model.PopularProduct;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static String BASE_URL = "https://searchinapi.ml/api/v2/";

    public Home() {
        // Required empty public constructor
    }
    List<PopularProduct> popularProductList ;
    RecyclerView popularProductRecyclerview;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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

        popularProductList=new ArrayList<>();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        popularProductRecyclerview=view.findViewById(R.id.popularProductRecyclerview);
//        EditText t1=view.findViewById(R.id.textView);
//        EditText t2=view.findViewById(R.id.textView2);
//        EditText t3=view.findViewById(R.id.textView3);
//        EditText t4=view.findViewById(R.id.textView4);
//        TextView lbl=view.findViewById(R.id.textView5);
//        Button b1 =view.findViewById(R.id.button);
        GetStoreData getStoreData = new GetStoreData();
        getStoreData.execute();

//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppDatabase db= Room.databaseBuilder(getContext(), AppDatabase.class,"cart_db").allowMainThreadQueries().build();
//                ProductDao productDao=db.ProductDao();
//                Boolean check=productDao.is_exist(Integer.parseInt(t1.getText().toString()));
//                if(check==false)
//                {
//                    int pid=Integer.parseInt(t1.getText().toString());
//                    String pname=t2.getText().toString();
//                    int price=Integer.parseInt(t3.getText().toString());
//                    int qnt=Integer.parseInt(t4.getText().toString());
//                    productDao.insertrecord(new Product(pid,pname,price,qnt));
//                    t1.setText("");
//                    t2.setText("");
//                    t3.setText("");
//                    t4.setText("");
//                   lbl.setText("com.example.scango.Product Inserted Successfully");
//                }
//                else
//                {
//                    t1.setText("");
//                    t2.setText("");
//                    t3.setText("");
//                    t4.setText("");
//                   lbl.setText("com.example.scango.Product Already in Cart");
//                }
//            }
//        });
//


        return view;
    }
    private class GetStoreData extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(BASE_URL + "products");
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);


                    int data = isr.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }

            return current;
        }

        /**
         * @param
         * @deprecated
         */
        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject1 = jsonArray.optJSONObject(i);

                    PopularProduct popularProduct = new PopularProduct();
                    popularProduct.setId(jsonObject1.getInt("id"));
                    popularProduct.setImage_url(jsonObject1.getString("image_url"));
                    popularProduct.setName(jsonObject1.getString("name"));
                    popularProduct.setPrice(jsonObject1.getString("base_price"));
                    popularProduct.setWeight(jsonObject1.getString("weight"));
                    popularProduct.setRating(jsonObject1.getInt("rating"));

                    popularProductList.add(popularProduct);


                }



            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutStoreIntoRecyclerView(popularProductList);

        }
    }

    private void PutStoreIntoRecyclerView(List<PopularProduct> popularProductList) {
        PopularProductAdapter popularProductAdapter = new PopularProductAdapter(getContext(), popularProductList);
        popularProductRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        popularProductRecyclerview.setAdapter(popularProductAdapter);
    }


}
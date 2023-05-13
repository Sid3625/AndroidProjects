package com.example.scango;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.example.scango.model.PopularProduct;


public class DetailedActivity extends AppCompatActivity {


    ImageView img;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView=findViewById(R.id.detailed_img);
        TextView textView=findViewById(R.id.detailed_price);
        TextView ts=findViewById(R.id.detailed_rating);
        TextView tb=findViewById(R.id.product_name);
//        TextView tn=findViewById(R.id.textView6);
        Button addToCart=findViewById(R.id.add_to_cart);


        Bundle bundle=getIntent().getExtras();

        String price=bundle.getString("base_price");
        float f=Float.valueOf(price);
        int a=(int) f;
        int rating=bundle.getInt("rating");
//        int id=bundle.getInt("id");

        String name=bundle.getString("name");

        String image=bundle.getString("image_url");

        Glide.with(this).load(image).into(imageView);
        textView.setText("" +a);
        tb.setText(name.toString());
        ts.setText(""+rating);
//        int price1 = new Integer(textView.getText().toString());



        addToCart=findViewById(R.id.add_to_cart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase2 db= Room.databaseBuilder(getApplicationContext(), AppDatabase2.class,"cart_db3").allowMainThreadQueries().build();
                ProductDao productDao=db.ProductDao();


                int id = 0;
                Boolean check=productDao.is_exist(Integer.parseInt(String.valueOf(id)));
                if(check==false)
                {

                    String name=tb.getText().toString();
                    int price=Integer.parseInt(textView.getText().toString());
                    int qnt=1;


//                    int qnt=Integer.parseInt(t4.getText().toString());
                    productDao.insertrecord(new Product(id,name,price,qnt));


                    Toast.makeText(getApplicationContext(),"Product Inserted Successfully",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Product Already in Cart",Toast.LENGTH_SHORT).show();

                }
            }
        });



    }




}



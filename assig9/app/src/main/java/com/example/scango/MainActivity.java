package com.example.scango;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.scango.fragment.Cart;
import com.example.scango.fragment.Home;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

//import androidx.appcompat.widget.SearchView;

public class
MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private NavigationBarView navigationBarView;
    private MenuItem.OnActionExpandListener OnActionExpandListener;
    private Toolbar toolbar;
    //    SearchView searchView;
    ListView listView;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;


//    private AppBarConfiguration mAppBarConfiguration;/*newmain2*/
//    private ActivityMain3Binding binding;/*newmain2*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        bottomNavigationView=findViewById((R.id.bottomNav));
//        navigationBarView=findViewById(R.id.bottomNav);
        bottomNavigationView.setOnItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new Home()).commit();

    }/*newmain2*/




    private BottomNavigationView.OnItemSelectedListener bottomNavMethod= item -> {
        Fragment fragment=null;
        switch (item.getItemId()){
            case R.id.home:
                fragment=new Home();
                break;
            case R.id.shop:
                fragment=new Cart();
                break;

            case R.id.result:
                fragment=new Result();
                break;


//            default:
//                return false;

        }
//                    DrawerLayout drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
//                    drawerLayout.close();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
        return true;
    };


}
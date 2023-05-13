package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialogBuilder;
    private PopupMenu popupMenu;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        popupMenu = new PopupMenu(MainActivity.this, findViewById(R.id.button_popup));
        textView = findViewById(R.id.text_view);

        Button buttonDialog = findViewById(R.id.button_dialog);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        Button buttonPopup = findViewById(R.id.button_popup);
        buttonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        registerForContextMenu(textView);
    }

    private void showAlertDialog() {
        alertDialogBuilder.setTitle("Title");
        alertDialogBuilder.setMessage("Message");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });
        alertDialogBuilder.show();
    }

    private void showPopupMenu(View v) {
        Menu menu = popupMenu.getMenu();
        getMenuInflater().inflate(R.menu.popup_menu, menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_1:
                        // do something
                        return true;
                    case R.id.menu_item_2:
                        // do something
                        return true;
                    case R.id.menu_item_3:
                        // do something
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu_item_1:
                Toast.makeText(MainActivity.this, "Context Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.context_menu_item_2:
                Toast.makeText(MainActivity.this, "Context Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.context_menu_item_3:
                Toast.makeText(MainActivity.this, "Context Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}

package com.zealsoft.androidexample;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    LinearLayout mLay;
    Button btnPop,btnCtx;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        mLay=findViewById(R.id.mLayout);

        btnPop=findViewById(R.id.btnPopUp);
        btnCtx=findViewById(R.id.btnVtxMenu);

        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pMenu=new PopupMenu(MenuActivity.this,btnPop);
                pMenu.getMenuInflater().inflate(R.menu.op_menus,pMenu.getMenu());
                pMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.MnRed:
                                mLay.setBackgroundColor(Color.RED);
                                break;

                            case R.id.MnBlue:
                                mLay.setBackgroundColor(Color.BLUE);
                                break;
                            case R.id.MnYellow:
                                mLay.setBackgroundColor(Color.YELLOW);
                                break;

                            case R.id.MnCyan:
                                mLay.setBackgroundColor(Color.CYAN);
                                break;
                        }
                        return true;
                    }
                });

                pMenu.show();
            }
        });

        registerForContextMenu(btnCtx);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.op_menus,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.MnRed:
                mLay.setBackgroundColor(Color.RED);
                break;

            case R.id.MnBlue:
                mLay.setBackgroundColor(Color.BLUE);
                break;
            case R.id.MnYellow:
                mLay.setBackgroundColor(Color.YELLOW);
                break;

            case R.id.MnCyan:
                mLay.setBackgroundColor(Color.CYAN);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.op_menus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.MnRed:
                mLay.setBackgroundColor(Color.RED);
                break;

            case R.id.MnBlue:
                mLay.setBackgroundColor(Color.BLUE);
                break;
                case R.id.MnYellow:
                mLay.setBackgroundColor(Color.YELLOW);
                break;

            case R.id.MnCyan:
                mLay.setBackgroundColor(Color.CYAN);
                break;
        }

        return true;
    }
}

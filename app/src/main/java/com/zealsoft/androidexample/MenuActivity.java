package com.zealsoft.androidexample;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    LinearLayout mLay;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        mLay=findViewById(R.id.mLayout);
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

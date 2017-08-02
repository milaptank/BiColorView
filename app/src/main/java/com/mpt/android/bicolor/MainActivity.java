package com.mpt.android.bicolor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mpt.android.trianglebicolor.TriangleBiColorView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TriangleBiColorView triColorView = (TriangleBiColorView) findViewById(R.id.triColorView);
        triColorView.setRotation(45);
        triColorView.setTopColor(R.color.colorPrimaryDark);
        triColorView.setBottomColor(R.color.colorAccent);

    }
}

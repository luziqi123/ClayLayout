package com.clay.longface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.clay.longface.layout.ClayLayout;
import com.clay.longface.layout.Dot;
import com.clay.longface.layout.IStrategy;
import com.clay.longface.layout.dot.DotStrategy;
import com.clay.longface.layout.grid.GridStrategy;

public class MainActivity extends AppCompatActivity {

    ClayLayout clayLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clayLayout = (ClayLayout) findViewById(R.id.clay);
        IStrategy gridStrategy = new GridStrategy(3);
        clayLayout.setStrategy(gridStrategy);

//        for (int i = 0; i < 9 ; i++) {
//            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(R.mipmap.ic_launcher);
//            clayLayout.addView(imageView);
//        }
    }
}

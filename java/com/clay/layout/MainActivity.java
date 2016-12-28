package com.clay.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.clay.layout.layout.ClayLayout;
import com.clay.layout.layout.LinearStrategy;
import com.clay.layout.layout.dot.BzilStrategy;
import com.clay.layout.layout.dot.Dot;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClayLayout layout = (ClayLayout) findViewById(R.id.clay);
        BzilStrategy bzilStrategy = new BzilStrategy();
        bzilStrategy.setDot(new Dot(0 , 0));
        layout.setStrategy(new BzilStrategy());
//        layout.setStrategy(new LinearStrategy());

        for (int i = 0; i < 8; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.mipmap.ic_launcher);
            layout.addView(imageView);
        }

    }

}
package com.iamdeveloper.activityexample;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    int drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                drawable = R.drawable.test;
                imageView.setImageDrawable(setImage(drawable));
                return false;
            }
        });
    }

    private Drawable setImage(int id){
        if(Build.VERSION.SDK_INT >= 22){
            return getResources().getDrawable(id,getApplicationContext().getTheme());
        }else{
            return getResources().getDrawable(id);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("drawable",drawable);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        drawable = savedInstanceState.getInt("drawable");
        if(drawable != 0){
            imageView.setImageDrawable(setImage(drawable));
        }

    }
}

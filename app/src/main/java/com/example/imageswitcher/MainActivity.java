package com.example.imageswitcher;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher imageswitcher;
    Button nextButton;
    int imageSwitcherImages[] =
            {R.drawable.one, R.drawable.two, R.drawable.three};
    int switcherimagelength = imageSwitcherImages.length;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextButton = findViewById(R.id.button);
        imageswitcher = findViewById(R.id.imageSwitcher);
        Animation aniOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation aniIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        imageswitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView = new ImageView(getApplicationContext());
                switcherImageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT
                ));
                switcherImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                switcherImageView.setImageResource(imageSwitcherImages[counter]);
                //switcherImageView.setMaxHeight(100);
                return switcherImageView;
            }
        });
        imageswitcher.setOutAnimation(aniOut);
        imageswitcher.setInAnimation(aniIn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if (counter == switcherimagelength) {
                    counter = 0;
                    imageswitcher.setImageResource(imageSwitcherImages[counter]);
                } else {
                    imageswitcher.setImageResource(imageSwitcherImages[counter]);
                }
            }
        });
    }
}

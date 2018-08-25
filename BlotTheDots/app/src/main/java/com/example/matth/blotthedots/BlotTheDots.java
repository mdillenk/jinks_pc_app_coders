package com.example.matth.blotthedots;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.graphics.drawable.AnimationUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class BlotTheDots extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private Random random = new Random();
    int globalDuration = 500;
    View globalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blot_the_dots);
        imageView1 = findViewById(R.id.imageView1);
        imageView1.setVisibility(View.INVISIBLE);
        imageView2 = findViewById(R.id.imageView2);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3 = findViewById(R.id.imageView3);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4 = findViewById(R.id.imageView4);
        imageView4.setVisibility(View.INVISIBLE);
        imageView5 = findViewById(R.id.imageView5);
        imageView5.setVisibility(View.INVISIBLE);

    }

    public void onClickStartButton(View v){
        Toast.makeText(this, "Starting", Toast.LENGTH_LONG).show();
        globalView = v;
        handleAnimation(v);
    }

    private void handleAnimation(View v){

            animateAll(v);

    }

    private void animateAll(View v){

        imageView1.setX(random.nextInt((int)v.getX()));
        imageView2.setX(random.nextInt((int)v.getX()));
        imageView3.setX(random.nextInt((int)v.getX()));
        imageView4.setX(random.nextInt((int)v.getX()));
        imageView5.setX(random.nextInt((int)v.getX()));

        v = (View)v.getParent();

        imageView1.setY(random.nextInt(v.getBottom()));
        imageView2.setY(random.nextInt(v.getBottom()));
        imageView3.setY(random.nextInt(v.getBottom()));
        imageView4.setY(random.nextInt(v.getBottom()));
        imageView5.setY(random.nextInt(v.getBottom()));


        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.VISIBLE);
        imageView3.setVisibility(View.VISIBLE);
        imageView4.setVisibility(View.VISIBLE);
        imageView5.setVisibility(View.VISIBLE);

        int randomval = random.nextInt(globalDuration);
        ObjectAnimator animator1ScaleUpX = ObjectAnimator.ofFloat(imageView1, "scaleX", 0,1).setDuration(randomval);
        ObjectAnimator animator1ScaleUpY = ObjectAnimator.ofFloat(imageView1, "scaleY", 0,1).setDuration(randomval);

        randomval = random.nextInt(globalDuration);
        ObjectAnimator animator2ScaleUpX = ObjectAnimator.ofFloat(imageView2, "scaleX", 0,1).setDuration(randomval);
        ObjectAnimator animator2ScaleUpY = ObjectAnimator.ofFloat(imageView2, "scaleY", 0,1).setDuration(randomval);

        randomval = random.nextInt(globalDuration);
        ObjectAnimator animator3ScaleUpX = ObjectAnimator.ofFloat(imageView3, "scaleX", 0,1).setDuration(randomval);
        ObjectAnimator animator3ScaleUpY = ObjectAnimator.ofFloat(imageView3, "scaleY", 0,1).setDuration(randomval);

        randomval = random.nextInt(globalDuration);
        ObjectAnimator animator4ScaleUpX = ObjectAnimator.ofFloat(imageView4, "scaleX", 0,1).setDuration(randomval);
        ObjectAnimator animator4ScaleUpY = ObjectAnimator.ofFloat(imageView4, "scaleY", 0,1).setDuration(randomval);

        randomval = random.nextInt(globalDuration);
        ObjectAnimator animator5ScaleUpX = ObjectAnimator.ofFloat(imageView5, "scaleX", 0,1).setDuration(randomval);
        ObjectAnimator animator5ScaleUpY = ObjectAnimator.ofFloat(imageView5, "scaleY", 0,1).setDuration(randomval);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animator1ScaleUpX, animator1ScaleUpY, animator2ScaleUpX, animator2ScaleUpY, animator3ScaleUpX, animator3ScaleUpY, animator4ScaleUpX, animator4ScaleUpY, animator5ScaleUpX, animator5ScaleUpY);
        animatorSet.start();

        try {
            Thread.sleep(random.nextInt(globalDuration));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        randomval = random.nextInt(globalDuration);
        ObjectAnimator animator1ScaleDownX = ObjectAnimator.ofFloat(imageView1, "scaleX", 1,0).setDuration(randomval);
        ObjectAnimator animator1ScaleDownY = ObjectAnimator.ofFloat(imageView1, "scaleY", 1,0).setDuration(randomval);

        randomval = random.nextInt(globalDuration);
        ObjectAnimator animator2ScaleDownX = ObjectAnimator.ofFloat(imageView2, "scaleX", 1,0).setDuration(randomval);
        ObjectAnimator animator2ScaleDownY = ObjectAnimator.ofFloat(imageView2, "scaleY", 1,0).setDuration(randomval);

        randomval = random.nextInt(globalDuration);
        ObjectAnimator animator3ScaleDownX = ObjectAnimator.ofFloat(imageView3, "scaleX", 1,0).setDuration(randomval);
        ObjectAnimator animator3ScaleDownY = ObjectAnimator.ofFloat(imageView3, "scaleY", 1,0).setDuration(randomval);

        randomval = random.nextInt(globalDuration);
        ObjectAnimator animator4ScaleDownX = ObjectAnimator.ofFloat(imageView4, "scaleX", 1,0).setDuration(randomval);
        ObjectAnimator animator4ScaleDownY = ObjectAnimator.ofFloat(imageView4, "scaleY", 1,0).setDuration(randomval);

        randomval = random.nextInt(globalDuration);
        ObjectAnimator animator5ScaleDownX = ObjectAnimator.ofFloat(imageView5, "scaleX", 1,0).setDuration(randomval);
        ObjectAnimator animator5ScaleDownY = ObjectAnimator.ofFloat(imageView5, "scaleY", 1,0).setDuration(randomval);
        animator5ScaleDownY.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }
            @Override
            public void onAnimationStart(Animator animation) {
                // ...
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // ...
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animateAll(globalView);
            }


        });

        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(animator1ScaleDownX, animator1ScaleDownY, animator2ScaleDownX, animator2ScaleDownY, animator3ScaleDownX, animator3ScaleDownY, animator4ScaleDownX, animator4ScaleDownY, animator5ScaleDownX, animator5ScaleDownY);
        animatorSet2.start();

    }


}

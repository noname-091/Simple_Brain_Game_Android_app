package my.app.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {


    public ImageView img1, img2, img3, img4;
    private List<ImageView> list;
    private boolean a=false, b=false, c=false, d=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        list = new ArrayList<>();

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale1);
        if (id == img1.getId()){
            img1.startAnimation(animation);
            a = true;
            animation.setAnimationListener(this);
        }
        else if (id == img2.getId()){
            img2.startAnimation(animation);
            b = true;
            animation.setAnimationListener(this);
        }
        else if (id == img3.getId()){
            img3.startAnimation(animation);
            c = true;
            animation.setAnimationListener(this);
        }
        else if (id == img4.getId()){
            img4.startAnimation(animation);
            d = true;
            animation.setAnimationListener(this);
        }


    }



    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.scale2);

        if (list.size() == 2){
            if(list.get(0).getTag() == list.get(1).getTag() && list.get(0) != list.get(1)){
                list.get(0).setVisibility(View.INVISIBLE);
                list.get(1).setVisibility(View.INVISIBLE);
                list.clear();
            }else {
                list.get(0).startAnimation(animation);
                list.get(0).setImageResource(R.drawable.stars);
                list.get(0).startAnimation(animation1);

                list.get(1).startAnimation(animation);
                list.get(1).setImageResource(R.drawable.stars);
                list.get(1).startAnimation(animation1);
                list.clear();
            }

        }
        else {
            if (a) {
                img1.setImageResource(R.drawable.ice);
                img1.startAnimation(animation1);
                list.add(img1);
                a = false;
            } else if (b) {
                img2.setImageResource(R.drawable.ice);
                img2.startAnimation(animation1);
                list.add(img2);
                b = false;
            }else if (c) {
                img3.setImageResource(R.drawable.ice);
                img3.startAnimation(animation1);
                list.add(img3);
                c = false;
            }else if (d) {
                img4.setImageResource(R.drawable.ice);
                img4.startAnimation(animation1);
                list.add(img4);
                d = false;
            }

            animation1.setAnimationListener(this);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
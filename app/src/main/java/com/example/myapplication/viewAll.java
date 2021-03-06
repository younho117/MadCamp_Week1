package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;
import static com.example.myapplication.Fragment2.favImgs;
import static com.example.myapplication.Fragment2.heart_toggled;


public class viewAll extends AppCompatActivity {

    ImageView imageView;
    ImageView chooseImg;
    ToggleButton heart;
    ToggleButton other_heart;


    int[] img_id = {R.id.imglist1, R.id.imglist2, R.id.imglist3, R.id.imglist4, R.id.imglist5, R.id.imglist6, R.id.imglist7, R.id.imglist8, R.id.imglist9, R.id.imglist10,
            R.id.imglist11, R.id.imglist12, R.id.imglist13, R.id.imglist14, R.id.imglist15, R.id.imglist16, R.id.imglist17, R.id.imglist18, R.id.imglist19, R.id.imglist20};
    int[] img_src = {R.drawable.white, R.drawable.green, R.drawable.sky, R.drawable.mountain, R.drawable.rainbow, R.drawable.clock, R.drawable.red, R.drawable.purple, R.drawable.computer, R.drawable.orange,
            R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4, R.drawable.cat5, R.drawable.cat6, R.drawable.goose1, R.drawable.cat7, R.drawable.cat8, R.drawable.cat9};
    int[] heart_id = {R.id.heart1, R.id.heart2, R.id.heart3, R.id.heart4, R.id.heart5, R.id.heart6, R.id.heart7, R.id.heart8, R.id.heart9, R.id.heart10,
            R.id.heart11, R.id.heart12, R.id.heart13, R.id.heart14, R.id.heart15, R.id.heart16, R.id.heart17, R.id.heart18, R.id.heart19, R.id.heart20};

    static int favnum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        imageView = findViewById(R.id.viewImg);

        final int[] delete = new int[img_id.length];
        for (int i=0; i<img_id.length; i++){
            int finalI = i;
            heart = findViewById(heart_id[finalI]);
            heart.setChecked(heart_toggled[finalI]);

            if (heart_toggled[finalI]){
                heart.setBackgroundDrawable(getResources().getDrawable(R.drawable.fullheart));
            }
            else{
                heart.setBackgroundDrawable(getResources().getDrawable(R.drawable.emptyheart));
            }

            heart.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    if (heart.isChecked()){
                        heart.setBackgroundDrawable(getResources().getDrawable(R.drawable.fullheart));
                        view_favorite vf = new view_favorite();
                        delete[finalI] = favImgs.size();
                        vf.addfavImgs(new favImg(img_src[finalI]));
                        heart_toggled[finalI] = true;
                        favnum++;
                    }
                    else{
                        heart.setBackgroundDrawable(getResources().getDrawable(R.drawable.emptyheart));
                        view_favorite vf = new view_favorite();
                        favImgs.remove(delete[finalI]);
                        heart_toggled[finalI] = false;
                        favnum--;
                    }
                }
            });

            chooseImg = findViewById(img_id[finalI]);
            chooseImg.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    heart = findViewById(heart_id[finalI]);
                    imageView.setImageResource(img_src[finalI]);

                    for (int j=0; j<img_id.length; j++){
                        other_heart = findViewById(heart_id[j]);
                        other_heart.setVisibility(View.INVISIBLE);
                    }
                    heart.setVisibility(View.VISIBLE);
                }
            });
            heart.setVisibility(View.INVISIBLE);
            heart_toggled[finalI] = heart.isChecked();
        }
    }
}


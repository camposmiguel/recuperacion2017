package com.miguelcr.a01_constraintlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.imageViewFotoHotel) ImageView fotoHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Picasso.with(this).load("https://images.trvl-media.com/hotels/1000000/150000/140600/140596/140596_275_z.jpg")
                .resize(100,150)
                .into(fotoHotel);


    }
}

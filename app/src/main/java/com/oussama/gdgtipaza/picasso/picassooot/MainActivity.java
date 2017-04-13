package com.oussama.gdgtipaza.picasso.picassooot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    ImageView imageView;
    ProgressBar progressBar;
    String url ="http://streamsystem.com/catalogue/Photo/allin.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.btn);
        imageView = (ImageView)findViewById(R.id.img);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn) {
            Picasso.with(this)
                    .load(url)
                    .resize(500, 800)
                    .error(R.drawable.warning)
                    .into(imageView, new Callback.EmptyCallback() {
                        @Override
                        public void onSuccess() {
                            progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                            progressBar.setVisibility(View.GONE);
                        }
                    });

            Picasso.with(this)
                    .load(url)
                    .into(imageView);



        }
    }
}

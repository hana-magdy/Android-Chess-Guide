package com.example.chessguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {
    TextView tvDetails;
    String[] Details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails= findViewById(R.id.tvDetails);
        Details=getResources().getStringArray(R.array.descriptions);
        tvDetails.setText(Details[0]);

    }

    @Override
    public void OnItemSelection(int index) {
        tvDetails.setText(Details[index]);
    }
}

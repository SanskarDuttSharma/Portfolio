package com.example.porfolioapp.home;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.porfolioapp.R;

public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.fragment_home,container,false);



    }



    public void open(View view){
        Intent bintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
        startActivity(bintent);
    }

}

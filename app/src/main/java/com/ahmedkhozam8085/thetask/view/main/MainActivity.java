package com.ahmedkhozam8085.thetask.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.ahmedkhozam8085.thetask.R;
import com.ahmedkhozam8085.thetask.adapter.DataAdapter;
import com.ahmedkhozam8085.thetask.model.home.Data;
import com.ahmedkhozam8085.thetask.model.home.DataItem;
import com.ahmedkhozam8085.thetask.model.profile.Profile;
import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DataAdapter dataAdapter;
    TextView posts,followers,following,name,location,bio;
    CircleImageView profileImage;
    MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts = findViewById(R.id.txtPosts);
        followers = findViewById(R.id.txtfollowers);
        following = findViewById(R.id.txtFollowing);
        name = findViewById(R.id.txtFullName);
        location = findViewById(R.id.txtLocation);
        bio = findViewById(R.id.txtBio);
        profileImage = findViewById(R.id.imgProfile);
        
        mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getAllDatafromjson();
        mainActivityViewModel.getProfileDatafromjson();
        mainActivityViewModel.allDataMutableLiveData.observe(this, new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                getPopularData(data.getData());

            }
        });

        mainActivityViewModel.profileMutableLiveData.observe(this, new Observer<Profile>() {
            @Override
            public void onChanged(Profile profile) {
                 populateProfileData(profile);


            }
        });
    }

    private void populateProfileData(Profile profile) {
        posts.setText(String.valueOf(profile.getData().getCounts().getPosts()));
        followers.setText(String.valueOf(profile.getData().getCounts().getFollowers()));
        following.setText(String.valueOf(profile.getData().getCounts().getFollowing()));
        name.setText(profile.getData().getFullName());
        location.setText(profile.getData().getLocation());
        bio.setText(profile.getData().getBio());
        Glide.with(getApplicationContext()).load(profile.getData().getProfilePicture()).into(profileImage);
    }

    private void  getPopularData(List<DataItem> popularList){
        recyclerView = findViewById(R.id.recyclerImages);
        dataAdapter = new DataAdapter(this, popularList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(dataAdapter);

    }
}
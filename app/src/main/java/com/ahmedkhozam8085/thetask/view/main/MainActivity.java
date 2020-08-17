package com.ahmedkhozam8085.thetask.view.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
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

    TextView profileNameTV;
    TextView LocationTV;
    TextView bioTV;
    TextView postsTV;
    TextView followersTV;
    TextView FollowingTV;
    RecyclerView imagesRV;
    DataAdapter dataAdapter;
    GridLayoutManager gridLayoutManager;
    ConstraintLayout constraintLayout;
    CardView cardView;
    String TAG = "MainActivity";
    de.hdodenhof.circleimageview.CircleImageView profile_iv;
    MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        constraintLayout = findViewById(R.id.constraintLayout);

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


        profileNameTV = findViewById(R.id.profileName_tv);
        LocationTV = findViewById(R.id.Location_tv);
        bioTV = findViewById(R.id.bio_tv);
        postsTV = findViewById(R.id.posts_tv);
        followersTV = findViewById(R.id.followers_tv);
        FollowingTV = findViewById(R.id.following_tv);
        profile_iv = findViewById(R.id.profile_iv);

        profileNameTV.setText(profile.getData().getFullName());
        LocationTV.setText(profile.getData().getLocation());
        bioTV.setText(profile.getData().getBio());
        postsTV.setText(String.valueOf(profile.getData().getCounts().getPosts()));
        followersTV.setText(String.valueOf(profile.getData().getCounts().getFollowers()));
        FollowingTV.setText(String.valueOf(profile.getData().getCounts().getFollowing()));

        Glide.with(this).load(profile.getData().getProfilePicture())
                .into(profile_iv);
    }

    private void  getPopularData(List<DataItem> popularList){
        imagesRV = findViewById(R.id.images_rv);
        dataAdapter = new DataAdapter(this, popularList);
        imagesRV.setLayoutManager(new GridLayoutManager(this, 2));
        imagesRV.setHasFixedSize(true);
        imagesRV.setAdapter(dataAdapter);

        imagesRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {
                    // Do something
                } else if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    // Do something
                  //  setLayoutVisibilityToGone();
                } else {
                    // Do something
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    // Scrolling up
                    setLayoutVisibilityToGone();
                } else {
                    // Scrolling down
                }
            }
        });

    }

    private void setLayoutVisibilityToGone() {
        constraintLayout.setVisibility(View.GONE);
    }
}
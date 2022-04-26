package com.project.favourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.PopupMenu;
import android.widget.VideoView;

// Credits for sample lecture video:
// https://www.youtube.com/watch?v=xbpUHSKoALg

public class VideoSession extends AppCompatActivity {

    ImageButton settingsButton;
    ImageButton camButton;
    ImageButton screenButton;

    // Video to play to emulate lecture
    VideoView sessionVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_session);

        // Referencing and Initializing the buttons
        settingsButton = findViewById(R.id.settingsBtn);
        camButton = findViewById(R.id.camBtn);
        screenButton = findViewById(R.id.screenBtn);

        // Set video stuff
        sessionVideo = findViewById(R.id.videoView);
        sessionVideo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.session_video_crop);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(sessionVideo);
        sessionVideo.setMediaController(mediaController);


        // Setting onClick behavior to the settingsButton
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initializing the popup menu and giving the reference as current context
                // popupMenu is our settings menu!
                PopupMenu popupMenu = new PopupMenu(VideoSession.this, settingsButton);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.settings_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
//                        Toast.makeText(VideoSession.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();

                        // Put case statements here to do things depending on menu choice

                        return true;
                    }
                });

                // Showing the popup menu
                popupMenu.show();
            }
        });

        camButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start VideoSession activity if we click the cam button
                Intent i = new Intent(VideoSession.this, VideoSession.class);
                startActivity(i);
            }
        });

        // Write a listener for screenButton to change to screen sharing mode (create another activity!)

        // Implement whiteboard capabilities for the whiteboard button?




    }
}
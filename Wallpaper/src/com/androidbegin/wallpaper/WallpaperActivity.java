package com.androidbegin.wallpaper;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.app.WallpaperManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class WallpaperActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Wallpaper Tutorial");
        setContentView(R.layout.main_wallpaper);
        
        // Find the Button in main_wallpaper.xml
        Button SetWallpaperButton = (Button)findViewById(R.id.button);
        
        // Find the ImageView in main_wallpaper.xml
        ImageView ImagePreview = (ImageView)findViewById(R.id.image);

        // Attached the image into main_wallpaper.xml 
        ImagePreview.setImageResource(R.drawable.sample_wallpaper);
       
        // Listening to Button click
        SetWallpaperButton.setOnClickListener(new Button.OnClickListener(){

        	public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		
        		// Retrieve a WallpaperManager associated with the given Context. 
        		WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        		
        		try {
        			// Change the current system wallpaper to the bitmap in the given resource. 
        			myWallpaperManager.setResource(R.drawable.sample_wallpaper);
        			
        			// Notify the user on successful change
        			Toast.makeText(WallpaperActivity.this, "Wallpaper successfully changed", Toast.LENGTH_SHORT).show();
        			
        			// Catch exceptions
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	}
        	});
        }

    // Not using options menu for this tutorial
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_wallpaper, menu);
        return true;
    }
}

package com.androidbegin.wallpapertutorial;

import java.io.IOException;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.WallpaperManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml
		setContentView(R.layout.activity_main);

		// Create an actionbar
		ActionBar actionBar = getActionBar();
		actionBar.show();

		// Locate ImageView in activity_main.xml
		ImageView mywallpaper = (ImageView) findViewById(R.id.wallpaper);

		// Attach image into ImageView
		mywallpaper.setImageResource(R.drawable.wallpaper);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Create an actionbar menu
		menu.add("Set as Wallpaper")
				// Add a new Menu Button
				.setOnMenuItemClickListener(this.SetWallpaperClickListener)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		return super.onCreateOptionsMenu(menu);
	}

	// Capture actionbar menu item click
	OnMenuItemClickListener SetWallpaperClickListener = new OnMenuItemClickListener() {

		public boolean onMenuItemClick(MenuItem item) {

			// Retrieve a WallpaperManager
			WallpaperManager myWallpaperManager = WallpaperManager
					.getInstance(MainActivity.this);

			try {
				// Change the current system wallpaper
				myWallpaperManager.setResource(R.drawable.wallpaper);

				// Show a toast message on successful change
				Toast.makeText(MainActivity.this,
						"Wallpaper successfully changed", Toast.LENGTH_SHORT)
						.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
			}

			return false;
		}
	};
}

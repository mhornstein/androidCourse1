package course.labs.activitylab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityOne extends CountingActivity {
	private final String TAG = "Lab-ActivityOne";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);

		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(ActivityOne.this, ActivityTwo.class);
				startActivity(myIntent);
			}
		});
		
		loadTextView();
		// Has previous state been saved?
		if (savedInstanceState != null) {
			loadCounters(savedInstanceState);
		}

		// Emit LogCat message
		Log.i(getTag(), "Entered the onCreate() method");

		mCreate++;
	}

	@Override
	protected String getTag() {
		return this.TAG;
	}

}

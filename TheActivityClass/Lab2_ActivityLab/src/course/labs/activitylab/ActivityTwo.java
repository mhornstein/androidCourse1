package course.labs.activitylab;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityTwo extends CountingActivity {
	private final String TAG = "Lab-ActivityTwo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish(); //we want just to finish, nothing else!
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

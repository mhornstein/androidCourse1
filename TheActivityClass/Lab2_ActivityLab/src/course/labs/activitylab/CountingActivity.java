package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public abstract class CountingActivity extends Activity {
	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// Life cycle counters
	protected int mCreate = 0, mRestart = 0, mStart = 0, mResume = 0;
	protected TextView mTvCreate, mTvRestart, mTvStart, mTvResume;

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(getTag(), "Entered the onStart() method");

		mStart++;
		displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();

		// Emit LogCat message
		Log.i(getTag(), "Entered the onResume() method");

		mResume++;
		displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();

		// Emit LogCat message
		Log.i(getTag(), "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		// Emit LogCat message
		Log.i(getTag(), "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// Emit LogCat message
		Log.i(getTag(), "Entered the onRestart() method");

		mRestart++;
		displayCounts();
	}


	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(getTag(), "Entered the onDestroy() method");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		saveCounters(outState);
		super.onSaveInstanceState(outState);
	}
	
	protected void loadTextView() {
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);
	}

	protected void loadCounters(Bundle savedInstanceState){
		mCreate = savedInstanceState.containsKey(CREATE_KEY) ? savedInstanceState.getInt(CREATE_KEY) : 0;
		mStart = savedInstanceState.containsKey(START_KEY) ? savedInstanceState.getInt(START_KEY) : 0;
		mResume = savedInstanceState.containsKey(RESUME_KEY) ? savedInstanceState.getInt(RESUME_KEY) : 0;
		mRestart = savedInstanceState.containsKey(RESTART_KEY) ? savedInstanceState.getInt(RESTART_KEY) : 0;
	}

	protected void saveCounters (Bundle savedInstanceState){
		savedInstanceState.putInt(CREATE_KEY, mCreate);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(RESTART_KEY, mRestart);
	}

	protected void displayCounts() {
		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	}

	/**
	 * String for LogCat documentation
	 * @return the tag of the given activity
	 */
	protected abstract String getTag();
}

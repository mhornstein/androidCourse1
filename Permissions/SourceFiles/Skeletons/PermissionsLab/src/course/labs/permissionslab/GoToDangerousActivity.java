package course.labs.permissionslab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GoToDangerousActivity extends Activity {

	private static final String TAG = "Lab-Permissions";

	private static final String DANGEROUS_ACTIVITY_ACTION = "course.labs.permissions.DANGEROUS_ACTIVITY";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.go_to_dangerous_activity);

		Button startDangerousActivityButton = (Button) findViewById(R.id.start_dangerous_activity_button);
		startDangerousActivityButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				startDangerousActivity();

			}
		});

	}

	private void startDangerousActivity() {

		Log.i(TAG, "Entered startDangerousActivity()");

		//implicit activity starting. the argument is a string representing the action
		Intent intent = new Intent("course.labs.permissions.DANGEROUS_ACTIVITY");
		startActivity(intent);


	}

}

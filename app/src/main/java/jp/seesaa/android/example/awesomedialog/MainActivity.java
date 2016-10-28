package jp.seesaa.android.example.awesomedialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.seesaa.android.library.dialog.AwesomeDialogFragment;
import jp.seesaa.android.library.dialog.MaterialDialogFragment;

public class MainActivity extends AppCompatActivity implements AwesomeDialogFragment.Callback {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void clickButton() {
        new MaterialDialogFragment.Builder(this)
                .title("Title")
                .message("Message")
                .positive("Positive")
                .negative("Negative")
                .requestCode(12345)
                .show();
    }

    @Override
    public void onMyDialogSucceeded(int requestCode, int resultCode, Bundle params) {
        Log.d(TAG, "onMyDialogSucceeded: " + requestCode + " / " + resultCode);
        Toast.makeText(this, "Succeeded: " + requestCode, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMyDialogCancelled(int requestCode, Bundle params) {
        Log.d(TAG, "onMyDialogCancelled: " + requestCode);
        Toast.makeText(this, "Cencelled: " + requestCode, Toast.LENGTH_SHORT).show();
    }
}

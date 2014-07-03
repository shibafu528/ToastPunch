package info.shibafu528.toastpunch;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {

    private Handler handler = new Handler();
    private Random random = new Random();
    private TextView textView;
    private int point = 0;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        final Toast toast = Toast.makeText(getApplicationContext(), "（＾ω＾ ≡ ＾ω＾）", Toast.LENGTH_SHORT);
                        switch (random.nextInt(9)) {
                            case 0:
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                break;
                            case 1:
                                toast.setGravity(Gravity.LEFT, 0, 0);
                                break;
                            case 2:
                                toast.setGravity(Gravity.RIGHT, 0, 0);
                                break;
                            case 3:
                                toast.setGravity(Gravity.BOTTOM, 0, 0);
                                break;
                            case 4:
                                toast.setGravity(Gravity.TOP, 0, 0);
                                break;
                            case 5:
                                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                                break;
                            case 6:
                                toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
                                break;
                            case 7:
                                toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
                                break;
                            case 8:
                                toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
                                break;
                        }
                        toast.getView().setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                switch (event.getAction()) {
                                    case MotionEvent.ACTION_UP:
                                        textView.setText(String.valueOf(++point));
                                        toast.cancel();
                                        break;
                                }
                                return true;
                            }
                        });
                        toast.show();
                    }
                });
            }
        }, 400, 400);
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }
}

public class MainActivity extends AppCompatActivity {

    private TextView countdownTimer;
    private Button startButton, stopButton;
    private CountDownTimer timer;
    private boolean timerRunning;
    private long timeLeftInMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownTimer = findViewById(R.id.countdown_timer);
        startButton = findViewById(R.id.start_button);
        stopButton = findViewById(R.id.stop_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timerRunning) {
                    startTimer();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    stopTimer();
                }
            }
        });
    }

    private void startTimer() {
        timer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                startButton.setText("Start");
                stopButton.setVisibility(View.INVISIBLE);
            }
        }.start();

        timerRunning = true;
        startButton.setText("Pause");
        stopButton.setVisibility(View.VISIBLE);
    }

    private void stopTimer() {
        timer.cancel();
        timerRunning = false;
        startButton.setText("Start");
        stopButton.setVisibility(View.INVISIBLE);
    }

    private void updateCountdownText() {
        int hours = (int) (timeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((timeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
        countdownTimer.setText(timeLeftFormatted);
    }

}
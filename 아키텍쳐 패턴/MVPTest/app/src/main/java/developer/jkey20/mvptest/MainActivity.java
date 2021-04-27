package developer.jkey20.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Contract.View {

    Presenter presenter;
    private Button searchButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        searchButton = (Button) findViewById(R.id.time_serch_button);
        textView = (TextView) findViewById(R.id.time_textview);

        searchButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                presenter.getCurrentTime();
            }
        });
    }

    @Override
    public void changeText(Time time) {
        textView.setText(time.getHour() + "시" + time.getMinute() + "분");
    }
}
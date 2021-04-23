package developer.jkey20.roomtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameEditText = findViewById(R.id.name_edittext);
        EditText pwEditText = findViewById(R.id.password_edittext);
        Button insertButton = findViewById(R.id.insert_button);
        Button deleteButton = findViewById(R.id.delete_button);
        Button getAllButton = findViewById(R.id.getall_button);
        TextView resultTextView = findViewById(R.id.result_textview);
        AppDatabase appDatabase = AppDatabase.getAddDatabase(this);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.name = nameEditText.getText().toString();
                user.pw = pwEditText.getText().toString();
                new Thread(){
                    public void run(){
                        appDatabase.userDao().insert(user);
                    }
                }.start();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.name = nameEditText.getText().toString();
                user.pw = pwEditText.getText().toString();
                new Thread(){
                    public void run(){
                        appDatabase.userDao().delete(user);
                    }
                }.start();
            }
        });
        getAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    public void run(){
                        List<User> userList = appDatabase.userDao().getAll();
                        String result = "";
                        for(User user : userList){
                            result += "name : " + user.name + "\n" + "pw : " + user.pw + "\n";

                        }
                        resultTextView.setText(result);
                    }
                }.start();
            }
        });
    }
}

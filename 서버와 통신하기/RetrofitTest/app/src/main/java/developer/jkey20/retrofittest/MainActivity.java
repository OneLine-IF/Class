package developer.jkey20.retrofittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText titleEditText = findViewById(R.id.title_editText);
        EditText contentEditText = findViewById(R.id.content_edittext);
        EditText idEditText =  findViewById(R.id.id_edittext);
        Button postButton =  findViewById(R.id.post_button);
        Button updateButton = findViewById(R.id.update_button);
        Button deleteButton = findViewById(R.id.delete_button);
        Button getButton = findViewById(R.id.get_button);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://interface-app-dev.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ArrayList<Notice>> getNotice = apiService.findAll();
                getNotice.enqueue(new Callback<ArrayList<Notice>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Notice>> call, Response<ArrayList<Notice>> response) {
                        recyclerAdapter.setNoticeArrayList(response.body());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Notice>> call, Throwable t) {
                        Log.e("Error", t.getMessage());
                    }
                });
            }
        });



    }
}
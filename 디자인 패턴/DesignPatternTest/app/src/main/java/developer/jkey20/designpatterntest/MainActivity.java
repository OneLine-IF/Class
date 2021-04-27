package developer.jkey20.designpatterntest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import developer.jkey20.designpatterntest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnimalDatabase animalDatabase = AnimalDatabase.getAnimalDatabase(this);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Observer<ArrayList<Animal>> zooObserver = new Observer<ArrayList<Animal>>() {
            @Override
            public void onChanged(ArrayList<Animal> animals) {
                String result = binding.resultText.getText().toString();
                Log.i("result", result);
                for (Animal animal : animals) {
                    result += " " + animal.name;
                }
                binding.resultText.setText(result);
            }
        };
        viewModel.zoo.observe(this, zooObserver);
        binding.dbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DatabaseActivity.class);
                startActivity(intent);
            }
        });
        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        Animal animal = new Animal();
                        animal.setName(binding.nameEdittext.getText().toString());
                        animal.setBirth(binding.birthEdittext.getText().toString());

                        viewModel.addZoo(
                                binding.nameEdittext.getText().toString(),
                                binding.birthEdittext.getText().toString(),
                                binding.speciesEdittext.getText().toString()
                        );
                        animalDatabase.animalDao().insert(animal);
                    }
                }.start();
            }
        });

    }
}
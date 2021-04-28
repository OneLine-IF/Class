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
import java.util.List;

import developer.jkey20.designpatterntest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnimalDatabase animalDatabase = AnimalDatabase.getAnimalDatabase(this);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Observer<List<Cat>> catListObserver = new Observer<List<Cat>>() {
            @Override
            public void onChanged(List<Cat> cats) {
                String result = "";
                for (Cat cat : cats) {
                    result += cat.name + " ";
                }
                binding.catResultTextview.setText(result);
            }
        };
        Observer<List<Dog>> dogListObserver = new Observer<List<Dog>>() {

            @Override
            public void onChanged(List<Dog> dogs) {
                String result = "";
                for (Dog dog : dogs) {
                    result += dog.name + " ";
                }
                binding.dogResultText.setText(result);
            }
        };
        viewModel.catList.observe(this, catListObserver);
        viewModel.dogList.observe(this, dogListObserver);

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal animal = null;
                if (binding.speciesEdittext.getText().toString().equals("고양이")) {
                    animal = new Cat();
                    animal.setName(binding.nameEdittext.getText().toString());
                    animal.setBirth(binding.birthEdittext.getText().toString());
                    viewModel.addCatList((Cat) animal);
                } else if (binding.speciesEdittext.getText().toString().equals("강아지")) {
                    animal = new Dog();
                    animal.setName(binding.nameEdittext.getText().toString());
                    animal.setBirth(binding.birthEdittext.getText().toString());
                    viewModel.addDogList((Dog) animal);
                }
            }
        });

    }
}
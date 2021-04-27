package developer.jkey20.designpatterntest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    MutableLiveData<ArrayList<Animal>> zoo = new MutableLiveData<ArrayList<Animal>>();

    ArrayList<Animal> zooList = new ArrayList<>();

    public void addZoo(String name, String birth, String species){

        Animal animal = null;

        if(species.equals("고양이")){
            animal = new Cat();
            animal.setName(name);
            animal.setBirth(birth);
        }
        else if(species.equals("강아지")){
            animal = new Dog();
            animal.setName(name);
            animal.setBirth(birth);
        }
        zooList.add(animal);
        zoo.postValue(zooList);

    }

}

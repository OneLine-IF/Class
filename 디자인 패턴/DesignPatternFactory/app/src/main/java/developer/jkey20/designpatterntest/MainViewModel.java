package developer.jkey20.designpatterntest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<Cat>> catList = new MutableLiveData<List<Cat>>();
    ArrayList<Cat> _catList = new ArrayList<>();

    MutableLiveData<List<Dog>> dogList = new MutableLiveData<List<Dog>>();
    ArrayList<Dog> _dogList = new ArrayList<>();



    public void addCatList(Cat animal){
       _catList.add(animal);
       catList.postValue(_catList);
    }
    public void addDogList(Dog animal){
        _dogList.add(animal);
        dogList.postValue(_dogList);
    }
}

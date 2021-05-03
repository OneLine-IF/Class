package developer.jkey20.designpatterntest;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    Repository repository = Repository.getInstance();

    MutableLiveData<List<Cat>> catList = new MutableLiveData<List<Cat>>();
    ArrayList<Cat> _catList = new ArrayList<>();

    MutableLiveData<List<Dog>> dogList = new MutableLiveData<List<Dog>>();
    ArrayList<Dog> _dogList = new ArrayList<>();

    public void addCatList(Cat animal) {
        _catList.add(animal);
        catList.postValue(_catList);
    }


    public void addDogList(Dog animal) {
        _dogList.add(animal);
        dogList.postValue(_dogList);
    }

    public void setDB(Application application){
        repository.setDataBase(application);
    }

    public List<Animal> getList() {
        return repository.getAnimals();
    }
    public void addDB(Animal animal){
        repository.addAnimal(animal);
    }
}

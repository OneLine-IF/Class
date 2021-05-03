package developer.jkey20.designpatterntest;

import android.app.Application;

import java.util.List;

public class Repository {

    private volatile static Repository INSTANCE;
    private AnimalDatabase animalDatabase;
    private AnimalDao animalDao;

    public Repository() {
    }

    public static Repository getInstance() {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Repository();
                }
            }
        }
        return INSTANCE;
    }

    public void setDataBase(Application application) {
        animalDatabase = AnimalDatabase.getAnimalDatabase(application);
        animalDao = animalDatabase.animalDao();
    }

    public List<Animal> getAnimals() {
        return animalDatabase.animalDao().getAll();
    }
    public void addAnimal(Animal animal){
        animalDatabase.animalDao().insert(animal);
    }
}

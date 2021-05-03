package developer.jkey20.designpatterntest;

public class TypeAnimalFactory {
    public Animal getAnimal(AnimalFactory animalFactory){
        return animalFactory.createAnimal();
    }
}


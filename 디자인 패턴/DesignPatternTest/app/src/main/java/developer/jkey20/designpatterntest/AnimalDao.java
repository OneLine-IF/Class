package developer.jkey20.designpatterntest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalDao {

    @Query("SELECT * FROM ANIMAL")
    List<Animal> getAll();

    @Insert
    void insert(Animal animal);

    @Delete
    void delete(Animal animal);
}

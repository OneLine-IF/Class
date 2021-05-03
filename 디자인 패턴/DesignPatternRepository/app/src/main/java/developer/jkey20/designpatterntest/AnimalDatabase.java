package developer.jkey20.designpatterntest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Animal.class, version = 1)
public abstract class AnimalDatabase extends RoomDatabase {
    private static AnimalDatabase INSTANCE;

    public abstract AnimalDao animalDao();

    public static AnimalDatabase getAnimalDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AnimalDatabase.class, "animal-db").build();
        }
        return INSTANCE;
    }
}

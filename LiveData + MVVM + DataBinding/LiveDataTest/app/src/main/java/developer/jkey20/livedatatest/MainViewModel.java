package developer.jkey20.livedatatest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<User> userData = new MutableLiveData<>();

    public void setUserData(){
        User user = getUserData();
        userData.setValue(user);
    }


    private User getUserData(){
        User user = new User();
        user.name = "홍길동";
        user.phoneNumber = "010-0000-0000";

        return user;
    }

}

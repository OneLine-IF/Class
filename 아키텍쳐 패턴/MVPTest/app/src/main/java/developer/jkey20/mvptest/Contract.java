package developer.jkey20.mvptest;

public interface Contract {
    interface View{
        void changeText(Time time);
    }

    interface Presenter{
        void getCurrentTime();
    }
}

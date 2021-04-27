package developer.jkey20.mvptest;

import java.time.LocalTime;
import java.util.Calendar;

import developer.jkey20.mvptest.Contract.View;

public class Presenter implements Contract.Presenter{

    View view;
    Time time;

    public Presenter(Contract.View view) {
        this.view = view;
        this.time = new Time();
    }

    @Override
    public void getCurrentTime() {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        time.setTime(hour, minute);

        view.changeText(time);

    }
}

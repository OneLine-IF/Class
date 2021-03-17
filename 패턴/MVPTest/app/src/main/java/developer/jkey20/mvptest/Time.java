package developer.jkey20.mvptest;

public class Time {
    int hour;
    int minute;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }


    public void setTime(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }
}

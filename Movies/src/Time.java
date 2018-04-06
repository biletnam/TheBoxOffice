public class Time {

    private long initial;
    public Time(long initial){
        this.initial = initial;
    }

    public long getSeconds(long milli){
        milli -= initial;
        return (milli / 1000) % 60;
    }

    public long getMinutes(long milli){
        milli -= initial;
        return (milli / (1000 * 60)) % 60;
    }

    public long getHours(long milli){
        milli -= initial;
        return (milli / (1000 * 60 * 60)) % 12;
    }
}

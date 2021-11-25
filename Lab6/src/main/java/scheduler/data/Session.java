package scheduler.data;

public class Session {

    public Bucket[] getDays() {
        return days;
    }

    public void setDays(Bucket[] days) {
        this.days = days;
    }

    private Bucket[] days = {
        new Bucket(),
        new Bucket(),
        new Bucket(),
        new Bucket(),
        new Bucket(),
        new Bucket(),
        new Bucket()
    };
}

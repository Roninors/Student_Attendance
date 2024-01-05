package fetchData;

public class Attendance {
    private boolean is_present;
    private int date;

    public boolean getIsPresent(){
        return is_present;
    }

    public int getDate(){
        return date;
    }

    public void setIsPresent(boolean is_present){
        this.is_present = is_present;
    }

    public void setDate(int date){
        this.date = date;
    };
}

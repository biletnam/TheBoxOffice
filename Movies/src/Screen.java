import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Screen {

    private String movie;
    private int[] tickets = {30, 30, 30, 30, 30, 30};
    private ArrayList<String> times = new ArrayList<>(Arrays.asList("10:00 PM", "12:00 AM", "2:00 PM", "4:00 PM", "6:00 PM", "8:00 PM", "10:00 PM", "12:00 PM"));

    public Screen(String movie, int numOfTickets){
        this.movie = movie;
        for(int i = 0; i < 7; i++){
            tickets[i] = numOfTickets;
        }
    }

    public Screen(String movie){
        this.movie = movie;
    }

    public String getMovie(){
        return movie;
    }

    public void setMovie(String movie){
        this.movie = movie;
    }

//    public void ticketsSold(int ticketsBought,){
//        tickets -= ticketsBought;
//    }
//
//    public int getTicketSales(){
//        return  tickets;
//    }

    public List<String> getTimes(int currentTime, int dayLength) {

        for(int i = 0; i <= dayLength; i += 3){
            System.out.print(i+"    ");
            System.out.println(times.subList(currentTime % 6, 7));
        }


       if(currentTime == 0){
           return times;
       }
       else if(currentTime <= 3){
            return times.subList(1,6);
       }
       else if(currentTime <= 6)

    }

    public String toString(){
        return "This screen is playing "+movie+" and has "+tickets+" remaining.";
    }
}


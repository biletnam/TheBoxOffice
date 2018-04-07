import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Screen {

    private String movie;
    private int[] tickets = {30, 30, 30, 30, 30, 30, 30, 30};
    private ArrayList<String> times = new ArrayList<>(Arrays.asList("10:00", "12:00", "14:00", "16:00", "18:00", "20:00", "22:00", "24:00"));
    private Scanner scanner = new Scanner(System.in);
    int timeIndex;

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
//        for(int i = 0; i <= dayLength / 1000; i += 6){
//            System.out.print(i+"    "+currentTime+"    "+currentTime / 6);
            System.out.println("The current available times are "+ times.subList( currentTime / 6, 8) +"\nEnter one of" +
                    " the available times.");
            String time = scanner.nextLine();
            for(int i = 0; i < times.size(); i++){
                if(times.get(i).equals(time)){
                    timeIndex = i;
                }
            }
            System.out.println("How many tickets would you like to buy? There are "+tickets[timeIndex]+
                    " left for the "+times.get(timeIndex)+" showing.");
            int numTickets = scanner.nextInt();
            if(numTickets <= tickets[timeIndex]){
                tickets[timeIndex] -= numTickets;
            }
        return null;
    }

    public String toString(){
        return "This screen is playing "+movie+" and has "+tickets.toString()+" remaining.";
    }
}


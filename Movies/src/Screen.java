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


    public void swapMovies(Screen screen2){
        String placeholder = screen2.getMovie();
        int[] movieTickets = screen2.getTickets();
        screen2.setMovie(movie);
        screen2.setTickets(tickets);
        movie = placeholder;
        tickets = movieTickets;
    }

    public void setTickets(int[] tickets){
        this.tickets = tickets;
    }

    public int[] getTickets(){
        return tickets;
    }
//    public void ticketsSold(int ticketsBought,){
//        tickets -= ticketsBought;
//    }
//
//    public int getTicketSales(){
//        return  tickets;
//    }

    public void getTimes(int currentTime, int dayLength) {
        int numTickets;
        String time = null;
        if(currentTime / 6 < 8) {
            System.out.println("The current available times for " + movie + " are " + times.subList(currentTime / 6, 8) + "\nEnter one of" +
                    " the available times.");
            time = scanner.next();
            for (int i = 0; i < times.size(); i++) {
                if (times.get(i).equals(time)) {
                    timeIndex = i;
                }
            }
            System.out.println("How many tickets would you like to buy? There are " + tickets[timeIndex] +
                    " left for the " + times.get(timeIndex) + " showing.");
            numTickets = tickets[timeIndex] + 1;
            while (numTickets > tickets[timeIndex]) {
                numTickets = scanner.nextInt();
                if (numTickets <= tickets[timeIndex] && numTickets > 0) {
                    tickets[timeIndex] -= numTickets;
                    break;
                }
                System.out.println("There aren't that many tickets left. There are only " + tickets[timeIndex] + " tickets available.");
            }
        }
    }

    public String toString(){
        return movie +" ("+movie.substring(0,1).toUpperCase()+")";
    }

    public String stats(){
        String ticketStats = "This screen is playing "+movie+" and sold tickets for the following times:";
        for(int i = 0; i < times.size(); i++){
            ticketStats += "\n"+tickets[i]+" tickets at "+times.get(i);
        }
        ticketStats += "\n\n";
        return ticketStats;
    }
}


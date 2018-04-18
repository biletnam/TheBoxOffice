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

    /**
     * Creates a theater with a fixed number of tickets and times, but a unique name passed in
     * @param movie the string name of the movie
     */
    public Screen(String movie){
        this.movie = movie;
    }

    /**
     * Gets the name of the movie at the screen
     * @return the string name of the movie at the screen
     */
    public String getMovie(){
        return movie;
    }

    /**
     * Sets the movie name of this screen to a new movie name
     * @param movie the new name of the movie passed by the user
     */
    public void setMovie(String movie){
        this.movie = movie;
    }

    /**
     * Swaps the movies in two separate screens
     * @param screen2 the second screen being swapped with
     */
    public void swapMovies(Screen screen2){
        String placeholder = screen2.getMovie();
        int[] movieTickets = screen2.getTickets();
        screen2.setMovie(movie);
        screen2.setTickets(tickets);
        movie = placeholder;
        tickets = movieTickets;
    }

    /**
     * Sets the number of tickets in the screen for when movies are swapped between theaters
     * @param tickets the number of tickets to set the screen to
     */
    public void setTickets(int[] tickets){
        this.tickets = tickets;
    }

    /**
     * Gets the number of tickets in this screen
     * @return the number of tickets in this screen
     */
    public int[] getTickets(){
        return tickets;
    }

    /**
     * Gets all of the current available times a movie is playing at. Once a time has been picked out the user specifies
     * how many tickets they want and it will check if it is a valid number.
     * @param currentTime the current hour in game
     */
    public void getTimes(int currentTime) {
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

    /**
     * Creates a string of the movie's name and its prefix
     * @return a string of the movie's name and prefix
     */
    public String toString(){
        return movie +" ("+movie.substring(0,1).toUpperCase()+")";
    }

    /**
     * Gets all of the tickets at each hour for this screen and returns them as a string
     * @return a string of all the tickets remaining at each hour
     */
    public String stats(){
        int ticketsSold = 0;
        String ticketStats = "This screen is playing "+movie+" and sold tickets for the following times:";
        for(int i = 0; i < times.size(); i++){
            ticketStats += "\n"+tickets[i]+" tickets at "+times.get(i);
            ticketsSold += 30 - tickets[i];
        }
        ticketStats += "\nThis screen sold a total of "+ticketsSold+" tickets\n\n";
        return ticketStats;
    }
}


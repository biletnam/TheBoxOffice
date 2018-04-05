import java.util.Scanner;

public class StartGame {

    private int ticketSales;
    private final static long INITIAL_TIME = System.currentTimeMillis();
   // private boolean daytime = true;
    private final static long DAY_LENGTH = 42000;




    public static void getMovieTimes(Screen screen){
        screen.getTimes((int)(System.currentTimeMillis() - INITIAL_TIME)/ 1000, (int)DAY_LENGTH / 1000);
    }


    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        boolean daytime = true;
        String movieName;

        Screen one = new Screen("The Shape of Water");
        Screen two = new Screen("Lady Bird");
        Screen three = new Screen("The Big Sick");
        Screen four = new Screen("Get Out");
        Screen five = new Screen("Dunkirk");

        System.out.println("This Movie theater runs on a unique time system where every 3 seconds is equivalent to one hour");
        while(System.currentTimeMillis() - INITIAL_TIME < DAY_LENGTH){
            System.out.println("What movie would you like to see? Your options are The Shape of Water (S), Lady Bird (L), " +
                   "The Big Sick (B), Get Out (G) and Dunkirk (D)" +
                    "\nThe current time is "+((System.currentTimeMillis() - INITIAL_TIME)/ 1000) / 3+" hours");
            movieName = scanner.next();
            switch(movieName){
                case "S":
                    getMovieTimes(one);
                case "L":
                    getMovieTimes(two);
                case "B":
                    getMovieTimes(three);
                case "G":
                    getMovieTimes(four);
                case "D":
                    getMovieTimes(five);
                default:
                    break;
            }
        }
    }


}

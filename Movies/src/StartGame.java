import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        String movieName;
        Time convertTime = new Time(INITIAL_TIME);
        Calendar cal = Calendar.getInstance();

        Screen one = new Screen("The Shape of Water");
        Screen two = new Screen("Lady Bird");
        Screen three = new Screen("The Big Sick");
        Screen four = new Screen("Get Out");
        Screen five = new Screen("Dunkirk");


        System.out.println("This Movie theater runs on a unique time system where every 3 seconds is equivalent to one hour");
        while(System.currentTimeMillis() - INITIAL_TIME < DAY_LENGTH){

            cal.setTimeInMillis(System.currentTimeMillis() - INITIAL_TIME);


            String currentTime = String.format("%02d:00", 10 + (((System.currentTimeMillis() - INITIAL_TIME) / 1000) / 3));
                   // (((System.currentTimeMillis() - INITIAL_TIME) / 100) % 60));



            System.out.println("What movie would you like to see? Your options are The Shape of Water (S), Lady Bird (L), " +
                   "The Big Sick (B), Get Out (G) and Dunkirk (D). If you would like to swap a theater just type \'swap\'" +
                    " and the names of the two movies you want to swap(B G)"+
                    "\nThe current hour is"+"\n"+System.currentTimeMillis()+"\n"+INITIAL_TIME+"   "+currentTime);

            movieName = scanner.nextLine();
            switch(movieName){
                case "S":
                    getMovieTimes(one);
                    break;
                case "L":
                    getMovieTimes(two);
                    break;
                case "B":
                    getMovieTimes(three);
                    break;
                case "G":
                    getMovieTimes(four);
                    break;
                case "D":
                    getMovieTimes(five);
                    break;
                case "swap":
                    System.out.println("To swap the movie playing in a theater just type ")
                default:
                    break;
            }
        }
    }


}

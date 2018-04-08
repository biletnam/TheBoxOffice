import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class StartGame {

    private int ticketSales;
    private final static long INITIAL_TIME = System.currentTimeMillis();
   // private boolean daytime = true;
    private final static long DAY_LENGTH = 42000;


//    Screen one = new Screen("The Shape of Water");
//    Screen two = new Screen("Lady Bird");
//    Screen three = new Screen("The Big Sick");
//    Screen four = new Screen("Get Out");
//    Screen five = new Screen("Dunkirk");

//    public static void getMovieTimes(Screen screen){
//        screen.getTimes((int)(System.currentTimeMillis() - INITIAL_TIME)/ 1000, (int)DAY_LENGTH / 1000);
//    }



    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        String movieName;
        String switchMovies;
        Time convertTime = new Time(INITIAL_TIME);
        Calendar cal = Calendar.getInstance();
        FindScreens findScreens = new FindScreens(INITIAL_TIME, DAY_LENGTH);





        System.out.println("This Movie theater runs on a unique time system where every 3 seconds is equivalent to one hour.");
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        while(System.currentTimeMillis() - INITIAL_TIME < DAY_LENGTH){

            cal.setTimeInMillis(System.currentTimeMillis() - INITIAL_TIME);


            String currentTime = String.format("%02d:00", 9 + (((System.currentTimeMillis() - INITIAL_TIME) / 1000) / 3));
                   // (((System.currentTimeMillis() - INITIAL_TIME) / 100) % 60));



            System.out.println("\nWhat movie would you like to see? Your options are The Shape of Water (S), Lady Bird (L), " +
                   "The Big Sick (B), Get Out (G) and Dunkirk (D).\nIf you would like to swap a theater just type \'swap\'" +
                    "\nThe current hour is "+currentTime);

            movieName = scanner.next();
            findScreens.screenTimes(movieName);
//            if(switchMovies != null){
//                findScreens.screenSwap(movieName, switchMovies);
//            }
        }
        System.out.println("The theater is closing, have a good night!");
        System.out.println(findScreens.getStats());
    }

}

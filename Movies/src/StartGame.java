import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class StartGame {

    private final static long INITIAL_TIME = System.currentTimeMillis();
    private final static long DAY_LENGTH = 42000;

    /**
     * Initializes the game and the timer for it. Stays within a loop until either the user wants to end or the timer
     * passes the 14th in game hour.
     * @param args
     */
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        String movieName;
        Calendar cal = Calendar.getInstance();
        FindScreens findScreens = new FindScreens(INITIAL_TIME, DAY_LENGTH);
        boolean playing = true;

        System.out.println("This Movie theater runs on a unique time system where every 3 seconds is equivalent to one hour, " +
                "and the day immediately begins.\nAfter the timer passes the 14th in game hour, the game will end.");

        while(System.currentTimeMillis() - INITIAL_TIME < DAY_LENGTH && playing){

            cal.setTimeInMillis(System.currentTimeMillis() - INITIAL_TIME);


            String currentTime = String.format("%02d:00", 10 + (((System.currentTimeMillis() - INITIAL_TIME) / 1000) / 3));

            System.out.println("\nHello customer! What movie would you like to see? Your options are "+ findScreens.getScreenOne()+
                    " "+findScreens.getScreenTwo()+" "+findScreens.getScreenThree()+" "+findScreens.getScreenFour()+" "+findScreens.getScreenFive()+""+
                           "\nIf you would like to swap a theater just type \'swap\'" +
                    "\nIf you want to leave the theater type \'end\'"+
                    "\nThe current hour is "+currentTime);

            movieName = scanner.nextLine();
            playing = findScreens.screenTimes(movieName);
        }
        System.out.println("The theater is closing and all the theaters are shutting down now, have a good night!\n");
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(findScreens.getStats());
    }

}

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class StartGame {

    private int ticketSales;
    private final static long INITIAL_TIME = System.currentTimeMillis();
    private final static long DAY_LENGTH = 42000;




    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        String movieName;
        String switchMovies;
        Calendar cal = Calendar.getInstance();
        FindScreens findScreens = new FindScreens(INITIAL_TIME, DAY_LENGTH);
        boolean playing = true;





        System.out.println("This Movie theater runs on a unique time system where every 3 seconds is equivalent to one hour, and it starts the day immediately.");
//        try{
//            Thread.sleep(3000);
//        }catch(Exception e){
//            e.printStackTrace();
//        }

        while(System.currentTimeMillis() - INITIAL_TIME < DAY_LENGTH && playing){

            cal.setTimeInMillis(System.currentTimeMillis() - INITIAL_TIME);


            String currentTime = String.format("%02d:00", 10 + (((System.currentTimeMillis() - INITIAL_TIME) / 1000) / 3));
                   // (((System.currentTimeMillis() - INITIAL_TIME) / 100) % 60));



            System.out.println("\nHello customer! What movie would you like to see? Your options are "+ findScreens.getScreenOne()+//      "The Shape of Water (S), Lady Bird (L), " +
                    " "+findScreens.getScreenTwo()+" "+findScreens.getScreenThree()+" "+findScreens.getScreenFour()+" "+findScreens.getScreenFive()+""+
                   //"The Big Sick (B), Get Out (G) and Dunkirk (D)." +
                           "\nIf you would like to swap a theater just type \'swap\'" +
//                    "\nIf you want the current time type \'time\'"+
                    "\nIf you want to leave the theater type \'end\'"+
                    "\nThe current hour is "+currentTime);

           // if(System.currentTimeMillis() - INITIAL_TIME < DAY_LENGTH) {
                movieName = scanner.nextLine();
                playing = findScreens.screenTimes(movieName);
           // }
//            if(switchMovies != null){
//                findScreens.screenSwap(movieName, switchMovies);
//            }
        }
        System.out.println("The theater is closing, have a good night!\n");
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(findScreens.getStats());
    }

}

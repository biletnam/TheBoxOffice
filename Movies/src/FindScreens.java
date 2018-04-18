import java.util.Scanner;

public class FindScreens {

   private Screen one, two, three, four, five;
   private long initTime, dayLength;
   private Scanner scanner;

    /**
     * Initializes the five theaters and the scanner for checking which movie the user wants to watch
     * @param initTime the time the game was started at
     * @param dayLength the total time the game will be played for
     */
    public FindScreens(long initTime, long dayLength){
        one = new Screen("Shape of Water");
        two = new Screen("Lady Bird");
        three = new Screen("Big Sick");
        four = new Screen("Get Out");
        five = new Screen("Dunkirk");
        this.initTime = initTime;
        this.dayLength = dayLength;
        scanner = new Scanner(System.in);
    }

    /**
     * Checks if the string passed by the user is a movie prefix, end or swap. If the string is a movie name it will
     * get all of the times currently available for the current time.
     * @param movieName the name of the movie the user wants to see, or the other command they want to operate
     * @return only returns false if the user typed in end, otherwise it returns true
     */
    public boolean screenTimes(String movieName) {
        Screen screen = findMovie(movieName.toUpperCase());
        if(movieName.equals("end")){
            return false;
        }
        if (!movieName.equals("swap") && !movieName.equals("time") && screen != null){
            screen.getTimes((int) (System.currentTimeMillis() - initTime) / 1000);
        }
        return true;
    }

    /**
     * Swaps two movie screens based on which two are passed in by the user
     */
    public void screenSwap(){
        System.out.println("Now type the two movies you want to swap (S L).");
        String movie1 = scanner.next();
        String movie2 = scanner.next();
        Screen screen1 = findMovie(movie1);
        Screen screen2 = findMovie(movie2);
        screen1.swapMovies(screen2);
        System.out.println("The movies "+movie1+" and "+movie2+" have successfully been swapped");
    }

    /**
     * Checks the string passed by the user against a list of all the movies and commands that can be used in the game.
     * @param movieName the string movie name passed by the user
     * @return either the screen equivalent to the movie name or just null
     */
    public Screen findMovie(String movieName){
        switch(movieName) {
            case "S":
                return one;
            case "L":
                return two;
            case "B":
                return three;
            case "G":
                return four;
            case "D":
                return five;
            case "SWAP":
                screenSwap();
                break;
            case "END":
                break;
            default:
                System.out.println(movieName+ " isn't in the system");
                break;
        }
        return null;
    }

    /**
     * Gets the stats of all the movie theaters and merges them into one string
     * @return the string of all the movie stats
     */
    public String getStats(){
        return one.stats()+"\n"+two.stats()+"\n"+three.stats()+"\n"+four.stats()+"\n"+five.stats();
    }

    /**
     * Gets the name and prefix of the first theater
     * @return a string of the movie name and its prefix
     */
    public String getScreenOne(){
        return one.toString();
    }

    /**
     * Gets the name and prefix of the second theater
     * @return a string of the movie name and its prefix
     */
    public String getScreenTwo(){
        return two.toString();
    }

    /**
     * Gets the name and prefix of the third theater
     * @return a string of the movie name and its prefix
     */
    public String getScreenThree(){
        return three.toString();
    }

    /**
     * Gets the name and prefix of the fourth theater
     * @return a string of the movie name and its prefix
     */
    public String getScreenFour(){
        return four.toString();
    }

    /**
     * Gets the name and prefix of the fifth theater
     * @return a string of the movie name and its prefix
     */
    public String getScreenFive(){
        return five.toString();
    }
}

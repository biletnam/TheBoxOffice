import java.util.List;
import java.util.Scanner;

public class FindScreens {

   private Screen one, two, three, four, five;
   private long initTime, dayLength;
   private Scanner scanner;

    public FindScreens(long initTime, long dayLength){
        one = new Screen("The Shape of Water");
        two = new Screen("Lady Bird");
        three = new Screen("The Big Sick");
        four = new Screen("Get Out");
        five = new Screen("Dunkirk");
        this.initTime = initTime;
        this.dayLength = dayLength;
        scanner = new Scanner(System.in);
    }

    public boolean screenTimes(String movieName) {
        Screen screen = findMovie(movieName);
        if(movieName.equals("end")){
            return false;
        }
        if (!movieName.equals("swap") && !movieName.equals("time")){
            screen.getTimes((int) (System.currentTimeMillis() - initTime) / 1000, (int) dayLength / 1000);
        }
        return true;
    }

    public void screenSwap(){
        System.out.println("Now type the two movies you want to swap (S L).");
        String movie1 = scanner.next();
        String movie2 = scanner.next();
        Screen screen1 = findMovie(movie1);
        Screen screen2 = findMovie(movie2);
        screen1.swapMovies(screen2);
        System.out.println("The movies "+movie1+" and "+movie2+" have successfully been swapped");
    }

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
            case "swap":
                screenSwap();
                break;
            case "time":
                String currentTime = String.format("%02d:00", 9 + (((System.currentTimeMillis() - initTime) / 1000) / 3));
                System.out.println("The current hour is "+currentTime);
            default:
                break;
        }
        return null;
    }

    public String getStats(){
        return one.toString()+"\n"+two.toString()+"\n"+three.toString()+"\n"+four.toString()+"\n"+five.toString();
    }
}

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

    public void screenTimes(String movieName){
        Screen screen = findMovie(movieName);
        screen.getTimes((int)(System.currentTimeMillis() - initTime)/ 1000, (int)dayLength / 1000);
    }

    public void screenSwap(){
//        Screen screen1 = findMovie(movie1);
//        Screen screen2 = findMovie(movie2);
//        screen1.swapMovies(screen2);


        System.out.println("Now type the two movies you want to swap (S L).");
        String movie1 = scanner.next();
        String movie2 = scanner.next();
        Screen screen1 = findMovie(movie1);
        Screen screen2 = findMovie(movie2);
        screen1.swapMovies(screen2);
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
            default:
                break;
        }
        return null;
    }

    public String getStats(){
        return one.toString()+"\n"+two.toString()+"\n"+three.toString()+"\n"+four.toString()+"\n"+five.toString();
    }
}

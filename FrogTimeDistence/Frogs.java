




import java.io.NumberFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Frogs {

    static int distanceRound = 9, spendTimeRound = 8, rounds, remain, spendTime,roundsByTime,remainByTime,distanceByTime;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Distance(5m, 6m) or Time (3s , 4s)");

        try {

            String inputval = sc.nextLine();

            String last = inputval.substring(inputval.length() - 1);
            System.out.println(last);

            if (last.equals("m") || last.equals("s")) {
                
                String inputNewVal = inputval.substring(0, inputval.length() - 1);

                int valueInput = Integer.parseInt(inputNewVal);

                if (last.equals("m")) {
                    getTimeByDistance(valueInput);
                } else {
                    getDistanceByTime(valueInput);
                }
            } else {

                System.out.println("Input should be this format 1m, 3m or 1s, 5s");

            }

        } catch (InputMismatchException ime) {
            System.out.println("Exception occur " + ime);
        } catch (NumberFormatException e) {
            System.out.println("Exception occur " + e);
        }
    }

    public static void timeCalculation(int number) {
        spendTime = number + (rounds * spendTimeRound);
        System.out.println("Jony is spent " + spendTime + "s for his journey");
    }

    public static void distanceCalculation(int num) {
        distanceByTime = num + (roundsByTime * distanceRound);
        System.out.println("Jony's distance of journey is" + distanceByTime +"m");
    }

    public static void getTimeByDistance(int valueInput) {
      
        rounds = valueInput / distanceRound;
        remain = valueInput % distanceRound;

        if (remain == 0) {
            timeCalculation(0);
        } else {

            if (remain <= 5 && remain > 0) {
                timeCalculation(1);
            } else if (remain <= 7 && remain > 5) {
                timeCalculation(3);
            } else if (remain <= 8 && remain > 7) {
                timeCalculation(8);
            }
        }
        
    }

    public static void getDistanceByTime(int valueInput) {
        
        
        
        roundsByTime = valueInput / spendTimeRound;
        remainByTime = valueInput % spendTimeRound;

        if (remainByTime == 0) {
            distanceCalculation(0);
        } else {

            if (remainByTime <= 1 && remainByTime > 0) {
                distanceCalculation(5);
            } else if (remainByTime <= 3 && remainByTime > 1) {
                distanceCalculation(8);
            } else if (remainByTime <= 8 && remainByTime > 3) {
                distanceCalculation(9);
            }
        }
    
    }

}

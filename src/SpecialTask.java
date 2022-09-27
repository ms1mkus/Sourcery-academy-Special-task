import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialTask {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter .txt file name " +
        "(or press enter to read default .txt file for testing):  ");

        ArrayList<String> output = readFile(scan.nextLine());

        //Defines a two digiti pattern that is larger than 10 (to be used in a search)
        Pattern pattern=Pattern.compile("[1-9][0-9]");

        //Prints texts rows if they contain number equal or larger than 10
        printIfContains(output, pattern);


    }

    public static ArrayList<String> readFile(String fileName){
        ArrayList<String> output=new ArrayList<>();

        if(fileName.isEmpty()){
            fileName="DefaultTesting.txt";
        }

        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                output.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        if(output.isEmpty()){
            System.exit(0);
        }
        return output;
    }

    public static void printIfContains(ArrayList<String> output, Pattern pattern){
        for(String x : output){
            Matcher matcher=pattern.matcher(x);
            if(matcher.find()){
                System.out.println(x);
            }
        }
    }
}

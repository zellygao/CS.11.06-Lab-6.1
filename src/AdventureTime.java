import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            int result1 = challengeOne("inputOneTwo.txt");
            System.out.println("Result: " + result1);
            int result2 = challengeTwo("inputOneTwo.txt");
            System.out.println("Result: " + result2);
            int result3 = challengeThree("inputThreeFour.txt");
            System.out.println("Result: " + result3);
            int result4 = challengeFour("inputThreeFour.txt");
            System.out.println("Result: " + result4);
            writeFileAllAnswers("Answers", result1, result2, result3, result4);
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */

    public static int challengeOne(String fileName) throws IOException {
        int count = 0;
        int[] array = readFile(fileName);

        int lineCount = countLinesInFile(fileName);
        for(int i = 0; i<array.length-1; i++){
            if(array[i]<array[i+1]){
                count++;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int [] array = readFile(fileName);
        int count2 = 0;

        for(int i=3; i<array.length; i++){
            int sum1 = array[i] + array[i-1] + array[i-2];
            int sum2 = array[i-1] + array[i-2] + array[i-3];
            if(sum1>sum2){
                count2++;
            }
        }
        return count2;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName2
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName2) throws FileNotFoundException {
        String[] array = readTextFile(fileName2);
        int horizontal = 0;
        int depth = 0;

        for(int i =0; i<array.length; i++){
            if(array[i].contains("forward")){
                int horizontalvalue = Integer.parseInt(array[i].split(" ") [1]);
                horizontal += horizontalvalue;
            }
            if(array[i].contains("up")){
                int depthvalue = Integer.parseInt(array[i].split(" ") [1]);
                depth += depthvalue;
            }
            if(array[i].contains("down")){
                int depthvalue2 = Integer.parseInt(array[i].split(" ") [1]);
                depth += depthvalue2;
            }
        }
        return depth*horizontal;

    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename2
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename2) throws FileNotFoundException {
        String[] array = readTextFile (filename2);
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (int i = 0; i<array.length; i++){
            if(array[i].contains("forward")){
                int horizontalvalue = Integer.parseInt(array[i].split(" ")[1]);
                horizontal+=horizontalvalue;
                depth+= aim*horizontalvalue;
            }
            if(array[i].contains("up")){
                int depthvalue = Integer.parseInt(array[i].split(" ")[1]);
                aim -= depthvalue;
            }
            if(array[i].contains("down")){
                int depthvalue2 = Integer.parseInt(array[i].split(" ")[1]);
                aim += depthvalue2;
            }
        }
        return depth*horizontal;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

    private static String[] readTextFile (String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;

    }
}
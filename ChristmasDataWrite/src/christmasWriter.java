import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.lang.IllegalStateException;
import java.io.IOException;
public class christmasWriter {
        public static void main(String[] args) {
            //creating the file and getting values
            try (Formatter output = new Formatter("ChristmasVals.txt")) {

                Scanner input = new Scanner(System.in);
                System.out.printf("%s%n%s%n+ ",
                        "Enter Tree's height, Tail's height and the Box's height(Respectively).",
                        "Press Command + D to end the file");
                while (input.hasNext()) {
                    try {

                        output.format("%d %d %d %n", input.nextInt(), input.nextInt(), input.nextInt());
                    }
                    catch(NoSuchElementException elementException){
                        System.err.println("Invalid input. Please try again.");
                        input.nextLine();
                    }
                    System.out.print("+ ");
                }
                }
            catch(SecurityException | FileNotFoundException |FormatterClosedException e)
            {
                e.printStackTrace();
            }
            // reading the file and printing the trees in another file
            try(Scanner input = new Scanner(Paths.get("ChristmasVals.txt"))) {
                PrintStream myWriter = new PrintStream("ChristmasTrees.txt");
                while (input.hasNext()) {
                        int PHeight = input.nextInt();
                        int THeight = input.nextInt();
                        int BHeight = input.nextInt();
                        for (int i = 1; i <= PHeight; i++) {

                            for (int space = 1; space <= PHeight - i; space++) {
                                myWriter.print(" ");
                            }

                            for (int star = 1; star <= i * 2 - 1; star++) {
                                myWriter.print("*");

                            }
                            myWriter.println();
                        }
                        for(int i= 0; i< THeight; i++){
                            for (int j=1; j<PHeight-1; j++){
                                myWriter.print(" ");
                            }
                            myWriter.print("| |");
                            myWriter.println();
                        }
                        for(int i = 1; i <= BHeight; i++)
                        {
                            for(int j = 1; j <= PHeight; j++)
                            {
                                myWriter.print("- ");
                            }
                            myWriter.println();
                        }
                        myWriter.println();
                        myWriter.println();
                }
                myWriter.close();
                System.out.print("Successfully wrote to the file.");
            }
            catch (IOException | NoSuchElementException | IllegalStateException e) { e.printStackTrace();
            }

        }


}


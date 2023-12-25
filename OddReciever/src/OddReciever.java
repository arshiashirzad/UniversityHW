import java.util.Scanner;
public class OddReciever {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter your odd number");
        double OddNumber =(double) input.nextInt();
        while(OddNumber % 2 == 0) {
            System.out.println("you entered a wrong number / please enter an odd number");
            OddNumber = input.nextInt();
        }
        double r1Checker =(double) Math.ceil(OddNumber/6);

        int r = (int)Math.round(r1Checker);

        int[][] OddMatrix = new int[r][3];
        int[][] EvenMatrix = new int[r][3];
        int[][] MultiplicatedMatrix = new int [r][3];
        int Oddvalue =1;
        int Evenvalue =0;
        //filling the odd matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <3 ; j++) {
                OddMatrix[i][j] = Oddvalue;
                Oddvalue+=2;
            }
        }
        //filling the even matrix,
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <3 ; j++) {
                EvenMatrix[i][j] = Evenvalue;
                Evenvalue += 2;
            }
        }
        //filling the multipicated matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <3 ; j++) {
                MultiplicatedMatrix[i][j] = (EvenMatrix[i][j]) * (OddMatrix[i][j]);
            }
        }
        //printing the odd matrix
        System.out.println("the Odd Matrix is:");
        for (int k = 0; k < r; k++) {
            System.out.println("-----------");
            for (int y = 0; y <3 ; y++) {
                if(y!=2){
                    System.out.print("|"+OddMatrix[k][y]+"|");
                }else {
                    System.out.println("|"+OddMatrix[k][y]+"|");
                }

            }
        }
        System.out.println("the Even Matrix is:");
        //printing the even matrix
        for (int i = 0; i < r; i++) {
            System.out.println("-----------");
            for (int j = 0; j <3 ; j++) {
                if(j!=2){
                    System.out.print("|"+EvenMatrix[i][j]+"|");
                }else {
                    System.out.println("|"+EvenMatrix[i][j]+"|");
                }
            }
        }
        //the loop for printing the multipication of two matrixes
        System.out.println("the multipication of two matrixes is:");
        for (int i = 0; i < r; i++) {
            System.out.println("-----------");
            for (int j = 0; j <3 ; j++) {
                if(j!=2){
                    System.out.print("|"+MultiplicatedMatrix[i][j]+"|");
                }else {
                    System.out.println("|"+MultiplicatedMatrix[i][j]+"|");
                }
            }
        }
    }
}
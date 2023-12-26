
import javax.xml.crypto.dsig.keyinfo.PGPData;
import java.util.Scanner;
import java.math.BigDecimal;
public class ChristmasTree {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("enter the height of this tree:");
        int PHeight = input.nextInt();
        System.out.println("enter the height of the tail of this tree:");
        int THeight = input.nextInt();
        System.out.println("enter the rows of the box of this tree:");
        int BHeight = input.nextInt();
        Christmas Christmas1 = new Christmas(PHeight,THeight,BHeight);
        Christmas1.Pyramidprinter();
        Christmas1.Taleprinter();
        Christmas1.Boxprinter();
    }
    }
public class NumbersTest {
    public static void main(String[] args) {
        Numbers Numbers1 = new Numbers();
        int[] A = Numbers1.fibonacci();
        int[] B = Numbers1.random();
        double[] C = arrayProduct(A,B);
        arrayDisplay(A,B,C);
    }
    //This method Mulitiplies fibonacci array with random array
    public static double[] arrayProduct(int[] A , int[] B){
        double[] multiplicatedArr = new double[A.length];
        for(int i=0 ;i<multiplicatedArr.length;i++ ){
            multiplicatedArr[i] = A[i]*B[i];
        }
        return multiplicatedArr;
    }
    //This method displays the elements in three kinds of arrays we valued
    public static void arrayDisplay(int[] A, int[] B , double[] C){
        System.out.println("array filled with Fibonacci numbers is : ");
        for (int j = 0; j < A.length; j++) {
            System.out.printf("%2d.%15d%n",
                    j+1 , A[j]);
        }
        System.out.println();
        System.out.println("array filled with Random numbers is : ");
        for (int j = 0; j < B.length; j++) {
            System.out.printf("%2d.%15d%n",
                    j+1 , B[j]);
        }
        System.out.println();
        System.out.println("array filled with Multiplicated numbers is : ");
        for (int j = 0; j < C.length; j++) {
            System.out.printf("%2d.%15.2f%n",
                    j+1 , C[j]);
        }

    }
}

//Coded by Arshia Shirzad


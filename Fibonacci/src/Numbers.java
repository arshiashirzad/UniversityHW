import java.util.Random;
public  class Numbers {
    /*we are declaring counter here to use its value in both methods,
    also we add counter to count how many fibo number we have till 149*/
    int counter = 0;
    public int[] fibonacci() {
        int n =600, firstSen = 0, secondSen = 1;

        // with this loop we count how many fibo number we have till 149
        while (firstSen <= n) {
            int nextSen = firstSen + secondSen;
            firstSen = secondSen;
            secondSen = nextSen;
            counter++;
        }
        int[] fiboArr = new int[counter];
        //then we will revalue the variables to add fibo values to our array
        firstSen =0;
        secondSen=1;
        //with this loop we put values into the array
        for(int i= 0;i <counter ; i++ ){
            fiboArr[i] = firstSen;
            int nextSen = firstSen + secondSen;
            firstSen = secondSen;
            secondSen = nextSen;
        }
        return fiboArr;
    }
    public int[] random(){
        int[] randArr = new int[counter];
        Random rand = new Random();
        for(int i=0 ; i< counter ; i++){
            randArr[i] = rand.nextInt(149);
        }
        return randArr;
    }
}


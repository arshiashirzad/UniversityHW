public  class Christmas{
    private int PHeight;
    private int THeight;
    private int BHeight;
    public Christmas(int PHeight , int THeight , int BHeight){
        this.BHeight = BHeight;
        this.PHeight = PHeight;
        this.THeight = THeight;
    }
    public  void Pyramidprinter() {
        for (int i = 1; i <= PHeight; i++) {

            for (int space = 1; space <= PHeight - i; space++) {
                System.out.print(" ");
            }

            for (int star = 1; star <= i * 2 - 1; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
    public void Taleprinter() {
        for(int i= 0; i< THeight; i++){
            for (int j=1; j<PHeight-1; j++){
                System.out.print(" ");
            }
            System.out.println("| |");
        }
    }
    public void Boxprinter() {
        for(int i = 1; i <= BHeight; i++)
        {
            for(int j = 1; j <= PHeight; j++)
            {
                System.out.print("- ");
            }
            System.out.print("\n");
        }
    }

}

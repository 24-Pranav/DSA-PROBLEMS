class RecursiveSumN{

    public static int recursiveSum(int num){

        if(num < 1){

            return num;
        }

        num += recursiveSum(num - 1);

        return num;
    }
    public static void main(String args[]){

        int n = 5;
        System.out.print(recursiveSum(n));
    }
}
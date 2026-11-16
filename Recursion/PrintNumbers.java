class PrintNumbers{

    static void printNum(int num){

        if(num == 3){
            return;
        }

        System.out.println(num);
        num++;

        printNum(num);
    }
    public static void main(String[] args) {
        
        printNum(0);
    }
}
public class ValidParenthesis {
    public static void main(String[] args) {
        
        String exp = "(**(";

        int min = 0;
        int max = 0;

        for(int i = 0; i < exp.length(); i++)
        {
            if (exp.charAt(i) == '(') {
                min++;
                max++;
            }
            else if (exp.charAt(i) == ')') {
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }

            if (min < 0) {
                min = 0;
            }
            
            if (max < 0) {
                System.out.println(false);
                return;
            }
        }

        if(min == 0)
        {
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}

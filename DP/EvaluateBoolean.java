public class EvaluateBoolean {
    static int f(int i, int j, int isTrue, String exp)
    {
        if(i > j)
        {
            return 0;
        }

        if (i == j) {
            
            if(isTrue == 1)
            {
                if(exp.charAt(i) == 'T')
                {
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                if(exp.charAt(i) == 'F')
                {
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }

        int ways = 0;

        for(int ind = i + 1; ind <= j - 1; ind += 2)
        {
            int lT = f(i, ind - 1, 1, exp);

            int lF = f(i, ind - 1, 0, exp);

            int rT = f(ind + 1, j, 1, exp);

            int rF = f(ind + 1, j, 0, exp);

            if (exp.charAt(ind) == '&') {
                
                if(isTrue == 1)
                {
                    ways += (lT * rT); 
                }
                else{
                    ways += ((lT * rF) + (lF * rT) + (lF * rF));
                }
            }
            else if (exp.charAt(ind) == '|') {
                if (isTrue == 1) {
                    
                    ways += ((lT * rF) + (lF * rT) + (lT * rT));
                }
                else{
                    ways += (lF * rF);
                }
            }
            else{
                if (isTrue == 1) {
                    
                    ways += ((lT * rF) + (lF * rT));
                }
                else{

                    ways += ((lT * rT) + (lF * rF));
                }
            }
        }

        return ways;
    }
    public static void main(String[] args) {
        
        String str = "T|T&F";

        int n = str.length();

        System.out.println(f(0, n - 1, 1, str));
    }   
}

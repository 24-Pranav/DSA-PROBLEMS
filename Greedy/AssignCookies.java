import java.util.Arrays;

public class AssignCookies {
    
    public static void main(String args[])
    {
        int greedy[] = {1,5,3,3,4};

        int cookies[] = {4,2,1,2,1,3};

        Arrays.sort(greedy);
        Arrays.sort(cookies);

        int n = greedy.length;
        int m = cookies.length;

        int left = 0;
        int right = 0;
        
        while (left < n && right < m) {
           
            if(greedy[left] <= cookies[right])
            {
                left++;
                right++;
            }
            else{
                right++;
            }
        }

        System.out.println(left);
    }
}

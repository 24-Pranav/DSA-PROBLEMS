public class LemonadeChange {

    public static void main(String[] args) {

        int bills[] = { 5, 5, 10, 10, 20 };

        int n = bills.length;

        int five = 0, ten = 0;

        for (int i = 0; i < n; i++) {
            if (bills[i] == 5) {

                five++;
            } else if (bills[i] == 10) {

                if (five >= 1) {

                    five--;
                    ten++;
                } else {
                    System.out.println(false);
                    return;
                }
            } else {

                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }
}

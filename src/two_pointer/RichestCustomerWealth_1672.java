package two_pointer;

public class RichestCustomerWealth_1672 {
    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}, {90, 0}};
        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
        int richestCustomerWealth = 0;
        int currentCustomerWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                currentCustomerWealth += accounts[i][j];
            }
            if (currentCustomerWealth >= richestCustomerWealth) {
                richestCustomerWealth = currentCustomerWealth;
            }
            currentCustomerWealth = 0;
        }
        return richestCustomerWealth;
    }
}

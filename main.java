import java.util.*;

public class main {
    static int robberProblem(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return arr[0];
        } else if (n == 2) {
            return Math.max(arr[0], arr[1]);
        } else {
            dp[0] = arr[0];
            dp[1] = Math.max(arr[0], arr[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
            }
            return dp[n - 1];
        }
    }

    static int isCycle(int n, int m) {
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = { 11, 12, 13, 11 };
        System.out.println(robberProblem(arr));
    }
}

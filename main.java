class Shape{
    protected int length;
    protected int breadth;
}
class Rectangle extends Shape{
    private float l;
    public float b;
    public void dimensions(int l, int b){
        this.l = l;
        this.b = b;
    }
    public float getL(){
        return l;
    }
    public float Area(){
        return getL()*b;
    }
}
class Naira{
    public int nairaProblem(int age){
        return age;
    }
    public float nairaProblem(float height){
        return height;
    }
}
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

    static int josephus(int n, int k){
        if(n == 1){
            return 1;
        }
        else{
            return (josephus(n-1, k)+ k-1) % n + 1;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 11, 12, 13, 11 };
        System.out.println(robberProblem(arr));
        Rectangle r = new Rectangle();
        r.dimensions(10, 5);
        System.out.println(r.Area());
        System.out.println(josephus(20, 5));
    }
}
 
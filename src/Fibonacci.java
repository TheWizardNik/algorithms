public class Fibonacci {
    public static int recFibonacci(int f) {
        if (f == 0) return 0;
        else if (f == 1) return 1;
        else return recFibonacci(f - 2) + recFibonacci(f - 1);
    }

    public static int cycFibonacci(int f) {
        int[] fib = new int[f+1];
        for (int i = 0; i < fib.length; i++) {
            if (i == 0) fib[i] = 0;
            else if (i == 1) fib[i] = 1;
            else fib[i]=fib[i-2]+fib[i-1];
        }
        return fib[f];
    }


    public static void main(String[] args) {
        System.out.println(recFibonacci(5));
        System.out.println(recFibonacci(3));
        System.out.println(recFibonacci(9));
        System.out.println(cycFibonacci(5));
        System.out.println(cycFibonacci(3));
        System.out.println(cycFibonacci(9));
    }
}

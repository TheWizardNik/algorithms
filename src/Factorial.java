public class Factorial {

    public static int recFactorial (int x)
    {
        if (x==1) return 1;
        else return x*recFactorial(x-1);
    }

    public static int cycFactorial(int x)
    {
        int fac=1;
        for (int i=1; i<=x;i++)
            fac*=i;
        return fac;
    }

    public static void main(String[] args) {
        System.out.println(recFactorial(4));
        System.out.println(recFactorial(3));
        System.out.println(recFactorial(10));
        System.out.println(cycFactorial(4));
        System.out.println(cycFactorial(3));
        System.out.println(cycFactorial(10));
    }
}

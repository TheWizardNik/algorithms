import java.util.Arrays;

public class Exm {
    public static int f(int zar,int n,int a,int b)
    {
        for (int i=0;i<n;i++)
        {
            if (b*i+a*(n-i)<zar) return n-i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(f(20,5,7,3));
    }
}

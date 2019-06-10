import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SumOf {
    public static int sumOfArray(int[] arr)
    {
        if (arr.length<1) return 0;
        else return arr[0]+sumOfArray(Arrays.copyOfRange(arr,1,arr.length));
    }

    public static int sumOfList(List<Integer> list)
    {
        if (list.size()<1) return 0;
        else return list.get(0)+sumOfList(list.subList(1,list.size()));
    }

    public static int maxOfList(List<Integer> list,int max)
    {
        if (list.size()<1) return max;
        else if (max<list.get(0)) max=list.get(0);
        max = maxOfList(list.subList(1,list.size()),max);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,7,8,1};
        System.out.println(sumOfArray(arr));
        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(10);
        System.out.println(sumOfList(list));
        System.out.println(maxOfList(list,0));
        }

    }


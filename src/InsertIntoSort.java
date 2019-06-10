public class InsertIntoSort {

    public static void insertIntoSort(int[] arr) {
        int temp, j;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,3,2,4,5,3,2,1,-10,111,12};
        insertIntoSort(arr);
        for (int i:arr)
            System.out.print(i+" ");
    }

}

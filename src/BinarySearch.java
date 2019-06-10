public class BinarySearch {

    private double[] array;

    public BinarySearch(double[] array) {
        this.array = array;
    }


    public int find(double x) {
        int i = -1;
        if (this.array != null) {
            int low = 0, high = this.array.length, mid;
            while (low < high) {
                mid = (low + high) >>> 1;
                if (x == this.array[mid]) {
                    i = mid;
                    break;
                } else {
                    if (x < this.array[mid]) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return i;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch(new double[]{-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50});
        System.out.println( bs.find(-30) );
        System.out.println( bs.find(0) );
        System.out.println( bs.find(7) );
        System.out.println( bs.find(-16) );
    }

}
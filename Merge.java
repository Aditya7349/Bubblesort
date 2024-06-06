public class Merge {
    
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
    
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;    
        int j = mid + 1; 
        int k = left;    

        /
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

    
    }

    private static void sort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            
            int mid = left + (right - left) / 2;

            
            sort(arr, temp, left, mid);
            sort(arr, temp, mid + 1, right);

        
            merge(arr, temp, left, mid, right);
        }
    }

    
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int[] temp = new int[arr.length];
        sort(arr, temp, 0, arr.length - 1);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

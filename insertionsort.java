//Timne Complexity: best case - O(n) worst case - O(n^2) average case - O(n^2)

public class insertionsort {
    static void insertionsortalgo(int[]arr){
        for(int i = 1;i<arr.length;i++){
            int curr = i;
            int prev = i-1;
            while(prev>=0 && arr[prev]>arr[curr]){
                int temp = arr[prev];
                arr[prev] = arr[curr];
                arr[curr] = temp;
                curr = prev;
                prev--;
            }

        }
    }//with swapping
    static void insertionsortalgo2(int[]arr){
        for(int i = 1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;

        }
    }    
    public static void main(String[] args) {
        int[] arr = {2, 7, 2, 1, 5, -8, 9, 4, 6, 3};
        insertionsortalgo(arr);
        System.out.println("Sorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int[] arr2 = {2, 7, 2, 1, 5, -8, 9, 4, 6, 3};
        insertionsortalgo2(arr2);
        System.out.println("Sorted array:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}

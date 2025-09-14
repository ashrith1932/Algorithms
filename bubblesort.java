//Best Case : O(n) with optimization,O(n^2) without optimization 
//Average case,worst case : O(n^2)


public class bubblesort {
    static void bubblesortalgo(int[]arr){
        for(int i = 0;i<arr.length-1;i++){
            boolean swapped = false;//for optimization
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){break;}
        }
    }
    public static void main(String[] args) {
        int[]arr = {2,7,2,1,5,-8,9,4,6,3};
        bubblesortalgo(arr);
        System.out.println("Sorted array:");
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

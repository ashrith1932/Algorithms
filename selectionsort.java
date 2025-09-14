//Time Complexity - O(n^2) (FOR ALL)

public class selectionsort {
    static void selectionsortalgo(int[]arr){
        for(int i = 0;i<arr.length-1;i++){
            int minindex = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[minindex]){minindex = j;}
            }
            int temp = arr[i];
            arr[i] = arr[minindex];
            arr[minindex] = temp;
        }
    }
    public static void main(String[] args) {
        int[]arr = {2,7,2,1,5,-8,9,4,6,3};
        selectionsortalgo(arr);
        System.out.println("Sorted array:");
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

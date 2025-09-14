// time complexity O(n log n)

public class mergesort {
    static void mergesortalgo(int[]arr,int left,int right){
        if(left<right){
            int mid = left + (right-left)/2;
            mergesortalgo(arr,left,mid);
            mergesortalgo(arr,mid+1,right);
            merge(arr,left,mid,right);
        }//O(logn)

    }
    static void merge(int []arr,int left,int mid,int right){
        int n1 = mid-left+1;
        int n2 = right-mid;
        int[]L = new int[n1];
        int[]R = new int[n2];
        for(int i = 0;i<n1;i++){L[i] = arr[left+i];}
        for(int j = 0;j<n2;j++){R[j] = arr[mid+1+j];}
        int i = 0,j=0;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){arr[left] = L[i];i++;}
            else{arr[left] = R[j];j++;}
            left++;
        }
        while(i<n1){arr[left] = L[i];i++;left++;}
        while(j<n2){arr[left] = R[j];j++;left++;}
    }//O(n)

    public static void main(String[] args) {
        int[] var1 = {2, 7, 2, 1, 5, -8, 9, 4, 6, 3};
        mergesortalgo(var1, 0, var1.length - 1);
        System.out.println("Sorted array:");
        for (int i = 0; i < var1.length; i++) {
            System.out.println(var1[i]);
        }
    }
}

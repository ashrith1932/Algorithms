//needed a sorted array to do
public class binarysearch {

    static int binarysearchalgo(int[]arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){return mid;}
            else if(arr[mid]<target){start = mid+1;}
            else{end = mid-1;}
        }
        return -1;
    };
    public static void main(String[] args) {
        int[]arr = {-10,9,2,3,4,4,5,6,7,8,11,19,23};
        int target = 4;
        int ans = binarysearchalgo(arr,target);
        if(ans!=-1){
            System.out.println("Element found at index "+ans);}
        else{System.out.println("Element not found");}

    }
}

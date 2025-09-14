//For sorting in decreasing order change "max" to "min" and
// < to > in (arr[largest],arr[left]) (arr[largest],arr[right]) 

public class heapsort {
    static void maxheapify(int[]arr,int i,int end){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < end && arr[largest]<arr[left]){largest = left;}
        if(right<end && arr[largest]<arr[right]){largest = right;}
        if(largest!=i){
            int temp = arr[i];
            arr[i]=arr[largest];
            arr[largest] = temp;
            maxheapify(arr, largest,end);
        }
        
    }   
    static void maxheaparrayn (int[]arr){
        for(int i = arr.length/2 -1 ;i>=0;i--){
            maxheapify(arr,i,arr.length-1);
        }
    }
    static void heapsortalgo(int[]arr,int end){
        if(end==-1||end==0){return;}
        int max = arr[0];
        arr[0] = arr[end];
        arr[end] = max;
        --end;
        maxheapify(arr,0,end);
        heapsortalgo(arr, end);
    }
    public static void main(String[] args) {
        int[]arr = {-1,2,2,3,0,5,2,6,-10,9,4,7};
        maxheaparrayn(arr);
        heapsortalgo(arr,arr.length-1);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

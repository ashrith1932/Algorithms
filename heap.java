//Code is given for Min-HEAP 
//(FOR MAX HEAP CHANGE THE COMPARISION SIGN TO < FOR (PARENT,CURR) AND (smallest,RIGHT,LEFT) AND CHANGE "smallest"->"SMALLEST")

public class heap {
    int[] heaparray;
    int maxsize;
    int size =-1;
    heap(int maxsize){
        this.maxsize = maxsize;
        heaparray = new int[maxsize];
    }
    void mininsert(int x){
        if(size+1==maxsize){System.out.println("maxsize reached");return;}
        heaparray[++size] = x;
        int curr = size;
        int parent = (curr-1) /2;
        while(curr>=0&&heaparray[parent]>heaparray[curr]){int temp = heaparray[parent];heaparray[parent] = heaparray[curr];heaparray[curr]=temp;curr = parent;parent = (curr-1) /2;}
    } //TimeComplexity - O(logn),for all n elements then O(nlogn)

    void extractmin(){
        if(size==-1){return;}
        if(size==0){System.out.println(heaparray[0]);--size;}
        int min = heaparray[0];
        heaparray[0] = heaparray[size];
        --size;
        minheapify(heaparray,0);
        System.err.println(min);
    } //Time Complexity - O(logn)

    static void  minheapify(int[]arr,int i){
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < arr.length && arr[smallest]>arr[left]){smallest = left;}
        if(right<arr.length && arr[smallest]>arr[right]){smallest = right;}
        if(smallest!=i){
            int temp = arr[i];
            arr[i]=arr[smallest];
            arr[smallest] = temp;
            minheapify(arr, smallest);
        }
        
    }//time Complexity - O(logn)

    void display(){
        for(int i = 0;i<=size;i++){
            System.out.println(heaparray[i]);
        }
    }

    //used if array is given by default
    static void minheaparrayn (int[]arr){
        for(int i = arr.length/2 -1 ;i>=0;i--){
            minheapify(arr,i);
        }
    }//(buildeheap)time Complexity - O(n)
    
    public static void main(String[] args) {
        int []arr = {10,2,5,1,19,4,13,23,9,11};
        minheaparrayn(arr);
        System.err.println("method 1");
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.err.println("method 2");
        //used if using insert of value everytime 
        heap h1 = new heap(10);
        h1.mininsert(15);
        h1.mininsert(9);
        h1.mininsert(4);
        h1.mininsert(1);
        h1.mininsert(6);
        h1.mininsert(2);
        h1.mininsert(8);
        h1.mininsert(11);
        h1.display();
        System.out.println("Your minimum after extraction");
        h1.extractmin();
        System.out.println("new heap after extraction");
        h1.display();
    }
}

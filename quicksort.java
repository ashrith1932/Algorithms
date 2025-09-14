public class quicksort {
    // return pivot at end
    static int pivotend(int[]arr,int left,int right){
        int val = arr[right];
        int i = left;
        for(int j = left;j<right;j++){
            if(arr[j]<=val){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[right];
        arr[right] = arr[i];
        arr[i] = temp;
        return i;
    }

    // return pivot at start
    static int pivotstart(int[]arr,int left,int right){
        int val = arr[left];
        int i = left+1;
        for(int j = left+1;j<=right;j++){
            if(arr[j]<=val){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = val;
        arr[left] = arr[i-1];
        arr[i-1] = temp;
        return i-1;
    }

    // return pivot at random
    static int pivotrandom(int[]arr,int left,int right){
        int random = (int)(Math.random() * (right - left + 1)) + left;
        int val = arr[random];
        arr[random] = arr[left];
        arr[left] = val;
        int i = left+1;
        for(int j = left+1;j<=right;j++){
            if(arr[j]<=val){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = val;
        arr[left] = arr[i-1];
        arr[i-1] = temp;
        return i-1;
    }
    
    // return pivot at median
    static int pivotmedian(int[]arr,int left,int right){
        int mid = (right+left)/2;
        int pivotindex = 0;
        if ((arr[left] - arr[mid])*(arr[right] - arr[left]) >= 0)
        pivotindex = left;
        else if ((arr[mid] - arr[left])*(arr[right] - arr[mid]) >= 0)
        pivotindex = mid;
        else
        {pivotindex = right;}
        int val = arr[pivotindex];
        arr[pivotindex] = arr[left];
        arr[left] = val;
        int i = left+1;
        for(int j = left+1;j<=right;j++){
            if(arr[j]<=val){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = val;
        arr[left] = arr[i-1];
        arr[i-1] = temp;
        return i-1;
    }

    //quicksort for pivot at end
    static void quicksortend(int[]arr,int left,int right){
        if(left<right){
        int pi = pivotend(arr,left,right);
        quicksortend(arr, left, pi-1);
        quicksortend(arr, pi+1, right);}
    }
    //quicksort for pivot at start
    static void quicksortstart(int[]arr,int left,int right){
        if(left<right){
        int pi = pivotstart(arr,left,right);
        quicksortstart(arr, left, pi-1);
        quicksortstart(arr, pi+1, right);}
    }
    //quicksort for pivot at random pivot
    static void quicksortrandom(int[]arr,int left,int right){
        if(left<right){
        int pi = pivotrandom(arr,left,right);
        quicksortrandom(arr, left, pi-1);
        quicksortrandom(arr, pi+1, right);}
    }
    //quicksort for pivot at median
    static void quicksortmedian(int[]arr,int left,int right){
        if(left<right){
        int pi = pivotmedian(arr,left,right);
        quicksortmedian(arr, left, pi-1);
        quicksortmedian(arr, pi+1, right);}
    }
    
    //MAIN FUNCTION
    public static void main(String[] args) {
        int[]arr = {2,7,2,1,5,-8,9,4,6,3,9,3};
        quicksortend(arr,0,arr.length-1);
        System.out.println("Pivot taken at end");
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("Pivot taken at start");
        int[]arr2 = {2,7,2,1,5,-8,9,4,6,3,2,2};
        quicksortstart(arr2,0,arr2.length-1);
        for(int i = 0;i<arr2.length;i++){
            System.out.println(arr2[i]);
        }
        System.out.println("Pivot taken at random");
        int[]arr3 = {2,7,2,1,5,-8,9,4,6,3,0,0};
        quicksortrandom(arr3,0,arr3.length-1);
        for(int i = 0;i<arr3.length;i++){
            System.out.println(arr3[i]);
        }
        System.out.println("Pivot taken at median");
        int[]arr4 = {2,7,2,1,5,-8,9,4,6,3,-10};
        quicksortmedian(arr4,0,arr4.length-1);
        for(int i = 0;i<arr4.length;i++){
            System.out.println(arr4[i]);
        }
    }
}

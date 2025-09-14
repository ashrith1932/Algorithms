import java.util.Arrays;

public class quicksortmedianofmedian {
    static void quickselectalgo(int[] arr,int left,int right){
        if(left<=right){
            int  i = partition(arr,left,right);
            quickselectalgo(arr,i+1,right);
            quickselectalgo(arr,left,i-1);
        }       
    }


    static int partition(int[]arr,int left,int right){
        int pi = pivot( arr, left,right);//to get the pivot index of median of median
        
        //find the index of pi in arr
        for(int i  = left;i<=right;i++){
            if(arr[i]==pi){
                pi = i;
                break;
            }
        }

        //applypivot at start by switching
        int temp = arr[left];
        arr[left] = arr[pi];
        arr[pi] = temp;
        int i = left+1;
        for(int j = left+1;j<=right;j++){
            if(arr[j]<=arr[left]){
                int temp1 = arr[j];
                arr[j] = arr[i];
                arr[i] = temp1;
                i++;
            }
        }
        int temp1 = arr[left];
        arr[left] = arr[i-1];
        arr[i-1] = temp1;  
        return i-1;//return final pivot index after partitioning
    }


    static int pivot(int[]arr,int left,int right){
        int length =(int) Math.ceil((double)(right - left + 1)/5.0);//number of groups of 5 + last group if any

        int[] median = new int[length];//declare length to fit medians

        for(int i = 0;i<length;i++){
            int subleft = left + i*5;
            int subright = subleft + 4;
            if(subright>right){subright=right;}
            median[i] = findmedian(arr,subleft,subright);
        }//find median of each group and store in median array

        if(median.length<=1){
            return median[0];
        }//end the process if only 1 median is there

        return pivot(median,0,median.length-1);//recursively find median of medians until 1 element left

    }
    static int findmedian(int[]arr,int left,int right){
        int[] temp = new int[right-left+1];
        for(int i = left;i<=right;i++){
            temp[i-left] = arr[i];
        }
        Arrays.sort(temp);// or use insertion sort as size is small

        return temp[(temp.length)/2];
    }//to find median of a group

    public static void main(String[] args) {
        int [] arr = {1,0,2,-1,9,3,2,5,2,2,3,10,54,12,0,-6};
        quickselectalgo(arr,0,arr.length-1);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

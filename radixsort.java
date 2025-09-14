//radix sort has time Complexity of O(d*(n+max)) ~ O(n)

public class radixsort {
    static int getmax(int[]arr){
        int max = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(max<arr[i]){max=arr[i];}
        }
        return max;
    }//to get max

    static void countingsort(int arr[],int exp){

        int[]count = new int[10];//declare size for digits(MAX){(0-9) in this case}

        for(int i = 0;i<arr.length;i++){
            count[(arr[i]/exp)%10]++;
        }//store freqencies O(N) //(arr[i]/exp)%10 gives the value at an injdex of 1/10s/100s/100s......

        //do cummulatives of indexies O(MAX)
        for(int i = 1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        int []output = new int[arr.length];

        //fetch the output by traversing org array from end and storing it in index acc to countarray map-1 while decrementing O(N)
        for(int i = arr.length-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        //transfer the output to org O(N)
        for(int i = arr.length-1;i>=0;i--){
            arr[i] = output[i];
        }        
    }
    static void radixsorting(int[]arr){
        int max = getmax(arr);
        for(int exp = 1;max/exp>0;exp =exp*10){
            countingsort(arr,exp);
        }
    }//perform on all digits that is digits present at max number O(d)
    public static void main(String[] args) {
        int [] arr = {1,432,2,99,89,9,123,22,2,11,94,8,0};
        radixsorting(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
//elemEnts have to be>0 for this code -> TIME COMPLEXITY O(N+MAX);

public class countingsort {
    static void countsort(int[]arr){
        int max = arr[0];

        for(int i = 1;i<arr.length;i++){
            if(max<arr[i]){max = arr[i];}
        }//fetch max element O(N)

        int[]count = new int[max+1];//declare size for 0 to max indexing O(MAX)

        for(int i = 0;i<arr.length;i++){
            count[arr[i]]++;
        }//store freqencies O(N)

        //do cummulatives of indexies O(MAX)
        for(int i = 1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        int []output = new int[arr.length];

        //fetch the output by traversing org array from end and storing it in index acc to countarray map-1 while decrementing O(N)
        for(int i = arr.length-1;i>=0;i--){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        //transfer the output to org O(N)
        for(int i = arr.length-1;i>=0;i--){
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int arr[] = {0,2,1,3,3,9,0,6,4,6,3,8};
        countsort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

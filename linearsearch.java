//linear search best - O(1) worst - O(n) Average - O(n)

public class linearsearch {
    public static void main(String[] args) {
        int[]arr = {1,-2,0,3,-19,23,2,2,9,6,5,4,2,8,7};
        int x = 10;
        boolean flag = false;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==x){
                System.out.println("Element found at index "+i);
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("Element not found");
        }
    }
}

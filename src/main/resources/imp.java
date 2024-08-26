public class imp{
    public static int bub(int arr[],int i,int j,int n){
        if(n==1){
            return 0;
        }
        if(j==n){
           return bub(arr,0,1,n-1);
        }
        if(arr[i]>arr[j]){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return bub(arr,i++,j++,n);
    }


  public static void main(String[] args){
    int arr[] = {5,2,3,1,4};
    bub(arr,0,1,5);
    for(int i=0;i<5;i++){
        System.out.println(arr[i]);
    }
  }
}
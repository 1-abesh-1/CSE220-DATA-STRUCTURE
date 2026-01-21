import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        
//input arrays
int []arr1 = {1,3,5,11} ;
int []arr2 = {2,7,8} ;

int n=arr1.length+arr2.length;
int []arr = new int[n];
int i=0;
// copy arr1
for (int a = 0; a < arr1.length; a++) {
    arr[i++] = arr1[a];
}

// copy arr2
for (int a = 0; a < arr2.length; a++) {
    arr[i++] = arr2[a];
}

for (int pass = 0; pass < n - 1; pass++) {
    for (int j = 0; j < n - 1 - pass; j++) {
        if (arr[j] > arr[j + 1]) {
            swap(arr, j);
        }
    }
}




System.out.print(Arrays.toString(arr));





    }





private static void swap( int arr[],int i){
    int temp=arr[i+1];
    arr[i+1]=arr[i];
    arr[i]=temp;
}


}

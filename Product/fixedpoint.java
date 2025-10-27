import java.util.Scanner;
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
        arr[i] = sc.nextInt();       
    }
    boolean found = false;
    for(int i=0; i<n; i++){
        if(arr[i]==i){
            System.out.println(arr[i]);
            found=true;
            break;
        
        }
    }
        if(!found){
        System.out.println("false");
        sc.close();
    }
}

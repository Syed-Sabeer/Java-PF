public class binarysort {
    public static void main(String[] args) {

int[] arr = {10, 20, 30, 40, 50, 60, 70};
int target = 40;
int start = 0;
int limit = arr.length - 1;

while (start <= limit) {
    int mid = (start + limit) / 2;
    if (arr[mid] == target) {
        System.out.println("Target "+ target +" is at index: " + mid);
        break;
    } else if (arr[mid] < target) {
        start = mid + 1;  
    } else {
        limit = mid - 1; 
    }
}
    }}
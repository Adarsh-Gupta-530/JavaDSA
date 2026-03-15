public class AllPermutationOfaString { // unique permutation
    
    public static void permute(char[] arr, int index) {
        if(index == arr.length) {
            System.out.println(new String(arr));
            return;
        }
        for(int i = index; i < arr.length; i++) {
            // Skip duplicates
            if(shouldSkip(arr, index, i)) continue;
            swap(arr, index, i);
            permute(arr, index + 1);
            swap(arr, index, i);
        }
    }
    public static boolean shouldSkip(char[] arr, int start, int current) {
        for(int i = start; i < current; i++) {
            if(arr[i] == arr[current]) return true;
        }
        return false;
    }
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        char[] ch = {'0','1','1'};
        permute(ch, 0);
    }
}

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] array1 = {-1,0,5,9};
        int[] array2 = {2,8,11,17};
        int inputSum = 7;

        System.out.println("Two Pointers: " + Arrays.toString(checkPairSorted(array1,array2,inputSum)));
        System.out.println("Brute Force: " + Arrays.toString(checkPairBruteForce(array1, array2, inputSum)));
        System.out.println("HashMap Method: " + Arrays.toString(checkPairUnsorted(array1, array2, inputSum)));
    }

    //Hashmap O(n+m)
    public static int[] checkPairUnsorted(int[] array1, int[] array2, int inputSum) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int x = 0; x < array1.length; x++) {
            map.put(inputSum - array1[x], x);
        }

        for (int j = 0; j < array2.length; j++) {
            if (map.containsKey(array2[j])) {
                return new int[]{map.get(array2[j]), j};
            }
        }
        return new int[] {-1, -1};
    }

    //Brute Force O(n×m)	
    private static int[] checkPairBruteForce(int[] array1, int[] array2, int inputSum) {

        for(int x =0; x < array1.length; x++){
            for(int j =0; j < array2.length; j++){
                if(array1[x] + array2[j] == inputSum){
                    return new int[] {x,j};
                }
            }
        }
        return new int[] {-1,-1};
    }

    //Two Pointers O(n)
    private static int[] checkPairSorted(int[] array1, int[] array2, int inputSum) {
        int x = 0;
        int j = array2.length - 1;

        while(x < array1.length && j >= 0){
            int sum = array1[x] + array2[j];
            if(sum == inputSum){
                return new int[] {x,j};
            }else if(sum < inputSum){
                x++;
            }else{
                j--;
            }
        }
        return new int[] {-1,-1};
    }


}

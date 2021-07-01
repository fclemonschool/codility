package io.fclemonschool.codility;

import java.util.HashMap;

/*This is a demo task.

    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

    Given A = [1, 2, 3], the function should return 4.

    Given A = [−1, −3], the function should return 1.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].*/
public class MissingInteger {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, Integer> intMap = new HashMap<>();
        int result = 1;
        for (int integer : A) {
            intMap.put(integer, integer);
        }

        for(int i = 1; i <= 1000000; i++) {
            if (!intMap.containsKey(i)) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 3, 6, 4, 1, 2});
    }
}

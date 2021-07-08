package io.fclemonschool.codility;

import java.util.HashMap;
import java.util.Map;

/*An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

    For example, consider array A such that

    A[0] = 3    A[1] = 4    A[2] =  3
    A[3] = 2    A[4] = 3    A[5] = -1
    A[6] = 3    A[7] = 3
    The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

    Write a function

    class Solution { public int solution(int[] A); }

    that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

    For example, given array A such that

    A[0] = 3    A[1] = 4    A[2] =  3
    A[3] = 2    A[4] = 3    A[5] = -1
    A[6] = 3    A[7] = 3
    the function may return 0, 2, 4, 6 or 7, as explained above.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [0..100,000];
    each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].*/
public class Dominator {
    public static int solution(int[] A) {
        // write your code in Java SE 8

        if (A.length == 0) {
            return -1;
        }

        int dominatorIndex = 0;
        int maxCount = 0;
        int maxKey = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : A) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            int currentMaxCount = Math.max(value, maxCount);
            if (maxCount < currentMaxCount) {
                maxCount = currentMaxCount;
                maxKey = key;
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();
            if (value == maxCount) {
                count++;
            }
        }
        if (count >= 2 || A.length / 2 >= maxCount) {
            return -1;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] == maxKey) {
                dominatorIndex = i;
                break;
            }
        }

        return dominatorIndex;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
        System.out.println(solution(new int[]{2, 1, 1, 3}));
        System.out.println(solution(new int[]{}));
    }
}

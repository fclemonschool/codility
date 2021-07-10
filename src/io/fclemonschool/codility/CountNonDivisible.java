package io.fclemonschool.codility;

import java.util.HashMap;

/*You are given an array A consisting of N integers.

    For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.

    For example, consider integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
    For the following elements:

    A[0] = 3, the non-divisors are: 2, 6,
    A[1] = 1, the non-divisors are: 3, 2, 3, 6,
    A[2] = 2, the non-divisors are: 3, 3, 6,
    A[3] = 3, the non-divisors are: 2, 6,
    A[4] = 6, there aren't any non-divisors.
    Write a function:

    class Solution { public int[] solution(int[] A); }

    that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.

    Result array should be returned as an array of integers.

    For example, given:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
    the function should return [2, 4, 3, 2, 0], as explained above.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..50,000];
    each element of array A is an integer within the range [1..2 * N].*/
public class CountNonDivisible {
    public int[] solution(int[] A) {
        // write your code in Java SE 8
        int[] result = new int[A.length];

        if (A.length == 1) {
            result[0] = 0;
            return result;
        }

        int count = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int a : A) {
            countMap.put(a, countMap.getOrDefault(a, 0) + 1);
        }
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        /*for (int i = 0; i < A.length; i++) { // 내가 한 것, 시간 초과
            int target = A[i];
            for (Iterator<Map.Entry<Integer, Integer>> iterator = countMap.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (target % entry.getKey() != 0) {
                    count += entry.getValue();
                }
                if (!iterator.hasNext()) {
                    result[i] = count;
                    count = 0;
                }
            }
        }*/

        for (int target : countMap.keySet()) {
            int sum = 0;
            int dividingValue = 1;
            while (dividingValue * dividingValue <= target) {
                if (target % dividingValue == 0) {
                    if (countMap.containsKey(dividingValue)) {
                        sum += countMap.get(dividingValue);
                    }
                    int k = target / dividingValue; // k = 몫
                    if (k != dividingValue) {
                        if (countMap.containsKey(k)) {
                            sum += countMap.get(k);
                        }
                    }
                }
                dividingValue++;
            }
            resultMap.put(target, A.length - sum);
        }

        for (int i = 0; i < A.length; i++) { // Map to array
            A[i] = resultMap.get(A[i]);
        }
        return A;
    }
}

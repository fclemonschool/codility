package io.fclemonschool.codility;

import java.util.HashSet;
import java.util.Set;

/*
A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
 */
public class PermCheck {
    // https://app.codility.com/demo/results/training8GXWFN-NN6/
    public static int solution(int[] A) {
        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int i : A) {
            if (i > max) {
                max = i;
            }
            set.add(i);
        }
        if (max > A.length || max < A.length || A.length != set.size()) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        assert solution(new int[]{4, 1, 3}) == 0;
        assert solution(new int[]{4, 1, 3, 2}) == 1;
    }
}

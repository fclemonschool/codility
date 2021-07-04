package io.fclemonschool.codility;
/*You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.

    You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.

    The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.

    The large sum is the maximal sum of any block.

    For example, you are given integers K = 3, M = 5 and array A such that:

    A[0] = 2
    A[1] = 1
    A[2] = 5
    A[3] = 1
    A[4] = 2
    A[5] = 2
    A[6] = 2
    The array can be divided, for example, into the following blocks:

            [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
[2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
[2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
[2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
    The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.

    Write a function:

    class Solution { public int solution(int K, int M, int[] A); }

    that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.

    For example, given K = 3, M = 5 and array A such that:

    A[0] = 2
    A[1] = 1
    A[2] = 5
    A[3] = 1
    A[4] = 2
    A[5] = 2
    A[6] = 2
    the function should return 6, as explained above.

    Write an efficient algorithm for the following assumptions:

    N and K are integers within the range [1..100,000];
    M is an integer within the range [0..10,000];
    each element of array A is an integer within the range [0..M].*/
public class MinMaxDivision { //binarySearch
    public static int solution(int K, int M, int[] A) {
        // write your code in Java SE 8
        int max = 0;
        int min = 0;

        for (int a : A) {
            max += a; // 한 블록에 모든 값이 포함된 경우가 최대값이기 때문에 초기 결과 값으로 지정
            min = Math.max(min, a);
        }
        int result = max;
        while(min <= max) { // 주어진 배열 A의 합계를 초기 값으로 저장한(이하 상한) 정수 max보다 주어진 배열 A내 최대 값을 저장한 정수 min(이하 하한)가 작거나 같을 경우 계속 수행
            int mid = (max + min) / 2; // 상한 값과 하한 값을 2로 나누어 변수 mid를 선언하고, 이진 검색을 수행
            if (dividable(mid, K, A)) {
                max = mid - 1;
                result = mid; // K 블록으로 분할이 가능하면 결과 값을 저장하는 result 변수에 mid 값을 넣고, 상한을 mid - 1 값으로 변경하여 이진 검색을 계속 수행
            } else {
                min = mid + 1; // K 블록으로 분할이 불가능하면(반복 도중 size가 0이 될 경우) 하한을 mid + 1 값으로 변경하여 이진 검색을 계속 수행
            }
        }
        return result;
    }

    public static boolean dividable(int mid, int size, int[] A) {
        int sum = 0;
        for (int j : A) {
            sum += j;
            if (sum > mid) {
                sum = j;
                size--; //그룹 축소
            }
            if (size == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 5, new int[]{5, 3}));
    }
}

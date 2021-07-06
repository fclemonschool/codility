package io.fclemonschool.codility;
/*an array a consisting of n integers is given. it contains daily prices of a stock share for a period of n consecutive days. if a single share was bought on day p and sold on day q, where 0 ≤ p ≤ q < n, then the profit of such transaction is equal to a[q] − a[p], provided that a[q] ≥ a[p]. otherwise, the transaction brings loss of a[p] − a[q].

    for example, consider the following array a consisting of six elements such that:

    a[0] = 23171
    a[1] = 21011
    a[2] = 21123
    a[3] = 21366
    a[4] = 21013
    a[5] = 21367
    if a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because a[2] − a[0] = 21123 − 23171 = −2048. if a share was bought on day 4 and sold on day 5, a profit of 354 would occur because a[5] − a[4] = 21367 − 21013 = 354. maximum possible profit was 356. it would occur if a share was bought on day 1 and sold on day 5.

    write a function,

    class solution { public int solution(int[] a); }

    that, given an array a consisting of n integers containing daily prices of a stock share for a period of n consecutive days, returns the maximum possible profit from one transaction during this period. the function should return 0 if it was impossible to gain any profit.

    for example, given array a consisting of six elements such that:

    a[0] = 23171
    a[1] = 21011
    a[2] = 21123
    a[3] = 21366
    a[4] = 21013
    a[5] = 21367
    the function should return 356, as explained above.

    write an efficient algorithm for the following assumptions:

    n is an integer within the range [0..400,000];
    each element of array a is an integer within the range [0..200,000].*/
public class MaxProfit {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int length = A.length;
        if (length == 0) {
            return 0;
        }

        int maxOne = 0;
        int maxTwo = 0;
        int min = A[0];
        for (int i = 0; i < length; i++) {
            maxOne = Math.max(A[i] - min, 0);
            min = Math.min(A[i], min);
            maxTwo = Math.max(maxOne, maxTwo);
        }
        return maxTwo;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
    }
}

/**
 *   Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
     You must not use any built-in exponent function or operator.
     For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python
     Input: x = 4
     Output: 2
     Explanation: The square root of 4 is 2, so we return 2.
*/
class SquareRoot {
    public static void main(String[] args) {
       System.out.println(findSquareRoot(4));
    }
    static int findSquareRoot(int x) {
        if (x==0 || x==1) return x;
        long left = 1, right = x, result = 0, mid = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid == x) return (int) mid;
            else if (mid * mid < x) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) result;
    }
}

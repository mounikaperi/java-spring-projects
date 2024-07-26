class Solution {
    public static void main(String[] args) {
        int[] nums = {12, 345, 67, 901, 23};
        System.out.println(findNumbers(nums));
        // Shorthand
        System.out.println(findNumbers1(nums));
    }
    public int findNumbers1(int[] nums) {
        int count =0;
        for(int i=0;i<nums.length;i++){
            if((int)(Math.log10(nums[i]))%2==1){
                count++;
            }
        }
        return count;
    }
    public int findNumbers(int[] nums) {
        int evenNumberCount = 0;
        int noOfDigitsCount = 0;
        for (int i=0; i<nums.length; i++) {
            noOfDigitsCount = countOfDigits(nums[i]);
            if (noOfDigitsCount % 2 == 0) evenNumberCount++;
        }
        return evenNumberCount;
    }
    static int countOfDigits(int num) {
        int count = 0;
        if (num < 0)  num = num * -1;
        if (num == 0) return 1;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}

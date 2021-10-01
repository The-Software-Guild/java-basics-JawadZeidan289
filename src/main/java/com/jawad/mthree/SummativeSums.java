package com.jawad.mthree;

public class SummativeSums {

    public static void main(String[] args) {
        int[] ex1 = new int[]{ 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] ex2 = new int[]{ 999, -60, -77, 14, 160, 301 };
        int[] ex3 = new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                140, 150, 160, 170, 180, 190, 200, -99 };

        System.out.println("#1 Array Sum: " + sumOfArray(ex1));
        System.out.println("#2 Array Sum: " + sumOfArray(ex2));
        System.out.println("#3 Array Sum: " + sumOfArray(ex3));
    }

    private static int sumOfArray(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum+=i;
        }
        return sum;
    }
}

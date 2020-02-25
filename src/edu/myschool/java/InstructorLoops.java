// All rights reserved (c) 2020 P. Tim Miller
// For academic use only
package edu.myschool.java;

import java.util.List;

// If you can read this, you have the wrong file. :-)
// DO NOT MODIFY, SUBMIT ONLY STUDENTLOOPS TO D2L
public class InstructorLoops implements Loops{
    public int getMaxMultiArray(int[][] intArray){
        int max = 0;
        for(int[] array: intArray){
            for(int i : array) {
                max = i > max ? i : max;
            }
        }
        return max;
    }

    public int getMaxList(List<Integer> intList){
        int max = 0;
        for(int i : intList) {
            max = i > max ? i : max;
        }
        return max;
    }

    public int getMaxArrayList(List<int[]> intArrayList){
        int max = 0;
        for(int[] i : intArrayList) {
            for (int j: i) {
                max = j > max ? j : max;
            }
        }
        return max;
    }
}

// All rights reserved (c) 2020 P. Tim Miller
// For academic use only
package edu.myschool.java;

//  PERFORMANCE TEST - ALTER VARIABLES FOR TESTING ON YOUR LOCAL SYSTEM
//  (grading will be at 1000x1000 @ 3 iterations passed to test)
//  DROP NUMBERS IF IT CRASHES ON YOUR SYSTEM
public class ComparePerformance {
    // Kobayashi Maru
    public static void main(String[] args) {
        int rows = 100;
        int cols = 100;
        int iterations = 3;

        TestData td = new TestData(TestData.Team.Teacher, rows, cols);
        td.test(iterations);
        td=null;

        // Student test
        TestData td2 = new TestData(TestData.Team.Student, rows, cols);
        td2.test(iterations);
    }
}
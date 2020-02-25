// All rights reserved (c) 2020 P. Tim Miller
// For academic use only
package edu.myschool.java;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestData {
    private int[][] intArray;
    private List<Integer> intList;
    private List<int[]> intArrayList;

    protected TestData.Team team;

    public TestData(TestData.Team team, int rows, int cols){
        this.intList = new ArrayList<>();
        this.intArrayList = new ArrayList<>();
        this.intArray = new int[rows][cols];
        this.team = team;
        System.out.println("\nBuilding test data at " + rows + "x" + cols);
        build();
        System.out.println("Build complete! Ready to test.\n");
    }

    private void build(){
        TestData.delay(2);
        int count = 0;
        Random number = new Random();

        for (int[] array : intArray) {
            intArrayList.add(new int[array.length]);
            for (int i = 0; i < array.length; i++) {
                int newInt = Math.abs(number.nextInt());
                array[i] = newInt;
                intList.add(newInt);
                intArrayList.get(count)[i] = newInt;
            }
            count++;
        }
        TestData.delay(2);
    }

    protected void test(int iterations){
        Loops maxSearch;
        if(this.team.equals(Team.Teacher)){
            maxSearch = new InstructorLoops();
        } else {
            maxSearch = new StudentLoops();
        }

        Loops finalMaxSearch = maxSearch;
        long runtime1 = 0, runtime2 = 0, runtime3 = 0;
        int counter = iterations > 0 ? iterations : 3;
        System.out.println("Running tests with " + counter + " iterations per test for " + this.team + "\n");
        int max1 = finalMaxSearch.getMaxMultiArray(intArray);
        int max2 = finalMaxSearch.getMaxList(intList);
        int max3 = finalMaxSearch.getMaxArrayList(intArrayList);
        for(int i = 0; i < iterations; i++){
            runtime1 += getTime(() ->
                    finalMaxSearch.getMaxMultiArray(intArray) );
            runtime2 += getTime(() ->
                    finalMaxSearch.getMaxList(intList) );
            runtime3 += getTime(() ->
                    finalMaxSearch.getMaxArrayList(intArrayList) );
            delay(3);
        }
        System.out.println("int[][]   max " + max1);
        System.out.printf("%s search average: %.7f ms\n\n", team.name(), ((double)runtime1 / counter)/1000000.0);
        System.out.println("List<>    max " + max2);
        System.out.printf("%s search average: %.7f ms\n\n", team.name(), ((double)runtime2 / counter)/1000000.0);
        System.out.println("List<arr> max " + max3);
        System.out.printf("%s search average: %.7f ms\n\n", team.name(), ((double)runtime3 / counter)/1000000.0);

        this.intArray=null;
        this.intList=null;
        this.intArrayList=null;
        System.gc();
    }

    private static long getTime(Runnable r) {
        long startTime = System.nanoTime();
        r.run();
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    protected static void delay(int hold){
        try {
            TimeUnit.SECONDS.sleep(hold);
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }

    // implicitly static
    public enum Team
    {
        Teacher, Student
    };
}

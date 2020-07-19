package com.company.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static private int allGood = 0; static private List<Integer> allGoodList = new ArrayList<>();
    static private int aBad = 0; static private List<Integer> aBadList = new ArrayList<>();
    static private int bBad = 0; static private List<Integer> bBadList = new ArrayList<>();
    static private int cBad = 0; static private List<Integer> cBadList = new ArrayList<>();
    static private int allDifferent = 0; static private List<Integer> allDifferentList = new ArrayList<>();

    public static void incrementAllGood(int i){
        ++allGood;
        allGoodList.add(i);
    }

    public static void incrementABad(int i){
        ++aBad;
        aBadList.add(i);
    }

    public static void incrementBBad(int i){
        ++bBad;
        bBadList.add(i);
    }

    public static void incrementCBad(int i){
        ++cBad;
        cBadList.add(i);
    }

    public static void incrementAllDifferent(int i){
        ++allDifferent;
        allDifferentList.add(i);
    }

    public static void clear(){
        allGood = 0;
        aBad = 0;
        bBad = 0;
        cBad = 0;
        allDifferent = 0;
        allGoodList.clear();
        aBadList.clear();
        bBadList.clear();
        cBadList.clear();
        allDifferentList.clear();
    }

    public static void print(){
        System.out.println("allGood: "+allGood+", "+allGoodList);
        System.out.println("aBad: "+aBad+", "+aBadList);
        System.out.println("bBad: "+bBad+", "+bBadList);
        System.out.println("cBad: "+cBad+", "+cBadList);
        System.out.println("allDifferent: "+allDifferent+", "+allDifferentList);
    }
}

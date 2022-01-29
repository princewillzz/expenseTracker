package com.expensetracker.expenseTracker.models;

public enum RepaymentAlgo {


    FIRST_IN_FIRST_OUT(Algo.FIRST_IN_FIRST_OUT);
    private final String algorithm;

    RepaymentAlgo(String algorithm) {
        this.algorithm = algorithm;
    }


    @Override
    public String toString() {
        return this.algorithm.toString();
    }

    public class Algo {
        public static final String FIRST_IN_FIRST_OUT = "first_in_first_out";
    }

}
package com.vcanus.model;

public class SecondArr {

    public static double[] MakeArray(double[] firArr){

        long[] secondArr = new long[firArr.length];
        long[] firstArr = new long[firArr.length];

        for(int i = 0; i < firArr.length; i++){
            firstArr[i] = (long)firArr[i]*10;
        }

        long result = 0;
        for(int i = 0; i < firstArr.length; i++){
            if(firstArr[i] == 0){
                secondArr[i] = 0;
            }else{
                secondArr[i] = result + firstArr[i];
            }
        }

        double[] secArr = new double[secondArr.length];

        for(int i = 0; i < secArr.length; i++){
            secArr[i] = (double)secondArr[i]/10d;
        }

        return secArr;
    }
}

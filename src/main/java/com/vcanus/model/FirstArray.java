package com.vcanus.model;

public class FirstArray {

    public static double[] MakeArray(){
        long[] firstArr = new long[100];

        for(int i = 0; i < firstArr.length; i++)
        {
            if(i < 50)
            {
                if (i % 2 == 0)
                {
                    firstArr[i] = i;
                }
                else
                {
                    firstArr[i] = -i;
                }
            }
            else if(i <60)
            {
                firstArr[i] = 0;
            }
            else
            {
                if (i % 2 == 0)
                {
                    firstArr[i] = i;
                }
                else
                {
                    firstArr[i] = -i;
                }
            }
        }

        double[] firArr = new double[firstArr.length];
        for(int i = 0; i < firstArr.length; i++){
            firArr[i] = (double)firstArr[i]/10;
        }
        return firArr;
    }

}

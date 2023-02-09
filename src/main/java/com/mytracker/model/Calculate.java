package com.mytracker.model;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Data
public class Calculate {

    public HashMap<Integer, HashMap> outerMap = new HashMap<Integer,HashMap>();

    List<Double> percentile = Arrays.asList(100.0,97.8,95.5,93.9,92.2,90.7,89.2,87.8,86.3,85.0,83.7,82.4,81.1,79.9,78.6,77.4,76.2,75.1,73.9,72.3,70.7,69.4,68.0,66.7,65.3,64.0,62.6,61.3,59.9,58.6,57.4);




    public void deneme()
    {
        int a=0;
        for(int i =1 ; i<=12 ; i++) {
            HashMap<Double, Double> innerMap = new HashMap<Double, Double>();
            for (int j = 20; j >= 12; j = j - 1) {
                double temp = Double.valueOf(j);
                temp = temp*0.5;
                innerMap.put(temp, percentile.get(a));
                a++;
                //System.out.println(innerMap.get(temp));
            }
            a -= 7;
            outerMap.put(i, innerMap);
        }
    }
}

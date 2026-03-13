package com.example;

import java.util.logging.Logger;

public class MyBigNumber {
    Logger logger = Logger.getLogger(MyBigNumber.class.getName());
    public String num(String num1, String num2){
        logger.info("From method num");

        if(num1.length() == 1 && num2.length() == 1){
            return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
        }

        String first = num1.length() > num2.length() ? num1 : num2;
        String second = num1.length() > num2.length() ? num2 : num1;

        logger.info("First: "+ first);
        logger.info("Second: " + second);

        String[] firstArray =  first.split("");
        String[] secondArray =  second.split("");


        int rememberNum = 0 ;
        StringBuilder result = new StringBuilder();

        int i = firstArray.length-1;
        int j = secondArray.length-1;

        while(i>=0){

            int jNumber = j <0 ? 0 :(Integer.parseInt(secondArray[j]));
            String sum = String.valueOf(Integer.parseInt(firstArray[i]) +  jNumber + rememberNum);

            logger.info("sum: " + sum);

            if(sum.length()>1){
                rememberNum =  Integer.parseInt(sum.charAt(0)+"");
                result.insert(0, sum.substring(1));
            }else{
                result.insert(0, sum);
                rememberNum = 0;
            }
            logger.info("rememberNum: " + rememberNum);
            logger.info("Result: " + result);

            i--;
            j--;

        }

        logger.info("DONE: "+result);
        return result.toString();
    }
}

package com.example.mini.validators;

public class LongtoStr {

    private LongtoStr(){}
    public static boolean isParsable(String string){
        try{
            Long.parseLong(string);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}

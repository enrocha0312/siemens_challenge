package org.example.Operators;

public class StringOperations {
    public static String ConcatRemove(String s, String t, int k){
        //the example from bla bla bla bla ignores the empty spaces
        //so I'll just make a trim operation for all spaces

        s = s.replace(" ","");
        t = t.replace(" ","");


        if(((s.length()<1) || (s.length()>100)))throw new ConstraintException("The length of String s must be between 1 and 100");
        if(((t.length()<1) || (t.length()>100)))throw new ConstraintException("The length of String t must be between 1 and 100");
        if(k<1 || k>100)throw new ConstraintException("k must be between 1 and 100");
        if(!s.matches("[a-z]+") || !t.matches("[a-z]+"))throw new ConstraintException("One of the words does not have only the lower characters from Portuguese Language");



        int sumLength = s.length()+t.length();

        //what is this verification? if k has the sum of the lengths, it can just erase a string and the other
        // but I also must verify if the difference between k and this sum of length is even, because it will be operations remaining
        // so what I would do, I should undo it
        if((k>=sumLength) && (((k-sumLength)%2)==0)){
            return "yes";
        }

        //let's verify if they have the same starting letters
        int sharedPrefix = 0;
        int minLength = Math.min(s.length(), t.length());

        for(int i =0; i< minLength;i++){
            if(s.charAt(i) == t.charAt(i)){
                sharedPrefix++;
            }else {
                break;
            }
        }
        int extrasCharactersFromStringS = s.length()-sharedPrefix;
        int charactersThatMustBeAdd = t.length() - sharedPrefix;
        int numberOfOperations = extrasCharactersFromStringS + charactersThatMustBeAdd;

        if (numberOfOperations==k){
            return "yes";
        }else if (numberOfOperations>k){
            return "no";
        }else {
            //if numberOfOperations>k, we should verify if there is any way to realize it
            //if we have more operations and the difference between them is even, we can just remove and add forever
            if(((k-numberOfOperations)%2)==0)return "yes";
            return "no";
        }
    }
}

package org.example.operators;


import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StringOperatorsTest {
    @Test
    public void itReturnsYesForANumberKGreaterThanSumofSandTAttendingToTheEvenDifferenceCondition(){
        String s = "abc";
        String t = "def";
        int k = 10;
        String response = StringOperations.ConcatRemove(s, t,k);
        assertEquals(response, "yes");
        assertTrue(k>(s.length()+t.length()));
        assertEquals(response.getClass(), String.class);
        assertNotNull(response);
    }
    @Test
    public void itReturnsYesForANumberKGreaterThanSumofSandTAttendingToTheEvenDifferenceConditionButKIsOdd(){
        String s = "abc";
        String t = "def";
        int k = 9;
        String response = StringOperations.ConcatRemove(s, t,k);
        assertEquals(response, "no");
        assertTrue(k>(s.length()+t.length()));
        assertEquals(response.getClass(), String.class);
        assertNotNull(response);
    }
    @Test
    public void itReturnsYesForKEqualNumberOfOperations(){
        String s = "bla bla bla bla".replace(" ", "");
        String t = "blablabcde";
        int k = 8;
        String response = StringOperations.ConcatRemove(s,t,k);
        assertEquals(response, "yes");
        assertEquals(response.getClass(), String.class);
        assertTrue(k<(s.length()+t.length()));
        assertNotNull(response);
    }
    @Test
    public void itReturnsYesForKGreaterThanNumberOfOperationsButOdd(){
        String s = "bla bla bla bla".replace(" ", "");
        String t = "blablabcde";
        int k = 9;
        String response = StringOperations.ConcatRemove(s,t,k);
        assertEquals(response, "no");
        assertEquals(response.getClass(), String.class);
        assertTrue(k<(s.length()+t.length()));
        assertNotNull(response);
    }
    @Test
    public void itReturnsYesForKLessThanNumberOfOperationsButOdd(){
        String s = "bla bla bla bla".replace(" ", "");
        String t = "blablabcde";
        int k = 7;
        String response = StringOperations.ConcatRemove(s,t,k);
        assertEquals(response, "no");
        assertEquals(response.getClass(), String.class);
        assertTrue(k<(s.length()+t.length()));
        assertNotNull(response);
    }
    @Test
    public void itReturnsYesForKLessThanNumberOfOperationsEven(){
        String s = "bla bla bla bla".replace(" ", "");
        String t = "blablabcde";
        int k = 10;
        String response = StringOperations.ConcatRemove(s,t,k);
        assertEquals(response, "yes");
        assertEquals(response.getClass(), String.class);
        assertTrue(k<(s.length()+t.length()));
        assertNotNull(response);
    }
    @Test
    public void itThrowsConstraintExceptionForStringSLessThan1(){
        String s="";
        String t="abcdefg";
        int k =10;
        try{
            StringOperations.ConcatRemove(s,t,k);
        }catch (Exception e){
            assertEquals(s.length(), 0);
            assertEquals(e.getClass(), ConstraintException.class);
            assertEquals(e.getMessage(), "The length of String s must be between 1 and 100");
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void itThrowsConstraintExceptionForStringSGreaterThan100(){
        String s=generateRandomStringGreaterThan100();
        String t="abcdefg";
        int k =10;
        try{
            StringOperations.ConcatRemove(s,t,k);
        }catch (Exception e){
            assertTrue(s.length()>100);
            assertEquals(e.getClass(), ConstraintException.class);
            assertEquals(e.getMessage(), "The length of String s must be between 1 and 100");
            assertNotNull(e.getMessage());
        }
    }
    @Test
    public void itThrowsConstraintExceptionForStringTLessThan1(){
        String t="";
        String s="abcdefg";
        int k =10;
        try{
            StringOperations.ConcatRemove(s,t,k);
        }catch (Exception e){
            assertEquals(t.length(), 0);
            assertEquals(e.getClass(), ConstraintException.class);
            assertEquals(e.getMessage(), "The length of String t must be between 1 and 100");
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void itThrowsConstraintExceptionForStringTGreaterThan100(){
        String t=generateRandomStringGreaterThan100();
        String s="abcdefg";
        int k =10;
        try{
            StringOperations.ConcatRemove(s,t,k);
        }catch (Exception e){
            assertTrue(t.length()>100);
            assertEquals(e.getClass(), ConstraintException.class);
            assertEquals(e.getMessage(), "The length of String t must be between 1 and 100");
            assertNotNull(e.getMessage());
        }
    }
    @Test
    public void itThrowsConstraintDueToKZero(){
        int k=0;
        try{
            StringOperations.ConcatRemove("abcd","efgh", k);
        }catch (Exception e){
            assertEquals(e.getClass(), ConstraintException.class);
            assertEquals(e.getMessage(), "k must be between 1 and 100");
            assertNotNull(e.getMessage());
        }
    }
    @Test
    public void itThrowsConstraintDueToKGreaterThan100(){
        int k=101;
        try{
            StringOperations.ConcatRemove("abcd","efgh", k);
        }catch (Exception e){
            assertEquals(e.getClass(), ConstraintException.class);
            assertEquals(e.getMessage(), "k must be between 1 and 100");
            assertNotNull(e.getMessage());
        }
    }
    @Test
    public void itThrowsExceptionForStringSWithoutTheAppropriateCharacters(){
        String s="Açaí";
        String t="abcdefg";
        int k =10;
        try{
            StringOperations.ConcatRemove(s,t,k);
        }catch (Exception e){
            assertEquals(e.getClass(), ConstraintException.class);
            assertEquals(e.getMessage(), "One of the words does not have only the lower characters from Portuguese Language");
            assertNotNull(e.getMessage());
        }
    }
    @Test
    public void itThrowsExceptionForStringTWithoutTheAppropriateCharacters(){
        String t="Açaí";
        String s="abcdefg";
        int k =10;
        try{
            StringOperations.ConcatRemove(s,t,k);
        }catch (Exception e){
            assertEquals(e.getClass(), ConstraintException.class);
            assertEquals(e.getMessage(), "One of the words does not have only the lower characters from Portuguese Language");
            assertNotNull(e.getMessage());
        }
    }
    private String generateRandomStringGreaterThan100() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<= 101; i++) {
            char randomChar = (char) ('a' + random.nextInt(26)); // Gera um caractere entre 'a' e 'z'
            sb.append(randomChar);
        }
        return sb.toString();
    }
}

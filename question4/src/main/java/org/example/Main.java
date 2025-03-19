package org.example;

import org.example.Operators.StringOperations;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringOperations.ConcatRemove("bla bla bla bla", "blablabcde",8));//yes
        System.out.println(StringOperations.ConcatRemove("abc", "def",6));//yes
        System.out.println(StringOperations.ConcatRemove("abc", "def",10));//yes
        System.out.println(StringOperations.ConcatRemove("abc", "def",9));//no
        System.out.println(StringOperations.ConcatRemove("abc", "def",5));//no
    }
}
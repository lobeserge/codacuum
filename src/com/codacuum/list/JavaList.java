package com.codacuum.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaList {
    public static void main(String[] args) {

        //define a new list
        List<String> stringList = new ArrayList<>();

        // add elements to a list
        stringList.add("Orange");
        stringList.add("Apple");
        stringList.add("banana");
        stringList.add("Pineapple");

        //get and print banana to console
        System.out.println(stringList.get(2));

        //get and print the size of our list
        System.out.println(stringList.size());

        //iterate the elements of our list
        for (String element:stringList){
            System.out.println(element);
        }

        //remove second element from list
       // stringList.remove(1);
        stringList.remove("Apple");
        System.out.println(stringList.size());

        //check of apple is still present in our list

        System.out.println(stringList.contains("Apple"));

        //update orange to watermelon
        stringList.set(0,"Watermelon");
        System.out.println(stringList.contains("Watermelon"));

        //get and print index of watermelon
        System.out.println(stringList.indexOf("Watermelon"));

        //clear list and print new size
        stringList.clear();
        System.out.println(stringList.size());

        //define new list and add to old list
        List<String> newList = new ArrayList<>();
        newList.add("java");
        newList.add("Python");
        newList.add("JavaScript");

        stringList.addAll(newList);

        //conversion from list and array
        String[] arrayString = stringList.toArray(new String[0]);
        for (int i=0; i<arrayString.length;i++){
            System.out.println(arrayString[i]);
        }

        //convert array to list

        String[] values = new String[]{ "angular", "react", "vue",};
        List<String> newListFromArray =  Arrays.asList(values);
        System.out.println(newListFromArray.size());




    }
}

package com.ocp17.java7;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DiamondOperator {
    public static void main(String[] args) {
      beforeJava7();
      System.out.println("--------------------------");
      withJava7();
    }
    private static void beforeJava7() {
      Map<String, Integer> inputMap = new HashMap<String, Integer>();
      inputMap.put("Sunday", 1);
      inputMap.put("Monday", 2);
      inputMap.put("Tuesday", 3);
      inputMap.put("Wednesday", 4);
      inputMap.put("Thursday", 5);
      inputMap.put("Friday", 6);
      inputMap.put("Saturday", 7);
      for (Entry<String, Integer> entry: inputMap.entrySet()) {
        System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
      }
    }
    private static void withJava7() {
      Map<String, Integer> inputMap = new HashMap<>();
      inputMap.put("Sunday", 1);
      inputMap.put("Monday", 2);
      inputMap.put("Tuesday", 3);
      inputMap.put("Wednesday", 4);
      inputMap.put("Thursday", 5);
      inputMap.put("Friday", 6);
      inputMap.put("Saturday", 7);
      for (Entry<String, Integer> entry: inputMap.entrySet()) {
        System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
      }
    }
}
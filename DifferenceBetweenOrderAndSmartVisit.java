import java.io.*;
import java.util.*;

/*
You are going on a camping trip, but before you leave you need to buy groceries. To optimize your time spent in the store, instead of buying the items from your shopping list in order, you plan to buy everything you need from one department before moving to the next.

Given an unsorted list of products with their departments and a shopping list, return the time saved in terms of the number of department visits eliminated.

Example: 
products = [
    ["Cheese",          "Dairy"],
    ["Carrots",         "Produce"],
    ["Potatoes",        "Produce"],
    ["Canned Tuna",     "Pantry"],
    ["Romaine Lettuce", "Produce"],
    ["Chocolate Milk",  "Dairy"],
    ["Flour",           "Pantry"],
    ["Iceberg Lettuce", "Produce"],
    ["Coffee",          "Pantry"],
    ["Pasta",           "Pantry"],
    ["Milk",            "Dairy"],
    ["Blueberries",     "Produce"],
    ["Pasta Sauce",     "Pantry"]
]

list1 = ["Blueberries", "Milk", "Coffee", "Flour", "Cheese", "Carrots"]

For example, buying the items from list1 in order would take 5 department visits, whereas your method would lead to only visiting 3 departments, a difference of 2 departments.

Produce(Blueberries)->Dairy(Milk)->Pantry(Coffee/Flour)->Dairy(Cheese)->Produce(Carrots) = 5 department visits
New: Produce(Blueberries/Carrots)->Pantry(Coffee/Flour)->Dairy(Milk/Cheese) = 3 department visits

list2 = ["Blueberries", "Carrots", "Coffee", "Milk", "Flour", "Cheese"] => 2
list3 = ["Blueberries", "Carrots", "Romaine Lettuce", "Iceberg Lettuce"] => 0
list4 = ["Milk", "Flour", "Chocolate Milk", "Pasta Sauce"] => 2
list5 = ["Cheese", "Potatoes", "Blueberries", "Canned Tuna"] => 0

All Test Cases:
shopping(products, list1) => 2
shopping(products, list2) => 2
shopping(products, list3) => 0
shopping(products, list4) => 2
shopping(products, list5) => 0

Complexity Variable:
n: number of products
*/


class Main {
     public static void main(String[] argv) {

    String[][] products = {
      {"Cheese",          "Dairy"},
      {"Carrots",         "Produce"},
      {"Potatoes",        "Produce"},
      {"Canned Tuna",     "Pantry"},
      {"Romaine Lettuce", "Produce"},
      {"Chocolate Milk",  "Dairy"},
      {"Flour",           "Pantry"},
      {"Iceberg Lettuce", "Produce"},
      {"Coffee",          "Pantry"},
      {"Pasta",           "Pantry"},
      {"Milk",            "Dairy"},
      {"Blueberries",     "Produce"},
      {"Pasta Sauce",     "Pantry"}
    };


    String[] list1 = {"Blueberries", "Milk", "Coffee", "Flour", "Cheese", "Carrots"};
    String[] list2 = {"Blueberries", "Carrots", "Coffee", "Milk", "Flour", "Cheese"};
    String[] list3 = {"Blueberries", "Carrots", "Romaine Lettuce", "Iceberg Lettuce"};
    String[] list4 = {"Milk", "Flour", "Chocolate Milk", "Pasta Sauce"};
    String[] list5 = {"Cheese", "Potatoes", "Blueberries", "Canned Tuna"};
    
    String[][] samples = {list1,list2,list3,list4,list5};
    
        for(int p=0;p<samples.length;p++){
            System.out.println("shopping(products, list"+(p+1)+") => "+shopping(products, samples[p]));
        }
    }
  
        public static int shopping(String[][] products, String[] sample) {
                int inOrderVisitCount = 0;
                int smartVisitCount = 0;
                String currentVisit = null;
                String previousVisit = null;
                Set<String> uniqueValue = new HashSet<String>();
            for(int p=0;p<sample.length;p++) {
                for(int i=0;i<products.length;i++){
                currentVisit = products[i][1];
                  if(sample[p] == products[i][0] && (previousVisit == null || currentVisit != previousVisit)) {
                          inOrderVisitCount++;
                          previousVisit = currentVisit;
                          uniqueValue.add(products[i][1]);
                    }
                }
            }
            smartVisitCount = uniqueValue.size();
            return inOrderVisitCount - smartVisitCount;
        }

}

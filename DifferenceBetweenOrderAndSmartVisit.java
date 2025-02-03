import java.io.*;
import java.util.*;

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

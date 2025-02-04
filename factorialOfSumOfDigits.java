/*Identify the factorial of sum of digits until it becomes as single digit
*/

class Main {
    
    public static void main(String[] args) {
        int[] sample = {23,67,678};
     for(int p=0;p<sample.length;p++) {
        int result = 0;
        
        int s = sample[p];
        int temp = s;
        while(String.valueOf(temp).toString().length() > 1){
                result = sumOfNumber(temp);
                temp = result;
        }
          System.out.println("Sum of "+sample[p]+" is " +result+" Factorial of "+result+" is "+factorial(result)); 
        }
    }
    
    public static int sumOfNumber(int value) {
        int temp = 0;
        while(value>0){
            int r = value%10;
            temp = temp + r;
            value = value/10;
        }
        return temp;
    }
    
    public static int factorial(int value) {
        int fact = 1;
        for(int i=value;i>=1;i--) {
            fact = fact * i;
        }
        return fact;
    }
}

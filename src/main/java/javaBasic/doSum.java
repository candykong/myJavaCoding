package javaBasic;

public class doSum {
    public static  Integer test_sum(){
        int s=0;
        for(int i=0; i<101; i++){
            s +=i;
        }
        System.out.println("0到100内整数的和为："+s);
        return s;
    }

    public static void main(String[] args) {
        test_sum();


    }
}

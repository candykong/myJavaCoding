package javaExercise;

import java.util.Collections;
import java.util.Comparator;
import  java.util.ArrayList;


public class ComparatorDemo implements Comparator<Students> {

    @Override
    public int compare(Students o1, Students o2) {
        /**
         * 先按成绩由大到小排名，成绩相同时候按照年龄由低到高排序。
         */
        if(o1.getScore() >o2.getScore()){
            return -1;
        }
        else if(o1.getScore()<o2.getScore()){
            return 1;
        }
        else {
            if(o1.getAge()>o2.getAge()){
                return 1;
            }
            else if(o1.getAge()<o2.getAge()){
                return -1;
            }
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        /**
         * 将对象装进数组，然后用数组的Arrays.sort方法排序
         */
        Students s[] = {new Students("zhangsan",20,89),
                new Students("lisi",22,89),
                new Students("wangwu",23,78),
                new Students("sunliu",27,90)};
        java.util.Arrays.sort(s,new ComparatorDemo());
        for(Students s1:s){
            System.out.println(s1);
        }

        /**
         * 使用Collections.sort排序
         */
        ArrayList<Students> st=new ArrayList<Students>();
        Students s1 = new Students("zhangsan",20,89);
        Students s2 = new Students("lisi",22,89);
        Students s3 = new Students("wangwu",23,78);
        Students s4 =  new Students("sunliu",27,90);
        st.add(s1);
        st.add(s2);
        st.add(s3);
        st.add(s4);
        Collections.sort(st,new ComparatorDemo());
        for(Students s0:st){
            System.out.println(s0);
        }
    }
}

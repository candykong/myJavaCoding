package javaExercise;

import com.sun.jnlp.ClipboardServiceImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableDemo implements Comparable<ComparableDemo> {
    private  String name;
    private  int age;
    private  float score;

    public ComparableDemo(String name,int age,float score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString(){
        return name +"\t\t"+age+"\t\t"+score;
    }

    @Override
    public int compareTo(@NotNull ComparableDemo o) {
        /**
         * 先按成绩由大到小排名，成绩相同时候按照年龄由低到高排序。
         */
        if(this.score >o.score){
            return -1;
        }
        else if(this.score<o.score){
            return 1;
        }
        else {
            if(this.age>o.age){
                return 1;
            }
            else if(this.age<o.age){
                return -1;
            }
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        /**
         * 先按成绩由大到小排名，成绩相同时候按照年龄由低到高排序。
         */
        ComparableDemo c[] = {new ComparableDemo("zhangsan",20,89),
                new ComparableDemo("lisi",22,89),
                new ComparableDemo("wangwu",23,78),
                new ComparableDemo("sunliu",27,90)};
        java.util.Arrays.sort(c);
        for(ComparableDemo c1:c){
            System.out.println(c1);
        }
    }
}


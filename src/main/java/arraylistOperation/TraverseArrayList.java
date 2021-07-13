package arraylistOperation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TraverseArrayList {

    //使用for遍历
    public static void traverseUsingFor(ArrayList<String> a){
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }

    }

    //使用foreach遍历
    public  static void traverUsingForeach(ArrayList<String> a){
        for (String str:a
        ) {
            System.out.println(str);
        }

    }

    //使用迭代器遍历
    public static void traverUsingIterator(ArrayList<String> a){
        Iterator<String> i = a.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        System.out.println("使用for遍历arraylist:");
        TraverseArrayList.traverseUsingFor(a);
        System.out.println("使用foreach遍历arraylist:");
        TraverseArrayList.traverUsingForeach(a);
        System.out.println("使用iterator遍历arraylist:");
        TraverseArrayList.traverUsingIterator(a);
    }



}

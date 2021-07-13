package javaExercise;

import java.util.*;

public class JavaUtilDemo {

    public static void vectorTest(){
        Enumeration<String> days;
        Vector<String> dayNames  = new Vector<String>();
        dayNames.add("monday");
        dayNames.add("tuesday");
        dayNames.add("wednesday");
        dayNames.add("thursday");
        dayNames.add("friday");
        dayNames.add("saturday");
        dayNames.add("sunday");
        days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
    }

    public static void mapTest(){
        Map<String,Integer>  m1 = new HashMap<>();
        m1.put("张三",20);
        m1.put("张三1",21);
        m1.put("张三2",22);
        m1.put("张三3",23);
        System.out.println("Map Elements");
        System.out.print("\t"+m1);
        List<Map.Entry<String,Integer>> list = new ArrayList<>(m1.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()-o1.getValue());
            }
        });
        System.out.println(list);
    }

    public static Map<String, Integer> sortMapByvalues(Map<String,Integer> m){
        /**
         * 利用collectios.sort进行按值排序
         */
        List<Map.Entry<String,Integer>> list = new ArrayList<>(m.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()-o1.getValue());
            }
        });
        Map<String,Integer> m2 = new LinkedHashMap<String, Integer>();
        for(Map.Entry<String,Integer> entry :list){
            m2.put(entry.getKey(),entry.getValue());
        }
        System.out.println(m2);
        return m2;
    }


    public  static  void sortByKeys(Map<String,Integer>  m){
        /**
         * 利用TreeMap自动对map按键排序 增序
         */
        TreeMap<String,Integer> tm = new TreeMap<>(m);
        for(Iterator<String> it = tm.keySet().iterator(); it.hasNext();){
            String s = it.next();
           System.out.println(s +"\t"+ m.get(s));
        }
    }



    public static void main(String[] args) {
        //EnumerationDemo.vectorTest();
        Map<String,Integer>  m1 = new HashMap<>();
        m1.put("张三",20);
        m1.put("张三3",10);
        m1.put("张三1",21);
        m1.put("张三2",22);

//        EnumerationDemo.sortMapByvalues(m1);
        JavaUtilDemo.sortByKeys(m1);
    }





}

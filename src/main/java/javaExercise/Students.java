package javaExercise;

public class Students {
    private String name;
    private  int age;
    private  float score;

    public Students(String name,int age,float score){
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public String toString(){
        return name +"\t\t"+age+"\t\t"+score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getScore() {
        return score;
    }
}

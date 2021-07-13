/**
 * @author kongzhibing
 * @create 2021-07-05-9:43
 */
public class Subject {
    private String name;
    private double grade;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    public double getAverageGrade(Double chinesegrade, Double mathgrade, Double englishgrade){

        double avg = (chinesegrade + mathgrade + englishgrade)/3;
        return avg;
    }


    public void getGradeLevel(double avg){
        if(avg <  0 || avg > 100){
            System.out.println("成绩输入有误");
        }
        else if(avg >=90){
            System.out.println("优秀");
        }
        else if(avg >=80){
            System.out.println("良好");
        }
        else if(avg >=60){
            System.out.println("及格");
        }
        else System.out.println("不及格");

    }
}

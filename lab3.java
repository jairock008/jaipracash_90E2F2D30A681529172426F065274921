import java.util.*;
interface exam{
    void percent_call();
}

class students{
    String name;
    int rno, mark1, mark2;
    students(String n, int r, int m1, int m2){
        name = n;
        rno = r;
        mark1 = m1;
        mark2 = m2;
    }
    void display(){
        System.out.println("Name of the student:"+ name);
        System.out.println("Roll No of the student:"+ rno);
        System.out.println("Marks in subject1:"+ mark1);
        System.out.println("Marks in subject2:"+mark2);
    }
}
class results extends students implements exam{
    results(String n, int r, int m1, int m2){
        super(n, r, m1, m2);
    }
    public void percent_cal(){
        int total = (mark1 + mark2);
        float percentage = total*100/200;
        System.out.println("percentage:"+percentage);
    }
    void display(){
        super.display();
    }
}

class lab3{
    public static void main(String[] args){
        Random ran = new Random();
        int n = ran.nextInt();
        results r= new results("jai", 12, 98, 99);
        r.display();
        r.percent_cal();
    }
}

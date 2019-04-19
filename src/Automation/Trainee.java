package Automation;

public class Trainee {

    public static void main(String[] args) {
        teamQA obj = new teamQA();

        obj.health_status = true;
        obj.age=23;
        obj.designation="trainee";
        obj.gender='M';
        obj.name="raghav";
        obj.project_name="kiosk";

        System.out.println("Age is = " + obj.age);
        System.out.println("Name is = " + obj.name);
        System.out.println("Project_name is = " + obj.project_name);
        System.out.println("Designation is = " + obj.designation);
        System.out.println("Gender is = " + obj.gender);
        System.out.println("Health is=" +obj.health_status);
    }
}

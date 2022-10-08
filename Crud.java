import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Crud {
    int empNo;
    String empName;
    int salary;

    public Crud(int empNo,String empName, int salary){
        this.empNo = empNo;
        this.empName = empName;
        this.salary = salary;

    }

    public int getEmpNo() {
        return empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public int getSalary() {
        return salary;
    }
    public String toString(){
        return empNo+" "+empName+" "+salary;
    }

}
 class Employee{
     public static void main(String[] args) {
         ArrayList<Crud> emp = new ArrayList<Crud>();
         Scanner sc = new Scanner(System.in);
         Scanner sc1 = new Scanner(System.in);
         int ch;
         do{
             System.out.println("1.INSERT");
             System.out.println("2.DISPLAY");
             System.out.println("3.SEARCH");
             System.out.println("4.DELETE");
             System.out.println("5.UPDATE");
             System.out.println("Enter Your Choice : ");
             ch = sc.nextInt();

             switch(ch){
                 case 1:
                     System.out.println("Enter Emp No: ");
                     int eno = sc.nextInt();
                     System.out.println("Enter Emp Name");
                     String ename = sc1.nextLine();
                     System.out.println("Enter Salary : ");
                     int sal = sc.nextInt();
                     emp.add(new Crud(eno,ename,sal));
                     break;
                 case 2:
                     System.out.println("-----------------------");
                     Iterator<Crud> i = emp.iterator();
                     while(i.hasNext()){
                         Crud e = i.next();
                         System.out.println(e);
                     }
                     System.out.println("----------------------");
                     break;
                 case 3:
                     boolean found  = false;
                     System.out.println("Enter EmpNo to Search : ");
                     int empNo = sc.nextInt();
                     System.out.println("---------------");
                     i = emp.iterator();
                     while(i.hasNext()){
                         Crud e = i.next();
                         if(e.getEmpNo() == empNo){
                             System.out.println(e);
                             found = true;
                         }
                     }
                     if(!found){
                         System.out.println("Record not Found");
                     }
                     System.out.println("---------------------");
                     break;

                 case 4 :
                      found = false;
                     System.out.println("Enter EmpNo to delete : ");
                     empNo = sc.nextInt();
                     System.out.println("----------------");
                     i = emp.iterator();
                     while(i.hasNext()){
                         Crud e = i.next();
                         if(e.getEmpNo() == empNo){
                             i.remove();
                             found = true;

                         }
                     }
                     if(!found){
                         System.out.println("Record not Found");
                     }else{
                         System.out.println("Record is deleted successfully");
                     }
                     System.out.println("--------------------");
                     break;

                 case 5 :
                     found= false;
                     System.out.println("Enter empNo to update : ");
                     empNo = sc.nextInt();
                     ListIterator<Crud> li = emp.listIterator();
                     while(li.hasNext()){
                         Crud e = li.next();
                         if(e.getEmpNo() == empNo){
                             System.out.println("Enter new Name1 : ");
                             ename = sc1.nextLine();
                             System.out.println("Enter new Salary : ");
                             sal = sc.nextInt();
                             li.set(new Crud(empNo,ename,sal));
                             found = true;
                         }
                     }
                     if(!found){
                         System.out.println("record not found");
                     }else{
                         System.out.println("Record is updated successfully");
                     }
                     break;



             }
         }while(ch!=0);
     }

}

package org.example;

import java.util.*;

public class Service {
    public DataAccess dataAccess = new DataAccess();
    public void addStudent(List<Student> students)
    {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        boolean nullCheck = false;
        do {
            String line = null;
            System.out.print("Name: ");
            if(!(line = scanner.toString()).isEmpty())
            {
                student.setName(line);
                System.out.println();
            }
            else{
                nullCheck = true;
            }
            System.out.print("Sex: ");
            if(!(line = scanner.toString()).isEmpty())
            {
                student.setSex(line);
                System.out.println();
            }else{
                nullCheck = true;
            }
            System.out.print("Age: ");
            if(!(line = scanner.toString()).isEmpty())
            {
                student.setAge(Integer.parseInt(line));
                System.out.println();
            }
            else{
                nullCheck = true;
            }
            System.out.print("Math: ");
            if(!(line = scanner.toString()).isEmpty())
            {
                student.setMathResult(Float.parseFloat(line));
                System.out.println();
            }
            else{
                nullCheck = true;
            }
            System.out.print("Physic: ");
            if(!(line = scanner.toString()).isEmpty())
            {
                student.setPhysResult(Float.parseFloat(line));
                System.out.println();
            }
            else{
                nullCheck = true;
            }
            System.out.print("Chemistry: ");
            if(!(line = scanner.toString()).isEmpty())
            {
                student.setChemistryResult(Float.parseFloat(line));
                System.out.println();
            }
            else{
                nullCheck = true;
            }
            student.setAverage(avg(student.getMathResult(), student.getPhysResult(), student.getChemistryResult()));
        } while (nullCheck);
        student.setId(students.size());
        students.add(student);
    }
    public void updateById(int id, List<Student> students)
    {
        for(Student student: students)
        {
            if(id == student.getId())
            {
                Scanner scanner = new Scanner(System.in);
                System.out.println(student.toString());
                System.out.print("Name: ");
                String line = scanner.toString();
                student.setName(line);
                System.out.println();
                System.out.print("Sex: ");
                if(!(line = scanner.toString()).isEmpty())
                {
                    student.setSex(line);
                    System.out.println();
                }
                System.out.print("Age: ");
                if(!(line = scanner.toString()).isEmpty())
                {
                    int age = Integer.parseInt(line);
                    student.setAge(age);
                    System.out.println();
                }
                System.out.print("Math: ");
                if(!(line = scanner.toString()).isEmpty())
                {
                    student.setMathResult(Float.parseFloat(line));
                    System.out.println();
                }
                System.out.print("Physic: ");
                if(!(line = scanner.toString()).isEmpty())
                {
                    student.setPhysResult(Float.parseFloat(line));
                    System.out.println();
                }
                System.out.print("Chemistry: ");
                if(!(line = scanner.toString()).isEmpty())
                {
                    student.setChemistryResult(Float.parseFloat(line));
                    System.out.println();
                }
                student.setAverage(avg(student.getMathResult(), student.getPhysResult(), student.getChemistryResult()));
                break;
            }
        }
    }
    public void deleteById(int id, List<Student> students)
    {
        for(Student student: students)
        {
            if(id == student.getId())
            {
                students.remove(student);
                break;
            }
        }
    }
    public List<Student> searchByName(String name, List<Student> students)
    {
        List<Student> studentList = new ArrayList<>();
        for(Student student: students)
        {
            if(name.equals(student.getName()))
            {
                studentList.add(student);
            }
        }
        return studentList;
    }
    public void arrangeByScore(List<Student> students)
    {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Float.compare(s1.getAverage(), s2.getAverage());
            }
        });
        displayAllStudent(students);
    }
    public void arrangeByName(List<Student> students)
    {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        displayAllStudent(students);
    }
    public void displayAllStudent(List<Student> students)
    {
        System.out.println(Arrays.toString(students.toArray()));
    }
    public void saveChange(List<Student> students)
    {
        dataAccess.saveData(students);
    }
    public float avg(float a, float b, float c)
    {
        float sum = a + b+ c;
        return sum/3;
    }
}

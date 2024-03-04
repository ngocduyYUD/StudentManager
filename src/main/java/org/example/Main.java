package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Student> students;
    public static DataAccess dataAccess = new DataAccess();
    public static Service service = new Service();
    public static void main(String[] args) {
        int choose = 0;
        students = dataAccess.getData();
        Scanner scanner = new Scanner(System.in);
        do {
            menuPrint();
            System.out.print("your choose: ");
            choose = scanner.nextInt();
            switch (choose)
            {
                case 1:
                    service.addStudent(students);
                    break;
                case 2:
                    System.out.print("update id: ");
                    int updateId = scanner.nextInt();
                    service.updateById(updateId, students);
                    break;
                case 3:
                    System.out.print(" delete id: ");
                    int deleteId = scanner.nextInt();
                    service.deleteById(deleteId, students);
                    break;
                case 4:
                    System.out.print("search by name: ");
                    String searchName = scanner.toString();
                    List<Student> searchNameResult = service.searchByName(searchName, students);
                    System.out.println(Arrays.toString(searchNameResult.toArray()));
                    break;
                case 5:
                    service.arrangeByScore(students);
                    break;
                case 6:
                    service.arrangeByName(students);
                    break;
                case 7:
                    service.displayAllStudent(students);
                    break;
                case 8:
                    service.saveChange(students);
                    break;
                case 0:
                    // code block
                    break;
            }
        } while (choose != 0);
    }
    public static void menuPrint()
    {
        System.out.println("**********Menu*********");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student By Id");
        System.out.println("3. Delete Studen By Id");
        System.out.println("4. Search By Name");
        System.out.println("5. Arrange By Average");
        System.out.println("6. Arrange By Name");
        System.out.println("7. Display All Student");
        System.out.println("8. Save Change");
    }
}
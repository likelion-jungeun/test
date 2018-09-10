import java.util.Scanner;

import bitcamp.java110test.cms.control.ManagerController;
import bitcamp.java110test.cms.control.StudentController;
import bitcamp.java110test.cms.control.TeacherController;

public class App {

    // arrayList 생성

    static Scanner key = new Scanner(System.in);

    public static String promptMenu() {

        System.out.println("[메뉴]");
        System.out.println("1.학생관리");
        System.out.println("2.강사관리");
        System.out.println("3.매니저관리");
        System.out.println("0.종료");
        System.out.println("번호를 입력하세요");
        while (true) {
            String menu = key.nextLine();
            switch (menu) {
            case "1":
            case "2":
            case "3":
            case "0":
                return menu;
            default:
                System.out.println("유효하지 않는 명령어입니다.");
            }
        }
    }

    public static void main(String[] args) {
        
        StudentController sc=new StudentController(key);
        TeacherController tc=new TeacherController(key);
        ManagerController mc=new ManagerController(key);
        

        while (true) {

            String menu = promptMenu();
            if (menu.equals("1")) {
                sc.serviceStudentMenu();
            } else if (menu.equals("2")) {
                tc.serviceTeacherMenu();
            } else if (menu.equals("3")) {
                mc.serviceManagerMenu();
            } else if (menu.equals("0")) {
                System.out.println("안녕히 가세요!");
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
        }
        key.close();
    }

}
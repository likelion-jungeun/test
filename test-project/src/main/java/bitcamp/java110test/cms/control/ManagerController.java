package bitcamp.java110test.cms.control;

import java.util.Scanner;

import bitcamp.java110test.cms.dao.ManagerList;
import bitcamp.java110test.cms.domain.Manager;

public class ManagerController {

    public static Scanner key;

    public static void inputManager() {

        while (true) {
            Manager m = new Manager();
            System.out.println("이름? ");
            m.setName(key.nextLine());
            System.out.println("나이? ");
            m.setAge(Integer.parseInt(key.nextLine()));
            System.out.println("전공? ");
            m.setMajor(key.nextLine());
            System.out.println("직위? ");
            m.setPosition(key.nextLine());

            ManagerList.add(m);

            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;
        }
    }

    public static void printManager() {
        for (int i = 0; i < ManagerList.size(); i++) {
            Manager m = ManagerList.get(i);
            System.out.printf("[%d] %s %d %s %s\n", i, m.getName(), m.getAge(), m.getMajor(), m.getPosition());

        }

    }

    public static void deleteManager() {

        System.out.println("삭제할 번호를 입력하세요");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= ManagerList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        ManagerList.remove(no);
        System.out.println("삭제하였습니다.");

    }

    public static void detailManager() {
        System.out.println("조회할 번호를 입력하세요");
        int no = Integer.parseInt(key.nextLine());

        if (no < 0 || no >= ManagerList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        Manager manager = ManagerList.get(no);
        System.out.printf("이름 : %s\n", manager.getName());
        System.out.printf("나이 : %d\n", manager.getAge());
        System.out.printf("전공 : %s\n", manager.getMajor());
        System.out.printf("직위 : %s\n", manager.getPosition());

    }

    public static void serviceManagerMenu() {
        while (true) {
            System.out.println("매니저 관리>");
            String command = key.nextLine();
            if (command.equals("list")) {
                printManager();
            } else if (command.equals("add")) {
                inputManager();
            } else if (command.equals("delete")) {
                deleteManager();
            } else if (command.equals("detail")) {
                detailManager();
            } else if (command.equals("quit")) {
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
        }
    }
}

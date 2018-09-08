package bitcamp.java110test.cms.control;

import java.util.Scanner;
import bitcamp.java110test.cms.domain.Member;

public class ManagerController {

    static Manager[] managers = new Manager[10];
    static int managerIndex = 0;
    public static Scanner key;

    static class Manager extends Member {
        String position;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

    }

    public static void inputManager() {

        Manager m = new Manager();
        while (true) {

            System.out.println("이름? ");
            m.setName(key.nextLine());
            System.out.println("나이? ");
            m.setAge(Integer.parseInt(key.nextLine()));
            System.out.println("전공? ");
            m.setMajor(key.nextLine());
            System.out.println("직위? ");
            m.setPosition(key.nextLine());

            managers[managerIndex++] = m;

            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;
        }
    }

    public static void printManager() {
        int count = 0;
        for (Manager m : managers) {
            if (count++ == managerIndex)
                break;
            System.out.printf("%s %d %s %s\n", m.getName(), m.getAge(), m.getMajor(), m.getPosition());

        }
    }

    public static void serviceManagerMenu() {
        while (true) {
            System.out.println("매니저 관리>");
            String command = key.nextLine();
            if (command.equals("list")) {
                printManager();
            } else if (command.equals("add")) {
                inputManager();
            } else if (command.equals("quit")) {
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
        }
    }
}

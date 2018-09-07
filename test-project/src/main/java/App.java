import java.util.Scanner;

public class App {

    // 매니저관리 기능추가
    static class Member {
        String name;
        int age;
        String major;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

    }

    static class Student extends Member {

        String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    static class Teacher extends Member {
        int pay;

        public int getPay() {
            return pay;
        }

        public void setPay(int pay) {
            this.pay = pay;
        }
    }

    static class Manager extends Member {
        String position;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

    }

    static Scanner key = new Scanner(System.in);

    static Student[] students = new Student[10];
    static Teacher[] teachers = new Teacher[10];
    static Manager[] managers = new Manager[10];

    static int studentIndex = 0;
    static int teacherIndex = 0;
    static int managerIndex = 0;

    public static void inputStudent() {

        while (true) {
            Student m = new Student();
            System.out.println("이름? ");
            m.setName(key.nextLine());
            System.out.println("나이? ");
            m.setAge(Integer.parseInt(key.nextLine()));
            System.out.println("전공? ");
            m.setMajor(key.nextLine());
            System.out.println("학번? ");
            m.setId(key.nextLine());
            students[studentIndex++] = m;
            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;

        }

    }

    public static void inputTeacher() {
        Teacher t = new Teacher();
        while (true) {
            System.out.println("이름? ");
            t.setName(key.nextLine());
            System.out.println("나이? ");
            t.setAge(Integer.parseInt(key.nextLine()));
            System.out.println("전공? ");
            t.setMajor(key.nextLine());
            System.out.println("급여? ");
            t.setPay(Integer.parseInt(key.nextLine()));

            teachers[teacherIndex++] = t;
            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;
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

    public static void printStudent() {

        int count = 0;
        for (Student s : students) {
            if (count++ == studentIndex)
                break;
            System.out.printf("%s %d %s %s\n", s.getName(), s.getAge(), s.getMajor(), s.getId());
        }
    }

    public static void printTeacher() {

        int count = 0;

        for (Teacher t : teachers) {
            if (count++ == teacherIndex)
                break;
            System.out.printf("%s %d %s %d\n", t.getName(), t.getAge(), t.getMajor(), t.getPay());
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

    public static void serviceStudentMenu() {

        while (true) {
            System.out.println("학생 관리>");
            String command = key.nextLine();
            if (command.equals("list")) {
                printStudent();
            } else if (command.equals("add")) {
                inputStudent();
            } else if (command.equals("quit")) {
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
        }

    }

    public static void serviceTeacherMenu() {
        while (true) {
            System.out.println("강사 관리>");
            String command = key.nextLine();
            if (command.equals("list")) {
                printTeacher();
            } else if (command.equals("add")) {
                inputTeacher();
            } else if (command.equals("quit")) {
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
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

    public static void main(String[] args) {

        while (true) {

            String menu = promptMenu();
            if (menu.equals("1")) {
                serviceStudentMenu();
            } else if (menu.equals("2")) {
                serviceTeacherMenu();
            } else if (menu.equals("3")) {
                serviceManagerMenu();
            } else if (menu.equals("0")) {
                System.out.println("안녕히 가세요!");
                break;
            } else
                System.out.println("유효하지 않는 명령어입니다.");
        }
        key.close();
    }

}
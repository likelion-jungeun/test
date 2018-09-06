import java.util.Scanner;

public class App {

    // 클래스로 나누기

    static class Member {
        String name;
        int age;
        String id;
        String dept;

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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

    }

    static Scanner key = new Scanner(System.in);
    static int index = 0;

    static Member[] members = new Member[10];

    public static void inputMembers() {

        while (true) {
            Member m = new Member();
            System.out.println("이름? ");
            m.setName(key.nextLine());
            System.out.println("나이? ");
            m.setAge(Integer.parseInt(key.nextLine()));
            System.out.println("학번? ");
            m.setId(key.nextLine());
            System.out.println("학과? ");
            m.setDept(key.nextLine());

            members[index++] = m;
            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;

        }

    }

    public static void printMembers() {
        System.out.println("이름\t나이\t학번\t학과");
        for (int i = 0; i < index; i++) {
            System.out.printf("%s\t%d\t%s\t%s\n", members[i].getName(), members[i].getAge(), members[i].getId(),
                    members[i].getDept());
        }
    }

    public static void main(String[] args) {
        inputMembers();
        printMembers();
        key.close();

    }

}
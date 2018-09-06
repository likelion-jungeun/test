import java.util.Scanner;

public class App {

    static String[] names = new String[10];
    static int[] ages = new int[10];
    static String[] ids = new String[10];
    static String[] depts = new String[10];

    static Scanner key = new Scanner(System.in);
    static int index = 0;

    public static void inputMembers() {

        while (true) {
            System.out.println("이름? ");
            names[index] = key.nextLine();
            System.out.println("나이? ");
            ages[index] = Integer.parseInt(key.nextLine());
            System.out.println("학번? ");
            ids[index] = key.nextLine();
            System.out.println("학과? ");
            depts[index] = key.nextLine();

            index++;
            System.out.println("계속 입력하시겠습니까?");
            if ("n".equalsIgnoreCase(key.nextLine()))
                break;

        }
//인진언니 ㅂㄷㅂㄷ
    }

    public static void printMembers() {
        System.out.println("이름\t나이\t학번\t학과");
        for (int i = 0; i < index; i++) {
            System.out.printf("%s\t%d\t%s\t%s\n", names[i], ages[i], ids[i], depts[i]);
        }
    }

    public static void main(String[] args) {
        inputMembers();
        printMembers();
        key.close();

    }

}

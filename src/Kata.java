import java.util.*;

public class Kata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Deque<Integer> check = new ArrayDeque<>();
        for (int i = 0; i < line.split("\\s").length; i++) {
            if (i % 2 != 0) {
                check.addFirst(Integer.parseInt(line.split("\\s")[i]));
            }
        }
        for (Integer s: check) {
            System.out.print(s + " ");
        }
    }
}

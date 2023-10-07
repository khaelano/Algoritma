import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner S = new Scanner(System.in);
        Cache cache = new Cache(8);

        while (true) {
            System.out.println("\nList of items in cache");
            System.out.println("[Index]       [Value]       [Frequency]");
            if (!cache.isEmpty()) {
                for (int i = 0; i < cache.cache.size(); i++) {
                    System.out.printf("%-7d       %-7d       %-7d\n", i, cache.see(i).value, cache.see(i).frequency);
                }
            }
            System.out.println("Enter the value");
            int value = S.nextInt();
            cache.put(value);
        }
    }
}

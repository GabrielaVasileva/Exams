package exam;

import java.text.DecimalFormat;
import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> map = new TreeMap<>();

        String input;
        while (!"Statistics".equals(input = scanner.nextLine())) {
            String[] commands = input.split("->");
            String username = commands[1];

            switch (commands[0]) {
                case "Add":
                    if (!map.containsKey(username)) {
                        map.put(username, new LinkedList<>());
                    } else {
                        System.out.printf("%s is already registered%n", username);
                    }
                    break;
                case "Send":
                    if (!map.containsKey(username)) {
                        System.out.println(username + " not found!");
                    } else {
                        String email = commands[2];
                        map.get(username).add(email);
                    }
                    break;
                case "Delete":
                    if (!map.containsKey(username)) {
                        System.out.println(username + " not found!");
                    } else {
                        map.remove(username);
                    }
                    break;
            }
        }

        System.out.println("Users count: " + map.size());


        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (String email :
                    entry.getValue()) {
                System.out.println(" - " + email);

            }
        }

    }
}


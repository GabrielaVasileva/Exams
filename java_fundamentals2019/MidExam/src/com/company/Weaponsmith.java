package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Weaponsmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split("\\|");
        List<String> nonModifiableList = Arrays.asList(parts);
        List<String> name = new ArrayList<>(nonModifiableList);

        String Command;
        while (!("Done".equals(Command = scanner.nextLine()))) {
            String commands[] = Command.split(" ");

            switch (commands[0]) {
                case "Move":
                    int index = Integer.parseInt(commands[2]);
                    if (index < name.size()) {
                        if (commands[1].equals("Right")) {
                            if (index + 1 < name.size()) {
                                String IndexNameHolder = name.get(index + 1);
                                name.set(index + 1, name.get(index));
                                name.set(index, IndexNameHolder);
                            }

                        } else if (commands[1].equals("Left")) {
                            if (index - 1 >= 0) {
                                String IndexNameHolder = name.get(index - 1);
                                name.set(index - 1, name.get(index));
                                name.set(index, IndexNameHolder);

                            }
                        }
                    }
                    break;
                case "Check":
                    if (commands[1].equals("Odd")) {
                        for (int i = 0; i < name.size(); i++) {
                            if (!(i % 2 == 0)) {
                                System.out.print(name.get(i)+" ");
                            }
                        }
                    } else if (commands[1].equals("Even")) {
                        for (int i = 0; i < name.size(); i++) {
                            if (i % 2 == 0) {
                                System.out.print(name.get(i)+" ");
                            }
                        }
                    }
                    break;
            }

        }

        System.out.println();
        String nameString = "";
        for (int i = 0; i < name.size(); i++) {
            nameString += name.get(i);
        }
        System.out.printf("You crafted %s!", nameString);

    }
}

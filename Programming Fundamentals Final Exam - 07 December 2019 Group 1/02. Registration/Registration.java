package exam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> Registration = new LinkedHashMap<>();

        String regex = "U\\$(?<username>[A-Z][a-z]{3,})U\\$P@\\$(?<password>[a-zA-Z]{5,}\\d+)P@\\$";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());

        int c = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if(!matcher.find()){
                Registration.put(input,"");
            }else {
                String username = matcher.group("username");
                String password = matcher.group("password");
                Registration.put(username,password);
                c++;
            }
        }



        if(c > 0){
            System.out.println("Registration was successful");
        }
        for (Map.Entry<String, String> entry : Registration.entrySet()) {
            if (entry.getValue().equals("")){
            }else {

                String username = entry.getKey();
                String password = entry.getValue();
                System.out.println("Username: "+username+", Password: "+ password);

            }
        }
        System.out.println("Successful registrations: "+c);

    }
}

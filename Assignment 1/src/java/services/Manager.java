package services;

import java.io.*;
import models.HomeItem;
import models.User;

/**
 *
 * @author 835178
 */
public class Manager {

    public static String path;

    public static boolean checkAuth(User u) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        Boolean found = false;
        while ((line = br.readLine()) != null) {
            String[] parsed = line.split(",");
            if (u.getUsername().contentEquals(parsed[0])) {
                if (u.getPassword().contentEquals(parsed[1])) {
                    found = true;
                }
            }
        }
        br.close();
        return found;
    }

    public static String getValue(String username) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        int value = 0;
        while ((line = br.readLine()) != null) {
            String[] parsed = line.split(",");
            if (username.contentEquals(parsed[0])) {
                value += Integer.parseInt(parsed[3]);
            }
        }
        br.close();
        return String.valueOf(value);
    }

    public static String getTotal() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        int value = 0;
        while ((line = br.readLine()) != null) {
            String[] parsed = line.split(",");
            value += Integer.parseInt(parsed[3]);
        }
        br.close();
        return String.valueOf(value);
    }

    public static HomeItem getMostExpensive() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line;
        String itemName = "";
        String owner ="";
        int value = 0;
        HomeItem i = null;
        while ((line = br.readLine()) != null) {
            String[] parsed = line.split(",");
            int number = Integer.parseInt(parsed[3]);
            if (number > value) {
                value = number;
                itemName = parsed[2];
                owner = parsed[0];
                
                
                i = new  HomeItem(itemName, owner, "", String.valueOf(number));
            }
        }
        
//        String [] arr = {itemName, String.valueOf(value), owner};
//        return arr;
        return i;
    }
}

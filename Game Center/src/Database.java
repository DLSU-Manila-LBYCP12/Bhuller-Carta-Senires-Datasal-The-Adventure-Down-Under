

import acm.graphics.GImage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;


public class Database implements Constants {

    public ArrayList<Profile> profiles = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    private String path = System.getProperty("user.dir") + "\\profiles.txt";

    
    public Database() throws FileNotFoundException, IOException {
        
        File f = new File(path);
        FileReader source = new FileReader(f);
        BufferedReader br = new BufferedReader(source);

        String temp = br.readLine();
        while (temp != null) {

            Profile temp_profile = new Profile(temp);
            temp = br.readLine();

            temp_profile.setsnakeScore(Integer.parseInt(temp));
            temp = br.readLine();
            temp_profile.setpong(Integer.parseInt(temp));
            temp = br.readLine();
            temp_profile.setbreak(Integer.parseInt(temp));
            temp = br.readLine();
            temp_profile.setquiz(Integer.parseInt(temp));
            temp = br.readLine();
            temp_profile.setmath(Integer.parseInt(temp));
            temp = br.readLine();
            while (!temp.equals("end profile")) {
                StringTokenizer token = new StringTokenizer(temp, " ");
                String name = token.nextToken();
                int weight;
                if (token.hasMoreTokens()) {
                    weight = Integer.parseInt(token.nextToken());
                } else {
                    System.out.println("No weight detected");
                    weight = 1;
                }
                temp_profile.addFriend(name, weight);

                temp = br.readLine();
            }

            addProfile(temp_profile);

            temp = br.readLine();
        }

    }

    public void saveProfiles() throws IOException {
        FileWriter writer = new FileWriter(path, false);
        PrintWriter print = new PrintWriter(writer);
        for (int i = 0; i < profiles.size(); i++) {
            print.println(profiles.get(i).save());
        }
        print.close();
    }

    public ArrayList<String> getProfiles() {

        for (int i = 0; i < profiles.size(); i++) {
            if (!names.contains(profiles.get(i).getName())) {
                names.add(profiles.get(i).getName());
            }
        }
        return names;
    }

    public void addProfile(Profile profile) {
        
        profiles.add(profile);
    }

    public int getSize(){
        return profiles.size();
    }
    public Profile getProfile(String name) {
        Profile profile = null;
        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).getName().equals(name)) {
                profile = profiles.get(i);
            }
        }

        return profile;
    }
    public Profile gProfile(int f) {
        

        return profiles.get(f);
    }
    public void deleteProfile(String name) {
        // You fill this in
        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).getName().equals(name)) {
                profiles.remove(i);
            }
        }
    }

    
    public boolean containsProfile(String name) {
        if (getProfile(name) != null) {
            return true;
        } else {
            return false;
        }
    }

}

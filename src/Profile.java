


import acm.graphics.*;

import java.util.*;

public class Profile implements Constants {

    private String name = "";
    private int snakeScore = 0, pongScore=0, breakScore=0, quizScore=0,mathScore=0; 
    private ArrayList<String> friends = new ArrayList<>();
    public ArrayList<Integer> weights = new ArrayList<>();
    private String summary;
    public Node profile_node;
    private StringTokenizer tokenString;

    
    public Profile(String name) {
                String entry;
                this.name = name;
                /*entry = name;
                tokenString = new StringTokenizer(name, " ");
                name = tokenString.nextToken();
                snakeScore = Integer.parseInt(tokenString.nextToken());
                pongScore = Integer.parseInt(tokenString.nextToken());
                breakScore = Integer.parseInt(tokenString.nextToken());
                quizScore = Integer.parseInt(tokenString.nextToken());
                mathScore = Integer.parseInt(tokenString.nextToken());*/
    }

    public String getName() {
        return this.name;
    }

    public int getsnakeScore() {
        return this.snakeScore;
    }

    public void setsnakeScore(int score) {
        // You fill this in
        this.snakeScore=score;

    }
    public void setpong(int score) {
        // You fill this in
        this.pongScore=score;

    }
    public void setbreak(int score) {
        // You fill this in
        this.breakScore=score;

    }
    public void setmath(int score) {
        // You fill this in
        this.mathScore=score;

    }
    public void setquiz(int score) {
        // You fill this in
        this.quizScore=score;

    }
    public int getpong() {
        // You fill this in
        return this.pongScore;

    }public int getbreak() {
        // You fill this in
        return this.breakScore;

    }public int getmath() {
        // You fill this in
        return this.mathScore;

    }
    public int getquiz() {
        // You fill this in
        return this.quizScore;

    }
    
    public boolean addFriend(String friend) {
        friends.add(friend);
        weights.add(1);
        return true;
    }

    public boolean addFriend(String friend, int weight) {
        friends.add(friend);
        weights.add(weight);
        return true;
    }

    public boolean removeFriend(String friend) {
        int index = friends.indexOf(friend);
        boolean snakeScore = friends.remove(friend);
        weights.remove(index);
        return snakeScore;

    }

    public boolean isFriend(Profile profile) {
        if (friends.contains(profile.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList getFriends() {
        return friends;
    }

    public String toString() {
        summary = name + " (" + snakeScore + pongScore + breakScore + quizScore + mathScore +"): ";
        for (int i = 0; i < friends.size() - 1; i++) {
            summary = summary.concat((String) friends.get(i) + ", ");
        }
        summary = summary.concat((String) friends.get(friends.size() - 1));

        return summary;
    }

    public String save() {
        summary = name + System.lineSeparator() + snakeScore + System.lineSeparator()+ pongScore + System.lineSeparator()+ breakScore + System.lineSeparator()+ quizScore + System.lineSeparator()+ mathScore + System.lineSeparator();
        if (friends.size() > 0) {
            for (int i = 0; i < friends.size(); i++) {
                summary = summary.concat(friends.get(i) + " " + weights.get(i) + System.lineSeparator());
            }
        }
        summary = summary.concat("end profile");

        return summary;
    }

    

    

}

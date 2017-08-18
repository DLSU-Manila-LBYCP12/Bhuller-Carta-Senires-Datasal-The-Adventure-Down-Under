
import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GPoint;

import java.awt.Color;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Node {
    public boolean selected = false;
    public ArrayList<Node> connections = new ArrayList<>();
    public ArrayList<Integer> weights = new ArrayList<>();
    public GLabel label = new GLabel("");
    private double x, y;
    public String name, initials = "";
    private GPoint location = new GPoint();
    public GOval node = new GOval(50, 50);
    public GCanvas container;
    public Color color = Color.GRAY;
    public Node(String name, double x, double y) {
        this.name = name;
        StringTokenizer token = new StringTokenizer(name, " ");
        while (token.hasMoreElements()) {
            initials = initials.concat(token.nextToken().substring(0, 1).toUpperCase());
        }

        this.x = x;
        this.y = y;
        location.setLocation(x, y);
    }
    
    public void DrawNode(GCanvas canvas) {
        container = canvas;
        node = new GOval(50, 50);
        node.setFilled(true);
        node.setFillColor(color);
        canvas.add(node, x, y);
        label = new GLabel(initials);
        canvas.add(label, x + node.getWidth() / 2 - label.getWidth() / 2, y + node.getHeight() / 2 + label.getHeight() / 2);

    }

    public GPoint getLocation() {

        return location;
    }

    public void setLocation(GPoint newLoc) {

        x = newLoc.getX();
        y = newLoc.getY();
        System.out.println("x = " + x + ", y = " + y);
        location.setLocation(x, y);
    }

    public void update() {
        
        node.setLocation(this.x, this.y);
        label.setLocation(this.x + node.getWidth() / 2 - label.getWidth() / 2, this.y + node.getHeight() / 2 + label.getHeight() / 2);
    }

    public GPoint getCenter() {
        GPoint center = new GPoint();
        center.setLocation(x + node.getWidth() / 2, y + node.getHeight() / 2);
        return center;
    }

    public void connect(Node toConnect) {
        connections.add(toConnect);
        weights.add(1);
    }

    public void connect(Node toConnect, int weight) {
        connections.add(toConnect);
        weights.add(weight);
    }

    public void disconnect(Node toDisconnect) {
        int index = connections.indexOf(toDisconnect);
        connections.remove(toDisconnect);
        weights.remove(index);

    }

    public String getName() {
        return name;
    }
    public void recolor(){
        color = Color.green;
        
       
    }
    public String toString(){
        return name;
    }
}

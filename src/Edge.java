
import acm.graphics.GCanvas;
import acm.graphics.GLine;
import java.awt.Color;

public class Edge {

    public Node nodeA, nodeB;
    private double x1, y1, x2, y2;
    private GLine connection;
    public int weight;
    public GCanvas canvas;
    public Edge(Node a, Node b, GCanvas canvas) {
        nodeA = a;
        nodeB = b;
        this.canvas = canvas;
        x1 = nodeA.getCenter().getX();
        y1 = nodeA.getCenter().getY();
        x2 = nodeB.getCenter().getX();
        y2 = nodeB.getCenter().getY();
        connection = new GLine(x1, y1, x2, y2);

        System.out.println("Connected " + a.name + " and " + b.name);
       
    }

    public Edge(Node a, Node b, GCanvas canvas, int weight) {
        this.weight = weight;
        nodeA = a;
        nodeB = b;
        this.canvas = canvas;
        x1 = nodeA.getCenter().getX();
        y1 = nodeA.getCenter().getY();
        x2 = nodeB.getCenter().getX();
        y2 = nodeB.getCenter().getY();
        connection = new GLine(x1, y1, x2, y2);

        System.out.println("Connected " + a.name + " and " + b.name);
        
    }

    

    void update() {
        x1 = nodeA.getCenter().getX();
        y1 = nodeA.getCenter().getY();
        x2 = nodeB.getCenter().getX();
        y2 = nodeB.getCenter().getY();
        connection.setStartPoint(x1, y1);
        connection.setEndPoint(x2, y2);

    }

    void show() {
        canvas.remove(connection);
        canvas.add(connection);
        connection.sendToBack();
    }

}

/**
 * <pre>
 * Name:
 * Mrs. Kankelborg
 * Period
 * Project 1 Traveling Salesman
 * Last Revised on: 
 * </pre>
 */
public class Tour
{
    /** 
    * Internal Node class - you may add constructors
    */
    private class Node
    {
        private Point data;
        private Node next;
        
        public Node(Point p) {
        	this.data = p;
        	this.next = null;
        }
        
        public Node(Point p, Node next){
            this.data = p;
            this.next = next;
        }
    }
    
    /**
    * Required fields
    */
    private Node home;
    private int size;
    
    /**
     * Creates an empty tour.
     */
    public Tour()
    {
    	home = null;
    	size = 0;
    }

    /**
     * Creates the 4-point tour a->b->c->d->a (for debugging)
     */
    public Tour(Point a, Point b, Point c, Point d)
    {
    	
    	
    	
    	home = new Node(a);
    	Node B = new Node(b);
    	Node C = new Node(c);
    	Node D = new Node(d);
    	
    	home.next = B;
    	B.next = C;
    	C.next = D;
    	
    	D.next = home;
    	
    	size = 4;
    	

    }
    
    /**
     * Returns the number of points in this tour.
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns the length of this tour.
     */
    public double length()
    {
    	if (size <= 1) {
    		return 0;
    	}
        int counter = 0;
        double sum = 0.0;
        Node current = home;
        while(counter < size) {
        	sum += current.data.distanceTo(current.data);
        	counter++;
        	current = current.next;
        }
        return sum;
    }

    /**
     * Returns a string representation of this tour.
     */
    @Override
    public String toString()
    {
    	if(size == 0) 
    	{
    		return null;
    	}
    	
        StringBuilder string = new StringBuilder();
        Node current = home;
        
        for (int i = 0; i < size; i++) {
            string.append(current.data.toString() + "\n");
        	current = current.next;
        }

        return string.toString();
    }

    /**
     * Draws this tour to standard drawing.
     */
    public void draw()
    {
    	if (size <= 1) { 
    		return;
    				}
    	
    	Node current = home;
    	for (int i = 0; i < size; i++) {
    		current.data.drawTo(current.next.data);
    		current = current.next;
    	}
    }

    /**
     * Inserts p into the tour using the nearest neighbor heuristic.
     */
    public void insertNearest(Point p)
    {
    	if(size == 0) {
    		home = new Node(p);
    		home.next = home;
    		size = 1;
    		return;
    	}
    	Node nearest = home;
    	Node nextval = home;
    	double minimum = Double.MAX_VALUE;
    	int length = size;
    	while(length > 0) {
    		double distance = p.distanceTo(nextval.data);
    		if(distance < minimum) {
    			nearest = nextval;
    			minimum = distance;
    		}
    		nextval = nextval.next;
    		length--;
    	}
 
    	Node newNode = new Node(p, nextval.next);
    	nextval.next = newNode;
    	size++;
    }

    /**
     * Inserts p into the tour using the smallest increase heuristic.
     */
    public void insertSmallest(Point p)
    {
    	// Create a node with the value of the point, and take the 
    	if(size == 0) {
    		home = new Node(p);
    		home.next = home;
    		size = 1;
    		return;
    	}
    	double minimum = Double.MAX_VALUE;
    	Node smallest = home;
    	Node nextval = home;
    	int length = size;
    	while(length > 0) {
    		double distance = p.distanceTo(nextval.data);
    		distance -= nextval.data.distanceTo(nextval.next.data);
    		distance += p.distanceTo(nextval.next.data);
    		if(distance < minimum) {
    			smallest = nextval;
    			minimum = distance;
    		}
    		length--;
    		nextval = nextval.next;
    	}
    	Node newNode = new Node(p, nextval.next);
    	nextval.next = newNode;
    	size++;
    }
}

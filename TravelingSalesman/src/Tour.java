/**
 * <pre>
 * Name: Farzad Hasan
 * Mrs. Kankelborg
 * Period 1
 * Project 1 Traveling Salesman
 * Last Revised on: 1/11/2023
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

        Node temp = home;
        int num = 0;
        double sum = 0;

        while(!temp.equals(home) || num == 0) {

            sum += temp.data.distanceTo(temp.next.data);
            
            temp = temp.next;
            num++;
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
    	//If home has no contents, set home to the new point.
    	if(size == 0) {
    		
    		home = new Node(p);
    		//Establishes link in the list.
    		home.next = home;
    		size = 1;
    		return;
    	}
    	//Tracks the next node
    	Node nearest = home;
    	//Checks which node is being looked at
    	Node nextval = home;
    	//Finding the smallest possible distance
    	double minimum = Double.MAX_VALUE;
    	int length = size;
    	while(length > 0) {
    		//Finding the distance between current and next point
    		double distance = p.distanceTo(nextval.data);
    		//The essence of the heuristic; if it is the closest, store this point.
    		if(distance < minimum) {
    			nearest = nextval;
    			minimum = distance;
    		}
    		nextval = nextval.next;
    		length--;
    	}
 
    	//Add the point to the closest point so far.
    	Node newNode = new Node(p, nearest.next);
    	nearest.next = newNode;
    	size++;
    }

    /**
     * Inserts p into the tour using the smallest increase heuristic.
     */
    public void insertSmallest(Point p)
    {
    	//If nothing is in the tour, set home to the first point.
    	if(size == 0) {
    		home = new Node(p);
    		//Connecting the list at the end.
    		home.next = home;
    		size = 1;
    		return;
    	}
    	//Tracking the smallest distance.
    	double minimum = Double.MAX_VALUE;
    	Node smallest = home;
    	Node nextval = home;
    	int length = size;
    	while(length > 0) {
    		double distance = p.distanceTo(nextval.data) + p.distanceTo(nextval.next.data) 
    		- nextval.data.distanceTo(nextval.next.data);
    		//Checks how much the tour changes by adding in the new point.
    		if(distance < minimum) {
    			smallest = nextval;
    			minimum = distance;
    		}
    		length--;
    		nextval = nextval.next;
    	}
    	
    	//Same as before, adds the point to the closest point so far.	
    	Node newNode = new Node(p, smallest.next);
    	smallest.next = newNode;
    	size++;
    }
}

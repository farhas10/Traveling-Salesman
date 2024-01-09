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
    	Node A = new Node(a);
    	Node B = new Node(b);
    	Node C = new Node(c);
    	Node D = new Node(d);
    	
    	A.next = B;
    	size++;
    	B.next = C;
    	size++;
    	C.next = D;
    	size++;
    	D.next = A;
    	size++;
    	
    	home = A;
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
        return 0;
    }

    /**
     * Returns a string representation of this tour.
     */
    @Override
    public String toString()
    {
        return null;
    }

    /**
     * Draws this tour to standard drawing.
     */
    public void draw()
    {
    }

    /**
     * Inserts p into the tour using the nearest neighbor heuristic.
     */
    public void insertNearest(Point p)
    {
    }

    /**
     * Inserts p into the tour using the smallest increase heuristic.
     */
    public void insertSmallest(Point p)
    {
    }
}

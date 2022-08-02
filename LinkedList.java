public class LinkedList {
    Table first;
    int size;
    // constructor
    public LinkedList(){
        first = null;
        size = 0;
    }

    // method to add element to the linkedlist
    public void add(int numberOfGuests, String name){
        Table newGuest = new Table(numberOfGuests, name);
        if(first == null){
            first = newGuest;
        }
        else{
            Table pointer = first;
            // find the last node
            while(pointer.next != null)
                pointer = pointer.next;

            // add the new node at that place
            pointer.next = newGuest;
        }
        // increase size by 1
        size++;
    }
    
    // method to remove the first node
    public Table removeFirst()
    {
    	// if its null, return an EmptyTable object
    	if (first == null)
    		return new Table.EmptyTable();
    	else
    	{
    		// create a temp object to return
    		Table temp = first;
    		first = first.next;
    		size--;
    		return temp;
    	}
    }
    
    // method to remove a guest from any position
    public Table removeGuest(String name)
    {
    	// if first is null, return EmptyTable
    	if (first == null)
    		return new Table.EmptyTable();
    	// if its in first, call removeFirst;
    	else if (first.name.equals(name))
    		return removeFirst();
    	
    	Table toReturn = new Table.EmptyTable();
    	Table pointer = first;
    	// iterate through and set that node to null
    	while (pointer.next != null)
    	{
    		if (pointer.next.name.equals(name))
    		{
    			toReturn = pointer.next;
    			size--;
    			if (pointer.next.next == null)
    			{
    				pointer.next = null;
    				return toReturn;
    			}
    			else 
    				pointer.next = pointer.next.next;
    		}
    		else
    			pointer = pointer.next;
    	}
    	return toReturn;
    }
    
    // method to get the position of a guest
    public int getPosition(String name)
    {
    	if (first == null)
    		return -1;
    	
    	Table pointer = first;
    	int index = 0;
    	// iterate through and find the index of the guest
    	while (pointer != null)
    	{
    		if (pointer.name.equals(name))
    			return index;
    		index++;
    		pointer = pointer.next;
    	}
    	return -1;
    }
    
    // method to get # of reservations with a certain # of guests
    public int getNumberOfParties(int number)
    {
    	if (first == null)
    		return -1;
    	
    	int result = 0;
    	Table pointer = first;
    	// iterate through and check for that number of guests
    	while (pointer != null)
    	{
    		if (pointer.guests == number)
    			result++;
    		pointer = pointer.next;
    	}
    	// return that number
    	return result;
    }
    
    // method to list all the reservations
    public String listReservations()
    {
    	String result = "";
    	
    	// if there are no reservations
    	if (first == null)
    		return "No reservations in queue at this time.\n";
    	else
    	{
    		Table pointer = first;
    		// iterate through and call the toString for each node
            while(pointer != null)
            {
            	result += pointer.toString();
            	pointer = pointer.next;
            }
    	}
    	return result + "\n" + "Total reservations: " + size + ".\n";
    }

}

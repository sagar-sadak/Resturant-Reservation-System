public class Table {
	
	// default visibility variables
    String name;
    int guests;
    Table next;

    // constructor
    public Table(int n, String name){
        this.name = name;
        guests = n;
        next = null;
    }

    // toString method
    public String toString(){
        return "\nReservation for " + name + ": party of "
                + guests + ".\n";
    }


    public static class EmptyTable extends Table {

        public EmptyTable() {
            super(-1, "");
        }
    }
}

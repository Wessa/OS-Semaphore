
public class Writer extends Thread {
	
	Buffer buf ;
	String Name ;
	String Content ;
	
	public Writer( String n , String c , Buffer b ) {
		
		Name = n ;
		Content = c ;
		buf = b ;
	}

	public void run(){

		buf.write ( Content ) ;
		System.out.println ( Name + "Finished Writing" ) ;
	}
	
}

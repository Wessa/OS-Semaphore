
public class Reader extends Thread {

	Buffer buf ;
	String Name ;
	
	public Reader( String n , Buffer b ) {
		
		Name = n ;
		buf = b ;
	}

	public void run(){
		
		System.out.println ( buf.read() ) ;
		System.out.println ( Name + "Finished Reading" ) ;
	}
}

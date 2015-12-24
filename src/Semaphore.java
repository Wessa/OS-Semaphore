
public class Semaphore {

	int init ;
	
	public Semaphore (){
		
		init = 1 ;
	}
	
	// Wait
	public synchronized void P(){
		
		init -- ;
		
		if ( init < 0 ){
			
			try { 
				wait() ; 
				//System.out.println("Blocked");
			}
			catch(  InterruptedException e ){}
			
		}
		
	}
	
	// Signal 
	public synchronized void V() {

		init ++ ; 
		
		if (init <= 0) 
			notify() ;
	}	
	
}

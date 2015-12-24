
public class Buffer {

	String bufContent ;
	
	int readerCount ;
	
	Semaphore mutex = new Semaphore() ;
	Semaphore write = new Semaphore() ;
	
	public Buffer (){
		
		readerCount = 0 ;
		bufContent = "" ;
	}
	
	public void write ( String content ){
		
		
		write.P();
		mutex.P();
		
		bufContent += content ;
	
		mutex.V();
		write.V();
	}
	
	public String read (){
		
		String res = "" ;
		
		mutex.P();
		readerCount ++ ;
		
		if ( readerCount == 1 )
			write.P();
		
		res = bufContent ;
		
		mutex.V();
		
		mutex.P();
		readerCount -- ;
		
		if ( readerCount == 0 )
			write.V();
		
		mutex.V();
		
		return res ;
	}
	
}

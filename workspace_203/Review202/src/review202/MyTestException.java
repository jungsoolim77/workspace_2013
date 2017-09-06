package review202;

public class MyTestException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public MyTestException() {

    }

    public MyTestException(String message) {
        super (message);
    }

    public MyTestException (Throwable cause) {
        super (cause);
    }

    public MyTestException(String message, Throwable cause) {
        super (message, cause);
    }

}

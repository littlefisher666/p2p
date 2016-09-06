package exception;

/**
 * Id不存在异常
 * @author 靳雅楠
 *
 */
public class IdNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotFoundException() {
	}

	public IdNotFoundException(String message) {
		super(message);
	}

	public IdNotFoundException(Throwable cause) {
		super(cause);
	}

	public IdNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public IdNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

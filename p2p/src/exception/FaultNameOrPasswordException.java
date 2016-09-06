package exception;
/**
 * 用户名或密码错误异常
 * @author 靳雅楠
 *
 */
public class FaultNameOrPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FaultNameOrPasswordException() {
	}

	public FaultNameOrPasswordException(String message) {
		super(message);
	}

	public FaultNameOrPasswordException(Throwable cause) {
		super(cause);
	}

	public FaultNameOrPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public FaultNameOrPasswordException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

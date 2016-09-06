package exception;

/**
 * 申请信息已存在异常
 * @author 靳雅楠
 *
 */
public class DuplicateApplyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateApplyException() {
	}

	public DuplicateApplyException(String message) {
		super(message);
	}

	public DuplicateApplyException(Throwable cause) {
		super(cause);
	}

	public DuplicateApplyException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateApplyException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

package gov.esprit.exception;

/**
 * {@link EgovException}.
 * 
 * @category Exception
 * @author monta
 */
public class EgovException extends Exception {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * the exception error code.
	 */
	private EgovErrorCode errorCode;
	
	/**
	 * the exception error message.
	 */
	private String errorMessage;
	
	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public EgovException(EgovErrorCode errorCode, String...args) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorCode.name() + args;
	}

	/**
	 * @return the errorCode
	 */
	public EgovErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(EgovErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
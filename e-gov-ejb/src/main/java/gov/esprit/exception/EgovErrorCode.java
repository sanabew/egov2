package gov.esprit.exception;

/**
 * {@link EgovException}.
 * 
 * @category Exception
 * @author monta
 *
 */
public enum EgovErrorCode {

	UNKOWN_ERROR_CODE("0.0"),
	
	DOES_NOT_EXIST_ITEM("0.1"),
	
	INVALID_ITEM("0.3");
	
	
	private String errorCode;

	/**
	 * @param errorCode
	 */
	private EgovErrorCode(String errorCode) {
		this.setErrorCode(errorCode);
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}

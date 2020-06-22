package cast.cruise.exception;

@SuppressWarnings("serial")
public class CruiseException extends RuntimeException {

	public CruiseException() {
	}

	public CruiseException(String message) {
		super(message);
	}

	public CruiseException(String message, Throwable cause) {
		super(message, cause);
	}

	public CruiseException(Throwable cause) {
		super(cause);
	}
}

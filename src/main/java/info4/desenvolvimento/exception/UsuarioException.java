package info4.desenvolvimento.exception;

public class UsuarioException extends Exception {

	private String messager;

	public String getMessager() {
		return messager;
	}

	public void setMessager(String messager) {
		this.messager = messager;
	}

	public UsuarioException(String messager) {
		super();
		this.messager = messager;
	}
	
	
	
}

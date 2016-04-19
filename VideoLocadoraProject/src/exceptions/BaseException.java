package exceptions;


public class BaseException extends Exception{

	public BaseException(String mensagem) {
		super(mensagem);
//		LogIO l = new LogIO();
//		l.log(mensagem);
	}
}
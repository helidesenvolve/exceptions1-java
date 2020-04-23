package model.exceptions;
             //CRIAR UMA EXCE��O PERSONALIZADA
public class DomainException extends RuntimeException{    //Exception obriga a tratar a exce��o
                                                   //RuntimeException compilador n�o obriga tratar
 //Classe Exception � do tipo serializable!
 //add valor padr�o de vers�o
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg){  //construtor que recebe um String(msg) como argumento, 
		super(msg);     //repassa a msg para o construtor da super classe Exception
	}

	
}

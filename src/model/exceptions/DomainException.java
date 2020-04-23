package model.exceptions;
             //CRIAR UMA EXCEÇÃO PERSONALIZADA
public class DomainException extends RuntimeException{    //Exception obriga a tratar a exceção
                                                   //RuntimeException compilador não obriga tratar
 //Classe Exception é do tipo serializable!
 //add valor padrão de versão
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg){  //construtor que recebe um String(msg) como argumento, 
		super(msg);     //repassa a msg para o construtor da super classe Exception
	}

	
}

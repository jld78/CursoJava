
public class Forma3 {

	
	private Integer i;
	
	public Forma3(){
		//Acá no
		
	}
	
	// Inicialización perezosa o lazy initialization
	public Integer getI(){
		if(i == null){
			i = new Integer(4);
		}
		return i;
	}
	
}

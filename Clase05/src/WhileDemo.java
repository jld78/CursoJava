
public class WhileDemo {

	public static void main(String[] args) {
		
		// while (cond. bool){
		//		cuerpo del while (si cond. es true)
		//		}
		
		int i = 0;
		
		while(i < 10){
			System.out.println(i++);
		};
		
		System.out.println();
		
		i=0;
		while(i < 10){
			System.out.println(i++);
			if(i == 5){
				break;
			}
		}
		
		System.out.println();
		
		i=0;
		while(i < 10){
			i++;
			if(i == 5){
				continue;
			}
			System.out.println(i);
		}
		
	}
	
}

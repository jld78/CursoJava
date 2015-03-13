
public class DiferenciaStringStringBuilder {

	public static void main(String[] args) {
		
		int i = 0;
		String tmp = "";
		long start = System.currentTimeMillis();
		
		while(i<10000){
			tmp += "Usuario" + i++ + " ";
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + " ms");
		
		
		i = 0;
		StringBuilder sb = new StringBuilder();
		start = System.currentTimeMillis();
		
		while(i<10000){
			sb.append("Usuario");
			sb.append(i++);
			sb.append(" ");
		}
		String tmp2 = sb.toString();
		end = System.currentTimeMillis();
		System.out.println(end - start + " ms");
		
		if(tmp.equals(tmp2)){
			System.out.println("Todo OK!");
		} else {
			System.out.println("Todo mal!!");
		}
	}
	
}

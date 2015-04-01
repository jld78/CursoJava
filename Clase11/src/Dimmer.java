
public class Dimmer extends Lampara {

	private static final int LIM_MIN_DEFAULT = 0;
	private static final int LIM_MAX_DEFAULT = 10;
	private int intensidad;
	private final int limMin;
	private final int limMax;;
	
	public Dimmer() {
		this.limMax = LIM_MAX_DEFAULT;
		this.limMin = LIM_MIN_DEFAULT;
	}
	
	public Dimmer(int limMax){
		this.limMax = limMax;
		this.limMin = LIM_MIN_DEFAULT;
	}
	
	public Dimmer(int limMin, int limMax) {
		this.limMin = limMin;
		this.intensidad = limMin-1;
		this.limMax = limMax;
	}
	
	public void inc() {
		if(intensidad < limMin){
			intensidad = limMin-1;
		}
		if(intensidad < limMax){
			intensidad++;
			if (!isPrendida()) {
				super.on();
			}
		}
	}
	
	public void on() {
		if(!isPrendida()){
			inc();
		}
	}
	
	public void off(){
		if(isPrendida()){
			dec();
		}
	}
	
	public void dec() {
		if(intensidad > limMin){
			intensidad--;
		}
		if(isPrendida()){
			intensidad = 0;
			super.off();
		}
	}
	
	public int getIntensidad() {
		return intensidad;
	}

}

package bo.edu.ucb.est;

public class Cliente {
	private String nombre; 
    private String cod_cliente;
    private int pin;
    
    public Cliente(){
        nombre = null;
	    cod_cliente = null;
        pin = 0;
    }
     
    
	public Cliente(String nombre, String cod_cliente, int pin) {
		super();
		this.nombre = nombre;
		this.cod_cliente = cod_cliente;
		this.pin = pin;
	}

	public String getNombre() {
		return nombre;
	}


	public String getCod_cliente() {
		return cod_cliente;
	}


	public int getPin() {
		return pin;
	}


	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", cod_cliente=" + cod_cliente + ", pin=" + pin + "]";
	} 
	
    
}
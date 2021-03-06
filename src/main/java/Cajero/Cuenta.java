package Cajero;

public class  Cuenta{  
    protected int numeroDeCuenta  ;
    protected String moneda;
    protected String tipo;
    protected double saldo;
    protected String cod;
    protected int pin;
    
    public Cuenta(){
  	  numeroDeCuenta = 0;
  	  moneda=null;
  	  tipo=null;
  	  saldo=0;
  	  cod = null;
      pin = 0;
    }
    
    public Cuenta(int numeroDeCuenta, String moneda, String tipo, double saldo, String cod, int pin) {
		this.numeroDeCuenta = numeroDeCuenta;
		this.moneda = moneda;
		this.tipo = tipo;
		this.saldo = saldo;
		this.cod = cod;
		this.pin = pin;
	}
    
    

	public int getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public String getMoneda() {
		return moneda;
	}

	public String getTipo() {
		return tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getCod() {
		return cod;
	}

	public int getPin() {
		return pin;
	}
        public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

    
    public void ingresar(double ingresar){ 
        this.saldo+=ingresar; 
    } 

    public void retirar(double retirar){ 
        this.saldo-=retirar; 
    }

     public double actualizarSaldo(){
        return saldo;
    }

	@Override
	public String toString() {
		return "Cuenta \nnumeroDeCuenta: " + numeroDeCuenta + "\nMoneda: " + moneda + "\nTipo: " + tipo + "\nSaldo:" + saldo;
	}
    
    
          
}

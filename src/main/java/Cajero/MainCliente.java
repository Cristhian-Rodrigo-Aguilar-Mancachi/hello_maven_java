package Cajero;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class MainCliente {
	static ArrayList<Cliente>cliente=new ArrayList<Cliente>();
	static ArrayList<Cuenta>cuenta=new ArrayList<Cuenta>();
	static Scanner entrada= new Scanner(System.in);
	static String codigo;
	static int pinc=0;

	public static void main(String[] args) { 
		Cliente c1=new Cliente("Juan Perez","jperez",3333);
		Cliente c2=new Cliente("Maria Gomez","mgomez",4444);
		Cliente c3=new Cliente("Santiago Perez","sperez",5555);
		cliente.add(c1);
		cliente.add(c2);
		cliente.add(c3);

		Cuenta e1=new Cuenta(111122,"Bolivianos","Caja de Ahorros",12000.0,"jperez",3333);
		Cuenta e2=new Cuenta(112211,"USD","Cuenta Corriente",100.0,"jperez",3333);
		Cuenta e3=new Cuenta(221122,"Bolivianos","Caja de Ahorros",0,"mgomez",4444);
		Cuenta e4=new Cuenta(331122,"Bolivianos","Caja de Ahorros",100,"sperez",5555);
		Cuenta e5=new Cuenta(332211,"USD","Cuenta Corriente",1000,"sperez",5555);
		Cuenta e6=new Cuenta(332233,"Bolivianos","Caja de Ahorros",100000,"sperez",5555);
		cuenta.add(e1);
		cuenta.add(e2);
		cuenta.add(e3);
		cuenta.add(e4);
		cuenta.add(e5);
		cuenta.add(e6);
		
		boolean error,fla,flag;
		System.out.println("Bienvenido"); 
		System.out.println("============================="); 
		do{
			System.out.print("Ingrese el codigo de cliente: ");
			String cod=entrada.nextLine();
			fla=compara_cod(cod);
			if(fla==true) {
				do{
					error=true;
					System.out.print("Ingrese el pin de seguridad: ");
					int pin=entrada.nextInt();
					flag=esSoloLetras(pin);
					if(flag==true) {
						error=false;
						System.out.print("\n"); 
						System.out.println("SOLO SE DEBE INGRESAR NUMEROS");  
						System.out.println("Vuelva a ingresar su pin");  
					}
					if(pin!=pinc) {
						error=false;
						System.out.println("El pin ingresado no es correcto");
					}
				}while(error==false);
				menu();
			}else {
				System.out.println("El codigo de cliente es incorrecto");  
			}
		}while(fla==false);
	}
	
	public static boolean compara_cod(String cod) {
		boolean fla=false;
		for(Cliente c: cliente) {
			if(cod.equals(c.getCod_cliente())) {
				codigo=c.getCod_cliente();
				pinc=c.getPin();
				fla=true;
			}
		}
		return fla;
	}
	public static void consultar() {
    	for(Cuenta c: cuenta) {
    		System.out.println(c.toString());
    		for(Cliente cli: cliente) {
    			System.out.println(cli.toString());
    		}	
    	}
    }
	public static void retiro() {
		double retiro=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del retiro: "));
		for(Cuenta c: cuenta) {
	    	c.retirar(retiro);
	    	JOptionPane.showMessageDialog(null, "Retiro realizado");
	    }
		
    }
	public static void deposito() {
		double deposito=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del deposito: "));
		for(Cuenta c: cuenta) {
			double x=c.getSaldo()+deposito;
			double a=c.getSaldo();
	    	c.setSaldo(x);
	    	JOptionPane.showMessageDialog(null, "Antiguo saldo"+a+"\nDeposito realizado"+"\nNuevo Saldo"+c.getSaldo());
	    }
    }
	
	public static boolean esSoloLetras(int cad){
		boolean flag=false;
		String cadena=cad+"";
		for (int i = 0; i < cadena.length(); i++)
		{
			char caracter = cadena.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII < 48 || valorASCII > 57)
				flag=true; 
		}
 
		return flag;
	}
	
	public static void menu() {
		int opcion=0;
		boolean flag=false;
		do {
			System.out.println("Menú de opciones");
			System.out.println("=====================");
			System.out.println("\n1. Ver Saldo");
			System.out.println("2. Depositar");
			System.out.println("3. Retirar");
			System.out.println("4. Salir");
			System.out.println("Ingrese una opción: ");
			opcion = entrada.nextInt();
			
			if(opcion>=1 && opcion<=4) {
				flag=true;
				menu2(opcion);
			}else {
				System.out.println("Introduzca una de las opciones");
			}

		}while(flag==true);
	}
	
	public static void menu2(int opcion) {
		boolean flag=false;
		if(opcion==1) {
			consulta();
		}else {if(opcion==2) {
				deposit();
			}else {if(opcion==3) {
					ret();
				
				}else
					System.exit(0);
			}	
		}
	}
	
	public static void consulta() {
		String cad="";
		int a=1;
		for(Cuenta c: cuenta) {
			if(codigo.equals(c.getCod())) {
				cad+="Cuenta "+a+"\n";
				a++;
			}
		}
		cad+="Ingrese el numero de la cuenta a la que desea ingresar: ";
		System.out.println(cad);
		int opcion = entrada.nextInt();
		a=0;
		for(Cuenta c: cuenta) {
			if(codigo.equals(c.getCod())) {
				a++;
				if(opcion==a) {
					System.out.println(c.toString());
				}
			}
		}
	}
	
	public static void deposit() {
		boolean flag=false;
		String cad="";
		int a=1;
		for(Cuenta c: cuenta) {
			if(codigo.equals(c.getCod())) {
				cad+="Cuenta "+a+"\n";
				a++;
			}
		}
		cad+="Ingrese el numero de la cuenta a la que desea ingresar: ";
		System.out.println(cad);
		int opcion = entrada.nextInt();
		a=0;
		for(Cuenta c: cuenta) {
			if(codigo.equals(c.getCod())) {
				a++;
				if(opcion==a) {
					
					System.out.println("Saldo Actual: "+c.getSaldo());
					do {
						flag=false;
						System.out.println("Ingrese monto a depositar en moneda "+c.getMoneda()+": ");
						float dep = entrada.nextFloat();
						if(dep==0) {
							System.out.println("El monto no puede ser cero ");
							flag=true;
						}
						if(dep<0) {
							System.out.println("El monto no puede ser negativo ");
							flag=true;
						}
						if(flag==false) {
							c.ingresar(dep);
							System.out.println("Deposito realizado");
						}
					}while(flag==true);
					
				}
			}
		}
	}
	
	public static void ret() {
		boolean flag=false;
		String cad="";
		int a=1;
		for(Cuenta c: cuenta) {
			if(codigo.equals(c.getCod())) {
				cad+="Cuenta "+a+"\n";
				a++;
			}
		}
		cad+="Ingrese el numero de la cuenta a la que desea ingresar: ";
		System.out.println(cad);
		int opcion = entrada.nextInt();
		a=0;
		for(Cuenta c: cuenta) {
			if(codigo.equals(c.getCod())) {
				a++;
				if(opcion==a) {
					System.out.println("Saldo Actual: "+c.getSaldo());
					do {
						flag=false;
						System.out.println("Ingrese monto a retirar en moneda "+c.getMoneda()+": ");
						float ret = entrada.nextFloat();
						if(ret==0) {
							System.out.println("El monto no puede ser cero ");
							flag=true;
						}
						if(ret<0) {
							System.out.println("El monto no puede ser negativo ");
							flag=true;
						}
						if(ret>c.getSaldo()) {
							System.out.println("El monto no puede ser mayor al saldo actual ");
							flag=true;
						}
						if(flag==false) {
							c.retirar(ret);
							System.out.println("Retiro realizado");
						}
					}while(flag==true);

				}
			}
		}
	}
} 


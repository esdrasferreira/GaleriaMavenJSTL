package br.com.esdrasferreira.model.dao;

public class Modulo {
	public int num1;
	public int num2;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public void mod(int num1, int num2) {

		int mod = num1 % num2;
		System.out.println(mod);

	}

	public static void main(String[] args) {
		
	Modulo modulo = new Modulo();
	

	
	modulo.mod(10, 5);
	

	}

}

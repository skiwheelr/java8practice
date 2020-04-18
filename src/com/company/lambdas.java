package com.company;

interface A {
	void show(int i);
}
//having this AIC is not necessary when lambda functions are used.

//class Xyz implements A {
//	public void show(){
//		System.out.println("Hello");
//	}
//}

public class lambdas {

	public static void main(String[] args){
		A obj;

		obj = (int i) -> System.out.println("Hello!" + i); //interface implemented
//		obj = new A(){ //anonymous inner class
//			public void show(){
//				System.out.println("hello");
//			}
//		};
//		obj = new Xyz();
		obj.show(6);
	}
}

package com.company;
//https://www.youtube.com/watch?v=svQKKg3aFzo

//passing a method inside a method ('function in a function' in functional programming) - high order functions


interface Parser {
	String parse(String str);
}

//implement this logic every pass
class StringParser {
	public static String convert(String s){ //this method called convert returns a String
//		public String convert(String s){ //this method called convert returns a String
		if(s.length()<=3)
			s = s.toUpperCase();
		else
			s = s.toLowerCase();
		return s;
	}
}

class MyPrinter{
	public void print(String str, Parser p){ //takes the string and the interface)
		str = p.parse(str);
		System.out.println(str);
	}
}

public class methodRef {
	public static void main (String[] args){
		StringParser sp = new StringParser();
		String str = "Mark";
		MyPrinter mp = new MyPrinter();
		//it knows to convert the string str using the sp.convert method automatically
		//if the convert method is not static, use sp::convert instead of StringParser.convert vvv
		mp.print(str,(StringParser::convert)); //the fact that it is taking an s and processing it is inferred here
//		mp.print(str,(s -> StringParser.convert(s))); //takes string as string and class.convert as parser interface

		//print anywhere you want
//		mp.print(System.out::println);
	}



}

package com.company;


import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.company.stream;
//
//class ConsImpl implements Consumer<Integer> {
//	public void accept(Integer i){
//		System.out.println(i);
//	}
//}

public class Main {


    public static void main(String[] args) {

    	stream s = new stream();
//    	s.run();



    	List<Integer> values = Arrays.asList(4,5,6,7,8);
    	Stream<Integer> S = values.stream();
    	S.forEach(System.out::println); //works (:: is method reference)
//		S.forEach(System.out::println); //exception from stream


//    	Consumer<Integer> c = (i) -> System.out.println(i);

    	//values.forEach(i -> System.out.println(i)); //lambda //Consumer
//    	Consumer<Integer> c = new Consumer<Integer>() {
//    		public void accept(Integer i) {
//    			System.out.println(i);
//			}
//		};
//    	values.forEach(c);
//		values.forEach((i)-> System.out.println(i));
    }
}


//interface justRun {
//	void show();
//}


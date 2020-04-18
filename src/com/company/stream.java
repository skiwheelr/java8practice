package com.company;

import java.util.ArrayList;
import java.util.List;

//stream api includes filter, findfirst, forEach, map, flatmap, oddNumbers, etc..
//once a value has been used, it cannot be used twice

public class stream {
	public void run() {

		List<Integer> values = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			values.add(i);
		}
		//intermediate method / lazy valuation
		values.stream().filter(i -> {
			System.out.println("hi");
			return true;
		}).findFirst().orElse(0); //executes hi once //orElse (if it does not find any of the values sought)

	}

		//creating as many threads possible automatically

//	values.stream().forEach(System.out::println);
//	values.forEach(System.out::println);

}

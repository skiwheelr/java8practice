package com.company;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class compfut {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		//Stage execution of thread1 as an asynchronous Completable Future with exception
		CompletableFuture<String> future = CompletableFuture.supplyAsync(()-> { try {
			return thread1();
			//if there is an exception caught:
		} catch (InterruptedException e) {
			throw new RuntimeException("computation error!");
		}
		});

		//Stage execution of the other threads with no exception rules
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {return thread2();});
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {return thread3();});

		// would print them out immediately
//		System.out.println(future2.get());
//		System.out.println(future3.get());


		//puts all these results into a string from a stream of completable futures
		//	THE BENEFIT HERE IS THAT IT DOES NOT COMBINE THEM UNTIL ALL HAVE PROCESSED ASYNCHRONOUSLY
		String combined = Stream.of(future, future2, future3)
				.map(CompletableFuture::join)//perform CompletableFuture.join() on each of them (when available)
				.collect(Collectors.joining("::"));//perform Collectors.joining() on them separating by ::

		//final action
		System.out.println(combined);

	}

	//returns text after 10 seconds
//	@org.jetbrains.annotations.NotNull
	public static String thread1() throws InterruptedException {
		Thread.sleep(10000);
		return "Execute first thread";
	}

	public static String thread2() {
		return "Execute second thread";
	}

	public static String thread3() {
		return "Execute third thread";
	}
}

package com.ocp17.java7.utils;

public class CustomDirtyResource implements AutoCloseable {
	@Override
	public void close() throws Exception {
		throw new NullPointerException("Oops!!! It is very bad to have a null pointer exception");
	}
	public void readFromResource() {
		throw new RuntimeException("I am sorry. I don't have data available right now due to network issue !!!");
	}
}

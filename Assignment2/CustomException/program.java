package com.exception;

import java.util.Scanner;

public class program {

	public static void main(String[] args) {
		Acceptstring s=new Acceptstring();
		Scanner sc=new Scanner(System.in);
		try {
			s.accept(sc);
		} catch (ExceptionLineTooLong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

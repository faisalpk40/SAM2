package VerifyPassword;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Verify {
	private static final String FILENAME = "C:/Users/sinsa/workspace/GeneratePassword/password.txt";

	public static void main(String[] args) {
			

		
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String passwordConfirm;
			String sCurrentLine;


			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				
			
			//confirm the password
			passwordConfirm = sCurrentLine;		
			Scanner user_input = new Scanner(System.in);
			String password;
			System.out.print("Enter the password:");
			password = user_input.next();
			if(passwordConfirm.compareTo(password) == 0){
				System.out.println("correct password");
			}else{
				System.out.println("incorrect password");
			}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} 
	}
}

package unl.cse.recursion;

import java.util.Scanner;

public class Palindrome {

	public boolean isPalindrome(String s) {
		if(s.length() == 0 || s.length()==1)
			return true;
		
			if(s.charAt(0) == s.charAt(s.length()-1))
			return isPalindrome(s.substring(1, s.length()-1));
			else
				return false;
	}
	
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		Palindrome p = new Palindrome();
		System.out.println("Enter a word: ");
		String str = s.next();
		System.out.println(str+" is a palindrome? "+p.isPalindrome(str));
	}
}

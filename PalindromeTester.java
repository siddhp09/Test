package schoolProjects;

import java.util.Scanner;

public class PalindromeTester {

		public static void main(String[] args){
			Scanner scn = new Scanner(System.in);
			String s;
			
			System.out.print("Enter a string: ");
			s = scn.nextLine();
			
			scn.close();
			
			System.out.println(isPalindrome(s));
		}
		public static String removePunctuation(String s){
			String s2 = "";
			s = s.toLowerCase();
			for(int x = 0; x < s.length(); x++){
				if((s.charAt(x) >= 'a' && s.charAt(x) <= 'z') || (s.charAt(x) >= 'A' && s.charAt(x) <= 'Z')){
					s2 = s2 + s.charAt(x);
				}
			}
			s = s2;
			return s;
		}
		public static String reverseString(String s){
			s = removePunctuation(s);
			String s2 = "";
			for(int y = s.length()-1; y >= 0; y--){
				s2 = s2 + s.charAt(y);
			}
			s = s2;
			return s;
		}
		public static boolean isPalindrome(String s){
			if(removePunctuation(s).equals(reverseString(s))){
				return true;
			}
			else{
				return false;
			}
		}
	}


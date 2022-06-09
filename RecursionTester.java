

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;





@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab2Tester {

	
	// sum
	
	@Test
	public void testSum1() {
		int start = 0;
		int end = 9; 
		int  sum= 0;
		for (int i = start ; i <= end ; i++) 
			sum  += i;
		
		assertEquals("Failed at sum (" + start + ", " + end + ")", sum, Lab2.sum(start, end));
			
	}
	

	@Test
	public void testMakeString1() {
		char init = '*'; 
		int n = 5;
		String result = ""; 
		for (int i = 0 ; i < n ; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab2.makeString(init, n));	
	}

	
	@Test
	public void testInterlace2() {

		String str = "*-*-*-*-";
		assertEquals("Failed: interlace(\"*\",\"-\",1)", str, Lab2.interlace("*","-",8));
	}

	
	

	@Test
	public void testGetSubstring1() {

		String str1 = "x + y + z - ( y * z) / 3 * n ";
		String result = " y * z";
		char open = '(';
		char close = ')';
		assertEquals("Failed: getSubstring(\"x + y + z - ( y * z) / 3 * n \", \"(\", \")\")", result, Lab2.getSubstring("x + y + z - ( y * z) / 3 * n ", '(', ')'));
	}
	
	@Test
	public void testGetSubstring11() {

		String str1 = "This is [quite} an example!";
		String result = "quite";
		char open = '[';
		char close = '}';
		assertEquals("Failed: getSubstring(\"x + y + z - ( y * z) / 3 * n \", \"(\", \")\")", result, Lab2.getSubstring("This is [quite} an example!", '[', '}'));
	}
	
	
	
	

	@Test
	public void testDecimalToBinary4() {
		int decimal = 13; 
		String binary = "1101";
		assertEquals("Failed: decimalToBinary(23)", binary, Lab2.decimalToBinary(13));
	}

}
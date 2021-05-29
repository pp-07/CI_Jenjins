package Package1;

import org.testng.TestNG;



public class TestRunner1 {

		static TestNG testng;
		public static void main(String[] args) {
			

		testng = new  TestNG();
		testng.setTestClasses(new Class[] {NewTest.class});
	 
	    testng.run();
		}

	}



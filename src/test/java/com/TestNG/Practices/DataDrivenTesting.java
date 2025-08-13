package com.TestNG.Practices;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting {

	@Test(dataProvider = "getData")
	public void CreateContact(String firstname, String lastname) {
		System.out.println("FirstName=======> " + firstname + " lastname =======> " + lastname);
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] objarr = new Object[3][2];
		objarr[0][0] = "Souvik";
		objarr[0][1] = "Guria";
		objarr[1][0] = "Stev";
		objarr[1][1] = "Smith";
		objarr[2][0] = "John";
		objarr[2][1] = "Cena";

		return objarr;
	}

}

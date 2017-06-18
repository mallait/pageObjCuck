package pl.lait.Test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pl.lait.PageObjects.*;
import pl.lait.Setup.Init;

public class ReservationTest extends Init {
	
	protected static WebDriver driver;
	
	@Before
	public void run(){
		driver = getDriver();
		
	}
	
	@Test
	public void reservation(){
		MainPage mainPage = new MainPage();
		SignOnPage signOnPage = new SignOnPage();
		ReservationPage reservationPage = new ReservationPage();
		
		//przechodzimy w górnym menu do strony SING-ON
		mainPage.link_signOn(driver).click();
		//logujemy się jako adam qwe/ qwe123;
		signOnPage.loginAs("adam_qwe","qwe123", driver);
		//wypełniamy pierwszą stronę rezerwacji lotów
		
		reservationPage.radio_oneWay(driver).click();
		reservationPage.selectPassengersCount(driver, "2");
		reservationPage.selectPassengersCount(driver).selectByVisibleText("3");
		
		reservationPage.selectFromPort(driver, "Frankfurt");
		reservationPage.selectFromMonth(driver, "July");
		reservationPage.selectFromDay(driver, "18");
		
		reservationPage.selectToPort(driver, "Paris");
		reservationPage.selecttoMonth(driver, "July");
		reservationPage.selectToDay(driver, "18");
		
		
	}


		
		
		
		

}

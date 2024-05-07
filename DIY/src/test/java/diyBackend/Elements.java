package diyBackend;

public class Elements {
	String email="//input[@placeholder='someone@email.com']";
	String contBtn="//button[normalize-space()='Continue with Email']";
	//String pwd="//*[@name='password']";
	String otp="/html/body/div/div/div/div/form/div/input[position() >= 1 and position() <= 6]\r\n"
			+ "";
	String contBtnfrompwd="//button[contains(text(),'Continue')]";
	String goToEvent="//*[@id='__next']/div[1]/div[2]/div/a";
	String registerBtn="//a[contains(text(),'Register')]";
	String contibueBtnfrmQty="(//*[contains(text(),'Continue')])[1]";
	String firstName="//input[@id='gjdh540']";
	String lastName="//input[@id='gjdh550']";
	String emailFront="//input[@id='gjdh560']";
	String saveForm="//button[@id='save0']";
	String checkout="(//*[contains(text(),'Checkout')])[1]";

}

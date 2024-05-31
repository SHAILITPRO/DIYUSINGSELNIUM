package diyBackend;

public class Elements {
	String textWelcom="//h2[normalize-space()='Welcome']";
	String email="//input[@placeholder='someone@email.com']";
	String contBtn="//button[normalize-space()='Continue with Email']";
	//String pwd="//*[@name='password']";
	String otp="/html/body/div/div/div/div/form/div/input[position() >= 1 and position() <= 6]\r\n"
			+ "";
	String phone="//*[@name='phone']";
	String skip="//button[contains(text(),'Skip')]";
	
	String completeYourProfile="//h2[contains(text(),'Complete Your Profile')]";
	String firstNameBackend="//*[@name='first_name']";
	String lastNameBackend="//*[@name='last_name']";
	String letsGo="//button[@type='submit']";
	String eventName="//*[@name='title']";
	String eventDescrElement="//textarea[@placeholder='Enter Description']";
	
	String EventStartdate=".flex:nth-child(1) > .flex .calender_input__v9nBO";
	String eventStartTime=".flex:nth-child(1) > .flex .w-full";
	String eventStartTimeSelect=".w-full:nth-child(33)";
	String eventEndDate=".flex:nth-child(2) > .flex .calender_input__v9nBO";
	String eventEndTime=".flex:nth-child(2) > .flex .w-full";
	String eventEndTimeSelect=".w-full:nth-child(47)";
	
	String location="//button[contains(text(),'Add Event Location')]";
	String enterlocation="//input[@placeholder='Enter Location']";
	
	
	
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

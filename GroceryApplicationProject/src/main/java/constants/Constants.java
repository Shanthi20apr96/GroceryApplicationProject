package constants;

public class Constants {
	public static final String TESTDATAFILE = System.getProperty("user.dir")+"\\src\\test\\resources\\Testdata.xlsx";
	public static final String CONFIGFILE = System.getProperty("user.dir")+ "\\src\\main\\resources\\config.properties";
	//login test assertion error messages
	public static final String VALIDCREDENTIALERROR = "user was unable to login with valid credentials";
	public static final String INVALIDPASSWORDERROR ="User was able to login with invalid password";
	public static final String INVALIDUSERNAMEERROR ="User was able to login with invalid username";
	public static final String INVALIDCREDENTIALERROR = "user is able to login using invalid credentials";
	//home test assertion error messages
	public static final String USERLOGOUTERROR ="User is not able to logout";
	
	//admin test assertion error messages
	public static final String ADDNEWUSERSERROR =" User is unable to add new users";
	public static final String REFRESHUSERLISTERROR = "Unable to refresh the users list";
	public static final String SEARCHUSERLISTERROR = "Unable to search the users list";
	
	
	//manage test assertion error messages
		public static final String ADDNEWNEWSSERROR =" User is unable to add new news";
		public static final String REFRESHNEWSLISTERROR = " Unable to reset news list";
		public static final String SEARCHNEWSLISTERROR = "Unable to search the news list";
		
}

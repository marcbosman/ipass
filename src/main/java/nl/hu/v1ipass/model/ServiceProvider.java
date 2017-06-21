package nl.hu.v1ipass.model;

public class ServiceProvider {
	private static AppService appService = new AppService();

	public static AppService getAppService() {
		return appService;
	}
}
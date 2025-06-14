package AllureReports;

import java.io.IOException;

public class Openallurereport {
	public static void openAllureReport() {
        try {
            String command = "cmd.exe /c allure serve allure-results";
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println("Failed to open Allure report.");
            e.printStackTrace();
        }
    }
}

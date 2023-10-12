package org.davshaw.Davank;

import java.util.List;

import org.davshaw.Controller.TeamLoanController;
import org.davshaw.External.Color;
import org.davshaw.External.ResultPack;
import org.davshaw.Gui.Admin.User.UserPage;
import org.davshaw.Service.Loan.getLoanReportAsText;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DavankApplication
{
	
	public static void main(String[] args)
	{
		System.setProperty("java.awt.headless", "false"); //Disables headless

		SpringApplication.run(DavankApplication.class, args);
		System.out.println(Color.color("RED","Spring Boot local project server is running from now on. All requests should appear under this message"));


		ResultPack<List<Integer>> result = TeamLoanController.getLoanReport(106);
        String message = getLoanReportAsText.getText(result.getResult());
		System.out.println(message);
                
                // Open main frame
                UserPage mainFrame = new UserPage();
				mainFrame.setVisible(true);
	
	}
}
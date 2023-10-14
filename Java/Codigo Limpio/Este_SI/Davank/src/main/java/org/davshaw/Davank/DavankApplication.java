package org.davshaw.Davank;

import org.davshaw.External.Color;
import org.davshaw.Gui.Admin.Admin.AdminPage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DavankApplication {

  public static void main(String[] args) {
    System.setProperty("java.awt.headless", "false"); //Disables headless

    SpringApplication.run(DavankApplication.class, args);
    System.out.println(
      Color.color(
        "RED",
        "Spring Boot local project server is running from now on. All requests should appear under this message"
      )
    );

    new AdminPage().setVisible(true);
  }
}

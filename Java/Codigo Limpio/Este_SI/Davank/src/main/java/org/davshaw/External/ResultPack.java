package org.davshaw.External;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ResultPack<Generic> {

  private Boolean okay;
  private Generic result = null;
  private String message = "";


  public String getMessageFormatted() {

    String message = "";
    message += "--------------------------------";
    message += "\n";
    message += "Executed successfully: " + this.getOkay();
    message += "\n";
    message += "Server returned: " + this.getResult();
    message += "\n";
    message += "Message: " + this.getMessage();
    message += "\n";
    message += "--------------------------------";
    return message;
  }
}

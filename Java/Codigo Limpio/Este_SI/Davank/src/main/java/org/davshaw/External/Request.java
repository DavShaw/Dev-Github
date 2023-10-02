package org.davshaw.External;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Request<Generic>
{
    private Boolean success;
    private String message = "";
    private Generic result = null;
}

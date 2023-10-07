package org.davshaw.External;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class RequestResult<Generic>
{
    private Boolean okay;
    private Generic result = null;
    private String message = "";
}

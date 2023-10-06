package org.davshaw.External;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestResult<Generic>
{
    private Boolean okay;
    private Generic result = null;
    private String message = "";
}

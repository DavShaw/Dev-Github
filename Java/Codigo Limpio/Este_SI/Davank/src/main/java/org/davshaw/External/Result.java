package org.davshaw.External;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Result<Generic>
{
    private Boolean okay;
    private Generic result = null;
    private String message = "";
}

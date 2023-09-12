package org.davshaw.external;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ExecuteTimer
{
    private LocalTime startTime;
    private LocalTime endTime;

    //No requiere constructor, pero tampoco es estático

    public void start()
    {
        this.startTime = LocalTime.now();
    }

    public void stop()
    {
        this.endTime = LocalTime.now();
    }

    public double getTotalTimeInSeconds()
    {
        Duration duration = Duration.between(startTime, endTime);
        long seconds = duration.getSeconds();
        long millis = duration.toMillisPart();
        return (seconds + (millis / 1000.0));
    }

}

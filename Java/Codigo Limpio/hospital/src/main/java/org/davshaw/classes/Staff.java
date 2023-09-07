package org.davshaw.classes;

import java.time.LocalTime;

public class Staff
{
    private String name;
    private String profession;
    private LocalTime bussyUntil;
    
    public Staff(String name, String profession)
    {
        this.name = name;
        this.profession = profession;
        this.bussyUntil = LocalTime.now();
    }

    public LocalTime getBussyUntil()
    {
        return this.bussyUntil;
    }

    public void addTimeToBusy(int minutes)
    {
        this.bussyUntil.plusMinutes(minutes);
    }

    public String getName()
    {
        return this.name;
    }

    public String getProfession()
    {
        return this.profession;
    }

    public boolean isBusy()
    {
        return this.bussyUntil.isAfter(LocalTime.now());
    }
}

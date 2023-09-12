package org.davshaw.external;

import org.davshaw.classes.Hospital;

public class TestCase
{
    TestData Data;
    public TestCase()
    {
        this.Data = new TestData();
    }


    public static void testData(Hospital hospital, int amountOfTest)
    {
        TestData database = new TestData();
        for (int i = 0; i < amountOfTest; i++)
        {
            String name = database.getNameToInsert();
            String desc = database.getDescriptionToInsert();
            int age = database.getAgeToInsert();
            hospital.agregarSolicitudes(name, desc, age);
        }
    }

}

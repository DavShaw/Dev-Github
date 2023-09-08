package org.davshaw.resources;

import java.util.ArrayList;
import java.util.List;

import org.davshaw.classes.RequestQueue;
import org.davshaw.external.DataBase;

public class TestCase
{

    TestData testData;
    public TestCase()
    {
        this.testData = new TestData();
    }

    public RequestQueue testCaseN1Object()
    {
        this.testData.getDatabase().connect();
        List<String> sqlStatements = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            String nameToInsert = this.testData.getNameToInsert();
            String descriptionToInsert = this.testData.getDescriptionToInsert();
            int ageToInsert = this.testData.getAgeToInsert();
            String sql = String.format("INSERT INTO requestDatabase VALUES ('%s', '%s', %s)", nameToInsert, descriptionToInsert, ageToInsert);
            sqlStatements.add(sql);
        }
        this.testData.getDatabase().executeBatchUpdate(sqlStatements);
        this.testData.getDatabase().disconnect();

        return null;
    }

    private void generateTestData(int testDataToGenerate)
    {
        this.testData.getDatabase().connect();
        List<String> sqlStatements = new ArrayList<>();
        for (int i = 0; i < testDataToGenerate; i++)
        {
            String nameToInsert = this.testData.getNameToInsert();
            String descriptionToInsert = this.testData.getDescriptionToInsert();
            int ageToInsert = this.testData.getAgeToInsert();
            String sql = String.format("INSERT INTO requestDatabase VALUES ('%s', '%s', %s)", nameToInsert, descriptionToInsert, ageToInsert);
            sqlStatements.add(sql);
        }
        this.testData.getDatabase().executeBatchUpdate(sqlStatements);
        this.testData.getDatabase().disconnect(); 
    }

    public void testCaseN1()
    {
        this.testData.getDatabase().connect();
        List<String> sqlStatements = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            String nameToInsert = this.testData.getNameToInsert();
            String descriptionToInsert = this.testData.getDescriptionToInsert();
            int ageToInsert = this.testData.getAgeToInsert();
            String sql = String.format("INSERT INTO requestDatabase VALUES ('%s', '%s', %s)", nameToInsert, descriptionToInsert, ageToInsert);
            sqlStatements.add(sql);
        }
        this.testData.getDatabase().executeBatchUpdate(sqlStatements);
        this.testData.getDatabase().disconnect();
    }

    public void testCaseN2()
    {
        this.testData.getDatabase().connect();
        List<String> sqlStatements = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            String nameToInsert = this.testData.getNameToInsert();
            String descriptionToInsert = this.testData.getDescriptionToInsert();
            int ageToInsert = this.testData.getAgeToInsert();
            String sql = String.format("INSERT INTO requestDatabase VALUES ('%s', '%s', %s)", nameToInsert, descriptionToInsert, ageToInsert);
            sqlStatements.add(sql);
        }
        this.testData.getDatabase().executeBatchUpdate(sqlStatements);
        this.testData.getDatabase().disconnect();
    }

    public void testCaseN3()
    {
        this.testData.getDatabase().connect();
        List<String> sqlStatements = new ArrayList<>();
        for (int i = 0; i < 10000; i++)
        {
            String nameToInsert = this.testData.getNameToInsert();
            String descriptionToInsert = this.testData.getDescriptionToInsert();
            int ageToInsert = this.testData.getAgeToInsert();
            String sql = String.format("INSERT INTO requestDatabase VALUES ('%s', '%s', %s)", nameToInsert, descriptionToInsert, ageToInsert);
            sqlStatements.add(sql);
        }
        System.out.println(sqlStatements.toString());
        this.testData.getDatabase().executeBatchUpdate(sqlStatements);
        this.testData.getDatabase().disconnect();
    }

    public DataBase getDatabase()
    {
        return this.testData.getDatabase();
    }

    public void deleteData()
    {
        this.testData.getDatabase().connect();
        this.testData.getDatabase().executeUpdate("DELETE FROM requestDatabase");
    }

}

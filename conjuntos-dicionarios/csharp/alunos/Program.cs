using System;
using System.Collections.Generic;

public class Alunos
{
    public static int StudentsCount(List<List<int>> courses)
    {
        var allStudents = new HashSet<int>();

        foreach (var course in courses)
        {
            allStudents.UnionWith(course);
        }

        return allStudents.Count;
    }

    public static void Main(string[] args)
    {
        List<List<int>> courseList = new List<List<int>>()
        {
            new List<int>() { 15, 21, 80, 42 },
            new List<int>() { 21, 80, 47 },
            new List<int>() { 12, 21, 47, 35 }
        };

        int result = StudentsCount(courseList);
        Console.WriteLine("Total students = " + result);
    }
}

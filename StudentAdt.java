/****************************************************************************
 *
 * Created by: Mr Coxall
 * Modified by : Ben Lapuhapo
 * Created on: March 10 2019
 * This program holds student information in an array, and as each new
 * student's info is entered, a new entry is created in the array
 *
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Create an enum of GRADES; can only be ONE of these following values
enum GRADES {

    TWELVE("12"),
    ELEVEN("11"),
    TEN("10"),
    Nine("9"),
    EIGHT("8"),
    SEVEN("7"),
    SIX("6"),
    FIVE("5"),
    FOUR("4"),
    THREE("3"),
    TWO("2"),
    ONE("1"),
    SK("Senior KindergarTEN"),
    JK("Junior KindergarTEN");

    private final String Grade;

    GRADES(String Grade)
    {
        this.Grade = Grade;
    }

    public String getGrade() {
        return this.Grade;
    }
}

// Information for a single student
class Student
{
    public String _FirstName;
    public String _LastName;
    public String _DateOfBirth; //dd/mm/yyyy
    public String _MiddleInitial;
    public GRADES _Grade;
    public boolean _Identified;

    //constructor
    public Student (String FirstName,String LastName,String DateOfBirth, String MiddleInitial,GRADES Grade,boolean Identified)
    {
        this._FirstName = FirstName;
        this._LastName = LastName;
        this._DateOfBirth = DateOfBirth;
        this._MiddleInitial = MiddleInitial;
        this._Grade = Grade;
        this._Identified = Identified;
    }
}

public class StudentADT
{

    public static void main(String[] args) throws IOException
    {
        // get student info
        boolean MoreStudents = true;

        String FirstName;
        String LastName;
        String DateOfBirth;
        String MiddleInitial;
        GRADES Grade;
        String GRADEString;
        String identification;
        boolean Identified = false;

        // Creates an array list (an array with no limit/index, so user can add indefinite amount of students
        ArrayList<Student> studentsArrList = new ArrayList<Student>();

        // Keeps asking for stuent information
	for (int counter = 0; MoreStudents == true; counter++)
        {

            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            // Obtains first name
            System.out.println("Enter a first name for student # " + (counter + 1) + ".");
            FirstName = br.readLine();

            // Obtains last name
            System.out.println("Enter a last name for student # " + (counter + 1) + ".");
            LastName = br.readLine();

            // Obtains date of birth
            System.out.println("Enter a date of birth (DD/MM/YYYY) for student # " + (counter + 1) + ".");
            DateOfBirth = br.readLine();

            // Obtains middle initial
            System.out.println("Enter a middle initial for student # " + (counter + 1) + ".");
            MiddleInitial = br.readLine();

            // Obtains Grade
            System.out.println("Enter a Grade (as plain text: JK-TWELVE) for student # " + (counter + 1) + ".");
            GRADEString = br.readLine();
            Grade = GRADES.valueOf(GRADEString.toUpperCase());

            // Asks if student is Identified
            System.out.println("Is student # " + (counter + 1) + " Identified? Y/N");

            if (br.readLine().equals("Y"))
            {
                Identified = true;
            }
            else
            {
                Identified = false;
            }

            // Creates a student with all the information obtained above
            Student currentStudent = new Student(FirstName, LastName, DateOfBirth, MiddleInitial, Grade, Identified);

            studentsArrList.add(currentStudent); //append new student to array list
            System.out.print("Current Students: \n");

            // Prints out every student in array and their Grade
            for(int nextStudent = 0; nextStudent < studentsArrList.size(); nextStudent ++)
            {
                // Prints student first, middle, last name and Grade
                System.out.print(studentsArrList.get(nextStudent)._FirstName + " " + studentsArrList.get(nextStudent)._MiddleInitial + " " + studentsArrList.get(nextStudent)._LastName + " is in Grade " + studentsArrList.get(nextStudent)._Grade + "\n");

                // Prints student date of birth
                System.out.print(studentsArrList.get(nextStudent)._FirstName + " is born " + studentsArrList.get(nextStudent)._DateOfBirth + "\n");

                // Checks if student is Identified
                if (Identified == true)
                {
                    identification = "Identified";
                }
                else
                {
                    identification = "not Identified";
                }

                // Prints if student is Identified or not
                System.out.print(studentsArrList.get(nextStudent)._FirstName + " is " + identification + "\n\n");
            }
            System.out.print("\n");
            System.exit(0);
        }
    }

}
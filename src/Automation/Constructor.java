/*add table and person details as per the below steps
First (Non Parameterized)
1.Define the dimensions of a table inside a class
2.Print the area of the table along with creation of object */

package Automation;
public class Constructor
{
    int length= 10;
    int breadth =20;
    int area = length*breadth;
    public Constructor()
    {
        System.out.println(area);
    }
    public static void main(String[] args)
    {
        Constructor obj = new Constructor();

    }

}
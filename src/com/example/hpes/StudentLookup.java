package com.example.hpes;

public class StudentLookup
{
public static final int COL_COUNT = 2;
public static final String R_NO= "rollno";
public static final String S_NAME="name";
public static int getColumnIndex(String col)
{
if(col.equalsIgnoreCase("rollno"))
{
return 0;
}
if(col.equalsIgnoreCase("name"))
{
return 1;
}
else
{
return -1;
}
}

}
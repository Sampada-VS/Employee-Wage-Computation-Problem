package com.employeewage;

public class EmployeeWage {
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;

	public static void main(String[] args)
	{
		calculateWage("Reliance",15,5,10);
		calculateWage("TCS",10,2,10);
	}
	public static void calculateWage(String company, int ratePerHr, int numOfworkingDays, int maxHrs)
	{
		int empWage;
		int empHrs;
		int totalEmpWage=0;
		int totalEmpHours=0;
		int totalWorkingDays=0;
		System.out.println("For company "+company+" : ");
		while (totalEmpHours<maxHrs && totalWorkingDays<numOfworkingDays)
		{
			totalWorkingDays++;
			int empCheck=(int)((Math.random()*10)%3);
			switch(empCheck)
			{
				case IS_FULL_TIME:
					empHrs=8;
					break;
				case IS_PART_TIME:
					empHrs=4;
					break;
				default:
					empHrs=0;
			}
			totalEmpHours=totalEmpHours+empHrs;
			if(totalEmpHours>maxHrs)
			{
				totalEmpHours=totalEmpHours-empHrs;
				totalWorkingDays--;
				break;
			}
			else
			{
				empWage=empHrs*ratePerHr;
				System.out.println("On day "+totalWorkingDays+" == Employee Daily wage: "+empWage);
			}
		}
		totalEmpWage=totalEmpHours*ratePerHr;
		System.out.println("Total Employee Wage :"+totalEmpWage);
		System.out.println("Total Employee Hours : "+totalEmpHours);
		System.out.println("Total working days : "+totalWorkingDays);
	}
}

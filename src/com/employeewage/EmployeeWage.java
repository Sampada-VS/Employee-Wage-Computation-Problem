package com.employeewage;

import java.util.*;

public class EmployeeWage implements ICalculateWage{
	
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
	
	private LinkedList<CompanyEmployeeWage> compEmpWageList;
	public int numOfCompany=0;
	
	public EmployeeWage()
	{
		compEmpWageList=new LinkedList<>();
	}
	public void addCompany(String company, int empRatePerHr, int numOfWorkingDays, int maxHrs)
	{
		CompanyEmployeeWage companyempwage= new CompanyEmployeeWage(company,empRatePerHr,numOfWorkingDays,maxHrs);
		compEmpWageList.add(companyempwage);
	}
	public void calculateWage()
	{
		for(int i=0;i<compEmpWageList.size();i++) {
			CompanyEmployeeWage companyempwage=compEmpWageList.get(i);
			companyempwage.setTotalEmpWage(this.calculateWage(companyempwage));
			System.out.println(companyempwage);
		}
	}

	public int calculateWage(CompanyEmployeeWage companyempwage)
	{
		int totalEmpHours=0;
		int totalWorkingDays=0;
		int totalEmpWage=0;

		System.out.println("For company "+companyempwage.company+"======");
		while (totalEmpHours<companyempwage.maxHrs && totalWorkingDays<companyempwage.numOfWorkingDays)
		{
			totalWorkingDays++;
			int empHrs;
			int empWage;
			
			int empCheck = (int)((Math.random()*10)%3);
			switch (empCheck)
			{
				case IS_FULL_TIME :
					empHrs=8;
					break;
				case IS_PART_TIME :
					empHrs=4;
					break;
				default :
					empHrs=0;
			}

			totalEmpHours=totalEmpHours+empHrs;
			if (totalEmpHours>companyempwage.maxHrs)
			{
				totalEmpHours=totalEmpHours-empHrs;
				totalWorkingDays--;
				break;
			}
			else
			{
				empWage=empHrs*companyempwage.empRatePerHr;
				totalEmpWage=totalEmpWage+empWage;
				System.out.println("Employee daily wage :"+empWage+" Total Employee Hours : "+totalEmpHours);
			}
			Dictionary<Integer, String> wage=new Hashtable<Integer, String>();
			String result="";
			result="Daily Wage :"+empWage+" Toatal Wage : "+totalEmpWage;
			wage.put(totalWorkingDays,result);
			for (Enumeration<String> i=wage.elements();i.hasMoreElements();)
			{
				System.out.println("Value in dictionary == "+i.nextElement());
			}
		}
		System.out.println("Total employee hours :"+totalEmpHours);
		System.out.println("Total working days :"+totalWorkingDays);
		return totalEmpHours*companyempwage.empRatePerHr;
	}
	public static void main(String[] args)
	{
		ICalculateWage employeewage =new EmployeeWage();
		employeewage.addCompany("Deloitte",10,4,10);
		employeewage.addCompany("Microsoft",30,5,30);
		employeewage.calculateWage();
	}
}

package com.employeewage;

public class EmployeeWage {
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
	
	public CompanyEmployeeWage[] compEmpWageArr;
	public int numOfCompany=0;
	public EmployeeWage()
	{
		compEmpWageArr=new CompanyEmployeeWage[2];
	}
	public void addCompany(String company, int empRatePerHr, int numOfWorkingDays, int maxHrs)
	{
		compEmpWageArr[numOfCompany]=new CompanyEmployeeWage(company,empRatePerHr,numOfWorkingDays,maxHrs);
		numOfCompany++;
	}
	public void calculateWage()
	{
		for(int i=0;i<numOfCompany;i++)
			compEmpWageArr[i].setTotalEmpWage(this.calculateWage(compEmpWageArr[i]));
	}
	public static void main(String[] args)
	{
		EmployeeWage empWageArr=new EmployeeWage();
		empWageArr.addCompany("Deloitte",20,2,5);
		empWageArr.addCompany("Microsoft",30,5,30);
		empWageArr.calculateWage();
	}
	public int calculateWage(CompanyEmployeeWage companyempwage)
	{
		int empHrs;
		int empWage;
		int totalEmpHours=0;
		int totalWorkingDays=0;
		System.out.println("For company "+companyempwage.company+"======");
		while (totalEmpHours<companyempwage.maxHrs && totalWorkingDays<companyempwage.numOfWorkingDays)
		{
			totalWorkingDays++;
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
				System.out.println("Employee daily wage :"+empWage+" Total Employee Hours : "+totalEmpHours);
			}
		}
		int totalEmpWage=totalEmpHours*companyempwage.empRatePerHr;
		System.out.println("Total employee wage :"+totalEmpWage);
		System.out.println("Total employee hours :"+totalEmpHours);
		System.out.println("Total working days :"+totalWorkingDays);
		return totalEmpWage;
	}
}

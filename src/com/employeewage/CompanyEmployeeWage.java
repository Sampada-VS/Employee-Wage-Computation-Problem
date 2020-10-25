package com.employeewage;

class CompanyEmployeeWage {
	public final String company;
	public final int empRatePerHr;
	public final int numOfWorkingDays;
	public final int maxHrs;
	public int totalEmpWage;

	public CompanyEmployeeWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrs)
	{
		this.company=company;
		this.empRatePerHr=empRatePerHr;
		this.numOfWorkingDays=numOfWorkingDays;
		this.maxHrs=maxHrs;
		totalEmpWage=0;
	}
	public void setTotalEmpWage(int totalEmpWage)
	{
		this.totalEmpWage=totalEmpWage;
	}
	public String toString()
	{
		return "Total employee wage for company "+company+" is : "+totalEmpWage;
	}
}

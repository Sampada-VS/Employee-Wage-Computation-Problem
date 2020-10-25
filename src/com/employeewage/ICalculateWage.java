package com.employeewage;

interface ICalculateWage {
	public void addCompany(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursInMonth);
	public void calculateWage();
}

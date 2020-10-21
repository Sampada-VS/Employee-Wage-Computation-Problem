
public class EmployeeWage {
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
	public static final int RATE_PER_HOUR=20;
	public static final int NUM_OF_WORKING_DAYS=20;
	public static final int MAX_HOURS=100;

	public static void main(String[] args)
	{
		calculate20Wage();
	}
	public static void calculate20Wage()
	{
		int empWage;
		int empHrs;
		int totalEmpWage=0;
		int totalEmpHours=0;
		int totalWorkingDays=0;

		while (totalEmpHours<MAX_HOURS && totalWorkingDays<NUM_OF_WORKING_DAYS)
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
			if(totalEmpHours>MAX_HOURS)
			{
				totalEmpHours=totalEmpHours-empHrs;
				totalWorkingDays--;
				break;
			}
			else
			{
				empWage=empHrs*RATE_PER_HOUR;
				System.out.println("On day "+totalWorkingDays+" == Employee Daily wage: "+empWage);
			}
		}
		totalEmpWage=totalEmpHours*RATE_PER_HOUR;
		System.out.println("Total Employee Wage : "+totalEmpWage);
		System.out.println("Total Employee Hours : "+totalEmpHours);
		System.out.println("Total working days : "+totalWorkingDays);
	}
}


public class EmployeeWage {
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
	public static final int RATE_PER_HOUR=20;
	public static final int NUM_OF_WORKING_DAYS=20;

	public static void main(String[] args)
	{
		calculate20Wage();
	}
	public static void calculate20Wage()
	{
		int empWage;
		int empHrs;
		int totalEmpWage=0;

		for(int day=1; day<=NUM_OF_WORKING_DAYS; day++)
		{
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
			empWage=empHrs*RATE_PER_HOUR;
			System.out.println("Employee daily wage: "+empWage);
			totalEmpWage=totalEmpWage+empWage;
		}
		System.out.println("Total Employee Wage : "+totalEmpWage);
	}
}

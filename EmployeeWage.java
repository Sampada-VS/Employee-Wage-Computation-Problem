
public class EmployeeWage {
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
	public static final int RATE_PER_HOUR=20;

	public static void main(String[] args)
	{
		int empWage=0;
		int empHrs=0;

		int empCheck=(int)((Math.random()*10)%3);
		if(empCheck == IS_FULL_TIME)
			empHrs=8;
		else if(empCheck == IS_PART_TIME)
			empHrs=4;
		empWage=empHrs*RATE_PER_HOUR;
		System.out.println("Employee daily wage: "+empWage);
	}
}

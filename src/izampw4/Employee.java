package izampw4;

abstract public class Employee{
	protected String name;
	
	public Employee(String nam) {
		name = nam;
		System.out.println("Employee created");
	}
	
	abstract public  void workOn();
//	abstract public  void workOn();
//	abstract public  void workOn();
	
	abstract public void report();
//	abstract public void report();
//	abstract public void report();
	
	public final boolean equal(final Employee sec){// virtual
		return false;
	}
	
	public  String toString() { //virtual
		return "";
	}
	
	public final String get_name() {
		return "";
	}
}

class SecurityEmployee extends Employee{
	public SecurityEmployee(String nam){
		super(nam);
		System.out.println("SecurityEmployee created");
	}
	
	public  void workOn() {
		
	}
	
//	public void workOn() {
//		
//	}
//	
//	public void workOn() {
//		
//	}
	
	public void report() {
		
	}
	
//	public void report() {
//		
//	}
//
//	public void report() {
//	
//	}
	
	public final boolean equal(final SecurityEmployee sec) {
		return false;
	}
	
	public SecurityEmployee clone() {
		SecurityEmployee temp=new SecurityEmployee("name");
		return temp;
	}
	

	public String toString() {
		return "";
	}
}

class MaintenanceEmployee extends Employee{
	public MaintenanceEmployee(String nam){
		super(nam);
		System.out.println("MaintenanceEmployee created");
	}
	
	public  void workOn() {
		
	}
	
//	public void workOn() {
//		
//	}
//	
//	public void workOn() {
//		
//	}
	
	public void report() {
		
	}
	
//	public void report() {
//		
//	}
//
//	public void report() {
//	
//	}
	
	public final boolean equal(final MaintenanceEmployee sec) {
		return false;
	}
	
	public MaintenanceEmployee clone() {
		MaintenanceEmployee temp=new MaintenanceEmployee("name");
		return temp;
	}
	

	public String toString() {
		return "";
	}
}

class CleaningEmployee extends Employee{
	public CleaningEmployee(String nam){
		super(nam);
		System.out.println("CleaningEmployee created");
	}
	
	public  void workOn() {
		
	}
	
//	public void workOn() {
//		
//	}
//	
//	public void workOn() {
//		
//	}
	
	public void report() {
		
	}
	
//	public void report() {
//		
//	}
//
//	public void report() {
//	
//	}
	
	public final boolean equal(final CleaningEmployee sec) {
		return false;
	}
	
	public CleaningEmployee clone() {
		CleaningEmployee temp=new CleaningEmployee("name");
		return temp;
	}
	

	public String toString() {
		return "";
	}
}




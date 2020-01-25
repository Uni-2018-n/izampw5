abstract public class Employee extends Object{
	protected String name;

	public Employee(){
		System.out.println("Employee just created");
	}

	public void workOn(CargoBay work_place){ //pure virtual

	}

	public void workOn(EquipmentCompartment work_place){//pure virtual

	}

	public void workOn(PassengerCompartment work_place){//pure virtual

	}

	public void report(CargoBay work_place){//pure virtual

	}

	public void report(EquipmentCompartment work_place){//pure virtual

	}

	public void report(PassengerCompartment work_place){//pure virtual

	}



	public boolean equal(final Employee sec){// virtual
		if(name == sec.name){
			return true;
		}
		return false;
	}

	public  String toString(){ //virtual
		return "Employee, " + name + " , ";
	}

	public final String get_name(){
		return name;
	}
}

final class SecurityEmployee extends Employee{
	public SecurityEmployee(String nam){
		name = nam;
		System.out.println("SecurityEmployee just created");
	}

	public final void workOn(CargoBay work_place){
		System.out.println("I SecurityEmployee, started working into a Cargo Bay");//print workOn message and then
		work_place.process(this);//change the variables into the work_place
	}

	public final void workOn(EquipmentCompartment work_place){
		System.out.println("I SecurityEmployee, started working into a Equipment Compartment");
		work_place.process(this);
	}

	public final void workOn(PassengerCompartment work_place){
		System.out.println("I SecurityEmployee, started working into a Passenger Compartment");
		work_place.process(this);
	}

	public final void report(CargoBay work_place){
		System.out.println("SecurityEmployee keep working on CargoBay");
	}

	public final void report(EquipmentCompartment work_place){
		System.out.println("SecurityEmployee keep working on EquipmentCompartment");
	}

	public final void report(PassengerCompartment work_place){
		System.out.println("SecurityEmployee keep working on PassengerCompartment");
	}

	public final  boolean equal(final SecurityEmployee sec){
		return super.equal(sec);//since there are no virables here its only about the superClass
	}

	public final SecurityEmployee clone(){
		SecurityEmployee temp=new SecurityEmployee(name);//create new temp with name the (class Employee)name of "this"
		return temp;
	}


	public final String toString(){
		return super.toString() + "SecurityEmployee";
	}
}

final class MaintenanceEmployee extends Employee{
	public MaintenanceEmployee(String nam){
		name = nam;
		System.out.println("MaintenanceEmployee created");
	}

	public final void workOn(CargoBay work_place){
		System.out.println("I MaintenanceEmployee, started working into a Cargo Bay");
		work_place.process(this);
	}

	public final void workOn(EquipmentCompartment work_place){
		System.out.println("I MaintenanceEmployee, started working into a Equipment Compartment");
		work_place.process(this);
	}

	public final void report(CargoBay work_place){
		System.out.println("MaintenanceEmployee keep working on CargoBay");
	}

	public final void report(EquipmentCompartment work_place){
		System.out.println("MaintenanceEmployee keep working on EquipmentCompartment");
	}

	public final boolean equal(final MaintenanceEmployee sec){
		return super.equal(sec);
	}

	public final MaintenanceEmployee clone(){
		MaintenanceEmployee temp=new MaintenanceEmployee(name);
		return temp;
	}


	public final String toString(){
		return super.toString() + "MaintenanceEmployee";
	}
}

final class CleaningEmployee extends Employee{
	public CleaningEmployee(String nam){
		name = nam;
		System.out.println("CleaningEmployee created");
	}

	public final void workOn(CargoBay work_place){
		System.out.println("I CleaningEmployee, started working into a Cargo Bay");
		work_place.process(this);
	}

	public final void workOn(PrivateCompartment work_place){
		System.out.println("I CleaningEmployee, started working into a Private Compartment");
		work_place.process(this);
	}

	public final void workOn(PassengerCompartment work_place){
		System.out.println("I CleaningEmployee, started working into a Passenger Compartment");
		work_place.process(this);
	}

	public final void report(CargoBay work_place){
		System.out.println("CleaningEmployee keep working on CargoBay");
	}

	public final void report(PrivateCompartment work_place){
		System.out.println("CleaningEmployee keep working on Private compartment");
	}

	public final void report(PassengerCompartment work_place){
		System.out.println("CleaningEmployee keep working on Passenger Compartment");
	}

	public final boolean equal(final CleaningEmployee sec){
		return super.equal(sec);
	}

	public final CleaningEmployee clone(){
		CleaningEmployee temp=new CleaningEmployee(name);
		return temp;
	}

	public final String toString(){
		return super.toString() + "CleaningEmployee";
	}
}

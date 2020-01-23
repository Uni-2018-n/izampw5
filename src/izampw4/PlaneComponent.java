// package izampw4;

abstract public class PlaneComponent extends Object{
	public PlaneComponent() {
		System.out.println("PlaneComponent created");
	}

	public  void process(SecurityEmployee worker) { //pure virtual

	}
	public  void process(MaintenanceEmployee worker) { //pure virtual

	}
	public  void process(CleaningEmployee worker) { //pure virtual

	}

	public boolean equal(final PlaneComponent sec) { //pure virtual
		return true;
	}

	public String toString() {
		return "PlaneComponent, ";
	}

	abstract public PlaneComponent clone();
	abstract public boolean ready_check();
}

class PassengerCompartment extends PlaneComponent{
	private PassengerCompartment Sub_PassCompartment;
	private boolean SecWorker;
	private boolean CleanWorker;

	public PassengerCompartment() {
		SecWorker = false;
		CleanWorker = false;
		System.out.println("PassengerCompartment created");
		if((MainClass.rnd.nextInt() % 3) == 0) { //TODO fix this
			System.out.println("Sub PassengerCompartment about to be created:");
			Sub_PassCompartment = new PassengerCompartment();
		}else {
			Sub_PassCompartment = null;
		}
	}

	public PassengerCompartment(boolean subs) {
		SecWorker = false;
		CleanWorker = false;
		Sub_PassCompartment = null;
		System.out.println("PassengerCompartment created");
	}

	public final void process(SecurityEmployee worker) {
		if(Sub_PassCompartment != null) {
			System.out.print("{Sub PassengerCompartment: ");
			worker.workOn(Sub_PassCompartment);
			worker.report(Sub_PassCompartment);
			System.out.println("}");
		}
		SecWorker = true;
	}

	public final void process(CleaningEmployee worker) {
		if(Sub_PassCompartment != null) {
			System.out.print("{Sub PassengerCompartment: ");
			worker.workOn(Sub_PassCompartment);
			worker.report(Sub_PassCompartment);
			System.out.println("}");
		}
		CleanWorker = true;
	}

	public final boolean equal(final PassengerCompartment sec) {
		if(super.equal(sec)) {
			if(SecWorker == sec.SecWorker && CleanWorker == sec.CleanWorker) {
				if(Sub_PassCompartment != null && sec.Sub_PassCompartment != null) {
					return Sub_PassCompartment.equal(sec.Sub_PassCompartment);
				}else {
					return true;
				}
			}
		}
		return false;
	}

	public final PassengerCompartment clone() {
		PassengerCompartment temp= new PassengerCompartment(true);
		temp.SecWorker = SecWorker;
		temp.CleanWorker = CleanWorker;
		if(Sub_PassCompartment != null) {
			temp.Sub_PassCompartment = Sub_PassCompartment.clone();
		}
		return temp;
	}

	public final boolean ready_check() {
		if(SecWorker & CleanWorker) {
			System.out.println("PassengerCompartment OK!");
			System.out.println(toString());
			if(Sub_PassCompartment != null) {
				System.out.print("Sub: ");
				if(!(Sub_PassCompartment.ready_check())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public final String toString() {
		String temp = super.toString() + "PassengerCompartment, ";
		if(SecWorker) {
			temp = temp + "SecurityEmployee worker here, ";
		}else {
			temp = temp + "Need SecurityEmployee to work here, ";
		}
		if(CleanWorker) {
			temp = temp + "CleaningEmployee worked here, ";
		}else {
			temp = temp + "Need CleaningEmployee to work here, ";
		}
		if(Sub_PassCompartment != null) {
			temp = temp + "\n {Sub_PassCompartment, " + Sub_PassCompartment.toString() + "}";
		}else {
			temp = temp + "No Sub_PassCompartment.";
		}
		return temp;
	}
}

abstract class PrivateCompartment extends PlaneComponent{
	protected boolean SecWorker;
	protected boolean CleanWorker;

	public PrivateCompartment() {
		SecWorker = false;
		CleanWorker = false;
		System.out.println("PrivateCompartment created");
	}

	public void process(SecurityEmployee worker) {
		System.out.println("I SecurityEmployee started working into a privateCompartment");
		SecWorker = true;
	}

	public void process(CleaningEmployee worker) {
		System.out.println("I CleaningEmployee started working into a privateCompartment");
		CleanWorker = true;
	}

	public boolean equal(final PrivateCompartment sec) {
		if(SecWorker == sec.SecWorker && CleanWorker == sec.CleanWorker) {
			return true;
		}
		return false;
	}

	public boolean ready_check() {
		if(SecWorker && CleanWorker) {
			System.out.println("PrivateCompartment OK");
			return true;
		}
		return false;
	}

	public String toString() {
		String temp = super.toString() + "PrivateCompartment, ";
		if(SecWorker) {
			temp = temp + "SecurityEmployee worked here, ";
		}else {
			temp = temp + "Need SecurityEmployee to work here, ";
		}

		if(CleanWorker) {
			temp = temp + "CleaningEmployee worked here. ";
		}else {
			temp = temp + "Need CleaningEmployee to work here, ";
		}

		return temp;
	}

	abstract public PrivateCompartment clone();
}

class EquipmentCompartment extends PrivateCompartment{
	private boolean SecWorker;
	private boolean MaintWorker;

	public EquipmentCompartment() {
		SecWorker= false;
		MaintWorker= false;
		System.out.println("EquipmentCompartment created");
	}

	public final void process(SecurityEmployee worker) {
		super.process(worker);
		SecWorker = true;
	}

	public final void process(MaintenanceEmployee worker) {
		MaintWorker = true;
	}

	public final void process(CleaningEmployee worker) {
		super.process(worker);
	}

	public final boolean equal(EquipmentCompartment sec) {
		if(super.equal(sec)) {
			if(SecWorker = sec.SecWorker && MaintWorker == sec.MaintWorker) {
				return true;
			}
		}
		return false;
	}

	public final EquipmentCompartment clone() {
		EquipmentCompartment temp = new EquipmentCompartment();
		temp.SecWorker = SecWorker;
		temp.MaintWorker = MaintWorker;
		((PrivateCompartment)temp).SecWorker = super.SecWorker;
		((PrivateCompartment)temp).CleanWorker = super.CleanWorker;
		return temp;
	}

	public final boolean ready_check() {
		if(super.ready_check()) {
			if(SecWorker && MaintWorker) {
				System.out.println("EquipmentCompartment OK!");
				System.out.println(toString());
				return true;
			}
		}
		return false;
	}

	public final String toString() {
		String temp = super.toString() + "EquipmentCompartment, ";
		if(SecWorker) {
			temp = temp + "SecurityEmployee worked here, ";
		}else {
			temp = temp + "Need SecurityEmployee to work here, ";
		}

		if(MaintWorker) {
			temp = temp + "MaintenanceEmployee worked here. ";
		}else {
			temp = temp + "Need MaintenanceEmployee to work here. ";
		}

		return temp;
	}
}

class CargoBay extends PrivateCompartment{
	private EquipmentCompartment equipment_space;
	private boolean SecWorker;
	private boolean CleanWorker;
	private boolean MaintWorker;

	public CargoBay() {
		SecWorker = false;
		CleanWorker = false;
		MaintWorker = false;
		equipment_space = new EquipmentCompartment();
		System.out.println("CargoBay Created");
	}

	public final void process(SecurityEmployee worker) {
		super.process(worker);
		System.out.print("Equipment_space of CargoBay: ");
		worker.workOn(equipment_space);
		worker.report(equipment_space);
		SecWorker = true;
	}

	public final void process(MaintenanceEmployee worker) {
		System.out.print("Equipment_space of CargoBay: ");
		worker.workOn(equipment_space);
		worker.report(equipment_space);
		MaintWorker = true;
	}

	public final void process(CleaningEmployee worker) {
		super.process(worker);
		equipment_space.process(worker);
		CleanWorker = true;
	}

	public final boolean equal(CargoBay sec) {
		if(super.equal(sec)) {
			if(SecWorker == sec.SecWorker && CleanWorker == sec.CleanWorker && MaintWorker == sec.MaintWorker) {
				if(equipment_space.equal(sec.equipment_space)) {
					return true;
				}
			}

		}
		return false;
	}

	public final String toString() {
		String temp= super.toString() + "CargoBay, ";
		if(SecWorker) {
			temp = temp + "SecurityEmployee worked here, ";
		}else {
			temp = temp + "Need SecurityEmployee to work here, ";
		}

		if(CleanWorker) {
			temp = temp + "CleaningEmployee worked here, ";
		}else {
			temp = temp + "Need CleaningEmployee to work here, ";
		}

		if(MaintWorker) {
			temp = temp + "MaintenanceEmployee worked here. ";
		}else {
			temp = temp + "Need MaintenanceEmployee to work here. ";
		}

		temp = temp + "\n{CargoBay's Equipment_space, " + equipment_space.toString() + "}";
		return temp;
	}

	public final boolean ready_check() {
		if(super.ready_check()) {
			if(equipment_space.ready_check()) {
				if(SecWorker && CleanWorker && MaintWorker) {
					System.out.println("CargoBay OK!");
					System.out.println(toString());
					return true;
				}
			}
		}
		return false;
	}

	public final CargoBay clone() {
		CargoBay temp = new CargoBay();
		temp.SecWorker = SecWorker;
		temp.CleanWorker = CleanWorker;
		temp.MaintWorker = MaintWorker;
		temp.equipment_space = equipment_space.clone();
		((PrivateCompartment)temp).SecWorker = super.SecWorker;
		((PrivateCompartment)temp).CleanWorker = super.CleanWorker;
		return temp;
	}

}

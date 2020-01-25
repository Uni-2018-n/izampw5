final public class Plane extends Object{
	private String title;
	private int max_pl;
	private int size_PassComp;
	private CargoBay cargo;
	private EquipmentCompartment e1;
	private EquipmentCompartment e2;
	private EquipmentCompartment e3;
	private PassengerCompartment[] pl_PassComp;

	public Plane(final String titl, final int ma_pl){//constructor with every parameter
		max_pl= ma_pl;
		System.out.println("Plane just created!");
		title = titl;
		cargo = new CargoBay();
		System.out.println("CARGOBAY DONE");
		e1 = new EquipmentCompartment();
		System.out.println("E1 DONE");
		e2 = new EquipmentCompartment();
		System.out.println("E2 DONE");
		e3 = new EquipmentCompartment();
		System.out.println("E3 DONE");

		double temp= max_pl/75.0;
		if(temp == (int)temp){
			size_PassComp = (int)temp;
		}else{
			size_PassComp = ((int)temp) + 1;
		}
		pl_PassComp = new PassengerCompartment[size_PassComp];
		for(int i=0;i<size_PassComp;i++){
			pl_PassComp[i] = new PassengerCompartment();
		}

	}

	public Plane(final String titl){//constructor with default value for the max_pl
		max_pl= 40;
		System.out.println("Plane just created!");
		title = titl;
		cargo = new CargoBay();
		System.out.println("CARGOBAY DONE");
		e1 = new EquipmentCompartment();
		System.out.println("E1 DONE");
		e2 = new EquipmentCompartment();
		System.out.println("E2 DONE");
		e3 = new EquipmentCompartment();
		System.out.println("E3 DONE");

		double temp= max_pl/75.0;
		if(temp == (int)temp){
			size_PassComp = (int)temp;
		}else{
			size_PassComp = ((int)temp) + 1;
		}
		pl_PassComp = new PassengerCompartment[size_PassComp];
		for(int i=0;i<size_PassComp;i++){
			pl_PassComp[i] = new PassengerCompartment();
		}

	}

	public Plane(){//constructor for clone(no initialization needed)
		System.out.println("Plane just created");
	}

	public final void process(SecurityEmployee worker){
		if(!cargo.ready_check()){//check if compartment is ready or not,
			worker.workOn(cargo);//if not send the worker to work there
			worker.report(cargo);//and print the report(to see that work is done)
		}
		if(!e1.ready_check()){//continue to to the next work_place
			worker.workOn(e1);
			worker.report(e1);
		}
		if(!e2.ready_check()){
			worker.workOn(e2);
			worker.report(e2);
		}
		if(!e3.ready_check()){
			worker.workOn(e3);
			worker.report(e3);
		}
		for(int i=0;i<size_PassComp;i++){
			if(!pl_PassComp[i].ready_check()){
				worker.workOn(pl_PassComp[i]);
				worker.report(pl_PassComp[i]);
			}
		}
	}

	public final void process(MaintenanceEmployee worker){
		if(!cargo.ready_check()){
			worker.workOn(cargo);
			worker.report(cargo);
		}
		if(!e1.ready_check()){
			worker.workOn(e1);
			worker.report(e1);
		}
		if(!e2.ready_check()){
			worker.workOn(e2);
			worker.report(e2);
		}
		if(!e3.ready_check()){
			worker.workOn(e3);
			worker.report(e3);
		}
	}

	public final void process(CleaningEmployee worker){
		if(!cargo.ready_check()){
			worker.workOn(cargo);
			worker.report(cargo);
		}
		if(!e1.ready_check()){
			worker.workOn((PrivateCompartment)e1);
			worker.report((PrivateCompartment)e1);
		}
		if(!e2.ready_check()){
			worker.workOn((PrivateCompartment)e2);
			worker.report((PrivateCompartment)e2);
		}
		if(!e3.ready_check()){
			worker.workOn((PrivateCompartment)e3);
			worker.report((PrivateCompartment)e3);
		}
		for(int i=0;i<size_PassComp;i++){
			if(!pl_PassComp[i].ready_check()){
				worker.workOn(pl_PassComp[i]);
				worker.report(pl_PassComp[i]);
			}
		}
	}

	public final boolean equal(final Plane sec){
		if(title == sec.title && max_pl == sec.max_pl){//check the variables if they are equal
			if(cargo.equal(sec.cargo)){//and then call the equal method for the other parts of the Plane
				if(e1.equal(sec.e1) && e2.equal(sec.e2) && e3.equal(sec.e3)){
					for(int i=0;i<size_PassComp;i++){
						if(!pl_PassComp[i].equal(sec.pl_PassComp[i])){
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}

	public final boolean ready_check(){
		if(!cargo.ready_check()){//ready_check for the "has a" work_spaces of the plane
			return false;
		}
		if(!e1.ready_check()){
			return false;
		}
		if(!e2.ready_check()){
			return false;
		}
		if(!e3.ready_check()){
			return false;
		}
		for(int i=0;i<size_PassComp;i++){
			if(!pl_PassComp[i].ready_check()){
				return false;
			}
		}
		return true;//and return true if plane and its compartments are ready
	}

	public final String toString(){//combine the desription of the plane and its compartments
		String temp = "Plane, title= " + title + ", max_pl= " + Integer.toString(max_pl) + ", " +
		"Parts: \n" +
		cargo.toString() + "\n" + e1.toString() + "\n" + e2.toString() + "\n" + e3.toString();
		for(int i=0;i<size_PassComp;i++){
			temp = temp + ("\n" + pl_PassComp[i].toString());
		}
		return temp;//and return it
	}

	public final Plane clone(){
		Plane temp = new Plane();
		temp.title = title;//clone variables
		temp.max_pl = max_pl;
		temp.size_PassComp = size_PassComp;
		temp.cargo = cargo.clone();//then call the clone method for the compartments of the Plane
		temp.e1= e1.clone();
		temp.e2 = e2.clone();
		temp.e3 = e3.clone();
		temp.pl_PassComp = new PassengerCompartment[temp.size_PassComp];
		for(int i=0;i<temp.size_PassComp;i++){
			temp.pl_PassComp[i] = pl_PassComp[i].clone();
		}
		return temp;//and return it
	}
}

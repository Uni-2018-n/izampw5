package izampw4;

abstract public class PlaneComponent {
	public PlaneComponent() {
		System.out.println("PlaneComponent created");
	}
	
	abstract public  void process();
//	abstract public  void process();
//	abstract public  void process();
	
	public boolean equal(final PlaneComponent sec) {
		return false;
	}
	
	public String toString() {
		return "";
	}
	
	abstract public PlaneComponent clone();
	abstract public boolean ready_check();
}




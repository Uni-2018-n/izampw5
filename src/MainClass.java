public class MainClass {
	public static void main(String[] args) {
		Plane my_plane= new Plane("Zephyr One", 200);
		System.out.println("PLANE CONSTRUCTOR DONE\n");

		SecurityEmployee SecEmpl= new SecurityEmployee("Bill");
		System.out.println(SecEmpl.toString());

		MaintenanceEmployee MaintEmpl= new MaintenanceEmployee("Bob");
		System.out.println(MaintEmpl.toString());

		CleaningEmployee CleanEmpl= new CleaningEmployee("Mike");
		System.out.println(CleanEmpl.toString());

		System.out.println("EMPLOYEE DONE\n");

		my_plane.process(SecEmpl);
		my_plane.process(MaintEmpl);
		my_plane.process(CleanEmpl);

		System.out.println("PROCESS DONE\n");

		if(my_plane.ready_check()) {
			System.out.println("\n PLANE TOSTRING: ");
			System.out.println(my_plane.toString());
			System.out.println("Plane ready to take off!!");
		}else {
			System.out.println("Plane not ready ERROR ERROR COLLISION COLLISION");
		}

		System.out.println("<CLONE>");
		Plane test_plane = my_plane.clone();

		System.out.println("test_plane::toString: ");
		System.out.println(test_plane.toString());
		if(test_plane.equal(my_plane)) {
			System.out.println("PLANES ARE EQUAL");
		}else {
			System.out.println("PLANES AINT EQUAL");
		}
		System.out.println("</CLONE>");

		System.out.println("Program Ended!");
	}
}

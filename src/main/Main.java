package main;
import controller.Controller;
import vue.IHM;


public class Main {
	
	public static void main(String[] args) {
		 IHM main_vue = new IHM();
		 main_vue.setController(new Controller(main_vue));
	}

}

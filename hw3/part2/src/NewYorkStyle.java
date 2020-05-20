public class NewYorkStyle extends Pizza{

	private String size;
	private String crustThickness;

	public void makeCrust() {
		System.out.println("Making crust of the pizza");
	}

	public void addToppings() {
		System.out.println("Adding toppings to the pizza");
	}

	public void preHeatOven() {
		System.out.println("Preheat the oven before placing the pizza");
	}

	public void cook() {
		System.out.println("Cooking the pizza for required time");
	}
}
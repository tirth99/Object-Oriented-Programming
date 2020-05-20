public abstract class Pizza{

	protected abstract void makeCrust();
	protected abstract void cook();
	protected abstract void preHeatOven();
	protected abstract void addToppings();

	// Template method with abstract methods.

	public void makeFromScratch(){
		makeCrust();
		addToppings();
		preHeatOven();
		cook();
	}
}
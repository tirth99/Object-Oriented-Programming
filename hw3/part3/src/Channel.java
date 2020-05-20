public enum Channel{

	CH1("CBS" , 1),
	CH2("ESPN" , 2),
	CH3("Adult Swim" , 3),
	CH4("Disney" , 4),
	CH5("Discovery" , 5);

	private String chName;
	private int chNumber;

	Channel(String name, int num){
		this.chName = name;
		this.chNumber = num;
	}

	public String getChName() {
		return chName;
	}

	public int getChNumber() {
		return chNumber;
	}
}
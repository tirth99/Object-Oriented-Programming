import java.util.Scanner;

public class Television{

	public static void changeChannel(Channel ch){

		switch(ch){

			case CH1:
				System.out.println("You are on channel " + ch.getChNumber() + ", watching " + ch.getChName() + ".");
				break;

			case CH2:
				System.out.println("You are on channel " + ch.getChNumber() + ", watching " + ch.getChName() + ".");
				break;

			case CH3:
				System.out.println("You are on channel " + ch.getChNumber() + ", watching " + ch.getChName() + ".");
				break;

			case CH4:
				System.out.println("You are on channel " + ch.getChNumber() + ", watching " + ch.getChName() + ".");
				break;

			case CH5:
				System.out.println("You are on channel " + ch.getChNumber() + ", watching " + ch.getChName() + ".");
				break;

			default:
				System.out.println("Channel not found.");
		}
	}

	public static void main(String[] args){
		Channel[] channels = Channel.values();
		for (Channel ch: channels) {
			changeChannel(ch);
		}
	}
}
package bean.user;
public class Dice1 {
	private int num;
	public int getNum() {
		num = (int)(Math.random() * 6.0) + 1;
		return num;
	}
}

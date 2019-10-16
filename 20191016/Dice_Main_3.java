package bean.user;

public class Dice_Main_3 {

	public static void main(String[] args) {
		Dice3 dice3 = new Dice3();
		dice3.setStartNum(Integer.parseInt(args[0]));
		dice3.setEndNum(Integer.parseInt(args[1]));
		System.out.println(Integer.parseInt(args[0])+"&"+Integer.parseInt(args[1])+"values");
		System.out.println("= "+dice3.getNum());
	}
}
class Dice3 {
	private int num, startNum, endNum;
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getEndNum() { return endNum; }
	public int getNum() {
		num = (int)(Math.random()*(endNum-startNum)) + startNum;
		return num;
	}
}

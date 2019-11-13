package bean.user;
public class Lotto2 {
	private String num;
	public void setNum(String num) {
		this.num = num;
	}
	public String getNum() {
		int[] arr = new int[6];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*45)+1;
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0;i<arr.length;i++){
			num+=arr[i]+" ";
		}
		return num;
	}
}

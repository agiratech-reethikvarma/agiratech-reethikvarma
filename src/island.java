
public class island {
	island i;

	public static void main(String[] args) {
		island i2 = new island();
		island i3 = new island();
		island i4 = new island();
		i2.i = i3;
		i3.i = i4;
		i4.i = i2;

//		System.gc();
		i2 = null;
		i3 = null;
		i4 = null;
		System.out.println(i2);

	}

}

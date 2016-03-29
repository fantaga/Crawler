package cn.fan.node;

public class TestReplace {
	public static void main(String[] args) {
		String str = "fdjfjafj\\dilfj//d/f/fg/g/h/h.html";
		
		String regex = "[&%#\\.-=+!/\\\\]";
		String s = str.replaceAll(regex, "_");
		System.out.println(s);
	}
}

package schoolProjects;

public class LineTest {

	public static void main(String[] args) {
		Line x = new Line(new Point(1,4), new Point(2,8));
		Line y = new Line(new Rational(-1),new Rational(4));

		System.out.println(x);
		
		System.out.println();
		
		System.out.println(y);
		System.out.println(x.isConsistent(y));
		System.out.println(x.intersection(y));
		System.out.println(x.isPerpendicular(y));
		
		
	}

}

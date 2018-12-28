package schoolProjects;


public class Line {
	private Rational b;
	private boolean isHorizontal;
	private boolean isVertical;
	private Rational m;
	private Rational xIntercept;

	// default constructor
	public Line() {
		b = new Rational(0,0);
		isHorizontal = false;
		m = new Rational(1,1);
		isVertical = false;
		xIntercept = new Rational(0,0);
	}

	// overloaded constructor
	public Line(double m_, double b_) {
		if(m_ == 0) {
			m = new Rational(0,0);
			isHorizontal = true;
			b = new Rational(b_);
			isVertical = false;
		}
		else {
		b = new Rational(b_);
		isHorizontal = false;
		isVertical = false;
		m = new Rational(m_);
		xIntercept = new Rational((-1 * b.decimalValue()) , m.decimalValue());
		}
	}
	

	public Line(int a, int b_, int c) {
		if(b_ == 0) {
			isVertical = true;
			isHorizontal = false;
			xIntercept = new Rational(c , (double)a); 
		}
		else if(a == 0) {
			isHorizontal = true;
			isVertical = false;
			b = new Rational(c , (double)b_);
			m = new Rational(0);
		}
		else {
			b = new Rational(c, (double)b_);
			m = new Rational((-1.0 * a) , b_);
				isHorizontal = false;
				isVertical = false;
				xIntercept = new Rational(c,(double)a);
		}
	}
	

	public Line(Point p, double m_) {
		if(m_ == 0) {
			isHorizontal = true;
			isVertical = false;
			m = new Rational(0);
			b = new Rational(p.getY());
		}
		else {
		b = new Rational(p.getY() - (m.decimalValue() * p.getX()));
		isHorizontal = false;
		isVertical = false;
		m = new Rational(m_);
		xIntercept = new Rational((-1 * b.decimalValue()), m.decimalValue());
		}
	}

	public Line(Point p, Point q) {
		double n = q.getY() - p.getY();
		double d = q.getX() - p.getX();
		if(d == 0) {
			isVertical = true;
			isHorizontal = false;
			xIntercept = new Rational(p.getX()); 
		}
		else if(n == 0) {
			isHorizontal = true;
			isVertical = false;
			b = new Rational(p.getY());
			m = new Rational(0,0);
		}
		else {
			m = new Rational(n,d);
			b = new Rational((p.getY()*m.getQ())-(m.getP()*p.getX()), m.getQ());
			xIntercept = new Rational((-1 * b.decimalValue()) , m.decimalValue());
			isHorizontal = false;
			isVertical = false;
			} 
		}
	

	// methods
	public boolean equals(Line l) {
		// checks if two line have same slope and y intercept
		if(this.isHorizontal() && l.isHorizontal()) {
			return Math.abs(this.getYIntercept().decimalValue() - l.getYIntercept().decimalValue()) < 0.01;
		} 
		else if(this.isVertical() && l.isVertical()) {
			return Math.abs(this.getXIntercept().decimalValue() - l.getXIntercept().decimalValue()) < 0.01;
		} 
		else if(this.isVertical() && l.isHorizontal() || this.isHorizontal() && l.isVertical()) {
			return false;
		}
		else if(this.isVertical() || l.isVertical()) {
			return false;
		}
		else if(this.isHorizontal() || l.isHorizontal()) {
			return false;
		}
		else {
			return Math.abs(this.getSlope().decimalValue() - l.getSlope().decimalValue()) < .01
					&& Math.abs(this.getYIntercept().decimalValue() - l.getYIntercept().decimalValue()) < .01;
		}
	}



	public double evaluate(double x) {
		return m.decimalValue() * x + b.decimalValue();
	}

	// getters
	public Rational getSlope() {
		return m;
	}

	public Rational getXIntercept() {
		return xIntercept;
	}

	public Rational getYIntercept() {
		return b;
	}

	// methods
	public Point intersection(Line l) {
		double x = 0, y = 0;
		if(this.isHorizontal() && l.isVertical()) {
			x = l.getXIntercept().decimalValue();
			y = this.getYIntercept().decimalValue();
			return new Point(x, y);
		}
		else if(this.isVertical() && l.isHorizontal()) {
			x = this.getXIntercept().decimalValue();
			y = l.getYIntercept().decimalValue();
			return new Point(x, y);
		}
		else if(this.isVertical()) {
			x = this.getXIntercept().decimalValue();
			y = l.evaluate(x);
			return new Point(x, y);
		}
		else if(l.isVertical()) {
			x = l.getXIntercept().decimalValue();
			y = this.evaluate(x);
			return new Point(x, y);
		}
		else {
		 x = (l.getYIntercept().decimalValue() - this.getYIntercept().decimalValue()) / (this.getSlope().decimalValue() - l.getSlope().decimalValue());
		 y = this.evaluate(x);
		return new Point(x, y);
		}
	}

	public boolean isConsistent(Line l) {
		return !this.isParallel(l);
	}

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public boolean isParallel(Line l) {
		// checks if two line have the same slope
		if(this.isHorizontal() && l.isHorizontal()) {
			return !this.equals(l);
		} 
		else if(this.isVertical() && l.isVertical()) {
			return !this.equals(l);
		} 
		else if((this.isHorizontal() && l.isVertical()) || (this.isVertical() && l.isHorizontal())) {
			return false;
		} 
		else if(this.isVertical() || l.isVertical()) {
			return false;
		}
		else if(this.isHorizontal() || l.isHorizontal()) {
			return false;
		}
		else {
			return Math.abs(this.getSlope().decimalValue() - l.getSlope().decimalValue()) < 0.01 && !this.equals(l);
		}
	}

	public boolean isPerpendicular(Line l) {
		return (Math.abs(this.getSlope().decimalValue() - (-1 / l.getSlope().decimalValue())) < .01);
	}

	public boolean isVertical() {
		return isVertical;
	}

	public String toString() {
		if(this.isVertical()) {
			return "x" + " = " + this.getXIntercept().decimalValue();
		}
		else if(this.isHorizontal()) {
			return "y" + " = " + this.getYIntercept().decimalValue();
		} 
		else {
		return "y=" + this.getSlope() + "x" + " + " + this.getYIntercept();
		}
	}
}




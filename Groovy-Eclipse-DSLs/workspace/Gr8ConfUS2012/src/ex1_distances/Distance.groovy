/**
 * Thanks, Joe!  
 * Borrowed from: http://joesgroovyblog.blogspot.com/2007/09/and-miles-to-go-before-i-sleep.html
 */
package ex1_distances

class Distance implements Comparable {
	BigDecimal length
	Unit unit

	Distance plus(Distance operand) {
		def newLength = this.length + Unit.convertUnit(operand, this.unit)
		new Distance(length : newLength, unit : this.unit)
	}
	Distance minus(Distance operand) {
		def newLength = this.length - Unit.convertUnit(operand, this.unit)
		new Distance(length : newLength, unit : this.unit)
	}
	int compareTo(other) {
		if(this.unit == other.unit)
			return this.length <=> other.length
		return this.length <=> Unit.convertUnit(other, this.unit)
	}
	String toString() {
		"$length $unit.name"
	}
}


class Unit {
	def ratio
	String name
	
	static def convertUnit(Distance d, Unit newUnit) {
		def factor = ratioTable[d.unit.ratio][newUnit.ratio]
		if (factor) {
			return d.length * factor
		} else {
			return d.length / ratioTable[newUnit.ratio][d.unit.ratio]
		}
	}
	
	static ratioTable = [
	//        mm,         cm,          m,        km,    y,   mi
	[          1,          0,          0,         0,    0, 0 ],    // mm
	[         10,          1,          0,         0,    0, 0 ],    // cm
	[        1e3,        1e2,          1,         0,    0, 0 ],    //  m
	[        1e6,        1e5,        1e3,         1,    0, 0 ],    // km
	[      914.4,      91.44,     0.9144, 0.9144e-3,    1, 0 ],    // yd
	[ 1.609344e6, 1.609344e5, 1.609344e3,  1.609344, 1760, 1 ],    // mi
	]
	
	public static final mm = new Unit(ratio : 0, name : "millimeter")
	public static final cm = new Unit(ratio : 1, name : "centimeter")
	public static final  m = new Unit(ratio : 2, name : "meter")
	public static final km = new Unit(ratio : 3, name : "kilometer")
	public static final yd = new Unit(ratio : 4, name : "yard")
	public static final mi = new Unit(ratio : 5, name : "mile(s)")
}

/**
 * A category class that provides extra methods to {@link Number}s 
 * to convert between {@link Distance} types.
 */
class DistanceCategory {
	static Distance getMm(Number n) { new Distance(length : n, unit : Unit.mm) }
	static Distance getMm(Distance d) {
		new Distance(length : Unit.convertUnit(d, Unit.mm), unit : Unit.mm)
	}
	
	static Distance getCm(Number n) { new Distance(length : n, unit : Unit.cm) }
	static Distance getCm(Distance d) {
		new Distance(length : Unit.convertUnit(d, Unit.cm), unit : Unit.cm)
	}
	
	static Distance getM(Number n) { new Distance(length : n, unit : Unit.m) }
	static Distance getM(Distance d) {
		new Distance(length : Unit.convertUnit(d, Unit.m), unit : Unit.m)
	}

	static Distance getKm(Number n) { new Distance(length : n, unit : Unit.km) }
	static Distance getKm(Distance d) {
		new Distance(length : Unit.convertUnit(d, Unit.km), unit : Unit.km)
	}
	
	static Distance getYd(Number n) { new Distance(length : n, unit : Unit.yd) }
	static Distance getYd(Distance d) {
		new Distance(length : Unit.convertUnit(d, Unit.yd), unit : Unit.yd)
	}

	static Distance getMi(Number n) { new Distance(length : n, unit : Unit.mi) }
	static Distance getMi(Distance d) {
		new Distance(length : Unit.convertUnit(d, Unit.mi), unit : Unit.mi)
	}
}
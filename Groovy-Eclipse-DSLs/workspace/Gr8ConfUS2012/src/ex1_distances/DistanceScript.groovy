package ex1_distances

use(DistanceCategory) {
	doDistance()	
}

def doDistance() {
	def d1 = 1.m 
	def d2 = 1.yd
	def d3 = 1760.yd
	def d4 = 100.cm
	println d1 + 1.yd 
	println 1.yd + 1.mi
	println 1.m - 1.yd
	println d2.m
	println d3.mi
	println d4.m
	println 1000.01.yd.km
	println 0xFF.km
}

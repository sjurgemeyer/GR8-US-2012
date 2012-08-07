import se.findout.gr8conf.rs.Album

class BootStrap {

    def init = { servletContext ->

		new Album(
				artist: "David Bowie",
				title: "The Rise and Fall of Ziggy Stardust and the Spiders from Mars",
				itemsInStock: 2,
				price: 8.2
		).save()
		new Album(
				artist: "David Bowie",
				title: "Alladin Sane",
				itemsInStock: 0,
				price: 9
		).save()
		new Album(
				artist: "The Clash",
				title: "London Calling",
				itemsInStock: 1,
				price: 8.5
		).save()
		new Album(
				artist: "The Stone Roses",
				title: "The Stone Roses",
				itemsInStock: 0,
				price: 9
		).save()

    }
    def destroy = {
    }
}

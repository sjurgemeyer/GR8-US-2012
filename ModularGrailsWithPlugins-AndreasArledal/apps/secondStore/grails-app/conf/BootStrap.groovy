import se.findout.gr8conf.rs.Album

class BootStrap {

    def init = { servletContext ->

		new Album(
				artist: "The Jam",
				title: "All mod cons",
				itemsInStock: 1,
				price: 8.2
		).save()
		new Album(
				artist: "The Specials",
				title: "The Specials",
				itemsInStock: 0,
				price: 9
		).save()

    }
    def destroy = {
    }
}

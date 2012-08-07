package se.findout.gr8conf.rs

class ManagerController {

    def index() {

		def albums = Album.list()

		[
				albumsInStock: albums.inject(0) { sum, album -> sum + album.itemsInStock },
				totalStockValue: albums.inject(0) { sum, album -> sum + album.itemsInStock * album.price}
		]

	}
}

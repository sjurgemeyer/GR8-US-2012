package se.findout.gr8conf

import se.findout.gr8conf.rs.Album

abstract class AlbumController {

	static defaultAction = "list"

	def list() {
		[albums: Album.list().sort()]
	}

	def search(String searchString) {
		render view: 'list', model: [albums: Album.findAllByArtistIlikeOrTitleIlike("%${searchString}%", "%${searchString}%")]
	}

}

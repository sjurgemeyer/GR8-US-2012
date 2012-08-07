package se.findout.gr8conf.rs

import se.findout.gr8conf.rs.Album
import se.findout.gr8conf.AlbumController

class AssistantAlbumController extends AlbumController {

	def edit(Long id) {
		Album album = Album.get(id)
		if (album) {
			render view: 'edit', model: [album: album]
		} else {
			flash.message = "Album not found!"
			redirect action: 'list'
		}
	}

	def update(Long id) {
		Album album = Album.get(id)
		processAlbum("Album successfully updated!", "Album couldn't be updated!", 'edit', album)
	}

	def create() {
		[album: new Album()]
	}

	def save() {
		processAlbum("Album successfully created!", "Album couldn't be created!", 'create')
	}

	def delete(Long id) {
		Album album = Album.get(id)
		album.delete()
		flash.message = "Album deleted"
		redirect action: 'list'
	}

	private def processAlbum(String successMessage, String errorMessage, String errorView, Album album = new Album()) {
		if (!album) album = new Album()
		album.properties = params
		if (album.save()) {
			flash.message = successMessage
			redirect action: 'list'
		} else {
			flash.message = errorMessage
			render view: view, model: [album: album]
		}
	}
}

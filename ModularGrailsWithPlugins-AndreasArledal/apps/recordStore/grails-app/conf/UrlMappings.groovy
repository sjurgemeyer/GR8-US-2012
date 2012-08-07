class UrlMappings {

	static mappings = {

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/customer/album/$action?/$id?" (controller: 'customerAlbum') {}
		"/assistant/album/$action?/$id?" (controller: 'assistantAlbum') {}

		"/"(view:"/index")
		"500"(view:'/error')

	}
}

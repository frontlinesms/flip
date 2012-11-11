modules = {
	application {
		resource url:'js/application.js'
	}
	flip {
		dependsOn "jquery"
		resource url:[dir:'js', file:"jquery.hotkeys.js"], disposition: "head"
	}
}


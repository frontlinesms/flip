modules = {
	application {
		resource url:'js/application.js'
	}
	flip {
		dependsOn "jquery"
		resource url:[dir:'js', file:"jquery.hotkeys.js"], disposition: "head"
		resource url:[dir: 'js', file: 'jquery.flippy.min.js'], disposition:'head'
		resource url:[dir: 'js', file: 'script.js'], disposition:'head'
		resource url:[dir: 'js', file: 'jquery.jqplot.min.js'], disposition:'head'
		resource url:[dir: 'js', file: 'jqplot.pieRenderer.min.js'], disposition:'head'
		resource url:[dir: 'js', file: 'jqplot.donutRenderer.min.js'], disposition:'head'
	}
}


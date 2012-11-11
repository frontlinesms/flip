package flip

class FlipTagLib {
	static namespace = 'flip'

	def dataTable = { attrs ->
println "Rendering data table for attrs $attrs"
		def name = attrs.id
		def data = attrs.data
		out << "<div id='$name-games'>"
		out << "	<h2>${g.message(code:"stats.games."+name+".title")}</h2>"
		out << "	<table>"
		out << "		<thead>"
		out << "			<tr>"
		data.keys.each { out << "<td>" + g.message(code:"stats.game.column.$it") + "</td>" }
		out << "			</tr>"
		out << "		</thead>"
		out << "		<tbody>"
		data.values.each { row ->
			out << "<tr>"
			row.each {
				out << "<td>"
				if(it instanceof Date) out << prettytime.display([date:it])
				else if(it instanceof Map) {
					boolean first = true
					it.each { label, link ->
						if(first) first = false
						else out << ' | '
						def params = link.size()>2? link[2]: []
println "Controller params for link generation: ${[controller:link[0], id:link[1], params:params]}"
						out << g.link([controller:link[0], id:link[1], params:params]) {
							g.message(code:"stats.game.action.$label")
						}
					}
				}
				else if(it == null) out << ''
				else out << it.toString()
				out << "</td>"
			}
			out << "</tr>"
		}
		out << "		</tbody>"
		out << "	</table>"
		out << "</div>"
	}
}


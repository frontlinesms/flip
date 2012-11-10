import org.compass.core.engine.SearchEngineQueryParseException

class SearchableController {
    def searchableService

    def index = {
        def dataModel
        if (!params.q?.trim()) {
            return [:]
        }
        try {
            return [searchResult: searchableService.search(params.q, params), searchString:'qweqwe']
        } catch (SearchEngineQueryParseException ex) {
            return [parseException: true]
        }
    }
}
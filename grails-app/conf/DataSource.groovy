hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
	development {
		dataSource {
			pooled = true
			driverClassName = "org.h2.Driver"
			username = "sa"
			password = ""
			dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
			url = "jdbc:h2:mem:devDb;MVCC=TRUE"
		}
	}
	test {
		dataSource {
			pooled = true
			driverClassName = "org.h2.Driver"
			username = "sa"
			password = ""
			dbCreate = "update"
			url = "jdbc:h2:mem:testDb;MVCC=TRUE"
		}
	}
	production {
		def vcapServices = System.env.VCAP_SERVICES
		def credentials = vcapServices? grails.converters.JSON.parse(vcapServices)["mysql-5.1"][0]["credentials"]: null
		dataSource {
			dbCreate = "update"
			url =  credentials? "jdbc:mysql://${credentials.hostname}:${credentials.port}/${credentials.name}?useUnicode=yes&characterEncoding=UTF-8" :""
			dialect = org.hibernate.dialect.MySQL5InnoDBDialect
			driverClassName = "com.mysql.jdbc.Driver"
			username = credentials? credentials.username: ""
			password = credentails? credentials.password: ""
			pooled = true
			properties {
				maxActive = -1
				minEvictableIdleTimeMillis=1800000
				timeBetweenEvictionRunsMillis=1800000
				numTestsPerEvictionRun=3
				testOnBorrow=true
				testWhileIdle=true
				testOnReturn=true
				validationQuery="SELECT 1"
			}
		}
	}
}


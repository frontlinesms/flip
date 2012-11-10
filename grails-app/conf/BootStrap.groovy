import flip.*

class BootStrap {
	def init = { servletContext ->
		createCyrillicAlphabet()
		createAmharicAbugida()
		createDemoGameAndSesh()
	}
	def destroy = {
	}

	def createAmharicAbugida() {
		def latinVowels = 'äuiaeəo'
		def cards = []
		def a = ['h':'ሀሁሂሃሄህሆ',
				'l':'ለሉሊላሌልሎ',
				'h':'ሐሑሒሓሔሕሖ',
				'm':'መሙሚማሜምሞ',
				's':'ሠሡሢሣሤሥሦ',
				'r':'ረሩሪራሬርሮ',
				's':'ሰሱሲሳሴስሶ',
				'š':'ሸሹሺሻሼሽሾ',
				'q':'ቀቁቂቃቄቅቆ',
				'b':'በቡቢባቤብቦ',
				't':'ተቱቲታቴትቶ',
				'č':'ቸቹቺቻቼችቾ',
				'h':'ኀኁኂኃኄኅኆ',
				'n':'ነኑኒናኔንኖ',
				'ñ':'ኘኙኚኛኜኝኞ',
				"ʾ":'አኡኢኣኤእኦ',
				'k':'ከኩኪካኬክኮ',
				'h':'ኸኹኺኻኼኽኾ',
				'w':'ወዉዊዋዌውዎ',
				"ʾ":'ዐዑዒዓዔዕዖ',
				'z':'ዘዙዚዛዜዝዞ',
				'ž':'ዠዡዢዣዤዥዦ',
				'y':'የዩዪያዬይዮ',
				'd':'ደዱዲዳዴድዶ',
				'ǧ':'ጀጁጂጃጄጅጆ',
				'g':'ገጉጊጋጌግጎ',
				"t'":'ጠጡጢጣጤጥጦ',
				"č'":'ጨጩጪጫጬጭጮ',
				"p'":'ጰጱጲጳጴጵጶ',
				"s'":'ጸጹጺጻጼጽጾ',
				"s'":'ፀፁፂፃፄፅፆ',
				'f':'ፈፉፊፋፌፍፎ',
				'p':'ፐፑፒፓፔፕፖ',
				'"v"':'ቨቩቪቫቬቭቮ'].each { k, v ->
			(1..<latinVowels.size()).each { i ->
				cards << new Card(a:v[i], b:k+latinVowels[i], tags:['amharic', 'amharic->latin']).save(flush:true, failOnError:true)
			}
		}

		def deck = new Deck(name:'Amharic Alphabet')
		cards.each { deck.addToCards(it) }
		deck.save(flush:true, failOnError:true)
	}

	def createCyrillicAlphabet() {
		def cards = []
		[Аа:'f_a_ther',
				Бб:'_b_it',
				Вв:'_v_ine',
				Гг:'_g_o',
				Дд:'_d_o',
				Ее:'_ye_t',
				Ёё:'_yo_lk',
				Жж:'plea_s_ure',
				Зз:'_z_oo',
				Ии:'m_e_',
				Йй:'_y_es',
				Кк:'_k_itten',
				Лл:'_l_amp',
				Мм:'_m_ap',
				Нн:'_n_ot',
				Оо:'m_o_re',
				Пп:'_p_et',
				Рр:'rolled r',
				Сс:'_s_ee',
				Тт:'_t_ool',
				Уу:'b_oo_t',
				Фф:'_f_ace',
				Хх:'U_gh_ (voiceless)',
				Цц:'si_ts_',
				Чч:'_ch_ip',
				Шш:'_sh_ut (voiceless)',
				Щщ:'_sh_eer',
				Ъъ:'silent, prevents palatalization',
				Ыы:'ros_e_s or s_i_lly',
				Ьь:'silent, slightly palatalises',
				Ээ:'m_e_t',
				Юю:'_u_se',
				Яя:'_ya_rd'].each { k, v ->
			cards << new Card(a:k[0], b:v, tags:['cyrillic (capital)->latin', 'cyrillic']).save(failOnError:true)
			cards << new Card(a:k[1], b:v, tags:['cyrillic (lower-case)->latin', 'cyrillic']).save(failOnError:true)
		}

		def deck = new Deck(name:'Cyrillic Alphabet').save(flush:true, failOnError:true)
		deck.addTag('language')
		cards.each { deck.addToCards(it) }
		deck.save(flush:true, failOnError:true)

		def d1 = new Deck(name:'Anatomy of Paper').save(failOnError:true, flush:true)
		d1.addTag('medicine').save(failOnError:true, flush:true)
		def d2 = new Deck(name:'Groovy Syntax').save(failOnError:true, flush:true)
		d2.addTag('coding').save(failOnError:true, flush:true)
	}

	def createDemoGameAndSesh() {
		def game = new Game(deck: Deck.findByName('Cyrillic Alphabet')).save(flush: true, failOnError: true)
		def sesh = new Sesh(game: game, complete: false, cards: game.deck.cards).save(flush: true, failOnError: true)
	}
}

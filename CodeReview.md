# CodeReviw

####  1. StockService에서 api 호출 과정에서 cors현상 발생

```
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service("stockService")
```
<br>


#### 2. PathVariable : 쿼리스트링만 사용하는 경우 리퀘스트 2번 오는 현상

- 문제 코드 - 리퀘스트 중복되는 현상 (StockController Class)

```
@Description("회사 symbol로 6개월 간의 기록 호출")
	@GetMapping(path="{name}")
	public Answer getStock(@PathVariable(required = true) String name) {
		Answer answer = this.stockService.stockService(name);
		return answer;
	}

	@Description("회사이름 기준으로 검색리스트 추가")
	@GetMapping(path="{input}")
	public List<StocksName> searchName(@PathVariable(required = true) String input) {
		List<StocksName> nameList = this.stockService.searchName(input);
		return nameList;
	}
```

- 수정 코드

```
@Description("회사 symbol로 6개월 간의 기록 호출")
	@GetMapping(path="stock/{name}")
	public Answer getStock(@PathVariable(required = true) String name) {
		Answer answer = this.stockService.stockService(name);
		return answer;
	}

	@Description("회사이름 기준으로 검색리스트 추가")
	@GetMapping(path="stock/search/{input}")
	public List<StocksName> searchName(@PathVariable(required = true) String input) {
		List<StocksName> nameList = this.stockService.searchName(input);
		return nameList;
	}
```
<br>

#### 3. 회사 이름 api 호출 시 api 할당량 초과

- 별도의 JSON 파일 삽입, init 시에 JSON 파싱 (initConfiguration Class)

```
@Description("회사이름 json 파일 얻어오기")
@Configuration
public class InitConfiguration {
    @Value("${stocks.name.list.file}")
    private String stocksNameListFileName;

    @Bean
    public StocksNameList getStocksNameList() {
        ClassPathResource resource = new ClassPathResource(stocksNameListFileName);
        List<StocksName> nameList;
        try {
            Path path = Paths.get(resource.getURI());
            String jsonString = Files.readAllLines(path).get(0);
            ObjectMapper objectMapper = new ObjectMapper();
            nameList = objectMapper.readValue(jsonString, new TypeReference<List<StocksName>>() {});
        } catch (IOException e) {
            nameList = new ArrayList<>();
        }
        StocksNameList stocksNameList = new StocksNameList();
        stocksNameList.setStocksNameList(nameList);
        return stocksNameList;
    }
}
```
<br>

#### 4. 회사 이름 전체 response 시 서버 딜레이 현상

- 텍스트 변화 감지 시 해당 검색어에 맞는 회사 검색 ( jqury, StockService.searchName)

- Jqury
```
 $('#input').on('keyup', function () {
            var stockName = [];
            var input = $('#input').val();
            if(input != undefined && input != null && input != '') {
                $.getJSON('http://localhost:8080/stock/search/' + input, function (data) {
                    $('.dropdown-menu').empty();
                    $.each(data, function (i, item) {
                        $('.dropdown-menu').append("<li id=" + item.symbol + ">" + item.name + " (" + item.symbol + ")" + "</li>");
                    });
                });
            } else {
                $('.dropdown-menu').empty();
            }
        });
```
- StockService.searchName
```
@Description("회사이름 통한 검색어 추가")
	@Override
	public List<StocksName> searchName(String input) {
		List<StocksName> nameList = new ArrayList<>();
		for(StocksName stocksName : stocksNameList.getStocksNameList()) {
			if(stocksName.contains(input)) {
				nameList.add(stocksName);
			}
		}
		return nameList;
	}
```
<br>

#### 5. 알고리즘 Code : util.package - GetAlgorithm

```
public class GetAlgorithm {

	@Description("알고리즘 시간복잡도 : O(N)")
	public Answer getAlgorithm(List<StocksInfomation> list) {
		int HighIdx = 0;
		int LowIdx = 0;
		int ansLowIdx = 0;
		int ansHighIdx = 0;
		double MaxGain = 0;
		double MaxHigh = 0;
		double MaxLow = Double.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			StocksInfomation si = list.get(i);
			if(MaxLow > si.getLow()) {
				MaxLow = si.getLow();
				LowIdx = i;
			}
			if(MaxHigh < si.getHigh()) {
				MaxHigh = si.getHigh();
				HighIdx = i;
			}
			if(LowIdx <= HighIdx) {
				MaxGain = Math.max(MaxGain, MaxHigh - MaxLow);
				ansLowIdx = LowIdx;
				ansHighIdx = HighIdx;
			}
		}
		int percent = (int) (((list.get(ansHighIdx).getHigh() * 100)/list.get(ansLowIdx).getLow())-100);
		Answer answer = new Answer(list.get(ansLowIdx).getDate(),list.get(ansHighIdx).getDate(),
				list.get(ansLowIdx).getLow(), list.get(ansHighIdx).getHigh(), percent,list);
		
		return answer;
	}
}
```

<br>

#### 6. API 호출 뒤 파싱 : util.package - GetAPI

``` 
@Description("회사 6개월 간 기록 api")
    public List<StocksInfomation> getPriceAPI(String site) {
        List<StocksInfomation> list = new ArrayList<StocksInfomation>();

        try {

            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setConnectTimeout(5000); //타임아웃 설정 5초
            factory.setReadTimeout(5000);//타임아웃 설정 5초
            RestTemplate restTemplate = new RestTemplate(factory);

            ResponseEntity<String> result = restTemplate.getForEntity(site, String.class);
            ObjectMapper objectMapper = new ObjectMapper();

            list = objectMapper.readValue(result.getBody(), new TypeReference<List<StocksInfomation>>() {});
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println(e.toString());

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return list;
    }
```


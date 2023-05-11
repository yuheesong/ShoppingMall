# 제목  
### 설명  

## 1. 기간  

## 2. 사용 기술  
- Java 11  
- Spring Boot 2.7.11  
- Maven 4.0.0  
- BootStrap 5.3.0  

## 3. 핵심 기능  
## 4. 회고/느낀점  
## 5. 오류  
1. com.mysema.codegen.model.Type 오류  
이 오류가 발생하며 Q클래스가 만들어지지 않았다.  
[해결방법:메이븐 사용 기준으로, <dependencies></dependencies> 사이에 넣은 querydsl 의존성 관련된 버전 부분을 주석처리 해준다.  
나는 querydsl-jpa와 querydsl-apt 관련된 두 의존성의 버전을 주석처리해주었더니 해결되었다.]  

2. Automatic Restart 적용시 발생하는 오류  
[해결방법:인텔리제이 최신 버전에서는 Registry의 compiler.automake.allow.when.app.running에 체크하는 대신,  
Advanced Settings에서 Allow auto-make to start even if developed application를 체크해야한다.]  

3. Thymeleaf 페이지 레이아웃 오류  
Thymeleaf Layout Dialect dependency를 pom.xml에 추가한후 footer와 header 등의 공통 페이지 구성요소를 이용하여 페이지 레이아웃 기능을  
사용하였지만, 애플리케이션 실행 결과 출력이 제대로 되지 않았다.  
[해결방법: 의존성 부분에서 버전을 삭제하였더니 해결이 되었다..!(2.5.1 버전을 추가했었던 상태였다)]  

4. 스프링 시큐리티의 WebSecurityConfigurerAdapter Deprecated 오류  
최신 버전의 스프링 시큐리티에서는 WebSecurityConfigurerAdapter가 Deprecated처리 된다.  
[해결방법: SecurityFilterChain을 Bean으로 등록하여 사용해야한다. 즉, 개발자가 커스텀할 설정들을 직접 @Bean으로 등록하여 사용해야한다.)
  
5. QueryDsl의 fetchResults() deprecated 오류  
fetchResults()는 QueryResults를 사용하고, 여기서 count 쿼리를 사용한다.  
그러나 QueryDsl 5.0.0 버전부터는 fetchResults()와 fetchCount()가 deprecated된다.  
[해결방법: 카운트할 때 fetchResults() 대신 fetch()를 사용한다. 또한, QueryResults를 List 타입으로 바꿔준다.]  
  
# 참고  
1. 깃허브를 이용하여 데이터 파일들을 git의 형상관리 형태로 관리하기  
AWS 같은 서버 원격 저장소 없이도 데이터를 저장하고 활용할 수 있다.
http://raw.githubusercontent.com/{owner이름}/{레포지토리이름}/{branch이름}/{파일 경로}의 URI형태를 이용하면 된다. (단, 레포지토리는 public이어야 한다.)
혹은, 쉽게 이용하는 방법으로는 레포지토리에 파일을 저장한후 마우스 오른쪽 클릭을 하여 새탭에서 파일을 열어주었다. 그러면 URI 주소가 상단에 뜨는데, 이를 복사하여 코드에 활용하였다.  

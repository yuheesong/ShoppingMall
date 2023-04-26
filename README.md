# 오류  
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

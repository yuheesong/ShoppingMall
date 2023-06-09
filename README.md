# 🍞유유의 브레드샵🍞  
베이커리 쇼핑몰이라는 컨셉과 함께 쇼핑 기능, 쇼핑몰 관리, 자유 커뮤니티 기능을 가진 웹사이트입니다.  
본 프로젝트는 개인 프로젝트로 진행되었습니다.  
http://13.125.198.44:8080/ (+추가: 2023.05.26)

## 1. 기간 📅  
2023-04 ~ 2023-05  

## 2. 사용 기술 ⚙️  
- Java 11  
- Spring Boot 2.7.11  
- Maven 4.0.0  
- MySQL 15.1
- BootStrap 5.3.0  
- HTML, CSS, JS

## 3. 핵심 기능 📱  
- 로그인 및 회원 가입  
-처음에 이메일로 가입하도록 구현하였으나 후에 편의성을 위하여 아이디로 로그인 하는 것으로 바꾸었다. 또한, 회원을 이메일로 구별하는 것에서 아이디를 통한 구별로 바꾸었다.    
-if(findMember != null || findMember2!=null)으로 아이디 or 이메일 하나라도 존재시 이미 존재하는 회원 경고창을 띄웠다.  
-추가: 아이디가 '브레드샵'인 회원에만 ADMIN계정 부여 (2023.05.25)  
<img width="70%" src="https://github.com/yuheesong/ShoppingMall/assets/98306847/e87b1cc9-eccf-4c6f-97f7-abc0e91df8fd"/>  
  
- 상품 등록  
<img width="70%" alt="상품등록" src="https://github.com/yuheesong/ShoppingMall/assets/98306847/e9502781-3594-45f6-b603-101ba956af4b">  
  
- 상품 상세 
<img width="70%" src="https://github.com/yuheesong/ShoppingMall/assets/98306847/72a8a01a-5506-43da-b375-d99b522fb4d4"/>  
  
- 상품 관리  
<img width="70%" alt="상품관리" src="https://github.com/yuheesong/ShoppingMall/assets/98306847/efa1e0fb-9ffd-42c1-803c-89aee679c908">  

- 상품 검색  
<img width="70%" alt="상품검색" src="https://github.com/yuheesong/ShoppingMall/assets/98306847/54fbb7ad-04d6-4c07-8695-9b5300f4ff61">  

- 장바구니  
<img width="70%" src="https://github.com/yuheesong/ShoppingMall/assets/98306847/8ca25481-f406-4b31-b495-032c17c48448"/>  
  
- 상품주문과 주문취소 
<img width="70%" src="https://github.com/yuheesong/ShoppingMall/assets/98306847/78629b70-66ba-4fbd-bbc3-052ec4f42c1e"/>  
  
- 자유게시판   
<img width="70%" src="https://github.com/yuheesong/ShoppingMall/assets/98306847/d8b55124-31e4-419f-a62c-e21a9970932b"/>   
  
- 수정 및 삭제  
<img width="70%" src="https://github.com/yuheesong/ShoppingMall/assets/98306847/91fe4493-f20c-4697-ba5b-9e829d9825e2"/>  
  

## 4. 회고/느낀점 ✔️  
- 스프링 강의만 n개월동안 듣다가 실제로 프로젝트를 통하여 내가 만들고 싶은 웹사이트를 만들어보니 스프링 프레임워크의 사용법에 대하여 더 친숙해질 수 있게 되었다.   
- 기본적인 쇼핑몰 웹사이트에 관한 전체적인 동작 프로세스에 대하여 알게 되었다.  
- 추가적인 기능을 덧붙이고 싶은 마음이 생겼다 (회원 탈퇴, 좋아요기능, aws를 통한 사이트 배포 등등). (+배포 완료, 스토리지 작업 추가진행중)


## 5. 오류 📌  
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
  
6. thymeleaf의 template might not exist or might not be accessible by any of the configured Template Resolvers 오류  
웹 페이지가 로컬에서는 잘 작동하나, AWS를 통하여 웹사이트를 배포할 시 특정 화면들에 접속 할 때 500 에러가 떴다.  
또한, 위와 같은 오류가 나타났다. 찾아보니 jar파일과 관련된 이슈인 것 같다.  
[해결방법: controller 파일들의 return 경로에서, 맨 앞이 /로 시작하는 경로들의 /를 삭제해주었더니 올바르게 서버에서도 동작하였다.  
IDE에서는 return 하는 경로가 /로 시작하여도 잘 동작하나, jar 배포시에는 //로 인식하여 잘 동작하지 않는다고 한다. ]  

# 참고  
1. 깃허브를 이용하여 데이터 파일들을 git의 형상관리 형태로 관리하기  
AWS 같은 서버 원격 저장소 없이도 데이터를 저장하고 활용할 수 있다.
http://raw.githubusercontent.com/{owner이름}/{레포지토리이름}/{branch이름}/{파일 경로}의 URI형태를 이용하면 된다. (단, 레포지토리는 public이어야 한다.)
혹은, 쉽게 이용하는 방법으로는 레포지토리에 파일을 저장한후 마우스 오른쪽 클릭을 하여 새탭에서 파일을 열어주었다. 그러면 URI 주소가 상단에 뜨는데, 이를 복사하여 코드에 활용하였다.  

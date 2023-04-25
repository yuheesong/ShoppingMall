# 오류  
1. com.mysema.codegen.model.Type 오류  
이 오류가 발생하며 Q클래스가 만들어지지 않았다.  
[해결방법:메이븐 사용 기준으로, <dependencies></dependencies> 사이에 넣은 querydsl 의존성 관련된 버전 부분을 주석처리 해준다.  
나는 querydsl-jpa와 querydsl-apt 관련된 두 의존성의 버전을 주석처리해주었더니 해결되었다.]  

2. Automatic Restart 적용시 발생하는 오류  
[인텔리제이 최신 버전에서는 Registry의 compiler.automake.allow.when.app.running에 체크하는 대신,  
Advanced Settings에서 Allow auto-make to start even if developed application를 체크해야한다.]
  

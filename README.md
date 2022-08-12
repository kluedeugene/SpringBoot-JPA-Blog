# :paperclip: Basic board Project
> 전반적인 웹의 기본 소양이 되는 게시판 프로젝트입니다.

![메인 화면](https://user-images.githubusercontent.com/50358936/184298605-ddc9ec56-5bd0-4426-8cc6-76de9360a271.png)

## 목차
- [들어가며](#들어가며)
  - [프로젝트 소개](#1-프로젝트-소개)    
  - [프로젝트 기능](#2-프로젝트-기능)    
  - [사용 기술](#3-사용-기술)   
     - [백엔드](#3-1-백엔드)
     - [프론트엔드](#3-2-프론트엔드)
  - [실행 화면](#4-실행-화면)   


- [구조 및 설계](#구조-및-설계)
  - [패키지 구조](#1-패키지-구조)
  - [DB 설계](#2-db-설계)
  - [API 설계](#3-api-설계)

- [개발 내용](#개발-내용)

- [마치며](#마치며)
  - [프로젝트 보완사항](#1-프로젝트-보완사항)
  - [후기](#2-후기)

## 들어가며
### 1. 프로젝트 소개

프로젝트를 시작하게 된 계기는 웹 프로그래밍의 기본 소양이라 할 수 있는 게시판을 직접 만들어보며 배우고자 시작하게 되었습니다.   
독학으로 관련 기술들을 학습한 이후 제작한 개인 프로젝트이기 때문에 개인적인 만족감을 가지고 있는 프로젝트입니다.

### 2. 프로젝트 기능

프로젝트의 주요 기능은 다음과 같습니다.
- **게시판 -** CRUD 기능 ,게시글 상세보기, 페이징 
- **사용자 -** Security 회원가입 및 로그인, 회원정보 수정, 회원가입시 유효성 검사 및 중복 검사
- **댓글 -** CRUD 기능

### 3. 사용 기술

#### 3-1 백엔드

##### 주요 프레임워크 / 라이브러리
- Java 17
- SpringBoot 2.7
- JPA(Spring Data JPA)
- Spring Security


##### Build Tool
- Maven 2,7,7

##### DataBase
- MySQL 8.0.19

#### 3-2 프론트엔드
- Html/Css
- JavaScript
- Bootstrap 4.3.1


### 4. 실행 화면
  <details>
    <summary>게시글 관련</summary>   
       
    
  **1. 게시글 전체 목록**   
  ![image](https://user-images.githubusercontent.com/50358936/184298605-ddc9ec56-5bd0-4426-8cc6-76de9360a271.png)   
  전체 목록을 페이징 처리하여 조회할 수 있다.   
     
  **2. 게시글 등록**   
  ![image](https://user-images.githubusercontent.com/50358936/184299894-c5dd2ef0-ca6f-45ed-ac71-c286c4f04f87.png) 
  로그인 한 사용자만 새로운 글을 작성할 수 있고, 작성 후 목록 화면으로 redirect한다.   
     
  **3. 게시글 상세보기**   
  ![image](https://user-images.githubusercontent.com/50358936/184300213-82d6d9be-c3ac-4eb4-b846-f06ef1471333.png) 
  
  미로그인시 상세보기 클릭
  ![image](https://user-images.githubusercontent.com/50358936/184304332-3b0aec42-584b-4f8d-9245-366181b5d98f.png)
  본인이 작성한 글만 수정 및 삭제가 가능하다. 로그인한 유저만 글상세보기를 할수있다.
     
   **4. 게시글 수정 화면**   
  ![image](https://user-images.githubusercontent.com/50358936/184300623-b0c9c9c0-a79b-4b9a-92ec-f422cde517b0.png)   
     
  제목과 내용만 수정할 수 있게 하고, 상세보기 화면으로 redirect 한다.   

  
  **5. 게시글 삭제 화면**   
  ![image](https://user-images.githubusercontent.com/50358936/184300922-ad643516-e858-4737-9fdb-b2ba986c3af8.png)   
   삭제 후 전체 목록 리스트 화면으로 redirect 한다.   
  
  </details>
  <br/>   
  
  <details>
    <summary>회원 관련</summary>   
     
  **1. 회원가입 화면**   
  ![image](https://user-images.githubusercontent.com/50358936/184301640-156fee57-6621-4001-a957-328cbf959f59.png)
  ![image](https://user-images.githubusercontent.com/50358936/184301646-7f4bfc0c-185f-4eb8-9410-efb97b9772d3.png) 

  회원가입 시 중복확인을 진행하며 완료시 회원 정보를 저장하고 목록화면으로 이동
     
  **2. 로그인 화면**   
  ![image](https://user-images.githubusercontent.com/50358936/184302400-e2887b02-61e8-4c8f-84f1-7d2df0a18218.png)
  등록된 계정 정보이어야만 로그인 진행
      
     
  **3. 회원정보 수정 화면**   
  ![image](https://user-images.githubusercontent.com/50358936/184302900-860fa4e8-a90f-45db-bba5-84cd52254ceb.png)   
  비밀번호와 이메일만 변경할 수 있다.   
  완료시 게시글 전체 리스트 화면으로 redirect 한다.      
           
  </details>
  <br/>   
  
  <details>
    <summary>댓글 관련</summary>   
       
  **1. 댓글 작성 화면**   
![image](https://user-images.githubusercontent.com/50358936/184303968-8cfa137c-19ec-414b-9a2c-8215f7bba4b1.png)
  댓글은 로그인 한 사용자만 달 수 있으며, 댓글 작성시 현재 페이지를 reload 한다.   
  
  **2. 댓글 수정**   
  ![image](https://user-images.githubusercontent.com/59757689/156977557-8a3dae77-9a8d-4fd3-824e-8ff22606609e.png)   
  다른 사용자는 다른 사람의 댓글을 수정/삭제할 수 없다.   
  ![image](https://user-images.githubusercontent.com/59757689/156977567-fd983777-5b04-4f57-a815-c89a59697377.png)   
  수정은 댓글 작성자만이 할 수 있다. 수정 완료 후 현재 페이지를 reload 한다.   
  
  **3. 댓글 삭제**  
   ![image](https://user-images.githubusercontent.com/59757689/156977567-fd983777-5b04-4f57-a815-c89a59697377.png)   
  삭제 또한 댓글 작성자만이 할 수 있다. 삭제 후 현재 페이지를 reload 한다.   
           
  </details>
  <br/>   
 
   
## 구조 및 설계   
   
### 1. 패키지 구조
   
<details>
  
<summary>패키지 구조 보기</summary>   
 
![image](https://user-images.githubusercontent.com/50358936/184305830-911aa0da-86f0-44c8-904e-a8fdcd5b1484.png)

  
 </details>   
 <br/>    
   
     
 ### 2. DB 설계

![erd 3차 2022-01-03](https://user-images.githubusercontent.com/59757689/148910882-2ac9ec57-c339-4bef-a6d5-13025a8d9ac9.PNG)   
![posts 테이블 db 설계](https://user-images.githubusercontent.com/59757689/148910938-c6a99c8e-fefc-467b-a2af-a68a00e01a11.PNG)   
![user 테이블 db 설계](https://user-images.githubusercontent.com/59757689/149279956-b0a184da-9b19-4bcf-9ce8-6c001ef81f1d.PNG) 
![comment 테이블 db 설계](https://user-images.githubusercontent.com/59757689/148910946-02280553-97ce-4d82-bbda-9c911ea89bd4.PNG)   
created_date와 modified_date는 날짜 포맷을 적용해주기 위해 datetime > varchar로 변경했습니다.   
   
<br/>

### 3. API 설계

![게시글 관련 API 설계](https://user-images.githubusercontent.com/59757689/156749365-5e4cee67-1431-4e3a-9140-7b58b6e1fd53.PNG)    
![회원 관련 API 설계 (2)](https://user-images.githubusercontent.com/59757689/148911411-0cfb65ee-5782-4f04-a7c9-7dcc84abfed8.PNG)   
![댓글 관련 API 설계](https://user-images.githubusercontent.com/59757689/148911410-9a7729af-bb3c-49e3-b180-c52ea12ee75c.PNG)   



## 마치며   
### 1. 프로젝트 보완사항   

초기에 구상한 기능은 기본적인 CRUD 즉, 게시판에 올라오는 게시글을 대상으로 Create, Read, Update, Delete가 가능한 게시판이었습니다.   
템플릿 엔진으로 Mustache를 선택했는데, 그 이유는 Mustache는 단순히 화면에 데이터를 렌더링 하는 엔진이고   
Logic-less 하기 때문에 View의 역할과 서버의 역할이 명확하게 분리되어 OOP의 5원칙 중 하나인 SRP를 지킬 수 있어    
MVC 설계에서 Model, View, Controller의 역할에 대한 구분도 명확하게 할 수 있겠다는 생각이 들었습니다.   
또한, 다른 템플릿에 비해 빠른 로딩 속도를 자랑하며, xss를 기본적으로 이스케이프 할 수 있다는 장점들에 이끌려 Mustache를 사용하게 되었습니다.   
그러나 게시판 CRUD 기능이 완성되어 갈 때 쯤, 아쉬운 부분이 계속해서 생겨 몇몇 기능들을 추가하게 되었습니다.   
mustache는 로직을 넣을 수 없어 그 과정에 데이터를 렌더링 하기 전 서버에서 전처리를 하거나,    
화면에 표시된 후에 자바스크립트로 후처리를 해줬지만 조금 아쉬운 부분이 몇 가지 남아있다고 생각합니다.   
<details>
  <summary>보완사항 보기</summary>
     
  
- 페이징 처리 및 검색 페이징에서 페이지 번호 활성화
- 페이지 번호는 10페이지 단위로 보여주기
- 페이지 처음, 끝으로 이동하는 버튼
- 생성, 수정시간 format 설정 varchar > datetime
- 다른 사용자와 자신의 댓글이 댓글란에 있을때 자신의 댓글만 수정,삭제 버튼 보이기
  
</details>   

추후에 브랜치를 나눠 Mustache에서 Thymeleaf로 조금씩 바꾸며 프로젝트 완성도를 높이고, 고도화 할 계획에 있습니다.   
   
   <details>
  <summary>추가할 기능 </summary>
     
  
- 댓글 페이징 처리
- 쿠키나 세션을 이용해 조회수 중복 카운트 방지
- 파일 업로드 기능 추가
- 좋아요 기능 추가
  
</details>  


### 2. 후기   

혼자 독학하며 처음 만들어본 프로젝트이기 때문에,   
공부한 내용을 사용해보는 설렘만큼이나 부족한 부분에 대한 아쉬움도 많이 남았습니다.   
효율적인 설계를 위해 고민하고 찾아보며 실제로 많이 공부할 수 있었던 부분도 많았습니다.   
책이나 블로그, 강의로 공부한 예제에서 납득했던 부분들은 실제로 코드를 짜면서 다양한 애로 사항을 마주했고   
'이 로직은 이 단계에서 처리하는게 맞는가', '각 레이어간 데이터 전달은 어떤 방식이든 DTO로 하는게 맞는가' 등   
여러 고민에 빠져 헤맨적도 있었지만, 다행히 결과는 대부분 최선을 찾았었던 것 같습니다.   
그리고 내가 만든 코드를 남에게 보여줬을 때, 누군가 코드의 근거를 물어본다면   
과연 자신 있게 나의 생각을 잘 얘기할 수 있을까 라는 생각을 굉장히 많이 하게 되었습니다.   
그래서 하나를 구현할 때 '이렇게 구현 하는 것이 과연 최선인가', '더 나은 Best Practice는 없을까'   
스스로 의심하고 고민하게 되는 습관을 가지게 되었습니다.   

두 번째로 기술적인 부분에서 더 공부하고 싶은 '방향'을 찾을 수 있었습니다.   
이번 프로젝트는 저에게 좋은 경험이 되었고, 저의 부족한 부분을 스스로 알 수 있는 좋은 계기가 되었습니다.   
부족한 부분에 대해 스스로 인지하고 있고, 더 깊게 공부하며 스스로 발전할 수 있는 '방향'을 다시한번 찾을 수 있게 되었습니다.   
이를 통해 더 나은 웹 애플리케이션을 만들 수 있을 것 같다는 자신감도 생겼습니다.   

끝까지 읽어주셔서 감사합니다.

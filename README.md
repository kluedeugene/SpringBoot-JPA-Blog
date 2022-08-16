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
  - [후기](#1-후기)

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

![image](https://user-images.githubusercontent.com/50358936/184598973-5271baef-5c29-47a8-a56b-8792808330d5.png)
<br>
![image](https://user-images.githubusercontent.com/50358936/184598467-e2ae9b78-6157-45ef-963b-e3ec2e273c74.png)
<br>
![image](https://user-images.githubusercontent.com/50358936/184598527-815c0a0a-2da9-482d-a465-306dbafba6a2.png)
<br>
![image](https://user-images.githubusercontent.com/50358936/184598769-9d0a834e-9753-4c7d-96b7-13b2b60b97ab.png)
   
<br/>

### 3. API 설계

![image](https://user-images.githubusercontent.com/50358936/184598973-5271baef-5c29-47a8-a56b-8792808330d5.png)

![image](https://user-images.githubusercontent.com/50358936/184598467-e2ae9b78-6157-45ef-963b-e3ec2e273c74.png)

![image](https://user-images.githubusercontent.com/50358936/184598527-815c0a0a-2da9-482d-a465-306dbafba6a2.png)

![image](https://user-images.githubusercontent.com/50358936/184598769-9d0a834e-9753-4c7d-96b7-13b2b60b97ab.png)

![image](https://user-images.githubusercontent.com/50358936/184818623-56a04788-1b68-47a7-9a02-b5a99ba03f1c.png)

![image](https://user-images.githubusercontent.com/50358936/184818680-7fe71f19-2834-45ef-8421-ba5e449623ed.png)


## 마치며   

   <details>
  <summary>추가할 기능 </summary>
     
- 댓글 수정삭제 미완료  
- 댓글 페이징 처리
- 로그인 회원가입 유효성검사및 
- 쿠키나 세션을 이용해 조회수 중복 카운트 방지
- 파일 업로드 기능 추가
- 좋아요 기능 추가
  
</details>  


### 1. 후기   

혼자 독학하며 처음 만들어본 스프링 프로젝트이기 때문에,   
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


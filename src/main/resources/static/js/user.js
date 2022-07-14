let index = {
	init: function () {
		//on -> 파라미터 1 이벤트가 일어나면, 파라미터2를 실행.
		$('#btn-save').on('click', () => {
			//function(){} 대신에 사용하는 이뉴는 화살표함수로 this를 바인딩하기 위해서이다.
			this.save();
		});
		$('#btn-update').on('click', () => {
			//function(){} 대신에 사용하는 이뉴는 화살표함수로 this를 바인딩하기 위해서이다.
			this.update();
		});
		// $('#btn-login').on('click', () => {
		// 	// function(){} , ()=>{} this를 바인딩하기 위해서!!
		// 	this.login();
		// });
	},

	save: function () {
		//	alert('user의 save함수 호출됨.');
		let data = {
			username: $('#username').val(),
			password: $('#password').val(),
			email: $('#email').val()
		};
		// console.log(data);

		//ajax 호출시 default가 비동기 호출
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
		//ajax가 통신을 성공하고 서버가 json 을 리턴해주면 자동으로 자바오브젝트로 변환해주네요( dataType 지정안해줘도)
		$.ajax({
			//회원가입 수행 요청 -> 정상이면  done 실행 실패하면 fail 실행
			type: 'POST',
			url: '/auth/joinProc', //요청 Url
			data: JSON.stringify(data), //요청과 함께 서버로 데이터를 전송 할 string 또는 map  , 자바  '스크립트' 오브젝트를 Json문자열로 변환
			contentType: 'application/json; charset=UTF-8', //body데이터가 어떤 타입인지(MIME)
			dataType: 'json' //서버에서 반환되는 데이터 형식을 지정합니다. 기본적으로 반환값이 String문자열인데 (생긴게 json이라면)=>javascript오브젝트로 변경
		})
			.done(function (response) {
				if(response.status === 500){
					alert("회원가입에 실패하였습니다.")
				}else{
				alert('회원가입이 완료되었습니다.');
				console.log(response);
				location.href = '/';
				}
			})
			.fail(function (error) {
				alert(JSON.stringify(error));
			});
	},

	update: function () {
		//	alert('user의 save함수 호출됨.');
		let data = {
			id: $('#id').val(),
			username: $('#username').val(),
			password: $('#password').val(),
			email: $('#email').val()
		};

		$.ajax({

			type: 'PUT',
			url: '/user', //요청 Url
			data: JSON.stringify(data), //요청과 함께 서버로 데이터를 전송 할 string 또는 map  , 자바  '스크립트' 오브젝트를 Json문자열로 변환
			contentType: 'application/json; charset=UTF-8', //body데이터가 어떤 타입인지(MIME)
			dataType: 'json' //서버에서 반환되는 데이터 형식을 지정합니다. 기본적으로 반환값이 String문자열인데 (생긴게 json이라면)=>javascript오브젝트로 변경
		})
			.done(function (response) {
				alert('회원정보수정이 완료되었습니다.');
				console.log(response);
				location.href = '/';
			})
			.fail(function (error) {
				alert(JSON.stringify(error));
			});
	}

	// login: function () {
	// 	let data = {
	// 		username: $('#username').val(),
	// 		password: $('#password').val()
	// 	};

	// 	$.ajax({
	// 		//로그인 수행 요청 -> 정상이면  done 실행 실패하면 fail 실행
	// 		type: 'POST',
	// 		url: '/api/user/login', //요청 Url
	// 		data: JSON.stringify(data), //요청과 함께 서버로 데이터를 전송 할 string 또는 map  , 자바  '스크립트' 오브젝트를 Json문자열로 변환
	// 		contentType: 'application/json; charset=UTF-8', //body데이터가 어떤 타입인지(MIME)
	// 		dataType: 'json' //서버에서 반환되는 데이터 형식을 지정합니다. 기본적으로 반환값이 String문자열인데 (생긴게 json이라면)=>javascript오브젝트로 변경
	// 	})
	// 		.done(function (response) {
	// 			alert('로그인이 완료되었습니다.');
	// 			console.log(response);
	// 			location.href = '/';
	// 		})
	// 		.fail(function (error) {
	// 			alert(JSON.stringify(error));
	// 		});
	// }
};

index.init();

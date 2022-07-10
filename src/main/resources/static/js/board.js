let index = {
	init: function () {
		//on -> 파라미터 1 이벤트가 일어나면, 파라미터2를 실행.
		$('#btn-save').on('click', () => {
			//function(){} 대신에 사용하는 이뉴는 화살표함수로 this를 바인딩하기 위해서이다.
			this.save();
		});
		$('#btn-delete').on('click', () => {
			this.deleteById();
		});
		$('#btn-update').on('click', () => {
			this.update();
		});
	},

	save: function () {

		let data = {
			title: $('#title').val(),
			content: $('#content').val(),
		};

		$.ajax({
			//글쓰기 요청 post
			type: 'POST',
			url: '/api/board', //요청 Url
			data: JSON.stringify(data),
			contentType: 'application/json; charset=UTF-8',
			dataType: 'json'
		})
			.done(function (response) {
				alert('글쓰기가 완료되었습니다.');
				console.log(response);
				location.href = '/';
			})
			.fail(function (error) {
				alert(JSON.stringify(error));
			});
	},

	deleteById: function(){
		let id = $("#id").text();

		$.ajax({
			type: "DELETE",
			url: "/api/board/"+id,
			dataType: "json"
		}).done(function(resp){
			alert("삭제가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},

	update: function () {

		let id = $("#id").val();

		let data = {
			title: $('#title').val(),
			content: $('#content').val(),
		};

		$.ajax({
			//글쓰기 요청 post
			type: 'PUT',
			url: '/api/board/'+id, //요청 Url
			data: JSON.stringify(data),
			contentType: 'application/json; charset=UTF-8',
			dataType: 'json'
		})
			.done(function (response) {
				alert('글수정이  완료되었습니다.');
				console.log(response);
				location.href = '/';
			})
			.fail(function (error) {
				alert(JSON.stringify(error));
			});
	},

};

index.init();

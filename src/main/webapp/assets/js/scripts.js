function abrirModalProduto(index) {
    $('#modalProduct' + index).modal();
}

function logout() {
	$.ajax({
		url: window.location.pathname.replace('/OkoneSports/', '') + '/logout',
		success: function(result) {
			window.location.href = 'index';
		}
	});
}

function logon() {
	$.ajax({
		url: 'login/logon?login=' + $('#login').val() + '&senha=' + $('#pwd').val(),
		success: function(result) {
			window.location.href = 'index';
		},
		error: function(jqXHR) {
			if (jqXHR.responseText.indexOf('Login e/ou') > -1) {
				alert('Login e/ou senha inválidos');
			} else {
				alert('Erro no login de usuário');
			}
			window.location.href = 'login';
		}
	});
}

function saveUser() {
	$.ajax({
		url: 'new_user/save',
		data: $('form').serialize(),
		type: 'POST',
		success: function(result) {
			alert('Usuário cadastrado com sucesso!');
			window.location.href = 'index';
		},
		error: function(jqXHR) {
			alert('Erro no cadastro de usuário');
			window.location.href = 'new_user';
		}
	});
}

function saveProduct() {
	$.ajax({
		url: 'add_product/save',
		data: $('form').serialize(),
		type: 'POST',
		success: function(result) {
			alert('Produto cadastrado com sucesso!');
			window.location.href = 'add_product';
		},
		error: function(jqXHR) {
			alert('Erro no cadastro de produto');
			window.location.href = 'add_product';
		}
	});
}



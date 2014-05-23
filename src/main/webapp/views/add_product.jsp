<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
	<div
		class="col-md-7 column center-column new-user-column panel panel-default">
		<h3 class="text-primary">Cadastrar um novo produto</h3>
		<form role="form" id="form_produto">
			<div class="view hide">
				<div class="alert alert-dismissable alert-danger">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">x</button>
					<label id="msg_error"></label>
				</div>
			</div>

			<div class="form-group">
				<label for="nome">Nome do produto:</label><input type="text"
					class="form-control required" id="nome" name="nome" />
			</div>
			<div class="form-group">
				<label for="descricao">Descrição:</label><input type="text"
					class="form-control required" id="descricao" name="descricao" />
			</div>
			<div class="form-group">
				<label for="preco">Preço:</label><input type="text"
					class="form-control required" id="preco" name="preco" />
			</div>
			<div class="form-group">
				<label for="imagem">Imagem:</label><input type="text"
					class="form-control required" id="imagem" name="imagem" />
			</div>
			<button type="button" class="btn btn-primary" onclick="saveProduct()">Salvar</button>
			<br /> <br />
		</form>
	</div>
</div>
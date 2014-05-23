<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>OkoneSports</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
<!--script src="js/less-1.3.3.min.js"></script-->
<!--append â€˜#!watchâ€™ to the browser URL, then refresh the page. -->

<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
  <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/img/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/img/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/img/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/img/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="assets/img/favicon.png">

<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/scripts.js"></script>
</head>

<body>
	<div class="container">
		<div
			class="col-md-7 column center-column new-user-column panel panel-default">
			<h3 class="text-primary">
				Faça parte do mundo <strong>OkoneSports</strong>
			</h3>
			<form role="form">
				<c:if test="login_error">
					<div class="view">
						<div class="alert alert-dismissable alert-danger">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">x</button>
							${msg_error}
						</div>
					</div>
				</c:if>

				<div class="form-group">
					<label for="nome">Nome completo:</label><input type="text"
						class="form-control" id="nome" name="nome" />
				</div>
				<div class="form-group">
					<label for="data_nascimento">Data de nascimento:</label><input
						type="date" class="form-control" id="data_nascimento"
						name="dataNascimento" />
				</div>
				<div class="form-group">
					<label for="rg">RG:</label><input type="text" class="form-control"
						id="rg" name="rg" />
				</div>
				<div class="form-group">
					<label for="cpf">CPF:</label><input type="text"
						class="form-control" id="cpf" name="cpf" />
				</div>
				<div class="form-group">
					<label for="email">Email:</label><input type="email"
						class="form-control" id="email" name="email" />
				</div>
				<div class="form-group">
					<label for="pwd">Senha:</label><input type="password"
						class="form-control" id="pwd" name="senha" />
				</div>
				<div class="form-group">
					<label>Por favor, leia com atenção os termos de uso</label>
					<textarea class="terms" readonly>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus blandit at sem at gravida. Vestibulum ac eros ut lorem ultrices vulputate. Aliquam a libero pretium, vehicula risus id, tristique neque. Nulla vitae vehicula libero. Mauris interdum tincidunt est nec vulputate. Mauris at ante neque. Sed non nulla sed diam tincidunt tincidunt. Nulla nec lorem ut tortor placerat malesuada a sed tellus. Vivamus pulvinar nulla augue, ac ullamcorper mi convallis a. Nullam condimentum ligula bibendum, euismod orci eu, consequat est. Nunc vitae magna et ante elementum suscipit. Fusce iaculis posuere commodo. Mauris sit amet sem laoreet, dapibus justo vitae, pharetra dui.
                        Quisque imperdiet, diam eget rutrum imperdiet, eros urna luctus eros, vitae consequat odio erat non felis. Praesent ut lectus nisi. Duis blandit turpis sed ante pulvinar tincidunt vel ut diam. Aliquam sagittis risus et volutpat ultricies. Phasellus non mauris nisl. Integer sollicitudin tellus ut quam dignissim, et iaculis enim luctus. Vivamus luctus, augue nec ullamcorper interdum, libero lorem mattis magna, sit amet aliquam mi neque in lorem. Fusce at tincidunt enim. Morbi est nisi, sodales condimentum risus a, lobortis consectetur augue.
                        Aenean id nunc massa. Vivamus sollicitudin eu dui vel elementum. Morbi leo urna, vulputate eu dignissim sed, malesuada a orci. Pellentesque venenatis, arcu vel gravida tristique, ligula velit tempus urna, vel aliquam nunc dui nec libero. Fusce lacus ante, ultrices malesuada arcu id, blandit facilisis tellus. Donec molestie fringilla est, id lobortis elit mattis non. Nunc ut elit eu augue sagittis fermentum.
                        Morbi aliquam massa a odio molestie sollicitudin. Etiam eget arcu at urna volutpat malesuada ut in nisi. Mauris id justo lorem. Praesent sollicitudin sem fermentum, pharetra magna ut, facilisis magna. Proin gravida vitae nunc at gravida. Vestibulum dictum vitae nibh ac convallis. Nunc et nibh convallis, viverra leo sit amet, volutpat leo.
                        Pellentesque a nisi nec ante scelerisque eleifend eu et felis. Pellentesque aliquam volutpat purus a euismod. Sed sagittis nulla augue, quis luctus sapien tempus ac. Duis auctor dui et dui tempor consectetur. Nullam lorem dui, commodo vel pellentesque nec, tempor vel leo. Integer feugiat pellentesque nulla quis tempus. Ut scelerisque, elit quis gravida lacinia, nunc risus consequat justo, vitae elementum augue nisi nec dolor. Pellentesque vitae felis purus.</textarea>
					<br />
				</div>
				<button type="button" class="btn btn-primary" onclick="saveUser()">Salvar</button>
				<br /> <br />
			</form>
		</div>
	</div>
</body>

</html>
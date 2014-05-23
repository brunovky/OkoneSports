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
<!--append ‘#!watch’ to the browser URL, then refresh the page. -->

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
		<div class="col-md-4 column center-column panel panel-default">
			<h3 class="text-primary">Fa�a seu login</h3>
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
					<label for="login">Login/Email:</label><input type="text"
						class="form-control required" id="login" name="login" />
				</div>
				<div class="form-group">
					<label for="pwd">Senha:</label><input type="password"
						class="form-control required" id="pwd" name="senha" />
				</div>
				<div class="checkbox">
					<label><input type="checkbox" /> Manter-me conectado</label>
				</div>
				<button type="button" class="btn btn-primary" onclick="logon()">Entrar</button>
				<br />
				<br />
				<div class="new-user">
					<label>Novo no site? </label> <a href="new_user">Cadastre-se
						aqui!</a>
				</div>
				<br />
			</form>
		</div>
	</div>
</body>
</html>
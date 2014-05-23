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

		<div id="header" class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-static-top"
					role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">OkoneSports</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-right">
							<c:if test="${is_admin}">
								<button type="button" class="btn btn-primary"
									onclick="window.location.href = 'add_product'">Cadastrar
									Produto</button>
							</c:if>
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Pesquise seu produto" name="pesquisa" />
							</div>
							<button type="button" class="btn btn-default"
								onclick="window.location.href = 'cart'">Pesquisar</button>
							<c:choose>
								<c:when test="${is_logged}">
									<div class="form-group btn-entrar hand-cursor">
										<a onclick="logout()" class="btn btn-danger btn-entrar">(${username})
											Sair</a>
									</div>
								</c:when>
								<c:otherwise>
									<a href="login" class="btn btn-success btn-entrar">Entrar</a>
								</c:otherwise>
							</c:choose>
						</form>
					</div>
				</nav>
			</div>
		</div>

	</div>
</body>
</html>
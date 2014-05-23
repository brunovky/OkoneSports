<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"></jsp:include>

<div class="panel panel-default">
	<table class="table table-hover">
		<thead>
			<tr>
				<th class="th-product">Imagem</th>
				<th class="th-product">Nome</th>
				<th class="th-product">Preço</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="produto" varStatus="num">
				<tr>
					<td class="td-product"><img
						src="assets/img/${produto.imagem}.png" width="64" height="64"
						onclick="abrirModalProduto(${num.index})" class="hand-cursor" /></td>
					<td class="td-product"><span>${produto.nome}</span></td>
					<td class="td-product"><span>R$ ${produto.valor}</span></td>
					<div class="modal fade" role="dialog" id="modalProduct${num.index}"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">x</button>
									<h4 class="modal-title" id="myModalLabel">${produto.nome}
									</h4>
								</div>
								<div class="modal-body">
									<img src="assets/img/${produto.imagem}.png" width="512"
										height="512" />
								</div>
							</div>
						</div>
					</div>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
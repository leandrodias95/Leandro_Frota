<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<h2>Estado</h2>
<table id="datatable" class="display">
    <thead>
        <tr>
            <th align="left">ID</th>
            <th align="left">Marca</th>
            <th align="left">Modelo</th>
            <th align="left">Odometro</th>
            <th align="left">Valor do Veículo</th>
            <th align="left">Observação</th>
            <th align="right"></th>
            <th align="right"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="veiculo" items="${veiculos}"> 
            <tr>
            <td align="left">${veiculo.idVeiculo}</td>
            <td align="left">${veiculo.marca}</td>
            <td align="left">${veiculo.modelo}</td>
            <td align="left">${veiculo.odometro}</td>
            <td align="left">${veiculo.valorVeiculo}</td>
            <td align="left">${veiculo.observacao}</td>
            <td align="center">
                <a href="${pageContext.request.contextPath}/VeiculoExcluir?idVeiculo=${veiculo.idVeiculo}">Excluir</a></td>
            <td align="center">
                <a href="${pageContext.request.contextPath}/VeiculoCarregar?idVeiculo=${veiculo.idVeiculo}">Alterar</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div align="center">
 <a href="${pageContext.request.contextPath}/VeiculoNovo">Novo</a>  
 <a href="index.jsp">Volta à Página Inicial</a>  
</div>
 <script>
        $(document).ready(function() {
            console.log('entrei ready');
            //Carregamos a datatable
            //$("#datatable").DataTable({});
            $('#datatable').DataTable({
                "oLanguage": {
                    "sProcessing": "Processando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "Nenhum registro encontrado.",
                    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                    "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                    "sInfoFiltered": "",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Seguinte",
                        "sLast": "Último"
                    }
                }
            });
        });
</script>

 <%@include file="/footer.jsp" %>

<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.account.information"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div class="col-sm-10">
    <h2><fmt:message key="menu.account.information"/></h2>
    <hr />

    <br />
    <c:if test="${account.responseCode == '00'}">
    <table class="table-striped" style="width: 60%">

        <tr>
            <th><fmt:message key="account.accountNumber"/></th>
            <td><c:out value="${account.accountNumber}"/></td>

        </tr>
        <tr>
            <th><fmt:message key="account.accountType"/></th>
            <td><c:out value="${account.accountType}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="account.currency"/></th>
            <td><c:out value="${account.currency}"/></td>
        </tr>
        <tr>
            <th><fmt:message key="account.availableBalance"/></th>
            <td style="text-align: right"><fmt:formatNumber pattern="#,###,###,###.##" value="${account.balance}" minFractionDigits="2" /></td>
        </tr>
    </table>

    </c:if>

    <br />
    <c:if test="${account.responseCode != '00'}">
        <div class="alert alert-danger alert-dismissable">
            <c:out value="${account.description}" /><br/>
        </div>
    </c:if>

    <hr />
    <div id="actions" class="form-group">
        <a class="btn btn-primary" href="<c:url value='/home'/>" >
            <i class="icon-ok icon-white"></i>
            <fmt:message key="button.done"/>
        </a>
    </div>
</div>



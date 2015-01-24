<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.account.statement"/></title>

    <script type="text/javascript" src="<c:url value='/scripts/added/jquery-1.11.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/added/jquery-ui-1.11.2.custom/jquery-ui.js'/>"></script>

    <link rel="stylesheet" type="text/css" href="${base}/scripts/added/jquery-ui-1.11.2.custom/jquery-ui.css">
</head>

<div class="col-sm-10">
    <h2><fmt:message key="menu.account.information"/></h2>
    <hr />
    <br />
    <c:if test="${account.responseCode == '00'}">
        <table class="table-striped" style="width: 50%;">

            <tr>
                <th style="width: 200px"><fmt:message key="account.accountNumber"/></th>
                <td><c:out value="${account.accountNumber}"/></td>

            </tr>
            <tr>
                <th><fmt:message key="name"/></th>
                <td><c:out value="${pageContext.request.remoteUser}"/></td>
            </tr>
            <tr>
                <th><fmt:message key="account.statementPeriod"/></th>
                    <td><c:out value="${period}"/>
                    </td>
            </tr>
            <tr>
                <th><fmt:message key="account.currency"/></th>
                <td><c:out value="${account.currency}"/></td>
            </tr>
        </table>
        <br />
        <display:table name="accountStatementList" cellspacing="0" cellpadding="0" requestURI=""
                       defaultsort="1" id="acss" pagesize="25" class="table table-condensed table-striped table-hover" export="false">
            <display:column property="transactionDate" titleKey="date" style="width: 20%" format="{0,date,dd/MM/yyyy}"/>
            <display:column property="description" titleKey="description" style="width: 25%"/>
            <display:column property="branch" titleKey="description" style="width: 10%"/>
            <display:column property="amount" titleKey="amount" style="width: 20%; text-align:right;" format="{0,number,0,000.00}"/>
            <display:column property="dbCr" titleKey="dbCr" style="width: 5%"/>
            <display:column property="balance" titleKey="balance" style="width: 20%; text-align:right;" format="{0,number,0,000.00}"/>

        </display:table>

        <br />
        <table class="table-striped" style="width: 30%">
            <tr>
                <th style="width: 200px"><fmt:message key="startingBalance"/></th>
                <td style="text-align: right"><fmt:formatNumber pattern="#,###,###,###.##" value="${asSummary.startingBalance}" minFractionDigits="2" /></td>

            </tr>
            <tr>
                <th><fmt:message key="totalCredit"/></th>
                <td style="text-align: right"><fmt:formatNumber pattern="#,###,###,###.##" value="${asSummary.totalCredit}" minFractionDigits="2" /></td>
            </tr>
            <tr>
                <th><fmt:message key="totalDebit"/></th>
                <td style="text-align: right"><fmt:formatNumber pattern="#,###,###,###.##" value="${asSummary.totalDebit}" minFractionDigits="2" /></td>
                </td>
            </tr>
            <tr>
                <th><fmt:message key="endingBalance"/></th>
                <td style="text-align: right"><fmt:formatNumber pattern="#,###,###,###.##" value="${asSummary.endingBalance}" minFractionDigits="2" /></td>
            </tr>
        </table>

    </c:if>

    <c:if test="${account.responseCode != '00'}">
        <div class="alert alert-danger alert-dismissable">
            <c:out value="${account.description}" /><br/>
        </div>
    </c:if>

    <br />
    <hr />
    <div id="actions" class="form-group">
        <a class="btn btn-primary" href="<c:url value='/home'/>" >
            <i class="icon-ok icon-white"></i>
            <fmt:message key="button.done"/>
        </a>
    </div>
</div>


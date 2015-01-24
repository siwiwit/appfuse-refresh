<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.account.statement"/></title>

    <script type="text/javascript" src="<c:url value='/scripts/added/jquery-1.11.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/added/jquery-ui-1.11.2.custom/jquery-ui.js'/>"></script>
    <script>
        $(function() {
            $( ".cdatepicker" ).datepicker();

            $( ".cselect" ).selectmenu();

            $( "#accordion" ).accordion();
        });
    </script>
    <link rel="stylesheet" type="text/css" href="${base}/scripts/added/jquery-ui-1.11.2.custom/jquery-ui.css">
</head>

<div class="col-sm-10">
    <h2><fmt:message key="menu.account.statement"/></h2>
    <hr />

    <%--<form method="get" id="account" action="<c:url value='/accountstatementresult'/>" class="well" autocomplete="off">--%>
    <spring:bind path="account.*">
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-danger alert-dismissable">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br />
                </c:forEach>
            </div>
        </c:if>
    </spring:bind>

    <form:form commandName="account" method="post" action="${applPath}/account/accountStatement" id="accountForm" >
    <table class="table-striped" style="width: 100%">
        <tr style="vertical-align: middle">
            <td style="width: 200px;">
                <fmt:message key="account.accountNumber"/>
            </td>
            <td>
                <select name="accNo" class="cselect" id="accNo" style="width: 150px;">
                    <option selected="selected">6022233375</option>
                    <option>6077666001</option>
                    <option>6095553200</option>
                </select>
            </td>
        </tr>
        <tr style="vertical-align: top;">
            <td>
                <p style="padding-top: 10px;"> <fmt:message key="account.statementPeriod"/></p>
            </td>
            <td>
                <div>
                    <p style="padding-top: 10px;">
                    <c:choose>
                        <c:when test="${periodType == 'daily'}">
                            <input type="radio" name="periodType" value="daily" checked>
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="periodType" value="daily" >
                        </c:otherwise>
                    </c:choose>
                    <fmt:message key="account.dailyStatement"/>
                    &nbsp;
                    <input type="text" name="datepickerFrom" class="cdatepicker" id="datepickerFrom" value="<c:out value="${newDate}" />" >
                    &nbsp;-&nbsp;
                    <input type="text" name="datepickerUntil" class="cdatepicker" id="datepickerUntil" value="<c:out value="${newDate}" />" >
                    </p>
                </div>
            <%--</td>
        </tr>
        <tr style="vertical-align: middle">
            <td></td>
            <td style="vertical-align: middle">--%>
                <div>
                    <p style="padding-top: 10px; ">
                    <c:choose>
                        <c:when test="${periodType == 'monthly'}">
                            <input type="radio" name="periodType" value="monthly" checked>
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="periodType" value="monthly" >
                        </c:otherwise>
                    </c:choose>
                    <fmt:message key="account.monthlyStatement"/>
                    &nbsp;
                    <select name="months" class="cselect" id="months" style="width: 355px;">
                        <option selected="selected">Januari</option>
                        <option>Februari</option>
                        <option>Maret</option>
                        <option>April</option>
                        <option>Mei</option>
                        <option>Juni</option>
                        <option>Juli</option>
                        <option>Agustus</option>
                        <option>September</option>
                        <option>Oktober</option>
                        <option>November</option>
                        <option>Desember</option>
                    </select>
                    </p>
                </div>
            </td>
        </tr>
    </table>

    <br />
    <hr />
    <button type="submit" name="view" class="btn btn-primary" onclick="bCancel=false">
        <i class="icon-upload icon-white"></i> <fmt:message key="view.accountStatement"/>
    </button>
    </form:form>
    <%--<div id="actions" class="form-group">
        <a class="btn btn-primary" href="accountstatementresult" >
            <i class="icon-ok icon-white"></i>
            <fmt:message key="view.accountstatement"/>
        </a>
    </div>--%>
</div>



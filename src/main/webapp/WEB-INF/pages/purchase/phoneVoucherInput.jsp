<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.transfer.internal"/></title>
    <script type="text/javascript" src="<c:url value='/scripts/added/jquery-1.11.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/added/jquery-ui-1.11.2.custom/jquery-ui.js'/>"></script>
    <script>
        $(function() {
            $( ".cdatepicker" ).datepicker();
        });
    </script>
</head>

<div class="col-sm-7">
    <h2><fmt:message key="menu.transfer.internal"/></h2>
    <hr />
    <br />
    <spring:bind path="transfer.*">

    </spring:bind>
    <form:form commandName="transfer" method="post" action="/transfer/transferInput" id="transferForm" >

    <div class="row">
        <div class="col-sm-6 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
            <spring:bind path="transfer.destinationAccountNumber">
                <appfuse:label styleClass="control-label" key="transfer.destinationAccountNumber"/>
                <br />
                <form:select path="destinationAccountNumber" >
                    <%--                    <form:option value="NONE" label="--- Select ---" />--%>
                    <form:options items="${accountNumberList}" />
                </form:select>
                <%--                <form:errors path="bank" cssClass="error" />--%>
                <br />
            </spring:bind>
            <spring:bind path="transfer.amount">
                <appfuse:label styleClass="control-label" key="transfer.amount"/>
                <form:input cssClass="form-control" path="amount" id="amount" />
            </spring:bind>
            <spring:bind path="transfer.news">
                <appfuse:label styleClass="control-label" key="transfer.news"/>
                <form:input cssClass="form-control" path="news" id="news" />
            </spring:bind>
            <br />
            <c:choose>
                <c:when test="${transferTime == 'transferNow'}">
                    <input type="radio" name="transferTime" value="transferNow" checked>
                </c:when>
                <c:otherwise>
                    <input type="radio" name="transferTime" value="transferNow" >
                </c:otherwise>
            </c:choose>
            <fmt:message key="transferNow"/>
            <br />
            <c:choose>
                <c:when test="${bankType == 'transferOnDate'}">
                    <input type="radio" name="transferTime" value="transferOnDate" checked>
                </c:when>
                <c:otherwise>
                    <input type="radio" name="transferTime" value="transferOnDate" >
                </c:otherwise>
            </c:choose>
            <fmt:message key="transferOnDate"/>
            <input type="text" name="datepickerTransfer" class="cdatepicker" id="datepickerTransfer" value="<c:out value="${newDate}" />" >

        </div>
    </div>

        <br />
        <hr />
        <button type="submit" name="view" class="btn btn-primary" onclick="bCancel=false">
            <i class="icon-upload icon-white"></i> <fmt:message key="next"/>
        </button>
    </form:form>

</div>


<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="menu.register.account"/></title>
</head>

<div class="col-sm-10">
    <h2><fmt:message key="menu.register.account"/></h2>
    <hr />
    <br />
    <form:form commandName="transfer" method="post" action="registerAccount" id="accountForm" >
        <table class="table-striped" style="width: 60%">
            <tr style="vertical-align: middle">
                <td>
                    <fmt:message key="transferType"/>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${bankType == 'sameBank'}">
                            <input type="radio" name="bankType" value="sameBank" checked>
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="bankType" value="sameBank" >
                        </c:otherwise>
                    </c:choose>
                    <fmt:message key="sameBank"/>
                </td>
            <tr style="vertical-align: middle">
                <td>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${bankType == 'otherBank'}">
                            <input type="radio" name="bankType" value="otherBank" checked>
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="bankType" value="otherBank" >
                        </c:otherwise>
                    </c:choose>
                    <fmt:message key="otherBank"/>
                </td>
            </tr>
        </table>

        <br />
        <hr />
        <button type="submit" name="view" class="btn btn-primary" onclick="bCancel=false">
            <i class="icon-upload icon-white"></i> <fmt:message key="next"/>
        </button>
    </form:form>

</div>


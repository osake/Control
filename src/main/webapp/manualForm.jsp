<%@ include file="/taglibs.jsp"%>

<head>
    <title><fmt:message key="manualDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='manualDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="manualList.manual"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="span2">
    <h2><fmt:message key="manualDetail.heading"/></h2>
    <fmt:message key="manualDetail.message"/>
</div>

<div class="span7">
    <s:form id="manualForm" action="saveManual" method="post" validate="true" cssClass="well form-horizontal">
            <s:hidden key="manual.id"/>
        <s:textfield key="manual.idioma" required="false" maxlength="30" />
        <s:textfield key="manual.tags" required="false" maxlength="150" />
        <s:textfield key="manual.titulo" required="true" maxlength="100" />
        <s:textfield key="manual.ubicacion" required="true" maxlength="80" />

        <div id="actions" class="form-actions">
            <s:submit type="button" cssClass="btn btn-primary" method="save" key="button.save" theme="simple">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </s:submit>
            <c:if test="${not empty manual.id}">
                <s:submit type="button" cssClass="btn btn-warning" method="delete" key="button.delete"
                    onclick="return confirmMessage(msgDelConfirm)" theme="simple">
                    <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
                </s:submit>
            </c:if>
            <s:submit type="button" cssClass="btn" method="cancel" key="button.cancel" theme="simple">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </s:submit>
        </div>
    </s:form>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['manualForm']).focus();
    });
</script>

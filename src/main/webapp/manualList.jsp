<%@ include file="/taglibs.jsp"%>

<head>
    <title><fmt:message key="manualList.title"/></title>
    <meta name="menu" content="ManualMenu"/>
</head>

<div class="span10">
    <h2><fmt:message key="manualList.heading"/></h2>

    <form method="get" action="${ctx}/manuales" id="searchForm" class="form-search">
    <div id="search" class="input-append">
        <input type="text" size="20" name="q" id="query" value="${param.q}"
               placeholder="<fmt:message key="search.enterTerms"/>" class="input-medium search-query"/>
        <button id="button.search" class="btn" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="manualList.message"/>



    <display:table name="manuals" class="table table-condensed table-striped table-hover" requestURI="" id="manualList" export="true" pagesize="25">
        <display:column property="id" sortable="true" href="editManual" media="html"
            paramId="id" paramProperty="id" titleKey="manual.id"/>
        <display:column property="id" media="csv excel xml pdf" titleKey="manual.id"/>
        <display:column property="idioma" sortable="true" titleKey="manual.idioma"/>
        <display:column property="tags" sortable="true" titleKey="manual.tags"/>
        <display:column property="titulo" sortable="true" titleKey="manual.titulo"/>
        <display:column property="ubicacion" sortable="true" titleKey="manual.ubicacion"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="manualList.manual"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="manualList.manuals"/></display:setProperty>

        <display:setProperty name="export.excel.filename"><fmt:message key="manualList.title"/>.xls</display:setProperty>
        <display:setProperty name="export.csv.filename"><fmt:message key="manualList.title"/>.csv</display:setProperty>
        <display:setProperty name="export.pdf.filename"><fmt:message key="manualList.title"/>.pdf</display:setProperty>
    </display:table>

    <div id="actions" class="form-actions">
        <a class="btn btn-primary" href="<c:url value='/editManual'/>" >
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/>
        </a>
        <a class="btn" href="<c:url value="/"/>" >
            <i class="icon-ok"></i> <fmt:message key="button.done"/>
        </a>
    </div>

</div>

<%@ include file="/taglibs.jsp" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <title><decorator:title default="Welcome"/> | <fmt:message key="webapp.name"/></title>
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" href="${ctx}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${ctx}/webjars/bootstrap/2.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/styles/app.css">
    <script type="text/javascript" src="${ctx}/webjars/jquery/1.8.2/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/webjars/bootstrap/2.2.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/app.js"></script>
    <decorator:head/>
</head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>
<a name="top"></a>

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <%-- For smartphones and smaller screens --%>
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="<c:url value='/'/>">AppFuse Light</a>
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li><a href="${ctx}/" title="Home">Home</a></li>
                        <li><a href="${ctx}/users" title="View Users">Users</a></li>
                        <!--Manual-START-->
                    <li><a href="${ctx}/manuales" title="Ver Manuales"><span>Manuales</span></a></li>
                    <!--Manual-END-->
                    <!-- Add new menu items here -->

                    </ul>
                </div>
                <script type="text/javascript">
                    $('a[href="${fn:substringBefore(pageContext.request.requestURI, '.')}"]').parent().addClass('active');
                </script>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span7">
                <%@ include file="/messages.jsp"%>
                <decorator:body/>

                <decorator:getProperty property="page.underground"/>
            </div>
        </div>
    </div>

    <div id="footer">
        <p>
            Created by <a href="#">Axxis Computo</a>.
        </p>
    </div>
</body>
</html>

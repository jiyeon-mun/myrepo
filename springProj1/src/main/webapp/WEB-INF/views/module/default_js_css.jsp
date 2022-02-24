<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:url var="bs_url" value="/static/bs-5.1.3/" />
<c:url var="jq_url" value="/static/jquery/" />
<link href="${bs_url }css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${jq_url }jquery-3.6.0.min.js"></script>
<script src="${bs_url }js/bootstrap.bundle.min.js"></script>
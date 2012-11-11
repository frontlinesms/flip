<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
<head>

	<!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">
	<title>Flip</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title><g:layoutTitle default="Grails"/> | FlippMe</title>

	<!-- Mobile Specific Metas
  ================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- CSS
  ================================================== -->
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'base.css')}" type="text/css">
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'skeleton.css')}" type="text/css">
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'layout.css')}" type="text/css">
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'custom.css')}" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Asap' rel='stylesheet' type='text/css'>

	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<!-- Favicons
	================================================== -->
	<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}">
	<link rel="shortcut icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
	<link rel="apple-touch-icon" sizes="72x72" href="${resource(dir: 'images', file: 'apple-touch-icon-72x72.png')}">
	<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-114x114.png')}">

	<r:require module="flip"/>
	<g:layoutHead/>
    <r:layoutResources />
</head>
<body class='container offset-by-four'>
    <div class='container sixteen columns' id='header'>
        <g:link controller="home">
	        <img src="${resource(dir: 'images', file: 'flippme.png')}" id='logo'/>
        </g:link>
    </div>
    <div class='container sixteen columns'>
        <g:layoutBody/>
    </div>
    <g:javascript library="application"/>
	<r:layoutResources />
</body>
</html>

<!DOCTYPE html>

<!-- 

Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 2.3.1

Version: 1.3

Author: KeenThemes

Website: http://www.keenthemes.com/preview/?theme=metronic

Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469

-->

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/public/public.jsp" %>

	<meta charset="utf-8" />

	<title>Metronic | Admin Dashboard Template</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="${basePath }common/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="${basePath }common/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="${basePath }common/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="${basePath }common/media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="${basePath }common/media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="${basePath }common/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="${basePath }common/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="${basePath }common/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES --> 

	<link href="${basePath }common/media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>

	<link href="${basePath }common/media/css/daterangepicker.css" rel="stylesheet" type="text/css" />

	<link href="${basePath }common/media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>

	<link href="${basePath }common/media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>

	<link href="${basePath }common/media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="${basePath }common/media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- BEGIN LOGO -->

				<a class="brand" href="index.html">

				<img src="${basePath }common/media/image/logo.png" alt="logo"/>

				</a>

				<!-- END LOGO -->

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

				<img src="media/image/menu-toggler.png" alt="" />

				</a>          

				<!-- END RESPONSIVE MENU TOGGLER -->            

				<!-- BEGIN TOP NAVIGATION MENU -->              

				<ul class="nav pull-right">


					<!-- END TODO DROPDOWN -->

					<!-- BEGIN USER LOGIN DROPDOWN -->

					<li class="dropdown user">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

							<img alt="" src="${basePath }common/media/image/avatar1_small.jpg" />
	
							<span class="username">Bob Nilson</span>


						</a>


					</li>

					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU --> 

			</div>

		</div>

		<!-- END TOP NAVIGATION BAR -->

	</div>

	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->

	<div class="page-container">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->        

			<ul class="page-sidebar-menu">

				<li>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

					<div class="sidebar-toggler hidden-phone"></div>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

				</li>


				<c:forEach items="${moduleList}" var="module">


					<li class="">
							<c:if test="${module.pid == null}">
								<a href="javascript:;"> <i class="${module.icon }"></i> <span class="title">${module.name }</span></a>
							</c:if>
						<ul class="sub-menu">
							<c:forEach items="${moduleList}" var="subModule">
								<c:if test="${subModule.pid == module.id}">
									<li>
										<a href="#" onclick="onLoad('${basePath }${subModule.url}')">${subModule.name}</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>

				</c:forEach>
			</ul>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div id="portlet-config" class="modal hide">

				<div class="modal-header">

					<button data-dismiss="modal" class="close" type="button"></button>

					<h3>Widget Settings</h3>

				</div>

				<div class="modal-body">

					Widget settings form goes here

				</div>

			</div>

			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->

						

						<!-- END BEGIN STYLE CUSTOMIZER -->    

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							Dashboard <small>statistics and more</small>

						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a href="index.html">Home</a> 

								<i class="icon-angle-right"></i>

							</li>

							<li><a href="#">Dashboard</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->
				<%-- <img alt="" src="${basePath }/common/media/image/start.JPG" width="100%" height="100%"> --%>
				 <div class="row-fluid">
				 	<div class="span12">
				 		<div class="portlet box light-grey">
			     			<iframe id="myFrame" src="" style="width: 100%;height:100%; border:none;" ></iframe>
			     		</div>
			     	</div>
			     </div>
			</div>

			<!-- END PAGE CONTAINER-->    

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">

			2016 &copy; Metronic by Neil.

		</div>

		<div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

		</div>

	</div>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->
	
	<script type="text/javascript">
			 function onLoad(url){
	   			$('#myFrame').attr("src",url); 
	    }
</script>

	<script src="${basePath }common/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="${basePath }common/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="${basePath }common/media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="media/js/excanvas.min.js"></script>

	<script src="media/js/respond.min.js"></script>  

	<![endif]-->   

	<script src="${basePath }common/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="${basePath }common/media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="${basePath }common/media/js/jquery.vmap.js" type="text/javascript"></script>   

	<script src="${basePath }common/media/js/jquery.vmap.russia.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.vmap.world.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.vmap.europe.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.vmap.germany.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.vmap.usa.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  

	<script src="${basePath }common/media/js/jquery.flot.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.flot.resize.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.pulsate.min.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/date.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/daterangepicker.js" type="text/javascript"></script>     

	<script src="${basePath }common/media/js/jquery.gritter.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/fullcalendar.min.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/jquery.sparkline.min.js" type="text/javascript"></script>  

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${basePath }common/media/js/app.js" type="text/javascript"></script>

	<script src="${basePath }common/media/js/index.js" type="text/javascript"></script>        

	<!-- END PAGE LEVEL SCRIPTS -->  

	<script>

		jQuery(document).ready(function() {    

		   App.init(); // initlayout and core plugins

		   Index.init();

		   Index.initJQVMAP(); // init index page's custom scripts

		   Index.initCalendar(); // init index page's custom scripts

		   Index.initCharts(); // init index page's custom scripts

		   Index.initChat();

		   Index.initMiniCharts();

		   Index.initDashboardDaterange();

		   Index.initIntro();

		});

	</script>

	<!-- END JAVASCRIPTS -->

<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>

<!-- END BODY -->

</html>
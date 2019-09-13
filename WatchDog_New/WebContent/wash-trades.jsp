	<%@page import="com.pojos.Trade"%>
	<%@page import="java.util.Set"%>
	
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html lang="en">
	
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- Tell the browser to be responsive to screen width -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<!-- Favicon icon -->
	<link rel="icon" type="image/jpg" sizes="16x16"
	href="../assets/images/favicon.jpg">
	<title>WATCHDOG - Wash Trade Detection Software</title>
	<!-- Custom CSS -->
	<link href="dist/css/style.css" rel="stylesheet">
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!---- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	<script>
	    window.onload = function () {
	
	    var chart = new CanvasJS.Chart("chartContainer", {
	    animationEnabled: false,  
	    title:{
	    text: "Wash Trades"
	    },
	    axisY: {
	    title: "Quantity",
	    valueFormatString: "#0,,.",
	    suffix: "",
	
	    },
	    data: [
	    {
	    showInLegend: true,
	    ValueFormatString: "#,### Units",
	    xValueFormatString: "YYYY",
	    type: "spline",
	    dataPoints: [
	    {x: new Date(2002, 0), y: 2506000},
	    {x: new Date(2003, 0), y: 6944000},
	    {x: new Date(2004, 0), y: 3386000},
	    {x: new Date(2005, 0), y: 2821000},
	    {x: new Date(2006, 0), y: 6026000},
	    {x: new Date(2007, 0), y: 2394000},
	    {x: new Date(2008, 0), y: 1872000},
	    {x: new Date(2009, 0), y: 2140000},
	    {x: new Date(2010, 0), y: 7289000},
	    {x: new Date(2011, 0), y: 4830000},
	    {x: new Date(2012, 0), y: 2009000},
	    {x: new Date(2013, 0), y: 2840000},
	    {x: new Date(2014, 0), y: 3386000},
	    {x: new Date(2015, 0), y: 1613000},
	    {x: new Date(2016, 0), y: 2821000},
	    {x: new Date(2017, 0), y: 2000000}
	    ]
	    },  {
	    type: "column",
	    name: "Wash Trades",
	    xValueFormatString: "YYYY",
	    yValueFormatString: "#,### Units",
	            borderWidth: 1,
	    <!-- type: "error", -->
	    <!-- name: "Wash Trade ", -->
	    <!-- toolTipContent: "<b>{name}:</b> {y[0]} - {y[1]} ", -->
	    dataPoints: [
	    {x: new Date(2003, 0), y: 6944000},
	    {x: new Date(2005, 0), y: 2821000},
	    {x: new Date(2007, 0), y: 2394000},
	    {x: new Date(2011, 0), y: 4830000},
	    {x: new Date(2013, 0), y: 2840000},
	    ]
	    }
	    ]
	    });
	    chart.render();
	
	    }
	</script>
	
	</head>
	
	<body class="skin-default-dark fixed-layout">
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<!-- <div class="preloader">
	        <div class="loader">
	            <div class="loader__figure"></div>
	            <p class="loader__label">Watchdog admin</p>
	        </div>
	    </div> -->
	
	
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper">
	<!-- ============================================================== -->
	<!-- Topbar header - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<header class="topbar">
	<nav class="navbar top-navbar navbar-expand-md navbar-dark">
	<!-- ============================================================== -->
	<!-- Logo -->
	<!-- ============================================================== -->
	<div class="navbar-header">
	<a class="navbar-brand" href="admin-index.html"> <!-- Logo icon -->
	<b> <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
	<!-- Dark Logo icon --> <img src="../assets/images/logo-icon.png"
	alt="homepage" class="dark-logo" /> <!-- Light Logo icon --> <img
	src="../assets/images/logo-light-icon.png" alt="homepage"
	class="light-logo" />
	</b> <!--End Logo icon --> <!-- Logo text -->
	<span> <!-- dark Logo text --> <img
	src="../assets/images/logo-text.png" alt="homepage"
	class="dark-logo" /> <!-- Light Logo text --> <img
	src="../assets/images/logo-light-text.png" class="light-logo"
	alt="homepage" /></span>
	</a>
	</div>
	<!-- ============================================================== -->
	<!-- End Logo -->
	<!-- ============================================================== -->
	<div class="navbar-collapse">
	<!-- ============================================================== -->
	<!-- toggle and nav items -->
	<!-- ============================================================== -->
	<ul class="navbar-nav mr-auto">
	<!-- This is  -->
	<li class="nav-item hidden-sm-up"><a
	class="nav-link nav-toggler waves-effect waves-light"
	href="javascript:void(0)"><i class="ti-menu"></i></a></li>
	<!-- ============================================================== -->
	<!-- Search -->
	<!-- ============================================================== -->
	<!-- <li class="nav-item search-box"> <a class="nav-link waves-effect waves-dark" href="javascript:void(0)"><i class="fa fa-search"></i></a>
	                            <form class="app-search">
	                                <input type="text" class="form-control" placeholder="Search &amp; enter"> <a class="srh-btn"><i class="fa fa-times"></i></a>
	                            </form>
	                        </li> -->
	</ul>
	<ul class="navbar-nav my-lg-0">
	<!-- ============================================================== -->
	<!-- User profile and search -->
	<!-- ============================================================== -->
	<li class="nav-item dropdown"><a
	class="nav-link dropdown-toggle text-muted waves-effect waves-dark"
	href="" data-toggle="dropdown" aria-haspopup="true"
	aria-expanded="false"><img src="../assets/images/users/1.jpg"
	alt="user" class="img-circle" width="30"></a></li>
	<!-- ============================================================== -->
	<!-- User profile and search -->
	<!-- ============================================================== -->
	</ul>
	</div>
	</nav>
	</header>
	<!-- ============================================================== -->
	<!-- End Topbar header -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- Left Sidebar - style you can find in sidebar.scss  -->
	<!-- ============================================================== -->
	<aside class="left-sidebar">
	<div class="d-flex no-block nav-text-box align-items-center">
	<span><img src="../assets/images/logo-icon.png"
	alt="elegant admin template"></span> <a
	class="waves-effect waves-dark ml-auto hidden-sm-down"
	href="javascript:void(0)"><i class="ti-menu"></i></a> <a
	class="nav-toggler waves-effect waves-dark ml-auto hidden-sm-up"
	href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
	</div>
	<!-- Sidebar scroll-->
	<div class="scroll-sidebar">
	<!-- Sidebar navigation-->
	<nav class="sidebar-nav">
	<ul id="sidebarnav">
	<li><a class="waves-effect waves-dark"
	href="admin-index.html" aria-expanded="false"><i
	class="fa fa-tachometer"></i><span class="hide-menu">Dashboard</span></a></li>
	<li><a class="waves-effect waves-dark"
	href="userViewAllTrades" aria-expanded="false"><i
	class="fa fa-table"></i><span class="hide-menu"></span>Trading
	Data</a></li>
	<li><a class="waves-effect waves-dark"
	href="viewAllWashTrades" aria-expanded="false"><i
	class="fa fa-bookmark-o"></i><span class="hide-menu"></span>Wash
	Trades</a></li>
	<li><a class="waves-effect waves-dark"
	href="admin-profile.html" aria-expanded="false"><i
	class="fa fa-user-circle-o"></i><span class="hide-menu">Profile</span></a></li>
	<div class="text-center m-t-30">
	<form name="form12" action="logout" method="post">
	<button type="submit" class="btn btn-primary">Logout</button>
	</form>
	</div>
	</ul>
	</nav>
	<!-- End Sidebar navigation -->
	</div>
	<!-- End Sidebar scroll-->
	</aside>
	<!-- ============================================================== -->
	<!-- End Left Sidebar - style you can find in sidebar.scss  -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- Page wrapper  -->
	<!-- ============================================================== -->
	<div class="page-wrapper">
	<!-- ============================================================== -->
	<!-- Container fluid  -->
	<!-- ============================================================== -->
	<div class="container-fluid">
	<!-- ============================================================== -->
	<!-- Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<div class="row page-titles">
	<div class="col-md-5 align-self-center">
	<h4 class="text-themecolor">
	<strong>Wash Trades</strong>
	</h4>
	</div>
	<div class="col-md-7 align-self-center text-right">
	<div class="d-flex justify-content-end align-items-center">
	<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
	<li class="breadcrumb-item active">Wash Trades</li>
	</ol>
	<button type="button"
	class="btn btn-success d-none d-lg-block m-l-15">
	Report</button>
	</div>
	</div>
	</div>
	<!-- ============================================================== -->
	<!-- End Bread crumb and right sidebar toggle -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- Start Page Content -->
	<!-- ============================================================== -->
	<!--  <div id="chartContainer" style="height: 300px; width: 100%;"></div> -->
	
	<div class="row">
	<!-- column -->
	<div class="col-6">
	<div class="card" style="border-radius: 10px;">
	<div class="card-body">
	<div class="table-responsive" style="overflow: hidden;">
	<div class="row">
	<div class="col-lg-6 row" style="padding-bottom: 10px;">
	<h4 style="padding-top: 7px;" class="col-lg-5">Trader</h4>
	<input type="text" id="" class="custom-select b-0 col-lg-6"
	disabled></input>
	</div>
	<div class="col-lg-6 row" style="padding-bottom: 10px;">
	<h4 style="padding-top: 7px;" class="col-lg-5">Broker</h4>
	<input type="text" id="" class="custom-select b-0 col-lg-6"
	disabled></input>
	</div>
	</div>
	
	<%
	                                       
	                                        //java.util.HashSet.Set
	                                        Set<Set<Trade>> trade =  (Set<Set<Trade>>)request.getAttribute("data");
	                                       
	for(Set<Trade> set:trade)
	{
	%>
	<table class="table">
	<%
	for (Trade t : set) {
	%>
	<%-- Arranging data in tabular form
	       --%>
	<tr>
	
	<td><%=t.getTradeId()%></td>
	<td><%=t.getTrader().getTraderName()%></td>
	<td><%=t.getTimeStamp()%></td>
	<td><%=t.isTradeType()%></td>
	<td><%=t.getSecurityId()%></td>
	<td><%=t.getQty()%></td>
	<td><%=t.getDealPrice()%></td>
	<td><%=t.getFirmId()%></td>
	<td><%=t.getBrokerId()%></td>
	
	</tr>
	<%
	} %>
	
	
	</table>
	<%
	} %>
	
	<%-- Arranging data in tabular form
	       --%>
	
	
	<div class="row">
	<div class="col-lg-6 row" style="padding-bottom: 10px;">
	<h4 style="padding-top: 7px;" class="col-lg-5">Profit</h4>
	<input type="text" id="" class="custom-select b-0 col-lg-6"
	disabled></input>
	</div>
	<div class="col-lg-6 row" style="padding-bottom: 10px;">
	<h4 style="padding-top: 7px;" class="col-lg-5">Count</h4>
	<input type="text" id="" class="custom-select b-0 col-lg-6"
	disabled></input>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	
	<!-- ============================================================== -->
	<!-- End PAge Content -->
	<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Container fluid  -->
	<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Page wrapper  -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- footer -->
	<!-- ============================================================== -->
	<footer class="footer"> © 2019 Watchdog Admin by Team 8,
	Batch 1, 2019 Grads Batch. </footer>
	<!-- ============================================================== -->
	<!-- End footer -->
	<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script src="../assets/node_modules/jquery/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script src="../assets/node_modules/popper/popper.min.js"></script>
	<script src="../assets/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- slimscrollbar scrollbar JavaScript -->
	<script src="dist/js/perfect-scrollbar.jquery.min.js"></script>
	<!--Wave Effects -->
	<script src="dist/js/waves.js"></script>
	<!--Menu sidebar -->
	<script src="dist/js/sidebarmenu.js"></script>
	<!--stickey kit -->
	<script
	src="../assets/node_modules/sticky-kit-master/dist/sticky-kit.min.js"></script>
	<script src="../assets/node_modules/sparkline/jquery.sparkline.min.js"></script>
	<!--Custom JavaScript -->
	<script src="dist/js/custom.min.js"></script>
	
	</body>
	
	</html>
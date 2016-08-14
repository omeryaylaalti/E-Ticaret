<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>E-Ticaret Sitesi Yönetim Paneli</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="description" content="">
<meta name="keywords"
	content="admin, bootstrap,admin template, bootstrap admin, simple, awesome">
<meta name="author" content="">

<!-- Bootstrap -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/third/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">
<link href="assets/css/animate.css" rel="stylesheet">
<link href="assets/third/morris/morris.css" rel="stylesheet">
<link rel="stylesheet" href="assets/third/nifty-modal/css/component.css">
<link rel="stylesheet"
	href="assets/third/sortable/sortable-theme-bootstrap.css">
<link rel="stylesheet" href="assets/third/icheck/skins/minimal/grey.css">
<link rel="stylesheet"
	href="assets/third/select/bootstrap-select.min.css">
<link rel="stylesheet" href="assets/third/summernote/summernote.css" />
<link rel="stylesheet"
	href="assets/third/magnific-popup/magnific-popup.css">
<link rel="stylesheet" href="assets/third/pace/pace-theme-minimal.css">
<link rel="stylesheet" href="assets/third/datepicker/css/datepicker.css" />
<link rel="stylesheet" href="assets/css/buttons.css" />
<link rel="stylesheet"
	href="assets/easy-pie-chart/jquery.easy-pie-chart.css" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
<link rel="shortcut icon" href="assets/img/favicon.ico">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$(".nav-tabs a").click(function() {
			$(this).tab('show');
		});

	});
</script>
</head>
<body>
	<!--Çıkış Yapma Modeli -->

	<div class="md-modal md-fall" id="logout-modal">
		<div class="md-content">
			<h3>
				<strong>Yönetim Paneli</strong> Bilgilendirme
			</h3>
			<div>
				<p class="text-center">Bu Sayfadan Çıkmak İstiyor musunuz?</p>
				<p class="text-center">
					<button class="btn btn-danger md-close">Hayır!</button>
					<a href="login.jsp" class="btn btn-success md-close">Evet,
						İstiyorum</a>
				</p>
			</div>
		</div>
	</div>
	<!--Sol Menü Kısmı -->
	<div class="left side-menu">

		<div class="body rows scroll-y  fadeInLeftBig">
			<div class="slimScrollDiv"
				style="position: relative; overflow: hidden; width: auto; height: 529px;">
				<div class="sidebar-inner slimscroller"
					style="overflow: hidden; width: auto; height: 529px;">
					<div class="media">
						<a class="pull-left" href="#"> <img
							class="media-object img-circle" src="assets/img/admin.png"
							alt="Avatar">
						</a>
						<div class="media-body">
							Hoşgeldiniz,
							<h4 class="media-heading">
								<strong>Site Yöneticisi</strong>
							</h4>
							<a class="md-trigger" data-modal="logout-modal">Çıkış Yap</a>
						</div>
					</div>
					<br>
					<div id="sidebar-menu">
						<ul>
							<li><a href="AdminPaneli.jsp"><i class="fa fa-home"></i>
									Anasayfa</a></li>
							<li><a href="kategoriler.jsp"><i class="fa fa-bug"></i><i
									class="fa fa-angle-double-down i-right"></i>Kategoriler</a></li>
							<li><a href="#"><i class="fa fa-bug"></i><i
									class="fa fa-angle-double-down i-right"></i>Siparişler</a></li>
							<li><a href="urunler.jsp"><i class="fa fa-edit"></i><i
									class="fa fa-angle-double-down i-right"></i>Ürünler</a></li>
							<li class="active"><a href="#"><i class="fa fa-table"></i>Müşteri
									Bilgileri</a></li>
						</ul>
						<div class="clear"></div>
					</div>
				</div>
				<div class="slimScrollBar"
					style="width: 7px; position: absolute; top: 16px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 513.47px; background: rgb(0, 0, 0);"></div>
				<div class="slimScrollRail"
					style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
			</div>
		</div>
	</div>

	<!--Sağ Taraf -->
	<div class="right content-page">
		<div class="header content rows-content-header">

			<!-- Button mobile view to collapse sidebar menu -->
			<button class="button-menu-mobile show-sidebar">
				<i class="fa fa-bars"></i>
			</button>

			<div class="navbar navbar-default" role="navigation">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<i class="fa fa-angle-double-down"></i>
						</button>
					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right top-navbar">

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"><strong>Site Yöneticisi</strong> <i
									class="fa fa-chevron-down i-xs"></i></a>
								<ul class="dropdown-menu animated half flipInX">
									<li><a class="md-trigger" data-modal="logout-modal">Çıkış
											Yap</a></li>
								</ul></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>

		<!-- ============================================================== -->
		<!-- Start Content here -->
		<!-- ============================================================== -->
		<div class="body content rows scroll-y">

			<!-- Page header -->
			<div class="page-heading animated fadeInDownBig">
				<h1>Ürünler</h1>
			</div>
			<!-- End page header -->

			<!-- Start info box -->
			<div class="row">
				<div id="sales-report" class="collapse in">
					<div class="table-responsive">
						<form action="UrunEkleveSil" method="get">
							<table data-sortable="" class="table table-striped"
								data-sortable-initialized="true">
								<tr>
									<td>Ürün Kategori ID</td>
									<td><input type="number" name="uruncatid" value="<%=id%>" /></td>
								</tr>
								<tr>
									<td>Ürün Adı</td>
									<td><input type="date" name="urunname" /></td>
								</tr>
								<tr>
									<td>Ürün Fiyatı</td>
									<td><input type="number" name="urunfiyat" /></td>
								</tr>
								<tr>
									<td>Ürün Stok Giriniz</td>
									<td><input type="number" name="urunstok" /></td>
								</tr>

								<tr>
									<td>Ürün Fotoğraf</td>
									<td><input type="text" name="urunphoto" /></td>
								</tr>
								<tr>
									<td>Ürün Detayı</td>
									<td><input type="text" name="urundetay" /></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><input type="submit" class="btn btn-default"
										value="Ürün Ekle"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>

		</div>

		<footer> © 2016 Bu panel <a href="">Ömer Yaylaaltı</a>
		tarafından tasarlanmıştır. İstanbul, Türkiye </footer>

	</div>
	<!-- ============================================================== -->
	<!-- End content here -->
	<!-- ============================================================== -->
	</div>

	<!-- End of page -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="assets/js/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/third/knob/jquery.knob.js"></script>
	<script src="assets/third/slimscroll/jquery.slimscroll.min.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="assets/third/morris/morris.js"></script>
	<script src="assets/third/nifty-modal/js/classie.js"></script>
	<script src="assets/third/nifty-modal/js/modalEffects.js"></script>
	<script src="assets/third/sortable/sortable.min.js"></script>
	<script src="assets/third/select/bootstrap-select.min.js"></script>
	<script src="assets/third/summernote/summernote.js"></script>
	<script src="assets/third/magnific-popup/jquery.magnific-popup.min.js"></script>
	<script src="assets/third/pace/pace.min.js"></script>
	<script src="assets/third/input/bootstrap.file-input.js"></script>
	<script src="assets/third/datepicker/js/bootstrap-datepicker.js"></script>
	<script src="assets/third/icheck/icheck.min.js"></script>
	<script src="assets/third/wizard/jquery.snippet.min.js"></script>
	<script src="assets/third/wizard/jquery.easyWizard.js"></script>
	<script src="assets/third/wizard/scripts.js"></script>
	<script src="assets/js/lanceng.js"></script>
	<script src="assets/scripts/custom/calendar.js"></script>

</body>
</html>
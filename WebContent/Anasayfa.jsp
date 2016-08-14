<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.eticaretforsalesite.controller.LoginController" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" ng-app="myApp">
<head>
<title>Smart Shop</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Smart Shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 





















</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- pignose css -->
<link href="css/pignose.layerslider.css" rel="stylesheet"
	type="text/css" media="all" />


<!-- //pignose css -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js"></script>
<!-- cart -->
<!-- for bootstrap working -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //for bootstrap working -->
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic'
	rel='stylesheet' type='text/css'>
<script src="js/jquery.easing.min.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.9/angular.js"></script>
<script src="js/angular-re-captcha.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						$
								.ajax({
									type : 'GET',
									url : 'KategoriListele',
									dataType : "json",
									success : function(response) {
										for (var i = 0; i < response.result.length; i++) {
											var ustkatname = response.result[i].text;
											var ustkatid = response.result[i].id;
											var altsonuc = response.result[i].altsonuc;
											$("#div_data")
													.append(
															'<li id="ustcatId_'+ustkatid+'"class="dropdown menu__item"><a href="#" class="dropdown-toggle menu__link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">'
																	+ ustkatname
																	+ '<span class="caret"></span></a><ul class="dropdown-menu multi-column columns-3"><div class="row"><div class="col-sm-3 multi-gd-img"><ul id="Id_'+ustkatid+'" class="multi-column-dropdown"></ul></div></div></ul></li>');
											for (var j = 0; j < altsonuc.length; j++) {
												var altkatname = altsonuc[j].alttext;
												var altkatid = altsonuc[j].altid;
												var result = '<dl><dt id="altcatId_'+altkatid+'">'
														+ altkatname
														+ '<dt></dl>';
												$("#Id_" + ustkatid).append(
														result);
												var enaltsonuc = altsonuc[j].enaltsonuc;
												for (var k = 0; k < enaltsonuc.length; k++) {
													var enaltkategoriad = enaltsonuc[k].enalttext;
													var enaltkategoriid = enaltsonuc[k].enaltid;
													var sonuc = '<dd class="dropdown menu__item id="enaltcatId_'+enaltkategoriid+'"><a href="alt_urunler.html?ID='
															+ enaltkategoriid
															+ '">'
															+ enaltkategoriad
															+ '</a><dd>';
													$("#altcatId_" + altkatid)
															.append(sonuc);

												}
											}
										}
										$("#div_data")
												.append(
														'<li class="menu__item"><a class="menu__link" href="contact.html">Iletişim</a></li>');
									}
								});

						$
								.ajax({
									type : 'GET',
									url : 'TumUrunler',
									dataType : "json",
									success : function(response) {
										console.log(response.result);
										for (var i = 0; i < response.result.length; i++) {
											var urunid = response.result[i].urunid;
											var fotourl = response.result[i].foto;
											var urunname = response.result[i].name;
											var urunfiyat = response.result[i].fiyat;
											$("#tumurunler")
													.append(
															'<div class="col-md-3 product-men" ><div class="men-pro-item simpleCart_shelfItem"><div class="men-thumb-item"><img src="'+fotourl+'" alt="" class="pro-image-front"><img src="'+fotourl+'" alt="" class="pro-image-back"><div class="men-cart-pro"><div class="inner-men-cart-pro"><a href="urundetay.html?NO='
																	+ urunid
																	+ '" class="link-product-add-cart">Ürün Detayı</a></div></div><span class="product-new-top">Yeni</span></div><div class="item-info-product "><h4><a href="urundetay.html?NO='
																	+ urunid
																	+ '">'
																	+ urunname
																	+ '</a></h4><div class="info-product-price"><span class="item_price">'
																	+ urunfiyat
																	+ ' TL</span></div><a href="sepet.html?NO='
																	+ urunid
																	+ '" class="item_add single-item hvr-outline-out button2">Sepete Ekle</a></div></div></div>');

										}
									}
								});

					});
	  
</script>
</head>
<body ng-controller="AppCtrl">
	<!-- header -->
	<div class="header">
		<div class="container">
			<ul>
				<li><span class="glyphicon glyphicon-time" aria-hidden="true"></span>Online
					ve Hızlı Alısveris</li>
				<li><span class="glyphicon glyphicon-shopping-cart"
					aria-hidden="true"></span>%100 Güvenli Satıs Sistemi</li>
				<li><span class="glyphicon glyphicon-envelope"
					aria-hidden="true"></span><a href="mailto:info@example.com">smartshop@gmail.com</a></li>
			</ul>
		</div>
	</div>
	<!-- //header -->
	<!-- header-bot -->
	<div class="header-bot">
		<div class="container">
			<div class="col-md-3 header-left">
				<h1>
					<a href="Anasayfa.jsp"><img src="images/logo3.jpg"></a>
				</h1>
			</div>
			<div class="col-md-6 header-middle">
				<form>
					<div class="search">
						<input type="search" value="Arama" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Arama';}"
							required="">
					</div>
					<div class="section_room">
						<select id="country" onchange="change_country(this.value)"
							class="frm-field required">
							<option value="null">Tüm Kategoriler</option>
							<option value="null">Teknoloji</option>
							<option value="AX">Giyim</option>
							<option value="AX">Yaşam</option>
							<option value="AX">Kişisel Bakım</option>
						</select>
					</div>
					<div class="sear-sub">
						<input type="submit" value=" ">
					</div>
					<div class="clearfix"></div>
				</form>
			</div>
			<div class="col-md-3 header-right footer-bottom">
				<ul>
					<li><a href="#" class="use1" data-toggle="modal"
						data-target="#myModal4"><span>Giriş Yap</span></a></li>
					<li><a class="fb" href="#"></a></li>
					<li><a class="twi" href="#"></a></li>
					<li><a class="insta" href="#"></a></li>
					<li><a class="you" href="#"></a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //header-bot -->
	<!-- banner -->
	<div class="ban-top">
		<div class="container">
			<div class="top_nav_left">
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse menu--shylock"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav menu__list" id="div_data">
							<li class="active menu__item menu__item--current"><a
								class="menu__link" href="Anasayfa.jsp">Anasayfa<span
									class="sr-only">(current)</span></a></li>

						</ul>
					</div>
				</div>
				</nav>
			</div>
			<div class="top_nav_right">
				<div class="cart box_1">
					<a href="sepet.html">
						<h3>
							<div class="total">
								<i class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></i>
								<span class="simpleCart_total"></span> (<span
									id="simpleCart_quantity" class="simpleCart_quantity"></span>
								ürün)
							</div>
						</h3>
					</a>
					<p>
						<a href="javascript:;" class="simpleCart_empty">Sepeti Boşalt</a>
					</p>

				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //banner-top -->
	<!-- banner -->
	<div class="banner-grid">
		<div id="visual">
			<div class="slide-visual">
				<!-- Slide Image Area (1000 x 424) -->
				<ul class="slide-group">
					<li><img class="img-responsive" src="images/ba1.jpg"
						alt="Dummy Image" /></li>
					<li><img class="img-responsive" src="images/ba2.jpg"
						alt="Dummy Image" /></li>
					<li><img class="img-responsive" src="images/ba3.jpg"
						alt="Dummy Image" /></li>
				</ul>

				<!-- Slide Description Image Area (316 x 328) -->
				<div class="script-wrap">
					<ul class="script-group">
						<li><div class="inner-script">
								<img class="img-responsive" src="images/baa1.jpg"
									alt="Dummy Image" />
							</div></li>
						<li><div class="inner-script">
								<img class="img-responsive" src="images/baa2.jpg"
									alt="Dummy Image" />
							</div></li>
						<li><div class="inner-script">
								<img class="img-responsive" src="images/baa3.jpg"
									alt="Dummy Image" />
							</div></li>
					</ul>
					<div class="slide-controller">
						<a href="#" class="btn-prev"><img src="images/btn_prev.png"
							alt="Prev Slide" /></a> <a href="#" class="btn-play"><img
							src="images/btn_play.png" alt="Start Slide" /></a> <a href="#"
							class="btn-pause"><img src="images/btn_pause.png"
							alt="Pause Slide" /></a> <a href="#" class="btn-next"><img
							src="images/btn_next.png" alt="Next Slide" /></a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
		<script type="text/javascript" src="js/pignose.layerslider.js"></script>
		<script type="text/javascript">
			//<![CDATA[
			$(window).load(function() {
				$('#visual').pignoseLayerSlider({
					play : '.btn-play',
					pause : '.btn-pause',
					next : '.btn-next',
					prev : '.btn-prev'
				});
			});
			//]]>
		</script>

	</div>
	<!-- //banner -->

	<!-- product-nav -->

	<div class="product-easy">
		<div class="container">

			<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
			<script type="text/javascript">
				$(document).ready(function() {
					$('#horizontalTab').easyResponsiveTabs({
						type : 'default', //Types: default, vertical, accordion           
						width : 'auto', //auto or any width like 600px
						fit : true
					// 100% fit in a container
					});
				});
			</script>
			<div class="sap_tabs">
				<div id="horizontalTab"
					style="display: block; width: 100%; margin: 0px;">
					<ul class="resp-tabs-list">
						<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>Sitedeki
								Tüm Ürünler</span></li>
					</ul>
					<div class="resp-tabs-container">
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0"
							id="tumurunler">
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="col-md-3 footer-left">
				<h2>
					<a href="index.html"><img src="images/logo3.jpg" alt=" " /></a>
				</h2>
				<p>Online Alışveriş yapabileceğiniz akıllı alışveriş sitesi</p>
			</div>
			<div class="col-md-9 footer-right">
				<div class="col-sm-6 newsleft">
					<h3>Yeni Haberleri Almak için EMail adresinizi kaydedin!</h3>
				</div>
				<div class="col-sm-6 newsright">
					<form>
						<input type="text" value="Email" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Email Adresiniz';}"
							required=""> <input type="submit" value="Kaydet">
					</form>
				</div>
				<div class="clearfix"></div>
				<div class="sign-grds">
					<div class="col-md-4 sign-gd">
						<h4>Hızlı Menü</h4>
						<ul>
							<li><a href="index.html">Anasayfa</a></li>
							<li><a href="mens.html">Teknoloji</a></li>
							<li><a href="womens.html">Giyim</a></li>
							<li><a href="electronics.html">Yaşam</a></li>
							<li><a href="codes.html">Kişisel Bakım</a></li>
							<li><a href="contact.html">Iletişim</a></li>
						</ul>
					</div>

					<div class="col-md-4 sign-gd-two">
						<h4>Mağaza Bilgileri</h4>
						<ul>
							<li><i class="glyphicon glyphicon-map-marker"
								aria-hidden="true"></i>Adres : Ataşehir Bulvarı, Mimarsinan
								Camii <span>İstanbul</span></li>
							<li><i class="glyphicon glyphicon-envelope"
								aria-hidden="true"></i>Email : <a href="mailto:info@example.com">smartshop@gmail.com</a></li>
							<li><i class="glyphicon glyphicon-earphone"
								aria-hidden="true"></i>Telefon : 0216 666 666</li>
						</ul>
					</div>
					<div class="col-md-4 sign-gd flickr-post">
						<h4>Hızlı Bakış</h4>
						<ul>
							<li><a href="single.html"><img src="images/b15.jpg"
									alt=" " class="img-responsive" /></a></li>
							<li><a href="single.html"><img src="images/b16.jpg"
									alt=" " class="img-responsive" /></a></li>
							<li><a href="single.html"><img src="images/b17.jpg"
									alt=" " class="img-responsive" /></a></li>
							<li><a href="single.html"><img src="images/b18.jpg"
									alt=" " class="img-responsive" /></a></li>
							<li><a href="single.html"><img src="images/b15.jpg"
									alt=" " class="img-responsive" /></a></li>
							<li><a href="single.html"><img src="images/b16.jpg"
									alt=" " class="img-responsive" /></a></li>
							<li><a href="single.html"><img src="images/b17.jpg"
									alt=" " class="img-responsive" /></a></li>
							<li><a href="single.html"><img src="images/b18.jpg"
									alt=" " class="img-responsive" /></a></li>
							<li><a href="single.html"><img src="images/b15.jpg"
									alt=" " class="img-responsive" /></a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="clearfix"></div>
			<p class="copy-right">
				&copy 2016 Smart Shop. All rights reserved | Design by <a
					href="http://w3layouts.com/">W3layouts</a>
			</p>
		</div>
	</div>
	<!-- //footer -->
	<!-- login -->
	<div class="modal fade" id="myModal4" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content modal-info">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body modal-spa">
					<div class="login-grids">
						<div class="login">
							<div class="login-bottom">
								<h3>Siteye Kayıt Ol</h3>
								<form action="RegisterController" method="post"
									name="registerForm" role="form" ng-submit="register()"
									novalidate>
									<div class="sign-up">
										<h4>Adınız - Soyadınız :</h4>
										<input type="text" value="Adınız - Soyadınız"
											onfocus="this.value = '';" name="name"
											onblur="if (this.value == '') {this.value = 'Adınız - Soyadınız';}"
											required="">

									</div>
									<div class="sign-in">
										<h4>Email Adresiniz:</h4>
										<input type="text" value="Email Adresiniz" name="email"
											onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = 'Email Adresiniz';}"
											required="">
									</div>
									<div class="sign-up">
										<h4>Parolanızı giriniz :</h4>
										<input type="password" value="Password" name="password"
											onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = 'Password';}"
											required="">

									</div>
									<div class="sign-up">
										<div re-captcha ng-model="user.captcha"></div>
									</div>
									<div class="sign-up">
										<input type="submit" ng-disabled="registerForm.$invalid"
											value="KAYIT OL">
									</div>

								</form>
							</div>
							<script>
								angular
										.module('myApp', [ 'reCAPTCHA' ])
										.config(
												function(reCAPTCHAProvider) {
													// required, please use your own key :)
													reCAPTCHAProvider
															.setPublicKey('6LfyK-0SAAAAAAl6V9jBGQgPxemtrpIZ-SPDPd-n');
													// optional
													reCAPTCHAProvider
															.setOptions({
																theme : 'normal'
															});
												})
										.controller(
												'AppCtrl',
												function($scope, reCAPTCHA) {
													$scope.user = {};
													// or you can also set key here
													reCAPTCHA
															.setPublicKey('6LfyK-0SAAAAAAl6V9jBGQgPxemtrpIZ-SPDPd-n');
													$scope.register = function() {
														if ($scope.registerForm.$valid) {
															$scope.showdialog = true;
															console
																	.log('Form is valid');
														}
													}
												})
							</script>
							<div class="login-right">
								<h3>Hesabınıza Giriş Yapınız</h3>
								<form action="Login" method="get">

									<div class="sign-in">
										<h4>Email Adresiniz:</h4>
										<input type="text" value="Email Adresiniz"
											onfocus="this.value = '';" name="email"
											onblur="if (this.value == '') {this.value = 'Email Adresiniz';}"
											required="">
									</div>
									<div class="sign-in">
										<h4>Parolanız :</h4>
										<input type="password" value="Password" name="password"
											onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = 'Password';}"
											required="">
									</div>
									<div class="sign-in">
										<input type="submit" value="GIRIS YAP">
									</div>
								</form>
							</div>
							<div class="clearfix"></div>
						</div>
						<p>
							By logging in you agree to our <a href="#">Terms and
								Conditions</a> and <a href="#">Privacy Policy</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //login -->
</body>
</html>
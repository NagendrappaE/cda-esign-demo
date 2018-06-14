<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="FinSmart Finance" content="all,follow">
    <meta name="FinSmart Finance" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>FinSmart Finance</title>

    <meta name="keywords" content="">

   <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet"> 

    <!-- Bootstrap and Font Awesome css -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <!-- Css animations  -->
    <link href="css/animate.css" rel="stylesheet">

    <!-- Theme stylesheet, if possible do not edit this stylesheet -->
    <link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.blue.css" rel="stylesheet" id="theme-stylesheet">

   
    <!-- Responsivity for older IE -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

    <!-- owl carousel css -->

    <!-- <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
 --></head>

<body>

    <div id="all">

          <header>

            <!-- *** TOP ***
_________________________________________________________ -->
            <!-- <div id="top">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-5 contact">
                            <p class="hidden-sm hidden-xs">Contact us on +420 777 555 333</p>
                            <p class="hidden-md hidden-lg"><a href="#" data-animate-hover="pulse"><i class="fa fa-phone"></i></a>  <a href="#" data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
                            </p>
                        </div>
                        <div class="col-xs-7">
                            <div class="login">
                                <a href="register.html" class="btn btn-success"><span class="hidden-xs text-uppercase">Free trail</span></a>
                                <a class="btn btn-info" href="#myModal" class="trigger-btn" data-toggle="modal"><span class="hidden-xs text-uppercase">Login</span></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div> -->

            <!-- *** TOP END *** -->

            <!-- *** NAVBAR ***
    _________________________________________________________ -->

            <div class="navbar-affixed-top" data-spy="affix" data-offset-top="200">

                <div class="navbar navbar-default yamm" role="navigation" id="navbar">

                    <div class="container">
                        <div class="navbar-header">

                            <a class="navbar-brand home" href="#">
                            	FinSmart Finance
                               <!--  <img src="img/ezip-logo.png" alt="Ezip logo" class="hidden-xs hidden-sm"> -->
                                <img src="img/ezip-logo.png" alt="Ezip logo" class="visible-xs visible-sm"><span class="sr-only">Ezip - go to homepage</span>
                            </a>
                            <div class="navbar-buttons">
                                <button type="button" class="navbar-toggle btn-template-main" data-toggle="collapse" data-target="#navigation">
                                    <span class="sr-only">Toggle navigation</span>
                                    <i class="fa fa-align-justify"></i>
                                </button>
                            </div>
                        </div>
                        <!--/.navbar-header -->

                        <div class="navbar-collapse collapse" id="navigation">

                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="index.html">Features</a>                 
                                </li>
                                

                                <li class="dropdown">
                                    <a href="#">Contact</a>
                                </li>
                                
                               <li><ul style="margin-top: 18px;"><li><!-- <a href="register.html" class="btn btn-success"><span class="hidden-xs text-uppercase">Free trail</span></a> -->
                                <a style="margin-left:15px;" class="btn btn-info" href="#"><span class="hidden-xs text-uppercase">Login</span></a></li></ul></li>
                            </ul>                     
                        </div>
                        <!--/.nav-collapse -->



                        <div class="collapse clearfix" id="search">

                            <form class="navbar-form" role="search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search">
                                    <span class="input-group-btn">

                    <button type="submit" class="btn btn-template-main"><i class="fa fa-search"></i></button>

                </span>
                                </div>
                            </form>

                        </div>
                        <!--/.nav-collapse -->

                    </div>


                </div>
                <!-- /#navbar -->

            </div>

            <!-- *** NAVBAR END *** -->

        </header>


		<section class="loginSec" style="background-color:#f4f4f4;margin-bottom:0px !important;">
        	<div class="container-fluid">
        		<div class="row">        		
	        		<div class="col-md-4" style="margin-top:1%;">
	        			<div class="box-bg-white leftBlock">
	        				<div class="text-center">
	        					<img src="/resources/img/Bulb.jpg" class="img-responsive">
	        					<h1 class="text-blue">FinSmart Finance</h1>
	        					<h3 class="text-orange">Finance make easy</h3>
	        				</div>
	        			</div>
	        		</div>
	        		
	        		<div class="col-md-8">
	        			<div class="box-bg-white validate-form">
	        				<h1 class="text-orange text-center">Customer Details</h1>
	        				<form class="login100-form " action="register" method="post">
								<div class="row">
									<div class="col-md-6">
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="customerName" value="Rakesh Sharma">
											<span class="focus-input100" data-placeholder="Name"></span>
										</div>
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="email" value="rakesh@gmail.com">
											<span class="focus-input100" data-placeholder="Email Id"></span>
										</div>
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="loantype" value="Home Loan">
											<span class="focus-input100" data-placeholder="Loan Type"></span>
										</div>
										
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="collectAmount" value="2,00,000">
											<span class="focus-input100" data-placeholder="Disbursed Amount"></span>
										</div>
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="email" value="13%">
											<span class="focus-input100" data-placeholder="Interest Rate"></span>
										</div>
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="startDate" value="07-04-2018">
											<span class="focus-input100" data-placeholder="Installment Starts on"></span>
										</div>
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="aadhar">
											<span class="focus-input100" data-placeholder="Aadhar Number"></span>
										</div>
									</div>
						
									<div class="col-md-6">
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="mobile" value="9874563217">
											<span class="focus-input100" data-placeholder="Mobile Number"></span>
										</div>
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="loanRefNo" value="147852369777">
											<span class="focus-input100" data-placeholder="Loan Reference Number"></span>
										</div>
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="sanctionedAmount" value="5,00,000">
											<span class="focus-input100" data-placeholder="Sanctioned Amount"></span>
										</div>
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="loanTenure" value="24">
											<span class="focus-input100" data-placeholder="Loan Tenure"></span>
										</div>
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="emiAmount" value="18,600">
											<span class="focus-input100" data-placeholder="EMI Amount"></span>
										</div>
										
										<div class="wrap-input100 validate-input">
											<input class="input100" type="text" name="frequency" value="Monthly">
											<span class="focus-input100" data-placeholder="Frequency"></span>
										</div>
										
									</div>																	
								</div>
								<div class="row text-center">
									<div class="col-md-12">
										<button type="button" class="btn btn-default btn-close" >Cancel</button>
										<button type="submit" class="btn btn-default btn-save"  name="Save" value="Save">Payments to NACH</button>
									</div>
								</div>
								</form>
	        			</div>
	        		</div>        		
        		</div>

        	</div>
        </section>
        
        
        	        	
        <div id="copyright">
            <div class="container">
                <div class="col-md-12">
                    <p class="pull-left">© 2018 Evolvus Ltd. All rights reserved.</p>
                    <!-- <p class="pull-right">Template by <a href="https://bootstrapious.com">Bootstrapious</a> & <a href="https://fity.cz">Fity.cz</a>
                         Not removing these links is part of the license conditions of the template. Thanks for understanding :) If you want to use the template without the attribution links, you can do so after supporting further themes development at https://bootstrapious.com/donate 
                    </p> -->

                </div>
            </div>
        </div>
        <!-- /#copyright -->

        <!-- *** COPYRIGHT END *** -->



    </div>
    <!-- /#all -->

    <!-- #### JAVASCRIPT FILES ### -->
	
	<a href="#0" class="cd-top">Top</a>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>
        window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
    </script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <script src="js/jquery.cookie.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/jquery.parallax-1.1.3.js"></script>
    <script src="js/front.js"></script>
     <script src="js/main.js"></script>
    

    

    <!-- owl carousel -->
    <script src="js/owl.carousel.min.js"></script>
	<script>
	$('.launch-modal').on('click', function(e){
	    e.preventDefault();
	    $( '#' + $(this).data('modal-id') ).modal();
	});
	</script>
</body>

</html>

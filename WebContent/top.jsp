<table>
                <tbody><tr>
                <td><h1 style="margin:5px 0;">{{message}}</h1></td>
                <td><img src="images/logo.jpg" style="height:30px;width:30px"/></td>                               
                </tr>
                </tbody></table>  
                <table align="right">
                <tr><td><span class="white"> Welcome ${username}  <img src="images/acc.png" style="height:25px;width:20px"> </span></td></tr>                                               
                <tr><td><a href="login.jsp" class="button red xlarge" ><span class="white">Logout</span></a></td></tr>
                </table>              
                <div class="redribbon"></div>                                
                <div class="overtop {{color}}">{{overtopmsg}}</div>                
<div class="slidebox">                
<div class="slideShowContainer">
<ul class="slideShow">
<a><img src="images/add2.jpg" /></a>
<a><img src="images/add3.jpg"  /></a>
</ul>
</div> 
</div>     
   
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<script>
$(function(){	
	
	var slides = $('.slideShow>a');
	var slideCount = 0;
	var totalSlides = slides.length;
	var slideCache = [];
	
	(function preLoader(){		
		if(slideCount < totalSlides){			
			slideCache[slideCount] = new Image();
			slideCache[slideCount].src = slides.eq(slideCount).find('img').attr('src');
			slideCache[slideCount].onload=function(){
				slideCount++;
				preLoader();
			}
		}
		else{						
			slideCount = 0;
			SlideShow();
		}
	}());
	
	function SlideShow(){	
		
		slides.eq(slideCount).fadeIn(3000).delay(5000).fadeOut(500, function(){
			slideCount<totalSlides -1 ? slideCount++: slideCount=0;					
			SlideShow();
		})
	}
	
})
</script>



// $(function(){
// 	$('.slideshow').each(function(){ //each(=while문)>> 반복해서 수행하겠다 
// 		var $slides=$(this).find('img'), //slideshow 안에있는 Img를 찾아와라
// 			slideCount=$slides.length, //img로 구성되어있는 이미지 개수를 불러와라
// 			currendIndex=0;

// 		$slides.eq(currendIndex).fadeIn(); //n번째에 있는 값을 fadein해라 
		
// 		setInterval(showNextSlide,1000); //setinterval>>shownextslide를 7.5초 동안 부를거다
	
// 		function showNextSlide(){
// 			var nextIndex=(currendIndex+1)%slideCount; 
// 			$slides.eq(currendIndex).fadeout();
// 			$slides.eq(nextIndex).fadeIn();

// 			currendIndex=nextIndex;
// 		}
// 	})
// })
$(function(){
	$('.slideshow').each(function(){
		var $slides = $(this).find('img'),
		    slideCount=$slides.length,
            currendIndex=0;

         $slides.eq(currendIndex).fadeIn();

         setInterval(showNextSlide,3000);

         function showNextSlide(){
         	var nextIndex=(currendIndex+1)%slideCount;
         	$slides.eq(currendIndex).fadeOut();
         	$slides.eq(nextIndex).fadeIn();
            
            currendIndex=nextIndex;

         }

	})
})
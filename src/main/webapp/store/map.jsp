<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="alcohol.mvc.dao.*"%>
    <%@ page import="alcohol.mvc.dto.*"%>

    <%@ page import="java.util.*"%>

	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .fac{
 	color: #0A056B; 
 	font-size: 20px;
 	text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white;
 }
</style>
</head>
<body>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=67df1f7c9b283b2023123ffabe045899&libraries=services"></script>

<%
	FactoryDAO facDao = new FactoryDAOImpl();
	List<FactoryDTO> list = facDao.factoryAll();
	

%>

<div id="map" style="width:400px;height:500px;"></div>
	
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(36.6412834441384 , 127.85105483840633),
			level: 13
		};

		var map = new kakao.maps.Map(container, options);
	
		// 마커가 표시될 위치입니다 
		//var markerPosition  = new kakao.maps.LatLng(37.90540357648284 , 127.30905300193753 ); 

		// 마커를 생성합니다
		//var marker = new kakao.maps.Marker({
		//    position: markerPosition
		//});

		// 마커가 지도 위에 표시되도록 설정합니다
		//marker.setMap(map);
		
		// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
		// marker.setMap(null);    
		
		var markerPositions = [
    {
        //content: '<div>배상면주가</div>', 
        latlng: new kakao.maps.LatLng(37.90540357648284 , 127.30905300193753)
    },
    {
        //content: '<div>국순당</div>', 
        latlng: new kakao.maps.LatLng(37.4893229 , 128.1957934)
    },
    {
        //content: '<div>풍정사계</div>', 
        latlng: new kakao.maps.LatLng(36.701695 , 127.545495)
    },
    {
        //content: '<div>중원당</div>',
        latlng: new kakao.maps.LatLng(36.9970372 , 127.8787317)
    },
    {
        //content: '<div>복순도가</div>',
        latlng: new kakao.maps.LatLng(35.5856494 , 129.0975319)
    },
    {
        //content: '<div>청산녹수</div>',
        latlng: new kakao.maps.LatLng(35.3451059 , 126.8128224)
    },
    {
        //content: '<div>한국 애플리즈</div>',
        latlng: new kakao.maps.LatLng(36.4370944 , 128.7231036)
    },
    {
        //content: '<div>태인합동주조</div>',
        latlng: new kakao.maps.LatLng(35.6516202 , 126.9450533)
    },
    {
        //content: '<div>제주샘주</div>',
        latlng: new kakao.maps.LatLng(33.4446362 , 126.3375372)
    }
];

// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    
for (var i = 0; i < markerPositions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: markerPositions[i].latlng, // 마커를 표시할 위치
        image : markerImage // 마커 이미지 
    });
    
}
    var positions = [
        {
            content: '<div class="customoverlay">' +
            '  <a href="https://www.soolsool.co.kr/" target="_blank">' +
            '    <strong class="fac">배상면주가</strong>' +
            '</div>', 
            latlng: new kakao.maps.LatLng(37.90540357648284 , 127.30905300193753)
        },
        {
            content: '<div class="customoverlay">' +
            '  <a href="http://www.ksdb.co.kr/" target="_blank">' +
            '    <strong class="fac">국순당</strong>' +
            '  </a>' +
            '</div>', 
            latlng: new kakao.maps.LatLng(37.4893229 , 128.1957934)
        },
        {
            content: '<div class="customoverlay">' +
            '  <a href="https://m.hwayang.co/" target="_blank">' +
            '    <strong class="fac">풍정사계</strong>' +
            '  </a>' +
            '</div>', 
            latlng: new kakao.maps.LatLng(36.701695 , 127.545495)
        },
        {
            content: '<div class="customoverlay">' +
            '  <a href="http://xn--v42bo8x7wc.com/" target="_blank">' +
            '    <strong class="fac">중원당</strong>' +
            '  </a>' +
            '</div>',
            latlng: new kakao.maps.LatLng(36.9970372 , 127.8787317)
        },
        {
            content: '<div class="customoverlay">' +
            '  <a href="https://boksoon.com/" target="_blank">' +
            '    <strong class="fac">복순도가</strong>' +
            '  </a>' +
            '</div>',
            latlng: new kakao.maps.LatLng(35.5856494 , 129.0975319)
        },
        {
            content: '<div class="customoverlay">' +
            '  <a href="http://www.bluegreenkorea.com/index.php" target="_blank">' +
            '    <strong class="fac">청산녹수</strong>' +
            '  </a>' +
            '</div>',
            latlng: new kakao.maps.LatLng(35.3451059 , 126.8128224)
        },
        {
            content: '<div class="customoverlay">' +
            '  <a href="https://www.applewine.co.kr/" target="_blank">' +
            '    <strong class="fac">한국 애플리즈</strong>' +
            '  </a>' +
            '</div>',
            latlng: new kakao.maps.LatLng(36.4370944 , 128.7231036)
        },
        {
            content: '<div class="customoverlay">' +
            '  <a href="http://www.xn--og5bv8a5dl6a612a.com/main.php" target="_blank">' +
            '    <strong class="fac">태인합동주조</strong>' +
            '  </a>' +
            '</div>',
            latlng: new kakao.maps.LatLng(35.6516202 , 126.9450533)
        },
        {
            content: '<div class="customoverlay">' +
            '  <a href="https://jejusaemju.modoo.at/" target="_blank">' +
            '    <strong class="fac">제주샘주</strong>' +
            '  </a>' +
            '</div>',
            latlng: new kakao.maps.LatLng(33.4446362 , 126.3375372)
        }
    ];

  for (var i = 0; i < positions.length; i ++) {
    // 커스텀 오버레이를 생성합니다
    var customOverlay = new kakao.maps.CustomOverlay({
        map: map,
        position: positions[i].latlng,
     	 content: positions[i].content,
        yAnchor: 2
    });
  }
    



	</script>
</body>
</html>
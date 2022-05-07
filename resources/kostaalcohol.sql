select * from users;
select * from category;
select * from product;
select * from payment;
select * from orders;
select * from order_line;
select * from refund;
select * from cart;
select * from coupon;
select * from subscription;
select * from factory;
select * from notice;
select * from QA;
select * from reply;
select * from review;
-----------------------------------------------------------------------------------------
create table users( --회원 
  u_id varchar2(30) primary key , --아이디
  u_pwd varchar2(30), --비번------------------------------숫자,영문(+)8자리
  u_name varchar2(30), --이름
  u_jumin varchar2(30), --주민번호
  u_phone varchar2(30), --연락처
  u_email varchar2(100), --이메일 
  u_addr varchar2(100),--주소
  u_addr2 varchar2(200), --상세주소 
  u_grade number default 0 not null, -- 권한 (0이면 유저 , 1이면 관리자)
  u_point number , --적립금
  join_date varchar2(30) --가입날짜
);

drop table users;
select * from users;
delete from users;

insert into users values('min','kosta1111','박민서','030413-2157879','010-2923-5057',
'alcohol@naver.com','경기도 수원시','구운동', default, 3000, sysdate)
insert into users values('jung','kosta2222','정유현','030518-228951','010-8548-5426',
'alcohol22@daum.net','서울시 강남구','대치동', default, 3000, sysdate)
insert into users values('kim','kosta3333','김정현','030309-1573486','010-1567-5759',
'alcohol33@gmail.com','경기도 성남시','구미동', default, 3000, sysdate)
insert into users values('lee','kosta4444','이수빈','030827-2435795','010-1338-0567',
'alcohol44@nate.com','경기도 의왕시','월암동', default, 3000, sysdate)
insert into users values('sun','kosta5555','김효선','031024-2461793','010-3355-4679',
'alcohol55@daum.net','서울시 용산구','이태원동', default, 3000, sysdate);

insert into users values('admin','alcohol1234','관리자','123-45-06789','02-333-0901',
'oneshotkorea@naver.com','서울시 마포구','안다미로', 1, 0, to_date('2021/10/01','YY/MM/DD'));--관리자
commit
---------------------------------------------------------------------------------
create table category( --카테고리
  cate_code varchar2(30) primary key, --카테고리 코드
  cate_name varchar2(30) --카테고리 이름  
);

drop table category;
select * from category;
delete from category;

insert into category values('A' ,'탁주');
insert into category values('B' ,'청주');  
insert into category values('C' ,'과실주');
insert into category values('D' ,'증류주');
insert into category values('Gift','선물세트');
insert into category values('Monthly','이달의 술');
---------------------------------------------------------------------------------
create table product( --상품 
  p_code varchar2(30) primary key, --상품코드  ----------상품코드를 A B C D 
  cate_code varchar2(30) references category(cate_code), --카테고리코드 
  p_name varchar2(100) , --상품이름 
  p_alcohol number, --도수
  p_price number, --상품가격
  p_stuck number , --재고수량 
  p_date varchar2(30) , --출시일 
  p_image varchar2(4000), --이미지
  p_image2 varchar2(4000), --이미지2
  p_image3 varchar2(4000), --이미지3
  p_detail varchar2(4000) --상품설명 
);

drop table product;
select * from product order by p_code 
delete from product;

insert into product values('A01','A','순창 지란지교 무화과 탁주',12,
15000,999,'2021년10월11일','img','향긋하고 달달한 무화과 탁주');
insert into product values('A02','A','만강에 비친 달',10,
16000,999,'2021년11월15일','img','단호박이 들어간 새콤한 막걸리');
insert into product values('A03','A','자연담은 복분자 막걸리',6,
13000,999,'2021년12월09일','img','생쌀 발효를 거쳐 만든 복분자 막걸리');

insert into product values('A04','A','붉은 원숭이',10.8,
9000,999,'2021년12월15일','img','홍국쌀로 만든 프리미엄 탁주');
insert into product values('A05','A','표문 막걸리',6,
18000,999,'2022년01월10일','img','한강주조와 대한제분의 콜라보 막걸리');

insert into product values('A06','A','편백숲 산소막걸리 딸기 스파클링',6.8,
14000,999,'2022년01월30일','img','딸기맛 탄산 가득한 막걸리');

insert into product values('A07','A','자연담은 복분자 막걸리',6,
13000,999,'2022년02월10일','img','생쌀 발효를 거쳐 만든 복분자 막걸리');
insert into product values('A08','A','마실꾸지',7,
15000,999,'2022년02월28일','img','꾸지뽕 열매가 들어간 막걸리');
insert into product values('A09','A','하얀 까마귀',8,
30000,999,'2022년03월05일','img','포근한 단맛,행운을 상징하는 하얀 까마귀');
insert into product values('A10','A','냥이탁주',9,
19000,999,'2022년04월04일','img','5가지 부재료를 넣어 만든 새콤달콤한 막걸리');

update product set p_code='A10' where p_code='A010'

---------------------------------------------------------------------------------------
insert into product values('B01','B','매화 깊은 밤',8,
12000,999,'2021년10월20일','img','매실의 달콤한 풍미와 은은한 사과 향');
insert into product values('B02','B','백련 맑은 술',12,
22000,999,'2021년11월10일','img','연잎차처럼 향긋하고 쌉쌀한 끝맛');
insert into product values('B03','B','기다림 흑미 약주',10,
19000,999,'2021년12월05일','img','흑미가 들어간 부산의 무첨가 수제 약주');
insert into product values('B04','B','면천두견주',18,
15000,999,'2021년12월24일','img','연분홍 진달래꽃주');

insert into product values('B05','B','니모메',11,
8500,999,'2022년01월17일','img','제주 감귤의 맛과 향');
insert into product values('B06','B','술송주',13,
8000,999,'2022년01월31일','img','솔 향기 가득 담은 술');
insert into product values('B07','B','새벽에 내린 눈을 닮은 서설',13,
15000,999,'2022년02월19일','img','새벽에 내린 눈과 같이 깨끗한 한국형 청주');
insert into product values('B08','B','술아-순곡주',15,
18000,999,'2022년03월01일','img','발효주와 증류주를 혼합해서 빚은 술');
insert into product values('B09','B','보리수헤는밤',8,
12000,999,'2022년03월27일','img','매실과 보리수의 만남');
insert into product values('B10','B','모든날에',15,
28000,999,'2022년04월14일','img','전통누룩을 사용하여 3번 빚은 술');

update product set p_name='솔송주' where p_name='술송주'
commit
---------------------------------------------------------------------------------------
insert into product values('C01','C','초선의 꿈 로제와인',12,
20000,999,'2021년10월25일','img','델라웨어 포도 품종으로 만든 새콤달콤한 와인');
insert into product values('C02','C','고도리 복숭아 와인',6,
23000,999,'2021년11월07일','img','복숭아의 수분을 얼려 과즙 당도를 높인 아이스 와인');
insert into product values('C03','C','시나브로 청수 화이트',11,
55000,999,'2021년12월16일','img','해산물과 잘 어울리는 편안하고 산뜻한 산미');

insert into product values('C04','C','단감명작',7,
18000,999,'2021년12월31일','img','창녕 단감으로 만든 화이트와인');
insert into product values('C05','C','그랑꼬또 로제와인',12,
27000,999,'2022년01월05일','img','맑은 핑크빛 속 산뜻한 맛');
insert into product values('C06','C','크라테 자두 와인',8.5,
22500,999,'2022년01월27일','img','자두 사탕 머금은 듯 싱그러운 와인');
insert into product values('C07','C','신애유자',5,
8000,999,'2022년02월13일','img','레모네이드에 사과 한조각');
insert into product values('C08','C','동백꽃 제주',16,
12000,999,'2022년03월08일','img','청포도를 먹는듯한 달콤한 술');
insert into product values('C09','C','댄싱파파',7,
55000,999,'2022년04월01일','img','달지 않고 깔끔한 애플사이다 같은 술');
insert into product values('C10','C','청포도 와인 절정',13.5,
23000,999,'2022년04월10일','img','산뜻한 풍미가 돋보이는 화이트 와인');

update product set p_price=18000 where p_price=55000

---------------------------------------------------------------------------------------
insert into product values('D01','D','만월',40,
18000,999,'2021년10월03일','img','둥근 보름달처럼 넓게 퍼지는 복분자의 향');
insert into product values('D02','D','겨울소주',25,
10000,999,'2021년11월11일','img','고소하고 담백한 곡물의 향');
insert into product values('D03','D','삼천갑자 동방주',12,
15000,999,'2021년12월21일','img','새싹삼이 통째로 들어간 담금주');

insert into product values('D04','D','고소리술',29,
18000,999,'2021년12월31일','img','고려시대부터 내려온 제주의 토속주');
insert into product values('D05','D','미르',40,
35000,999,'2022년01월02일','img','쌀,물,누룩으로만 빚은 고급 증류주');
insert into product values('D06','D','보석같이 빛나는 퍼플진',36.5,
50000,999,'2022년01월21일','img','매력전인 보라빛 진');
insert into product values('D07','D','농태기',25,
18000,999,'2022년02월16일','img','한국의 쌀과 북한의 양조법으로 만든 한민족의 술');
insert into product values('D08','D','양촌양조 여유소주',40,
35000,999,'2022년03월11일','img','양촌양조만의 독자적인 효모로 빚은 증류주');
insert into product values('D09','D','서울의 밤',25,
10000,999,'2022년03월22일','img','매실로 만든 한국의 진');
insert into product values('D10','D','병영설성 사또',40,
42000,999,'2022년04월05일','img','오디와 복분자향이 부드럽게 녹아있는 술');

commit

---------------------------------------------------------------------------------------
insert into product values('G01','Gift','꽃길을 여는 술들',20,
32900,999,'2021년10월18일','img','매화 깊은 밤+술잔');
insert into product values('G02','Gift','도원결의',10,
15000,999,'2021년11월25일','img','고도리 복숭아 와인+술잔');
insert into product values('G03','Gift','지란지교',30,
15000,999,'2021년12월04일','img','순창 지란지교 무화과 탁주+술잔');
insert into product values('G04','Gift','문배술',40,
80000,999,'2022년01월05일','img','고려시대부터 임금에게 진상하는 술');

insert into product values('G05','Gift','천년담주',15,
36000,999,'2022년01월20일','img','담양의 천년 역사를 담은 약주');

insert into product values('G06','Gift','대대포',13,
36000,999,'2022년02월03일','img','유기농쌀과 토종벌꿀을 사용한 막걸리');
insert into product values('G07','Gift','필',40,
57000,999,'2022년02월24일','img','여주고구마로 만든 필');
insert into product values('G08','Gift','예산사과로 만든 추사',40,
60000,999,'2022년03월03일','img','달콤한 사과로 만든 우리 술');
insert into product values('G09','Gift','술샘16',16,
24000,999,'2022년03월29일','img','오미자의 향긋함을 담은 술');
insert into product values('G10','Gift','꿀샘16',16,
30000,999,'2022년04월13일','img','천연꿀 프리미엄 리큐르');

commit

-----------------------------------------------------------------------------------------
insert into product values('M01','Monthly','봄의 술',20,
32900,999,'2021년10월18일','img','1월');
insert into product values('M02','Monthly','여름의 술',10,
15000,999,'2021년11월25일','img','2월');
insert into product values('M03','Monthly','가을의 술',30,
15000,999,'2021년12월04일','img','3월');
insert into product values('M04','Monthly','겨울의 술',30,
15000,999,'2021년12월04일','img','4월');

update product set p_name='11월의 술' ,p_date='2021년11월01일', p_detail='충북을 대표하는 우리 술' where p_code='M02';
update product set p_name='12월의 술', p_date='2021년12월01일', p_detail='경남을 대표하는 우리 술' where p_code='M03';
update product set p_name='1월의 술' ,p_date='2022년01월01일', p_detail='제주를 대표하는 우리 술' where p_code='M04';
update product set p_name='벗이랑 탁주', p_detail='강황, 홍국, 조릿대를 사용하여 빚은 막걸리',p_alcohol=15 where p_code='G02';
update product set p_price=80000 where p_code='G04'
update product set p_detail='홍국쌀로 만든 프리미엄 탁주' where p_code='A04'

insert into product values('G02','Gift','도원결의',10,
15000,999,'2021년11월25일','img','고도리 복숭아 와인+술잔');

insert into product values('M05','Monthly','2월의 술',25,
32000,999,'2022년02월01일','img','전남을 대표하는 우리 술');
insert into product values('M06','Monthly','3월의 술',15,
16000,999,'2021년03월01일','img','경북을 대표하는 우리 술');
insert into product values('M07','Monthly','4월의 술',35,
20000,999,'2021년04월01일','img','충남을 대표하는 우리 술');


commit
---------------------------------------------------------------------------------
create table payment( --결제
 pay_code number primary key, --결제코드
 pay_type number default 0 not null, --결제방식(0이면 카드 , 1이면 무통장)
 pay_account varchar2(30) --계좌번호
);

drop table payment;
select * from payment;
delete from payment;

create sequence payment_no_seq --결제코드 
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOMINVALUE
NOCYCLE;

drop sequence payment_no_seq;

insert into payment values(payment_no_seq.nextval, default, null); --카드
insert into payment values(payment_no_seq.nextval, 1, '우리은행 1111-111-111111'); --무통장
insert into payment values(payment_no_seq.nextval, 1, '신한은행 2222-222-222222'); --무통장
---------------------------------------------------------------------------------
create table orders( --주문
 order_code number primary key, --주문코드
 u_id varchar2(30) references users(u_id), --아이디 
 pay_code number references payment(pay_code), --결제코드
 order_date date, --주문날짜
 order_status varchar2(30) , --주문상태
 deli_status varchar2(30) , --배송상태
 deli_addr varchar2(100) , --수령자 주소
 deli_addr2 varchar2(200), --수령자 상세주소 
 order_phone varchar2(30) --수령자 연락처
);

drop table orders;
select * from orders;
delete from orders;

create sequence orders_no_seq --주문코드 
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOMINVALUE
NOCYCLE;

drop sequence orders_no_seq;

insert into orders values(orders_no_seq.nextval,'min',payment_no_seq.currval,sysdate,
'결제완료','배송대기중','경기도 수원시','구운동','010-2923-5057');
insert into orders values(orders_no_seq.nextval,'jung',payment_no_seq.currval,sysdate,
'결제완료','배송대기중','서울시 강남구','대치동','010-8548-5426');
insert into orders values(orders_no_seq.nextval,'kim',payment_no_seq.currval,sysdate,
'결제완료','배송대기중','경기도 성남시','구미동','010-1567-5759');


---------------------------------------------------------------------------------
create table order_line( --주문상세
 order_line_code number primary key, --주문상세코드
 order_code number references orders(order_code), --주문코드
 p_code varchar2(30) references product(p_code),--상품코드 
 order_line_count number --주문수량 
);

drop table order_line;
select * from order_line;
delete from order_line;

create sequence order_line_no_seq --주문상세코드 
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOMINVALUE
NOCYCLE;

drop sequence order_line_no_seq;

insert into order_line values(order_line_no_seq.nextval,orders_no_seq.currval,'A01',1); 
insert into order_line values(order_line_no_seq.nextval,orders_no_seq.currval,'B01',2); 
insert into order_line values(order_line_no_seq.nextval,orders_no_seq.currval,'C01',1); 
---------------------------------------------------------------------------------
create table refund( --환불
  re_code number primary key, --(1 단순변심 2 상품추가해서 재주문하기 3 주문오류 4 기타) 
  order_code number references orders(order_code), --주문코드
  re_reason varchar2(4000), --환불사유
  re_status varchar2(30) --환불상태 
);

drop table refund;
select * from refund;
delete from refund;

insert into refund values(1,orders_no_seq.currval,'단순변심','환불접수');
---------------------------------------------------------------------------------
create table cart( --장바구니
  cart_number number primary key, --장바구니번호
  u_id varchar2(30) references users(u_id), --아이디 
  p_code varchar2(30) references product(p_code),--상품코드 
  cart_count number --수량 
);

drop table cart;
select * from cart;
delete from cart;

create sequence cart_no_seq --장바구니번호  
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOMINVALUE
NOCYCLE;

drop sequence cart_no_seq;

insert into cart values(cart_no_seq.nextval,'kim','D01',1);
insert into cart values(cart_no_seq.nextval,'lee','G01',2);
---------------------------------------------------------------------------------
create table coupon ( --쿠폰
  c_number varchar2(30) primary key, --쿠폰번호  ------ 앞에 식별할수 있는것 ....(+)
  c_name varchar2(50), --쿠폰이름 
  u_id varchar2(30) references users(u_id),--아이디
  c_rate number, --할인가격
  c_startdate date, --쿠폰시작일
  c_enddate date -- 쿠폰종료일 ------------------------------------------------쿠폰기간 언제까지로(한달+)
);

drop table coupon;
select * from coupon;          
delete from coupon;

insert into coupon values('W_' || dbms_random.string('x',10),'welcome coupon','sun', 3000 ,sysdate, sysdate+30);
insert into coupon values('W_' || dbms_random.string('x',10),'welcome coupon','min', 3000 ,sysdate, sysdate+30); 
insert into coupon values('W_' || dbms_random.string('x',10),'welcome coupon','lee', 3000 ,sysdate, sysdate+30); 
insert into coupon values('W_' || dbms_random.string('x',10),'welcome coupon','jung',3000 ,sysdate, sysdate+30); 
insert into coupon values('W_' || dbms_random.string('x',10),'welcome coupon','kim', 3000 ,sysdate, sysdate+30); -- 영숫자 혼합, 가입쿠폰

insert into coupon values('B_' || dbms_random.string('x',10),'birthday coupon','sun', 5000 ,sysdate, sysdate+30); 
insert into coupon values('B_' || dbms_random.string('x',10),'birthday coupon','min', 5000 ,sysdate, sysdate+30);
insert into coupon values('B_' || dbms_random.string('x',10),'birthday coupon','lee', 5000 ,sysdate, sysdate+30);
insert into coupon values('B_' || dbms_random.string('x',10),'birthday coupon','jung', 5000 ,sysdate, sysdate+30);
insert into coupon values('B_' || dbms_random.string('x',10),'birthday coupon','kim', 5000 ,sysdate, sysdate+30);--생일쿠폰

insert into coupon values('N_' || dbms_random.string('x',10),'new product coupon','sun', 4000 ,sysdate, sysdate+30); 
insert into coupon values('N_' || dbms_random.string('x',10),'new product coupon','min', 4000 ,sysdate, sysdate+30);
insert into coupon values('N_' || dbms_random.string('x',10),'new product coupon','lee', 4000 ,sysdate, sysdate+30);
insert into coupon values('N_' || dbms_random.string('x',10),'new product coupon','jung', 4000 ,sysdate, sysdate+30);
insert into coupon values('N_' || dbms_random.string('x',10),'new product coupon','lee', 4000 ,sysdate, sysdate+30);--신상품쿠폰
---------------------------------------------------------------------------------
create table subscription ( --구독 
  sub_code varchar2(30) primary key, --구독코드
  u_id varchar2(30) references users(u_id), --아이디
  sub_startdate date, --구독시작일
  sub_price number --구독료 
); 

create sequence subscription_no_seq --구독코드
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOMINVALUE
NOCYCLE;

drop sequence subscription_no_seq;

drop table subscription;
select * from subscription;
delete from subscription;

insert into subscription values('sub_' || subscription_no_seq.nextval,'min',sysdate,39000);
insert into subscription values('sub_' || subscription_no_seq.nextval,'jung',sysdate,39000);
---------------------------------------------------------------------------------
create table factory ( --양조장
  f_name varchar2(50) primary key, --양조장이름
  f_type varchar2(4000), --양조장취급종류 
  --f_image varchar2(4000), --양조장이미지
  f_addr varchar2(4000) --양조장주소
);

drop table factory;
select * from factory;
delete from factory; 

delete from factory where f_name='제주샘주';

insert into factory values('배상면주가','탁주,약주, 청주,증류주','경기도 포천시 화현면 화현리 512');
insert into factory values('국순당','탁주,증류주','강원도 횡성군 둔내면 현천리 120');
insert into factory values('풍정사계','탁주,약주, 청주,과실주,증류주','충청북도 청주시 청원구 내수읍 풍정1길 8-2');
insert into factory values('중원당','약주,청주','충북 충주시 가금면 창동리 243');
insert into factory values('복순도가','탁주,청주','울산광역시 울주군 향산동길 48');
insert into factory values('청산녹수','탁주,증류주','전라남도 장성군 장성읍 백계리 444-1');
insert into factory values('한국애플리즈','과실주','경상북도 의성군 단촌면 일직점곡로 755');
insert into factory values('태인합동주조','탁주,증류주','전라북도 정읍시 태인면 창흥2길 17');
insert into factory values('제주샘주','약주,청주,증류주','제주시 애월읍 애언로 283');
---------------------------------------------------------------------------------
create table notice( --공지사항
  no_number number primary key, --공지사항번호
  u_id varchar2(30) references users(u_id), --아이디 
  no_title varchar2(4000), --공지사항제목
  no_content varchar2(4000), --공지사항내용 
  no_date date, --등록일 
  view_count number default 0 --조회수
);

create sequence notice_no_seq --공지사항번호
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOMINVALUE
NOCYCLE;

drop sequence notice_no_seq;

drop table notice;
select * from notice;
delete from notice;

insert into notice values(notice_no_seq.nextval,'admin','안다미로 오픈','안녕하세요? 안다미로를 방문해 주셔서 감사합니다.
안다미로는 500ml 상품만 판매하고 있습니다. 많은 이용 부탁드립니다.',to_date('2021/10/01','YY/MM/DD') ,default);

insert into notice values(notice_no_seq.nextval,'admin','정기배송날짜','안녕하세요? 안다미로입니다.정기결제는 매달 1일, 
정기배송은 매달 15일 입니다.',to_date('2021/10/01','YY/MM/DD'),default);

insert into notice values(notice_no_seq.nextval,'admin','신상품 출시','안녕하세요? 안다미로입니다. 
신상품이 출시되었습니다. 많은 관심 부탁드립니다',to_date('2021/10/15','YY/MM/DD') ,default);
---------------------------------------------------------------------------------
create table QA( --문의
  qa_number number primary key, --문의번호
  u_id varchar2(30) references users(u_id), --아이디
  qa_category number , --카테고리 (1 상품문의 2 결제/환불/교환 3 쿠폰/포인트 4 기타)
  qa_title varchar2(4000) , --제목
  qa_content varchar2(4000), --내용
  qa_date date, --등록일
  qa_secret number default 0 -- (0이면 비밀글 , 1이면 오픈)
);

drop table QA;
select * from QA;
delete from QA;

create sequence qa_no_seq --문의번호
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOMINVALUE
NOCYCLE;

drop sequence qa_no_seq;


insert into QA values(qa_no_seq.nextval,'min',1,'상품문의','상품의 용량이 나와있지 않아 궁금합니다'
,to_date('2021/10/28','YY/MM/DD') ,default);

insert into QA values(qa_no_seq.nextval,'lee',2,'결제/환불/교환 문의','상품이 깨진상태로 배송되었습니다. 환불처리 부탁드립니다',
to_date('2021/11/14','YY/MM/DD') ,1);

insert into QA values(qa_no_seq.nextval,'sun',3,'쿠폰/포인트 문의','포인트는 언제까지 사용가능한가요?'
,to_date('2022/02/06','YY/MM/DD') ,default);

insert into QA values(qa_no_seq.nextval,'jung',4,'기타문의','전통술 외에 다른 종류는 판매하지 않는건가요?'
,to_date('2022/03/16','YY/MM/DD') ,1);
---------------------------------------------------------------------------------
create table reply( --답변 
  re_number number primary key, --답글번호
  qa_number number references QA(qa_number), --문의번호
  u_id varchar2(30) references users(u_id), --아이디
  re_content varchar2(4000), --답변내용
  re_date date , --등록일
  re_secret number default 0 -- (0이면 비밀글, 1이면 오픈)
);

drop table reply;
select * from reply;
delete from reply;

create sequence reply_no_seq --문의번호
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOMINVALUE
NOCYCLE;

drop sequence reply_no_seq;

insert into reply values(reply_no_seq.nextval,qa_no_seq.currval,'admin','안녕하세요 min님, 안다미로는 전 상품 모두 500ml만 판매하고 있습니다'
,to_date('2021/10/29','YY/MM/DD') ,default);

insert into reply values(reply_no_seq.nextval,qa_no_seq.currval,'admin','안녕하세요 lee님 죄송합니다. 빠른시일내에 환불 처리해드리겠습니다'
,to_date('2021/11/15','YY/MM/DD') ,1);

insert into reply values(reply_no_seq.nextval,qa_no_seq.currval,'admin','안녕하세요 sun님, 포인트는 정해진 기간이 없습니다'
,to_date('2022/02/07','YY/MM/DD') ,default);

insert into reply values(reply_no_seq.nextval,qa_no_seq.currval,'admin','안녕하세요 jung님, 안다미로는 전통술만 판매하는 쇼핑몰입니다.
다른 종류는 판매 할 예정이 없습니다.',to_date('2022/03/07','YY/MM/DD') ,1);


 select * from QA q join reply r 
 on q.qa_number = r.re_number and q.qa_number=1;

---------------------------------------------------------------------------------
create table review( --후기
  view_number number primary key, --후기번호
  u_id varchar2(30) references users(u_id), --아이디
  p_code varchar2(30) references product(p_code), --상품코드
  view_content varchar2(4000), --후기내용
  view_score number, --별점 
  view_image varchar2(4000) --이미지 
);

drop table review;
select * from review;
delete from review;

create sequence review_no_seq --후기번호
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOMINVALUE
NOCYCLE;

drop sequence review_no_seq;

insert into review values(review_no_seq.nextval,'sun','C03','회와 같이 맛있게 먹었습니다. 설명처럼 해산물과 잘 어울려요',5,'img');
insert into review values(review_no_seq.nextval,'lee','M01','부모님께 선물해드렸는데 좋아하셨어요',5,'img');

commit
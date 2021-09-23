BEGIN
	
	CREATE TABLE member_access_log(
		seq bigint not null auto_increment,
		member_key int not null,
		device varchar(10),
		connect_ip varchar(15),
		
		reg_dtm datetime,
		primary key(seq)
	);
	CREATE INDEX member_key_idx ON member_access_log(member_key);
	
	/* member 사용자 정보 */
	CREATE TABLE member(
		member_key bigint not null auto_increment,
		member_id varchar(20) not null,
		passwd varchar(200) not null,
		role varchar(10),
		member_nm varchar(20) not null,
		state char(1) not null,
		reg_dtm datetime,
		mod_dtm datetime,
		primary key(member_key)
	);
	CREATE INDEX member_id_idx ON member(member_id);

	CREATE TABLE auth(
		auth_key bigint not null auto_increment,
		auth_nm varchar(20) not null,
		use_yn char(1) not null,
		reg_dtm datetime,
		mod_dtm datetime,
		primary key(auth_key)
	);

	CREATE TABLE member_auth(
		member_key int not null,
		auth_key int not null,
		use_yn char(1) not null,
		reg_dtm datetime,
		mod_dtm datetime
	);
	
	/* owner 사용자 정보 */
	CREATE TABLE owner(
		owner_key bigint not null auto_increment,
		owner_nm varchar(20) not null,
		state char(1) not null,
		reg_dtm datetime,
		mod_dtm datetime,
		primary key(owner_key)
	);
	CREATE INDEX owner_id_idx ON owner(owner_id);
	
	/* store 정보 */
	CREATE TABLE store(
		store_key bigint not null auto_increment,
		owner_key int not null,
		store_nm varchar(20) not null,
		state char(1) not null,
		reg_dtm datetime,
		mod_dtm datetime,
		primary key(store_key)
	);
	CREATE INDEX store_key_idx ON store(owner_key);
	
	/* 사장님 계좌 등 */
	CREATE TABLE account(
		account_key bigint not null auto_increment,
		owner_key int not null,
		bank varchar(200),
		account varchar(200),
		use_yn char(1) not null,
		reg_dtm datetime,
		mod_dtm datetime,
		primary key(account_key)
	);
	/* 주문 정보 */
	CREATE TABLE order(
		order_key bigint not null auto_increment,
		owner_key int not null,
		order_nm varchar(20) not null,
		reg_dtm datetime,
		primary key(order_key)
	);
	CREATE TABLE order_detail(
		order_key int not null,
		payment_key int not null,
		facevalue int,
		amount int,
		discount_rate int
	);
	CREATE TABLE order_snapshot(
		order_key int not null,
		amount int,
		facevalue int,
		reg_ymd varchar(8),
		discount_rate int,
		cnt int
	);
	
	CREATE TABLE payment(
		payment_key bigint not null auto_increment,
		payment_nm varchar(20) not null,
		rate int,
		primary key(payment_key)
	);
	/* 보상 금액 정보 */
	CREATE TABLE reward(
		reward_key bigint not null auto_increment,
		order_key int not null,
		amount int
	);
	/* 지급 관리 */
	CREATE TABLE orderPaymentAggregation(
		id bigint not null auto_increment,
		owner_key int not null,
		tot_account int,
		reg_ymd varchar(8),
		primary key(id)
	);
END
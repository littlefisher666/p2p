DROP DATABASE IF EXISTS p2p;
CREATE DATABASE p2p;
USE p2p;



CREATE TABLE company (
  companyId int(11) NOT NULL AUTO_INCREMENT,
  companyName varchar(20) DEFAULT NULL,
  financingInReturn double DEFAULT NULL,
  companyDetail text,
  status varchar(1) DEFAULT 'W',
  PRIMARY KEY (companyId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE lendingperiod (
  lendingPeriodId int(11) NOT NULL AUTO_INCREMENT,
  period varchar(20) DEFAULT NULL,
  status varchar(1) DEFAULT 'C',
  PRIMARY KEY (lendingPeriodId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE news (
  newsId int(11) NOT NULL AUTO_INCREMENT,
  newsTitle varchar(50) NOT NULL,
  content longtext NOT NULL,
  createAt date DEFAULT NULL,
  image varchar(50) DEFAULT NULL,
  status varchar(1) DEFAULT 'C',
  PRIMARY KEY (newsId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE productType (
  productTypeId int(11) NOT NULL AUTO_INCREMENT,
  productTypeName varchar(20) DEFAULT NULL,
  status varchar(1) DEFAULT 'C',
  PRIMARY KEY (productTypeId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE product (
  productId int(11) NOT NULL AUTO_INCREMENT,
  productName varchar(20) DEFAULT NULL,
  primeLendingRateFrom double DEFAULT NULL,
  primeLendingRateTo double DEFAULT NULL,
  company int(11) DEFAULT NULL,
  financingAmountFrom int(11) DEFAULT '0',
  financingAmountTo int(11) DEFAULT '0',
  productType int(11) DEFAULT NULL,
  lendingPeriod int(11) DEFAULT NULL,
  linkMan varchar(20) DEFAULT NULL,
  ownedBank varchar(20) DEFAULT NULL,
  productDescription text,
  createTime date DEFAULT NULL,
  status varchar(1) DEFAULT 'E',
  PRIMARY KEY (productId),
  KEY FK_Pro_company (company),
  KEY FK_PRO_PROTYPE (productType),
  KEY FK_PRO_LEADINGPRI (lendingPeriod),
  CONSTRAINT FK_PRO_LEADINGPRI FOREIGN KEY (lendingPeriod) REFERENCES lendingperiod (lendingPeriodId),
  CONSTRAINT FK_Pro_company FOREIGN KEY (company) REFERENCES company (companyId),
  CONSTRAINT FK_PRO_PROTYPE FOREIGN KEY (productType) REFERENCES producttype (productTypeId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE apply (
  applyId int(11) NOT NULL AUTO_INCREMENT,
  applyPerson varchar(10) DEFAULT NULL,
  applyPersonIDCard varchar(10) DEFAULT NULL,
  applyNum int(11) DEFAULT '0',
  applyDate date DEFAULT NULL,
  applyProductName varchar(20) DEFAULT NULL,
  applyProductId int(11) DEFAULT NULL,
  status varchar(1) DEFAULT 'W',
  PRIMARY KEY (applyId),
  KEY FK_APPLY_PRODUCT (applyProductId),
  CONSTRAINT FK_APPLY_PRODUCT FOREIGN KEY (applyProductId) REFERENCES product (productId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE sysuser (
  id int(11) NOT NULL AUTO_INCREMENT,
  userName varchar(20) NOT NULL,
  loginName varchar(20) NOT NULL,
  loginPassword varchar(64) NOT NULL,
  status varchar(1) DEFAULT 'O',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO company VALUES ('1', '中国银行',2.2, 
'中国银行全称是中国银行股份有限公司（Bank of China Limited，简称BOC），
总行(Head Office)位于北京复兴门内大街1号，是五大国有商业银行之一。
中国银行的业务范围涵盖商业银行、投资银行、保险和航空租赁，旗下有中银香港、
中银国际、中银保险等控股金融机构，在全球范围内为个人和公司客户提供金融服务。
中国银行作为中国国际化和多元化程度最高的银行，在中国内地、香港、澳门、
台湾及37个国家为客户提供全面的金融服务。主要经营商业银行业务，包括公司金融业务、
个人金融业务和金融市场业务等多项业务。2013年7月，英国《银行家》（The Banker）
杂志公布了2013年“全球1000家大银行”排名，位居第9位，与2012年排名一致。此外，
世界品牌实验室发布2012年“中国500最具价值品牌”排名结果，中国银行以885.16亿元品牌价值排名第10位，
较2011年排名上升1位，位居银行业第2位。','W');

INSERT INTO lendingperiod VALUES ('1', '1','C');
INSERT INTO lendingperiod VALUES ('2', '3','C');
INSERT INTO lendingperiod VALUES ('3', '6','C');
INSERT INTO lendingperiod VALUES ('4', '12','C');

INSERT INTO news VALUES ('1', '中国银行晋级全球银行前十','中国银行在本年初，晋级全球银行前十行列',str_to_date('08/09/2008','%m/%d/%Y'),'c://','C');

INSERT INTO productType VALUES ('1', '信用贷','C');
INSERT INTO productType VALUES ('2', '抵押贷','C');
INSERT INTO productType VALUES ('3', '质押贷','C');
INSERT INTO productType VALUES ('4', '担保贷','C');
INSERT INTO productType VALUES ('5', '票据贴现','C');

INSERT INTO product VALUES ('1', '苏科贷',7.0,8.0,1,100,500,1,1,'张三','中国银行南京分行',
'银投联贷业务是指对于合作范围内的PE拟投或已投的科技型中小企业的借款申请，
本行在综合考虑私募股权投资机构的投资管理能力和借款人未来发展前景等因素的基础上，
以信用、股权质押、PE保证或类保证等方式，向科技型中小企业发放用于满足其日常经营资金需求的授信业务。'
,str_to_date('08/09/2008','%m/%d/%Y'),'E');

INSERT INTO apply VALUES ('1','李四','123456789906201230',50,str_to_date('08/09/2008','%m/%d/%Y'),'苏科贷',1,'W');

INSERT INTO sysuser VALUES ('1', 'superAdmin', 'itany', 'itany','O');
INSERT INTO sysuser VALUES ('2', 'superAdmin', 'admin', 'admin','O');
INSERT INTO sysuser VALUES ('3', '张三', 'zhangsan', '12345','O');

CREATE TABLE company_status (
  company_statusId int(11) NOT NULL AUTO_INCREMENT,
  company_statusShortName varchar(1) NOT NULL,
  company_statusMeaning varchar(40) NOT NULL,
  PRIMARY KEY (company_statusId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO company_status VALUES ('1','P','passed');
INSERT INTO company_status VALUES ('2','R','refused');
INSERT INTO company_status VALUES ('3','W','wait to pass ; Default');
INSERT INTO company_status VALUES ('4','D','Deleted');

CREATE TABLE lendingperiod_status (
  lendingperiod_statusId int(11) NOT NULL AUTO_INCREMENT,
  lendingperiod_statusShortName varchar(1) NOT NULL,
  lendingperiod_statusMeaning varchar(40) NOT NULL,
  PRIMARY KEY (lendingperiod_statusId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lendingperiod_status VALUES ('1','O','Open');
INSERT INTO lendingperiod_status VALUES ('2','C','Closed ; Default');
INSERT INTO lendingperiod_status VALUES ('3','D','Deleted');

CREATE TABLE news_status (
  news_statusId int(11) NOT NULL AUTO_INCREMENT,
  news_statusShortName varchar(1) NOT NULL,
  news_statusMeaning varchar(40) NOT NULL,
  PRIMARY KEY (news_statusId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO news_status VALUES ('1','C','The current news ; Default');
INSERT INTO news_status VALUES ('2','F','The finished news');
INSERT INTO news_status VALUES ('3','D','Deleted');

CREATE TABLE productType_status (
  productType_statusId int(11) NOT NULL AUTO_INCREMENT,
  productType_statusShortName varchar(1) NOT NULL,
  productType_statusMeaning varchar(40) NOT NULL,
  PRIMARY KEY (productType_statusId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO productType_status VALUES ('1','O','Open');
INSERT INTO productType_status VALUES ('2','C','Closed ; Default');
INSERT INTO productType_status VALUES ('3','D','Deleted');

CREATE TABLE product_status (
  product_statusId int(11) NOT NULL AUTO_INCREMENT,
  product_statusShortName varchar(1) NOT NULL,
  product_statusMeaning varchar(40) NOT NULL,
  PRIMARY KEY (product_statusId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO product_status VALUES ('1','E','The effective product ; Default');
INSERT INTO product_status VALUES ('2','I','The Invalid product');
INSERT INTO product_status VALUES ('3','D','Deleted');

CREATE TABLE apply_status (
  apply_statusId int(11) NOT NULL AUTO_INCREMENT,
  apply_statusShortName varchar(1) NOT NULL,
  apply_statusMeaning varchar(40) NOT NULL,
  PRIMARY KEY (apply_statusId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO apply_status VALUES ('1','P','passed');
INSERT INTO apply_status VALUES ('2','R','refused');
INSERT INTO apply_status VALUES ('3','W','wait to pass ; Default');
INSERT INTO apply_status VALUES ('4','D','Deleted');

CREATE TABLE sysuser_status (
  sysuser_statusId int(11) NOT NULL AUTO_INCREMENT,
  sysuser_statusShortName varchar(1) NOT NULL,
  sysuser_statusMeaning varchar(40) NOT NULL,
  PRIMARY KEY (sysuser_statusId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO sysuser_status VALUES ('1','S','SuperAdministrator');
INSERT INTO sysuser_status VALUES ('2','A','Administrator');
INSERT INTO sysuser_status VALUES ('3','O','Ordinary Person ; Default');
INSERT INTO sysuser_status VALUES ('4','D','Deleted');

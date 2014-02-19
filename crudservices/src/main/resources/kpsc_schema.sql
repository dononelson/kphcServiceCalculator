DROP TABLE IF EXISTS SERVICES;
create table SERVICES
(
	Id                    		BIGINT   		NOT NULL,
	Type                        Char(4) 		NOT NULL,        
	Description                 Varchar(255) 	NOT NULL,        
	Effort                      Varchar(10) 	NOT NULL,                
	Lead_Time                   Numeric(5,2) 	NOT NULL,                
	Lead_Time_Unit              varchar(10),        
	Max_Hours                   Numeric(5,2)	NOT NULL,
	Start_Prior_days            smallint        NOT NULL,
	Days_Array                  varchar(512)    NOT NULL,
	Effective_Date				date			NULL
);

ALTER TABLE SERVICES ADD PRIMARY KEY(Id);


DROP TABLE IF EXISTS TASKS;
create table TASKS
(
	Id 							BIGINT   		NOT NULL,
	Service_id   				BIGINT,
	Region    					char(2),
	Env_type   					char(4),
	No_of_env    				smallint,
	Start_Date  				date,
	CRQ_no      				varchar(25),
	Activity_desc  				varchar(255),
	tStart_date   				date,
	tEnd_date     				date,
	status       				varchar(10)
);
ALTER TABLE TASKS ADD PRIMARY KEY(Id);

DROP TABLE IF EXISTS RESOURCES;
create table RESOURCES
(
	Id 							BIGINT   		NOT NULL,							
	Hours_per_staff				smallint,
	No_of_staffs				smallint,
	Effective_date				date
);

DROP TABLE IF EXISTS REGIONS;
create table REGIONS
(
	Id 							BIGINT   		NOT NULL,
	Region_Code				    char(4),
	Descr						varchar(255)
);

DROP TABLE IF EXISTS HOLIDAYS;
create table HOLIDAYS
(
	Id 							BIGINT   		NOT NULL,
	Holiday				    	date,
	Created_Date				date
);



DROP TABLE IF EXISTS APP_SEQ_STORE;
CREATE TABLE APP_SEQ_STORE(
APP_SEQ_NAME VARCHAR(255) NOT NULL,
APP_SEQ_VALUE BIGINT NOT NULL,
PRIMARY KEY(APP_SEQ_NAME)
)

INSERT INTO APP_SEQ_STORE VALUES ('SERVICES.Id', 0);
INSERT INTO APP_SEQ_STORE VALUES ('TASKS.Id', 0);
INSERT INTO APP_SEQ_STORE VALUES ('RESOURCES.Id', 2);
INSERT INTO APP_SEQ_STORE VALUES ('REGIONS.Id', 9);
INSERT INTO APP_SEQ_STORE VALUES ('HOLIDAYS.Id', 2);

INSERT INTO REGIONS (Id, REGION_Code) VALUES (0, 'NCAL');
INSERT INTO REGIONS (Id, Region_Code, Descr) VALUES (1, 'SCAL', 'SCAL');
INSERT INTO REGIONS (Id, Region_Code, Descr) VALUES (2, 'GA', 'GA');
INSERT INTO REGIONS (Id, Region_Code, Descr) VALUES (3, 'MAS', 'MAS');
INSERT INTO REGIONS (Id, Region_Code, Descr) VALUES (4, 'NW', 'NW');
INSERT INTO REGIONS (Id, Region_Code, Descr) VALUES (5, 'HI', 'HI');
INSERT INTO REGIONS (Id, Region_Code, Descr) VALUES (6, 'CO', 'CO');
INSERT INTO REGIONS (Id, Region_Code, Descr) VALUES (7, 'OH', 'OH');
INSERT INTO REGIONS (Id, Region_Code, Descr) VALUES (8, 'NATL', 'NATL');

insert into RESOURCES(Id, Hours_per_staff, No_of_staffs, Effective_date) values (1, 7, 15, curdate());
insert into HOLIDAYS values(1, '2014-02-17', curdate());


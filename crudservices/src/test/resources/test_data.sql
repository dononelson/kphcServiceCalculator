
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

insert into SERVICES values(100,
							'S7',
							'S7 : Environment Refresh Non-Prod from Prod Full Copy',
							'medium',
							5.0,
							'days',
							70.0,
							3,
							'1,1,6,12,12,12,12,12,2',
							'2014-02-21'
                           );
insert into TASKS values(42,
						 100,
						 'CO',
						 'NP',
						 1,
						 '2014-04-01',
						 'CRQ000000153222',
						 'KPHC CO - TESTCO3 refresh from TESTCO6',
						 null,
						 null,
						 null);

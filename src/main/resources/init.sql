DECLARE
BEGIN
DELETE FROM  person;
DELETE FROM  village;
insert into village(id, death_count, new_born_count) values (1,0,0);
insert into person (id, age, village_id,family_type,name,person_sts) values (1,1,1,'A', 'Neeraj', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values  (2,2,1,'A', 'Suraj', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values  (3,3,1,'A', 'Suresh', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values  (4,33,1,'A', 'Mukesh', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values  (5,32,1,'A', 'Rani', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values  (6,63,1,'A', 'Gaurav', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values   (7,62,1,'A', 'Sakshi', 'alive');
    
insert into person (id, age, village_id,family_type,name,person_sts) values (8,1,1,'B', 'NeerajB', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values  (9,2,1,'B', 'SurajB', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values  (10,3,1,'B', 'SureshB', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values   (11,4,1,'B', 'RiyaB', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values  (12,34,1,'B', 'MukeshB', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values  (13,33,1,'B', 'RaniB', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values  (14,64,1,'B', 'GauravB', 'alive');
insert into person (id, age, village_id,family_type,name,person_sts) values   (15,63,1,'B', 'SakshiB', 'alive');

commit;
end;
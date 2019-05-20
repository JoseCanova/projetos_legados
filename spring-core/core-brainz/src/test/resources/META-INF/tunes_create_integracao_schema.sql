create table TuneArtist (id int8 not null, name varchar(255) not null, checked boolean not null, primary key (id))
create table TuneArtist_TuneCredit (TuneArtist_id int8 not null, credits_id int8 not null, primary key (TuneArtist_id, credits_id))
create table TuneArtist_TuneRecord (TuneArtist_id int8 not null, records_id int8 not null, primary key (TuneArtist_id, records_id))
create table TuneArtist_TuneRelease (TuneArtist_id int8 not null, releases_id int8 not null, primary key (TuneArtist_id, releases_id))
create table TuneCredit (id int8 not null, name varchar(255) not null, checked boolean not null, primary key (id))
create table TuneRecord (id int8 not null, name varchar(255) not null, checked boolean not null, primary key (id))
create table TuneRecord_TuneTrack (TuneRecord_id int8 not null, tracks_id int8 not null, primary key (TuneRecord_id, tracks_id))
create table TuneRelease (id int8 not null, name varchar(255) not null, checked boolean not null, primary key (id))
create table TuneTrack (id int8 not null, name varchar(255) not null, checked boolean not null, primary key (id))
alter table TuneArtist_TuneCredit add constraint UK_cv1v4gd2rwo47buetx30mh1rg  unique (credits_id)
alter table TuneArtist_TuneRecord add constraint UK_s8byig78fxka3b4n4b5r6atj1  unique (records_id)
alter table TuneArtist_TuneRelease add constraint UK_er44g8rtl53am6c7i58opa0t0  unique (releases_id)
alter table TuneRecord_TuneTrack add constraint UK_892eeqvfn3s9fmhovswjmqm0m  unique (tracks_id)
alter table TuneArtist_TuneCredit add constraint FK_cv1v4gd2rwo47buetx30mh1rg foreign key (credits_id) references TuneCredit
alter table TuneArtist_TuneCredit add constraint FK_5a2f12mdk17c9v3mmyegblkfq foreign key (TuneArtist_id) references TuneArtist
alter table TuneArtist_TuneRecord add constraint FK_s8byig78fxka3b4n4b5r6atj1 foreign key (records_id) references TuneRecord
alter table TuneArtist_TuneRecord add constraint FK_1vkyft5u7s2xm3ywo2ng9qtew foreign key (TuneArtist_id) references TuneArtist
alter table TuneArtist_TuneRelease add constraint FK_er44g8rtl53am6c7i58opa0t0 foreign key (releases_id) references TuneRelease
alter table TuneArtist_TuneRelease add constraint FK_62ygqc3c5neb3j3428gimkpqs foreign key (TuneArtist_id) references TuneArtist
alter table TuneRecord_TuneTrack add constraint FK_892eeqvfn3s9fmhovswjmqm0m foreign key (tracks_id) references TuneTrack
alter table TuneRecord_TuneTrack add constraint FK_qo8k4xxxxohfcip17l8u2m0dl foreign key (TuneRecord_id) references TuneRecord

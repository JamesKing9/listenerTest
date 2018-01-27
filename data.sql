
DROP DATABASE`javaee`;
CREATE DATABASE `javaee`;
use javaee;

create table news_inf(
    news_id int auto_increment, 
    news_title varchar(255), 
    primary key(news_id)
);

insert into `news_inf`
    values
(null, "Inside Amazon's spheres, where workers chill in a rainforest"),
(null, "Aniston recently met Brad Pitt's kids"),
(null, "In Miryang, South Korea, a hospital fire kills 37 people and injures more than 130 others. "),
(null, "Rocket Lab's Electron becomes the first rocket to reach orbit using an electric pump-fed engine."),
(null, "An attack on a hotel (pictured) in Kabul, Afghanistan, kills at least 18 people and injures more than 20 others."),
(null, "If you read one thing today, make it this TIME piece from Microsoft’s Lili Cheng about why we should be optimistic about AI."),
(null, "All my work shirts are made by my Hong Kong tailor, Mr Chung. Unlike most tailors who just take your measurement and get someone else to do the stitching, Mr Chung does everything, from cutting to sewing, himself. "),
(null, "Very cool to see this first thing upon opening up the App Store this morning.  Great job Sofia!
");

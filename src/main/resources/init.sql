create databases `chatspringboot`;

use `chatspringboot`;

create table `user` (
	id int not null auto_increment,
	username varhcar(200) not null,
	email varchar(200) not null,
	password varchar(64) not null,
	primary key (id)
);

create table `role` (
	id int not null auto_increment,
	name varchar(100) not null,
	primary key (id)
);

insert into `role` (`name`) values ("USER");
insert into `role` (`name`) values ("ADMIN");

create table `users_roles` (
	`user_id` int not null,
	`role_id` int not null,
	key `user_fk_idx` (`user_id`),
	key `role_fk_idx` (`role_id`),
	constraint `user_fk` foreign key (`user_id`) references `user` (`id`),
	constraint `role_fk` foreign key (`role_id`) references `role` (`id`)
);
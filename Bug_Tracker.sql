
Create table Role(role_id int not null GENERATED ALWAYS AS IDENTITY primary key, role_name varchar(20) not null unique);

Create table Users(user_id int not null GENERATED ALWAYS AS IDENTITY primary key, user_name varchar(20) not null, email varchar(30) not null, password varchar(20) ,role_id int , available int not null,last_login timestamp,FOREIGN KEY (role_id) REFERENCES Role(role_id));


Create table Project(prj_id int not null GENERATED ALWAYS AS IDENTITY primary key, prj_name varchar(30) not null unique, description varchar(250), start_date date not null,status varchar(15) not null);


Create table Proj_users(prj_id int ,user_id int ,primary key(prj_id,user_id),FOREIGN KEY (prj_id) references Project(prj_id),FOREIGN KEY(user_id) references Users(user_id));

Create table Bug(bug_id int not null GENERATED ALWAYS AS IDENTITY primary key, title varchar(30) not null,description varchar(200) not null,prj_id int ,open_date date not null, marked_for_closing varchar(5) ,closed_on date ,status varchar(15) not null,severity varchar(15) not null,FOREIGN KEY(prj_id) references Project(prj_id));

Create table Bug_user(bug_id  int not null,user_id int not null,primary key(bug_id,user_id),FOREIGN KEY(bug_id) references Bug(bug_id),FOREIGN KEY(user_id) references Users(user_id));


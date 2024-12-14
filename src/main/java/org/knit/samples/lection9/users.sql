CREATE TABLE public.users (
	id bigint GENERATED ALWAYS AS IDENTITY NOT NULL,
	"name" varchar NOT NULL,
	"role" varchar NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);

INSERT INTO public.users ("name", "role") VALUES
('Alice', 'Admin'),
('Bob', 'User'),
('Charlie', 'User'),
('Diana', 'Moderator'),
('Eve', 'User'),
('Frank', 'User'),
('Grace', 'Admin'),
('Hank', 'User'),
('Ivy', 'Moderator'),
('Jack', 'User');

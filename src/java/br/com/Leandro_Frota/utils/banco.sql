create table Veiculo(idVeiculo serial  primary key not null,
					marca varchar(40),
					modelo varchar(40),
					odometro int,
					valorVeiculo decimal(10,2),
					observacao varchar(100));
					
insert into Veiculo(marca, modelo, odometro, valorVeiculo, observacao) values('Ford','sedan',5000,80000.00,'carro novo');

select * from Veiculo;
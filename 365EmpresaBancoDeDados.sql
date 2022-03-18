create database empresa365;
use empresa365;

Create table CLIENTE(
idCliente int primary key auto_increment,
idDestino int null,
nomeCliente varchar(60) not null,
CPF varchar(11) not null,
tel varchar(11) not null,
email varchar(100) not null,
creditCard varchar(24) not null,
foreign key(idDestino) references DESTINO(idDestino) on delete cascade 
);

Create table PROMOCAO(
idPromocao int primary key auto_increment,
idDestino int not null,
percentualDesconto double not null,
foreign key(idDestino) references DESTINO(idDestino) on delete cascade 
);

Create table DESTINO(
idDestino int primary key auto_increment,
nomeDestino varchar(100) not null,
localPartida varchar(100) not null,
horasDeViagem int not null,
dataViagem datetime not null,
preco double not null 
);


DELIMITER $$
create function fn_calcularPrecoComDesconto(preco double, percentualDesconto double)
returns double
deterministic
BEGIN
declare precoComDesconto double;
set precoComDesconto = preco * (1 - percentualDesconto/100);

return precoComDesconto;

end$$

select fn_calcularPrecoComDesconto(800, 10);

insert into destino (nomeDestino, localPartida, horasDeViagem, dataViagem, preco) values ('Guatemala', 'Rio de Janeiro', 5, '2022-03-29 12:00', 2200.00);
select * from destino;

insert into cliente (nomeCliente, CPF, tel, email, creditCard) values ('andre', '65733425321', '56986431324', 'andrefelipe@gmail.com', '4356423457585443');
update cliente set email = 'andremelo@gmail.com' where nomeCliente = 'andre';
select * from cliente;

insert into promocao (idDestino, percentualDesconto) values (1, 10);
insert into promocao (idDestino, percentualDesconto) values (3, 15);
select*from promocao;

Create View DestinoPromocao as
Select d.*, p.idPromocao, p.percentualDesconto, fn_calcularPrecoComDesconto(d.preco, p.percentualDesconto) as 'Preço com desconto'  
from agviagem.destino d
left join agviagem.promocao p
on d.idDestino = p.idDestino;

Select * from DestinoPromocao;


Create View DestinoEPromocao as
Select d.*, p.idPromocao, p.percentualDesconto, fn_calcularPrecoComDesconto(d.preco, p.percentualDesconto) as 'Preço a pagar'  
from agviagem.destino d
Inner join agviagem.promocao p
on d.idDestino = p.idDestino;
Select * from DestinoEPromocao;

Create View DestinoSemPromocao as
Select d.*, p.idPromocao, p.percentualDesconto, fn_calcularPrecoComDesconto(d.preco, p.percentualDesconto) as 'Preço a pagar'  
from agviagem.destino d
left join agviagem.promocao p
on d.idDestino = p.idDestino
where p.idPromocao is null;

Select * from DestinoSemPromocao;


Create View TabelaViajantes as
Select c.idCliente, c.nomeCliente, c.CPF, c.tel, c.email, c.creditCard ,d.*, p.idPromocao, p.percentualDesconto, fn_calcularPrecoComDesconto(d.preco, p.percentualDesconto) as 'Preço a pagar'  
from agviagem.cliente c 
inner join agviagem.destino d
on c.idDestino = d.idDestino
left join agviagem.promocao p
on d.idDestino = p.idDestino;

Select * from TabelaViajantes;
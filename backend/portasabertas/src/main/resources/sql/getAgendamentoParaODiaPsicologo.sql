select a.data as data,
p.nome as pacienteNome,
p.telefone as pacienteTelefone
from agendamento as a
inner join paciente as p
on a.paciente_id = p.id
where DATE(DATE_FORMAT(a.data,'%Y-%m-%d')) = '2021-12-07' and
p.id = 11;

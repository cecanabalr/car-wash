select reserva.*,
       agenda.fecha_inicio,
       agenda.fecha_fin,
       agenda.disponibilidad,
       servicio.nombre,
       servicio.valor
from reserva
         inner join agenda on reserva.id_agenda = agenda.id
         inner join servicio on reserva.id_servicio = servicio.id
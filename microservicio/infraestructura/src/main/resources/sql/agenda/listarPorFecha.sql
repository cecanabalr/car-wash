select id,fecha_inicio,fecha_fin,fecha_creacion,disponibilidad
from agenda
where fecha_inicio in (select fecha_inicio from agenda where fecha_inicio > now())
and fecha_inicio >= :fechaInicio
and disponibilidad = true
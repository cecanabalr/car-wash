select id,fecha_inicio,fecha_fin,fecha_creacion,disponibilidad
from agenda
where id = :id
and disponibilidad = true
and fecha_inicio >= now()
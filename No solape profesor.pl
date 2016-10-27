%Mismo dia, a la misma hora, mismo profesor.

mismoProfesor(profesor(Asignatura1,Nombre),profesor(Asignatura2,Nombre)):-
	Asignatura1\=Asignatura2.


horarioInvalido(asignacion(FranjaId1, Curso1,Asignatura1,intervalo(H1,H2),Dia),
		asignacion(FranjaId2, Curso2,Asignatura2,intervalo(H1,H2),Dia)):-

		asignacion(FranjaId1, Curso1,Asignatura1,intervalo(H1,H2),Dia),
		asignacion(FranjaId2, Curso2,Asignatura2,intervalo(H1,H2),Dia),
		FranjaId1 \= FranjaId2,
		profesor(Asignatura1,Prof),profesor(Asignatura2,Prof).


asignacion(1, gisi(3),isi,intervalo(830,1030),dia(1)).
asignacion(2, gisi(3),iac,intervalo(1030,1230),dia(1)).
%asignacion(3, gisi(3),iac,intervalo(830,1030),dia(2)).
asignacion(3, gisi(3),iso,intervalo(1230,1430),dia(1)).
asignacion(4, gisi(1),pr1,intervalo(830,1030),dia(2)).

profesor(iac,mfl).
profesor(pr1,mfl).


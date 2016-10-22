%Mismo dia, a la misma hora, mismo profesor.

horarioInvalido((franja(curso(N1),Asignatura1,intervalo(H1,H2),Dia),
		franja(curso(N2),Asignatura2,intervalo(H1,H2),Dia)):-

		franja(curso(N1),Asignatura1,intervalo(H1,H2),Dia),
		franja(curso(N2),Asignatura2,intervalo(H1,H2),Dia),
		Asignatura1\=Asignatura2,
		profesor(Asignatura1,Prof),
		profesor(Asignatura2,Prof)).




mismoProfesor(profesor(Asignatura1,Nombre),profesor(Asignatura2,Nombre)):-
	Asignatura1\=Asignatura2.

franja(gisi(3),isi,intervalo(830,1030),dia(1)).
franja(gisi(3),iac,intervalo(1030,1230),dia(1)).
franja(gisi(3),iso,intervalo(1230,1430),dia(1)).
franja(gisi(1),pr1,intervalo(830,1030),dia(2)).

profesor(iac,mfl).
profesor(pr1,mfl).


solape(intervalo(A,B),intervalo(C,D)):-
	%Amplitudes iguales

	C<A, A<D;
	C=A, B=D;
	A<C, C<B, B<D;

	%Amplitud del segundo menor que la del primero
	%C<A, A<D
	A<C, D<B;
	C<B,B<D;

	%Amplitud del segundo mayor que la del primero
	%C<A, A<D;
	C<A, B<D.
	%A<C, C<B, B<D

%El horario es invalido si a un profesor se le solapan las clases
horarioInvalido(Horario):-
	horarioAsignacion(Horario, FranjaId1),
	horarioAsignacion(Horario, FranjaId2),
	FranjaId1 \= FranjaId2,
	asignacionProfesor(FranjaId1, Profesor),
	asignacionProfesor(FranjaId2, Profesor),
	asignacionTiempo(FranjaId1, Intervalo1, Dia),
	asignacionTiempo(FranjaId2, Intervalo2, Dia),
	solape(Intervalo1, Intervalo2).

%no puede haber clase en el intervalo de H1-H2

horarioInvalido(Horario):-
%H1y H2 lo mete el cliente
	horarioAsignacion(Horario, FranjaId1),
	asignacionTiempo(FranjaId1, intervalo(1430,1330), _Dia).

% el horario es invalido si se le asigna clase a un profesor a una hora
% que no puede
%horarioInvalido(Horario):-
	%horarioAsignacion(Horario, FranjaId1),
	%asignacionProfesor(FranjaId1, _Nombre),
	%asignacionTiempo(FranjaId1, intervalo(A,B),dia(D)),
	%asignacionTiempoNoPuedeProfesor(FranjaId1,intervalo(A,B),dia(D)).



generarHorario:-
	write('Introduzca el horario: '),
	read(Horario),
	write('Introduzca el id del horario: '),
	read(Id),
	assert(horarioAsignacion(Horario,Id)),
	write('Introduzca el profesor: '),
	read(Profesor),
	assert(asignacionProfesor(Id,Profesor)),
	write('intervalo(H1,H2)' ),
	read(intervalo(H1,H2)),
	write('dia(N): '),
	read(dia(N)),
	assert(asignacionTiempo(Id,intervalo(H1,H2),dia(N))),
	horarioInvalido(Horario).

salida:-
	tell('C:/Users/Clara/Desktop/horarios/TimeTableManager/salida.txt'),
	generarHorario,
	told.

generarHorario1:-
	consult('C:/Users/Clara/Desktop/horarios/TimeTableManager/leer.txt'),
	horarioInvalido(Horario).



%asignacionTitulacion(1, gisi).
%asignacionCurso(1, 3).
%asignacionAsignatura(1, isi).
%asignacionAsignatura(1, pt).
%asignacionProfesor(1, pgr).
%asignacionProfesor(2, pgr).
%asignacionTiempo(1, intervalo(830,1030),dia(1)).
%asignacionTiempo(2, intervalo(830,1030),dia(1)).
%asignacionTiempo(1, intervalo(1230,1430),dia(1)).

%asignacionTiempo(1, intervalo(1830,2030),dia(1)).
%asignacionTiempoNoPuedeProfesor(1,intervalo(830,1030),dia(1)).


%asignacionTiempo(1, intervalo(830,1230),dia(2)).
%asignacionTiempo(1, intervalo(830,1230),dia(3)).
%horarioAsignacion(horario1, 1).
%horarioAsignacion(horario1, 2).













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
horarioInvalido(Horario):-
	horarioAsignacion(Horario, FranjaId1),
	asignacionProfesor(FranjaId1, _Nombre),
	asignacionTiempo(FranjaId1, intervalo(A,B),dia(D)),
	asignacionTiempoNoPuedeProfesor(FranjaId1,intervalo(A,B),dia(D)).


leerHorario:-
	consult('C:/Users/Clara/Desktop/horarios/TimeTableManager/leer.txt'),
	horarioInvalido(Horario).

borrar(X,[X|T],T).
borrar(X,[H|T],[H|NT]):-
	borrar(X,T,NT).

variaciones(0,_,[]).
variaciones(N,L,[H|Varia]):-
	N>0,
	N1 is N-1,
	borrar(H,L,Rest),
	variaciones(N1,Rest,Varia).


generarHorario(X):-
	L=[830,930,1030,1130,1230,1330,1430,1530,1630,1730,1830,1930,2030],
	variaciones(2,L,X).


asignacionTitulacion(1, gisi).
asignacionCurso(1, 3).
asignacionAsignatura(1, isi).
%asignacionAsignatura(1, pt).
asignacionProfesor(1, pgr).
%asignacionProfesor(2, pgr).
%asignacionTiempo(1, intervalo(X,Y),dia(N)).
%asignacionTiempo(2, intervalo(830,1030),dia(1)).
%asignacionTiempo(1, intervalo(1230,1430),dia(1)).

%asignacionTiempo(1, intervalo(1830,2030),dia(1)).
%asignacionTiempoNoPuedeProfesor(1,intervalo(830,1030),dia(1)).


%asignacionTiempo(1, intervalo(830,1230),dia(2)).
%asignacionTiempo(1, intervalo(830,1230),dia(3)).
horarioAsignacion(horario1, 1).
%horarioAsignacion(horario1, 2).









































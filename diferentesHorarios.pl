%Mismo dia, a la misma hora, mismo profesor.
%El solape son tres convoluciones:
% 1. Convolucion de dos pulsos rectangulares con la misma amplitud
% 2. Convolucion de dos pulsos rectangulares: el segundo menor amplitud
% 3. Convolucion de dos pulsos rectangulares: el segundo mayor amplitud

solape(intervalo1(A,B),intervalo2(C,D)):-
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


horarioInvalido(Horario):-
	horarioAsignacion(Horario, FranjaId1),
	horarioAsignacion(Horario, FranjaId2),
	FranjaId1 \= FranjaId2,
	asignacionProfesor(FranjaId1, Profesor),
	asignacionProfesor(FranjaId2, Profesor),
	asignacionTiempo(FranjaId1, Intervalo1, Dia),
	asignacionTiempo(FranjaId2, Intervalo2, Dia),
	solape(Intervalo1, Intervalo2).


asignacionTitulacion(1, gisi).
asignacionCurso(1, 3).
asignacionAsignatura(1, isi).
asignacionProfesor(1, pgr).
asignacionTiempo(1, intervalo(830,1030),dia(1)).

asignacionTitulacion(2, gisi).
asignacionCurso(2, 3).
asignacionAsignatura(2, iac).
asignacionProfesor(2, mfl).
asignacionTiempo(2, intervalo(1030,1230),dia(1)).

asignacionTitulacion(3, gisi).
asignacionCurso(3, 3).
asignacionAsignatura(3, iso).
asignacionProfesor(3, rgg).
asignacionTiempo(3, intervalo(1230,1430),dia(1)).

asignacionTitulacion(4, gisi).
asignacionCurso(4, 1).
asignacionAsignatura(4, pr1).
asignacionProfesor(4, mfl).
asignacionTiempo(intervalo(830,1030),dia(2)).

planEstudios(teleco,sistemasOperativos,2).
planEstudios(informatica,sistemasOperativos,2).

valoracion(horario1, 10).
horarioAsignacion(horario1, 1).
horarioAsignacion(horario1, 2).
horarioAsignacion(horario1, 3).
horarioAsignacion(horario1, 4).








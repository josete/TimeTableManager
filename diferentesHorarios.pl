%Mismo dia, a la misma hora, mismo profesor.
%El solape son tres convoluciones:
% 1. Convolucion de dos pulsos rectangulares con la misma amplitud
% 2. Convolucion de dos pulsos rectangulares: el segundo menor amplitud
% 3. Convolucion de dos pulsos rectangulares: el segundo mayor amplitud

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

%no puede haber clase en el intervalo de 1430-1530

horarioInvalido(Horario):-

	horarioAsignacion(Horario, FranjaId1),
	asignacionTiempo(FranjaId1, intervalo(1430,1530), _Dia).

% el horario es invalido si se le asigna clase a un profesor a una hora
% que no puede
horarioInvalido(Horario):-
	horarioAsignacion(Horario, FranjaId1),
	asignacionProfesor(FranjaId1, _Nombre),
	asignacionTiempo(FranjaId1, intervalo(A,B),dia(D)),
	asignacionTiempoNoPuedeProfesor(FranjaId1,intervalo(A,B),dia(D)).


unaAsignaturaDosPlanesEstudio(Horario):-
	horarioAsignacion(Horario, FranjaId1),
	horarioAsignacion(Horario, FranjaId2),
	FranjaId1 \= FranjaId2,
	asignacionAsignatura(FranjaId1, Asignatura),
	asignacionAsignatura(FranjaId2, Asignatura),
	asignacionTitulacion(FranjaId1, Titulacion1),
	asignacionTitulacion(FranjaId2, Titulacion2),
	Titulacion1\=Titulacion2.

% Un profesor no puede tener mas de 8 horas de clase al dia, ni menos de
% 4

numeroHorasValidoPorDiaProfesor(Horario):-
     %La N (el dia concreto) se le pide al cliente que la meta por teclado
     N=1,
     findall(Dif, (horarioAsignacion(Horario,A),asignacionProfesor(A, Prof), asignacionTiempo(A, intervalo(H1, H2), dia(N)), Dif is H2 - H1), L),
     sumaElementosLista(L,Horas),
     Horas=<800,
     Horas>=400.

numeroHorasValidoPorSemanaProfesor(Horario):-
     findall(Dif, (horarioAsignacion(Horario,A),asignacionProfesor(A, Prof), asignacionTiempo(A, intervalo(H1, H2), dia(N)), Dif is H2 - H1), L),
     sumaElementosLista(L,Horas),
     Horas=<600,
     Horas>=2000.








%Suma las horas de todos los dias
numeroHorasValidoPorSemana(Horario):-
 findall(N,(horarioAsignacion(Horario,A),asignacionProfesor(A,Prof),asignacionTiempo(A,intervalo(H1,H2),dia(N))),L),

 recorrerLista(L,T),
 sumaElementosLista(T,Horas),
 Horas=<2000,
 Horas>=600.


% Recorre la lista que contiene todos los dias que da clase un profesor,
% sacando las horas que da cada dia
recorrerLista([],[]).
recorrerLista([I|R],[T|U]):-
	 findall(Dif, (horarioAsignacion(Horario,A),asignacionProfesor(A, _Prof), asignacionTiempo(A, intervalo(H1, H2), dia(I)), Dif is H2 - H1), T),
	 recorrerLista(R,U).



sumaElementosLista([],0).
sumaElementosLista([A|B],R):-
	sumaElementosLista(B,S),
	R is S+A.

primeroLista([],[]).
primeroLista([A|_B],A).

ultimoLista([X],X).
ultimoLista([A|B],U):-
	ultimoLista(B,U).

segundoLista([X|[]],0).
segundoLista([A|B],E):-
	primeroLista(B,E).


comprobacionDosListas(_L,[X|[]]).
comprobacionDosListas([E|V],[U|W]):-
	primeroLista([E|V],E),
	segundoLista([U|W],E),
	comprobacionDosListas(V,W).

elementoMayor([X],X).
elementoMayor([X|Y],X):-
	elementoMayor(Y,N),
	X>N.
elementoMayor([X|Y],N):-
	elementoMayor(Y,N),
	X<N.

elementoMenor([X],X).
elementoMenor([X|Y],X):-
	elementoMenor(Y,G),
	X<G.
elementoMenor([X|Y],G):-
	elementoMenor(Y,G),
	X>G.

listaAsignaciones(Horario,L) :-
	findall(intervaloDia(H1, H2, Dia),
		asignacionTiempo(Horario, intervalo(H1, H2), Dia), L).

elementoMenorEnListaIntervaloDia([IntervaloDia], IntervaloDia).

elementoMenorEnListaIntervaloDia([Intervalo1|R], Intervalo1) :-
	elementoMenorEnListaIntervaloDia(R, Intervalo2),
	menorQue(Intervalo1, Intervalo2).

elementoMenorEnListaIntervaloDia([Intervalo1|R], Intervalo2) :-
	elementoMenorEnListaIntervaloDia(R, Intervalo2),
	\+ menorQue(Intervalo1, Intervalo2).

menorQue(intervaloDia(H1, H2, Dia),
	 intervaloDia(H3, H4, Dia)) :-
	H2 < H4.

menorQue(intervaloDia(H1, H2, dia(D1)),
	intervaloDia(H3, H4, dia(D2))) :-
	D1 < D2.

%Ordenar lista de mayor a menor
ordenarLista([X],[X]).
ordenarLista([X|Y],[X|V]):-
	elementoMenorEnListaIntervaloDia([X|Y],X),
	ordenarLista(Y,V).

ordenarLista([X|Y],[T|V]):-
	elementoMenorEnListaIntervaloDia([X|Y],T),
	borrar(T,[X|Y],L1),
	ordenarLista(L1,V).

borrar(X,[X|T],T).
borrar(X,[H|T],[H|NT]):-
	borrar(X,T,NT).

%  listaAsignaciones(1, L), ordenarLista(L, Lo).

meet(intervaloDia(0,0,Dia),0).

meet(intervaloDia(H1,H2,Dia), Horas) :-
	Horas is H2 - H1.

meet(intervaloDia(H1, H2,Dia),
      intervaloDia(H2, H3,Dia), Horas) :-
	Horas is H3 - H1.

meet(intervaloDia(H1, H2, Dia),
      intervaloDia([(H2, H3,Dia)|Resto]), Horas) :-
	Horas12 is H3 - H1,
	meet([intervaloDia(H2, H3,Dia) | Resto], HorasResto),
	Horas is Horas12 + HorasResto.

%intervaloDia(H1,H2,Dia).

%El profesor no puede tener mas de 6 horas de clase seguidas
% Si por la ma�ana tiene un numero de horas seguidas que no supera el
% limite de 6 y luego tiene una hora libre y clase otra vez, debe salir
% ture
horasContinuasDiaProfesor(Horario):-
	N=1,
	findall(H1,(horarioAsignacion(Horario, A),asignacionProfesor(A, Prof),asignacionTiempo(A, intervalo(H1,H2),dia(N))),L),
	findall(H2,(horarioAsignacion(Horario, A),asignacionProfesor(A, Prof),asignacionTiempo(A, intervalo(H1,H2),dia(N))),T),
	comprobacionDosListas(T,L),
	primeroLista(L,X),
	ultimoLista(T,Y),
	Dif is Y-X,
	Dif=<600;
	N=1,
	findall(H1,(horarioAsignacion(Horario, A),asignacionProfesor(A,
	Prof),asignacionTiempo(A, intervalo(H1,H2),dia(N))),L),
	findall(H2,(horarioAsignacion(Horario, A),asignacionProfesor(A,
	Prof),asignacionTiempo(A, intervalo(H1,H2),dia(N))),T),
	\+comprobacionDosListas(T,L).

%Un profesor no debe tener mas de 6 horas libres
maxGapsProfesorPorDia(Horario):-
     N=1,
% Mete en la lista L las horas a las que acaban las sesiones de un
% profesor en un dia
      findall(H2,(horarioAsignacion(Horario, A),asignacionProfesor(A, Prof),asignacionTiempo(A, intervalo(H1,H2),dia(N))),L),

% Mete en la lista T las horas a las que empiezan las sesiones de un
% profesor en un dia
       findall(H1,(horarioAsignacion(Horario, A),asignacionProfesor(A, Prof),asignacionTiempo(A, intervalo(H1,H2),dia(N))),T),

% Coge el elemento mayor de la lista L y el menor de la lista T y asi ya
% tenemos el rango de horas que el profesor esta en la universidad y al
% cual se le aplica el max gaps por dia
       elementoMayor(L,E),
       elementoMenor(T,U),

% Coge el numero de horas al dia que un profesor tiene clase y lo mete
% en la variable Horas
       findall(Dif, (horarioAsignacion(Horario,A),asignacionProfesor(A, Prof), asignacionTiempo(A, intervalo(H1, H2), dia(N)), Dif is H2 - H1), W),
       sumaElementosLista(W,Horas),

       %Resta es el rango de horas en el que un profesor tiene clases al dia
       Resta is E-U,
       %Las horas libres ser�n las horas que pasa en la universidad(Resta) menos las que esta dando clase (Horas).
       HorasLibres is Resta-Horas,
       %Horas libres = parametro que tiene que ser configurable por el ususario.
       HorasLibres=<600.

maxGapsProfesorPorSemana(Horario):-
	 findall(N,(horarioAsignacion(Horario,A),asignacionProfesor(A,Prof),asignacionTiempo(A,intervalo(H1,H2),dia(N))),L),
	 elim(L,X),
	 recorrerListaGapsDia(X,HorasLibres),
	 sumaElementosLista(HorasLibres,S),
	 %S es el parametro que mete el cliente
	 S=<30000.

elim([],[]).
elim([H|T],S):-member(H,T),!,elim(T,S).
elim([H|T],[H|S]):-elim(T,S).



recorrerListaGapsDia([],[]).
recorrerListaGapsDia([I|R],[HorasLibres|Y]):-
	findall(H2,(horarioAsignacion(Horario, A),asignacionProfesor(A, Prof),asignacionTiempo(A, intervalo(H1,H2),dia(I))),L),
	findall(H1,(horarioAsignacion(Horario, A),asignacionProfesor(A, Prof),asignacionTiempo(A, intervalo(H1,H2),dia(I))),T),
	elementoMayor(L,E),
	elementoMenor(T,U),
	findall(Dif, (horarioAsignacion(Horario,A),asignacionProfesor(A, Prof), asignacionTiempo(A, intervalo(H1, H2), dia(I)), Dif is H2 - H1), W),
       sumaElementosLista(W,Horas),
       Resta is E-U,
       HorasLibres is Resta - Horas,

       recorrerListaGapsDia(R,Y).

%No falla sino que da un error
diasEntreSesiones(Horario):-
	findall(N,(horarioAsignacion(Horario,A),asignacionProfesor(A,Prof),asignacionTiempo(1,intervalo(H1,H2),dia(N))),L),
	elim(L,X),
	restaElementosLista(X,T),
	elementoMayor(T,U),
	%El valor de U lo mete el usuario, es el numero max y  min de dias de separacion entre sesiones.
	U<3,
	U>1.


sumaElementosLista([],0).
sumaElementosLista([X|Y],R):-
	sumaElementosLista(Y,Z),
	R is X+Z.
restaElementosLista([],[]).
restaElementosLista(L,[]):-
	segundoLista(L,0).
restaElementosLista([X|Y],[R|T]):-
	segundoLista([X|Y],S),
	R is S-X,
	restaElementosLista(Y,T).

intervaloDia(H1,H2,Dia):-
	H1,H2,Dia.

asignacionTitulacion(1, gisi).
asignacionCurso(1, 3).
asignacionAsignatura(1, isi).
%asignacionAsignatura(1, pt).
asignacionProfesor(1, pgr).
asignacionTiempo(1, intervalo(830,1030),dia(1)).
asignacionTiempo(1, intervalo(1030,1230),dia(1)).
asignacionTiempo(1, intervalo(1230,1430),dia(1)).

asignacionTiempo(1, intervalo(1830,2030),dia(1)).

%asignacionTiempo(1, intervalo(830,1230),dia(2)).
asignacionTiempo(1, intervalo(830,1230),dia(3)).

%asignacionTiempoNoPuedeProfesor(1,intervalo(830,1030),dia(1)).
%asignacionTiempo(1, intervalo(1230,1430),dia(1)).


%asignacionTitulacion(2, gist).
%asignacionAsignatura(2, isi).



asignacionTitulacion(2, gisi).
asignacionCurso(2, 3).
asignacionAsignatura(2, iac).
%asignacionProfesor(2, mfl).
asignacionProfesor(2, pgr).
asignacionTiempoNoPuedeProfesor(2,intervalo(830,1030),dia(1)).
asignacionTiempo(2, intervalo(1630,2030),dia(1)).

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

valoracion(horario1, 10).
horarioAsignacion(horario1, 1).
%horarioAsignacion(horario1, 2).
%horarioAsignacion(horario1, 3).
%horarioAsignacion(horario1, 4).
















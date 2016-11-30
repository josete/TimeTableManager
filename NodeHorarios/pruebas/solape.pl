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

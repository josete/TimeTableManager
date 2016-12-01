<<<<<<< HEAD
vive(X,Y,Z):-
	is(Z,=(X,Y)).
viveMayor(X,Y,Z):-
	is(Z,>(X,Y)).
viveMenor(X,Y,Z):-
	is(Z,<(X,Y)).
=======
vive(X,Y):-
	=(X,Y).
>>>>>>> 3508acbdc89bb93490db6c9a91563460d853e25d
bird(pigeon).
bird(penguin).
lives(pigeon,_).
lives(penguin,antarctica).
lives(penguin,argentina).
lives(penguin,australia).
lives(penguin,chile).
lives(gorrion,alemania).

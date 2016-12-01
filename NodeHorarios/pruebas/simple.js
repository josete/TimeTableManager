var Prolog = require('jsprolog');
var p = require('./prueba.js');
var fs = require('fs');

var pu = new p();
var datos = fs.readFileSync('example.pl').toString();
console.log(datos);
var db = Prolog.default.Parser.parse(datos);
	//Como el modulo utilizado no admite realizar asserts, se hacen desde una clase separada, que modifica la base de datos prolog
	anadir = pu.anadirLives("penguin",["zoo","espana"],datos);
	db = anadir[0];
	datos = anadir[1];
	anadir = pu.anadirLives("gorrion",["francia","espana"],datos);
	db = anadir[0];
	datos = anadir[1];
	anadir = pu.anadirBird(["gorrion","aguila","periquito"],datos);
	db = anadir[0];
	datos = anadir[1];
	query = Prolog.default.Parser.parseQuery("viveMenor(1,2,X)."); 
    iter = Prolog.default.Solver.query(db, query);

while(iter.next()){	
	console.log(iter);
    console.log("X = ", iter.current.Y);
}
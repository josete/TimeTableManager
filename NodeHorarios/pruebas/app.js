var Prolog = require('jsprolog');
var p = require('./prueba.js');
var fs = require('fs');

var pu = new p();
var datos = fs.readFileSync('solape.pl').toString();
var db = Prolog.default.Parser.parse(datos);
	query = Prolog.default.Parser.parseQuery("member(X,[a,b,c]),member(Y,[1,2,3])."); 
    iter = Prolog.default.Solver.query(db, query);

while(iter.next()){
    console.log("X = ", iter.current.X);
}

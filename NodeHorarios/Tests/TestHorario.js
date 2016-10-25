horario = require("../Source/Objetos/Horario.js");
sesion = require("../Source/Objetos/Sesion.js");

exports.testHorarioSinGrupo = function(test){
	h = new horario();
	test.throws(function () { h.generar();});
	test.done();
}

exports.testHorarioSinAsignaturas = function(test){
	h = new horario();
	h.setGrupo("Hola");
	test.throws(function () { h.generar();});
	test.done();
}

exports.testSetSesiones = function(test){
	h = new horario();
	h.setSesiones([new sesion("IS",2,3),new sesion("IS",2,3)]);
	test.equal(2,h.getSesiones().length);
	test.done();
}
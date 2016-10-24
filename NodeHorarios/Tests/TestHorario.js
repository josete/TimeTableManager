horario = require("../Source/Objetos/Horario.js");

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
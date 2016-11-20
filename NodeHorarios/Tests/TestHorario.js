horario = require("../Source/Objetos/Horario.js");
sesion = require("../Source/Objetos/Sesion.js");
var profesor = require("../Source/Objetos/Profesor.js");
var asignatura = require("../Source/Objetos/Asignatura.js");

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

exports.testHoraSinSolape = function(test){
	h = new horario();
	raul = new profesor("Raul");
	iso = new asignatura("IS",3,"Informatica",raul);
	sesiones = [new sesion(iso,2,3),new sesion(iso,2,3)];
	h.setSesiones(sesiones);
	test.ok(h.comprobar.comprobarSolape(raul,"0-8"));
	test.done();
}

exports.testHoraConSolape = function(test){
	h = new horario();
	raul = new profesor("Raul");
	iso = new asignatura("IS",3,"Informatica",raul);
	sesiones = [new sesion(iso,2,3),new sesion(iso,2,3)];
	raul.anadirClase("0-8",sesiones[0]);
	h.setSesiones(sesiones);
	test.equal(false,h.comprobar.comprobarSolape(raul,"0-8"));
	test.done();
}

exports.testProfesorConHoras = function(test){
	h = new horario();
	raul = new profesor("Raul",0,4);
	iso = new asignatura("IS",3,"Informatica",raul);
	sesiones = [new sesion(iso,2,3),new sesion(iso,2,3)];
	raul.anadirClase("0-8",sesiones[0]);
	h.setSesiones(sesiones);
	test.ok(h.comprobar.comprobarHorasDiarias(raul,sesiones[1],0));
	test.done();
}

exports.testProfesorSinHoras = function(test){
	h = new horario();
	raul = new profesor("Raul",0,2);
	iso = new asignatura("IS",3,"Informatica",raul);
	sesiones = [new sesion(iso,2,3),new sesion(iso,2,3)];
	raul.anadirClase("0-8",sesiones[0]);
	h.setSesiones(sesiones);
	test.equals(false,h.comprobar.comprobarHorasDiarias(raul,sesiones[1],0));
	test.done();
}
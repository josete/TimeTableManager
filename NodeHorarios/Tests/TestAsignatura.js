asignatura = require("../Source/Objetos/Asignatura.js");

exports.testNombreAsignaturaNotNull = function(test){
	a = new asignatura("Hola",1,"Hola2");
	test.equal("Hola",a.getNombre());
	test.done();
}

exports.testCursoAsignaturaNotNull = function(test){
	a = new asignatura("Hola",1,"Hola2");
	test.equal(1,a.getCurso());
	test.done();
}

exports.testAsignaturaSinNombre = function(test){
	test.throws(function(){a = new asignatura(null,1,"Hola2");});
	test.done();
}

exports.testAsignaturaPuedeEnDia = function(test){
	a = new asignatura("Hola",1,"Hola2");
	test.ok(a.diaActualPuede());
	test.done();
}

exports.testAsignaturaNoPuedeEnDiaCambio = function(test){
	a = new asignatura("Hola",1,"Hola2");
	a.setPuede(false);
	test.equal(false,a.diaActualPuede());
	test.done();
}
curso = require("../Source/Objetos/Curso.js");

exports.testNombreCursoNotNull = function(test){
	a = new curso("Informatica",1,"Ingenieria");
	test.equal("Informatica",a.getNombre());
	test.done();
}
exports.testCursoCursoNotNull = function(test){
	a = new curso("Informatica",1,"Ingenieria");
	test.equal(1,a.getCurso());
	test.done();
}

exports.testCursoSinNombre = function(test){
	test.throws(function(){a = new curso(null,1,"Ingenieria");});
	test.done();
}


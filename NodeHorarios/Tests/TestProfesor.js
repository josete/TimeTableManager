profesor = require("../Source/Objetos/Profesor.js");

exports.testNombreProfesorNotNull = function(test){
	p = new profesor("Raul");
	test.equal("Raul",p.getNombre());
	test.done();
}

exports.testProfesorinNombre = function(test){
	test.throws(function(){p = new profesor(null);});
	test.done();
}

exports.testProfesorMaxHoras0 = function(test){
    test.throws(function(){p = new profesor("Raul",0,0);});
    test.done();
}

